package com.hotsix.admin;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hotsix.common.Paging;
import com.hotsix.event.EventModel;
import com.hotsix.event.EventService;
import com.hotsix.magazine.MagazineCommentModel;
import com.hotsix.magazine.MagazineModel;
import com.hotsix.magazine.MagazineService;
import com.hotsix.magazine.commentPaging;
import com.hotsix.member.MemberModel;
import com.hotsix.movie.MovieGradeModel;
import com.hotsix.movie.MovieModel;
import com.hotsix.movie.MovieService;
import com.hotsix.notice.NoticeModel;
import com.hotsix.notice.NoticeService;
import com.hotsix.qna.QnaModel;
import com.hotsix.qna.QnaService;
import com.hotsix.reserve.RoomModel;
import com.hotsix.reserve.TimetableDetailModel;
import com.hotsix.reserve.TimetableMasterModel;
import com.hotsix.validator.MovieValidator;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Resource(name = "movieService")
	private MovieService movieService;
	
	@Resource(name = "adminService")
	private AdminService adminService;
	
	@Resource(name = "eventService")
	private EventService eventService;
	
	@Resource(name = "noticeService")
	private NoticeService noticeService;
	
	@Resource(name = "magazineService")
	private MagazineService magazineService;
	
	@Resource(name ="qnaService")
	private QnaService qnaService;
	
	@ModelAttribute("movieModel")
	public MovieModel movieModel() {
		return new MovieModel();
	}
	
	
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockpaging = 5;
	private String pagingHtml;
	private Paging paging;
	
	private String filePath = "C:\\java\\App\\MovieTicket\\src\\main\\webapp\\upload\\movie\\";
	private static final String filePath2 = "C:\\java\\app\\MovieTicket\\src\\main\\webapp\\upload\\event\\";
	private static final String filePath3="E:\\App\\MovieTicket\\src\\main\\webapp\\upload\\magazine\\";
	
	// 매거진 댓글 페이징
	private int currentPage2 = 1;
	private int blockPage2 = 5; 
	private int totalCount2; 
	private int blockCount2 = 3; 
	private String pagingHtml2; 
	private commentPaging page2; 
	
	private ModelAndView mav = new ModelAndView();
	
	// 상영작리스트
	@RequestMapping(value = "/movieList.mt", method = RequestMethod.GET)
	public ModelAndView movieList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		List<MovieModel> movieList = movieService.movieList();
		
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty() || request.getParameter("currentPage").equals("0")) {
			currentPage = 1;
		}else{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		totalCount = movieList.size();
		
		paging = new Paging(currentPage, totalCount, blockCount, blockpaging, "movieList");
		pagingHtml = paging.getPagingHtml().toString();
		
		int lastCount = totalCount;
		//System.out.println(paging.getEndCount());
		//System.out.println(totalCount);
		if (paging.getEndCount() < totalCount) {
			lastCount = paging.getEndCount() + 1;
		}

		movieList = movieList.subList(paging.getStartCount(), lastCount);
		
		mv.addObject("list", movieList);
		mv.addObject("currentPage", currentPage);
		mv.addObject("pagingHtml", pagingHtml);
		mv.addObject("totalCount", totalCount);
		mv.setViewName("adminMovieList");
		return mv;
	}

	// 상영작 뷰
	@RequestMapping(value = "/movieView.mt", method = RequestMethod.GET)
	public ModelAndView movieView(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		int no = Integer.parseInt(request.getParameter("movie_no"));

		List<MovieModel> list2 = movieService.movieList_one(no);

		mv.addObject("list", list2);
		mv.setViewName("adminMovieView");
		return mv;
	}

	// 상영작 글쓰기 폼
	@RequestMapping(value = "/movieWrite.mt", method = RequestMethod.GET)
	public ModelAndView movieWrite(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("movieWrite");
		return mv;
	}
	
	// 상영작 글쓰기
    @RequestMapping(value = "/movieWrite.mt", method = RequestMethod.POST)
    public ModelAndView movieWrite2(@ModelAttribute("movieModel") MovieModel movieModel, BindingResult result, HttpServletRequest request, MultipartHttpServletRequest multipartHttpServletRequest) throws IOException{

      new MovieValidator().validate(movieModel, result);
      
      if(result.hasErrors() && (result.getErrorCount() != 4)) {
         //System.out.println("에러! "+result.getErrorCount());
         mav.setViewName("movieWrite");
         return mav;
      }
      
      try {
         movieModel.setShow_date(new SimpleDateFormat("yyyyMMdd").parse(request.getParameter("show_date")));
      } catch (ParseException e) {
         e.printStackTrace();
      }

      int seqName = movieService.getMagazine_NO_SEQ();

      if (!multipartHttpServletRequest.getFile("poster").getOriginalFilename().equals("")) {
         MultipartFile multipartFile0 = multipartHttpServletRequest.getFile("poster");
         String file_name0 = "poster_" + seqName;
         String file_ext0 = multipartFile0.getOriginalFilename()
               .substring(multipartFile0.getOriginalFilename().lastIndexOf('.') + 1);
         if (file_ext0 != "") {
            String full_name = file_name0 + "." + file_ext0;
            File file = new File(filePath + full_name);

            if (!file.exists()) {
               file.mkdirs();
            }
            try {
               multipartFile0.transferTo(file);
            } catch (Exception e) {
            }
            movieModel.setPoster(full_name);
         }
      } else {
         movieModel.setPoster("사진없음");
      }

      if (!multipartHttpServletRequest.getFile("cut1").getOriginalFilename().equals("")) {
         MultipartFile multipartFile = multipartHttpServletRequest.getFile("cut1");
         String file_name = "cut1_" + seqName;
         String file_ext = multipartFile.getOriginalFilename()
               .substring(multipartFile.getOriginalFilename().lastIndexOf('.') + 1);
         if (file_ext != "") {
            String full_name = file_name + "." + file_ext;
            File file = new File(filePath + full_name);

            if (!file.exists()) {
               file.mkdirs();
            }
            try {
               multipartFile.transferTo(file);
            } catch (Exception e) {
            }
            movieModel.setCut1(full_name);
         }
      } else {
         movieModel.setCut1("사진없음");
      }

      if (!multipartHttpServletRequest.getFile("cut2").getOriginalFilename().equals("")) {
         MultipartFile multipartFile2 = multipartHttpServletRequest.getFile("cut2");
         String file_name2 = "cut2_" + seqName;
         String file_ext2 = multipartFile2.getOriginalFilename()
               .substring(multipartFile2.getOriginalFilename().lastIndexOf('.') + 1);
         if (file_ext2 != "") {
            String full_name = file_name2 + "." + file_ext2;
            File file = new File(filePath + full_name);

            if (!file.exists()) {
               file.mkdirs();
            }
            try {
               multipartFile2.transferTo(file);
            } catch (Exception e) {
            }
            movieModel.setCut2(full_name);
         }
      } else {
         movieModel.setCut2("사진없음");
      }

      if (!multipartHttpServletRequest.getFile("cut3").getOriginalFilename().equals("")) {
         MultipartFile multipartFile3 = multipartHttpServletRequest.getFile("cut3");
         String file_name3 = "cut3_" + seqName;
         String file_ext3 = multipartFile3.getOriginalFilename()
               .substring(multipartFile3.getOriginalFilename().lastIndexOf('.') + 1);
         if (file_ext3 != "") {
            String full_name = file_name3 + "." + file_ext3;
            File file = new File(filePath + full_name);

            if (!file.exists()) {
               file.mkdirs();
            }
            try {
               multipartFile3.transferTo(file);
            } catch (Exception e) {
            }
            movieModel.setCut3(full_name);
         }
      } else {
         movieModel.setCut3("사진없음");
      }

      movieModel.setMovie_no(seqName);
      movieModel.setMovie_age_grade("0");
      movieModel.setMovie_score(0);
      movieModel.setMoviescore_people(0);

      movieService.movieWrite(movieModel);

      
      mav.setViewName("redirect:/admin/movieList.mt");
      return mav;
    }

	// 상영작 삭제
	@RequestMapping(value = "/movieDelete.mt", method = RequestMethod.GET)
	public String movieDelete(HttpServletRequest request) {
		int movie_no = Integer.parseInt(request.getParameter("movie_no"));

		// System.out.println(movie_no);

		movieService.movieDelete(movie_no);

		return "redirect:movieList.mt";
	}

	// 상영작 수정폼
	@RequestMapping(value = "/movieUpdate.mt", method = RequestMethod.GET)
	public ModelAndView movieUpdate(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int movie_no = Integer.parseInt(request.getParameter("movie_no"));

		// System.out.println(movie_no);

		List<MovieModel> list = movieService.movieList_one(movie_no);

		mav.addObject("list", list);
		mav.setViewName("adminMovieUpdate");
		return mav;
	}

	// 상영작 수정
	@RequestMapping(value = "/movieUpdate.mt", method = RequestMethod.POST)
	public String movieUpdate2(@ModelAttribute("movieModel") MovieModel movieModel, BindingResult result,
			MultipartHttpServletRequest multipartHttpServletRequest, MultipartHttpServletRequest request) {

		try {
			movieModel.setShow_date(new SimpleDateFormat("yyyyMMdd").parse(request.getParameter("date")));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int seqName = Integer.parseInt(request.getParameter("movie_no"));

		if (request.getFile("poster").getOriginalFilename().equals("")) {
			movieModel.setPoster(request.getParameter("poster_old"));
		} else {
			MultipartFile multipartFile0 = multipartHttpServletRequest.getFile("poster");
			String file_name0 = "poster_" + seqName;
			String file_ext0 = multipartFile0.getOriginalFilename()
					.substring(multipartFile0.getOriginalFilename().lastIndexOf('.') + 1);
			if (file_ext0 != "") {
				String full_name = file_name0 + "." + file_ext0;
				File file = new File(filePath + full_name);

				if (!file.exists()) {
					file.mkdirs();
				}
				try {
					multipartFile0.transferTo(file);
				} catch (Exception e) {
				}
				movieModel.setPoster(full_name);
			}
		}

		if (request.getFile("cut1").getOriginalFilename().equals("")) {
			movieModel.setCut1(request.getParameter("cut1_old"));
		} else {
			MultipartFile multipartFile1 = multipartHttpServletRequest.getFile("cut1");
			String file_name1 = "cut1_" + seqName;
			String file_ext1 = multipartFile1.getOriginalFilename()
					.substring(multipartFile1.getOriginalFilename().lastIndexOf('.') + 1);
			if (file_ext1 != "") {
				String full_name = file_name1 + "." + file_ext1;
				File file = new File(filePath + full_name);

				if (!file.exists()) {
					file.mkdirs();
				}
				try {
					multipartFile1.transferTo(file);
				} catch (Exception e) {
				}
				movieModel.setCut1(full_name);
			}
		}

		if (request.getFile("cut2").getOriginalFilename().equals("")) {
			movieModel.setCut2(request.getParameter("cut2_old"));
		} else {
			MultipartFile multipartFile2 = multipartHttpServletRequest.getFile("cut2");
			String file_name2 = "cut2_" + seqName;
			String file_ext2 = multipartFile2.getOriginalFilename()
					.substring(multipartFile2.getOriginalFilename().lastIndexOf('.') + 1);
			if (file_ext2 != "") {
				String full_name = file_name2 + "." + file_ext2;
				File file = new File(filePath + full_name);

				if (!file.exists()) {
					file.mkdirs();
				}
				try {
					multipartFile2.transferTo(file);
				} catch (Exception e) {
				}
				movieModel.setCut2(full_name);
			}
		}

		if (request.getFile("cut3").getOriginalFilename().equals("")) {
			movieModel.setCut3(request.getParameter("cut3_old"));
		} else {
			MultipartFile multipartFile3 = multipartHttpServletRequest.getFile("cut3");
			String file_name3 = "cut3_" + seqName;
			String file_ext3 = multipartFile3.getOriginalFilename()
					.substring(multipartFile3.getOriginalFilename().lastIndexOf('.') + 1);
			if (file_ext3 != "") {
				String full_name = file_name3 + "." + file_ext3;
				File file = new File(filePath + full_name);

				if (!file.exists()) {
					file.mkdirs();
				}
				try {
					multipartFile3.transferTo(file);
				} catch (Exception e) {
				}
				movieModel.setCut3(full_name);
			}
		}

		try {
			movieModel.setShow_date(new SimpleDateFormat("yyyyMMdd").parse(request.getParameter("date")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		movieService.movieUpdate(movieModel);

		return "redirect:movieList.mt";
	}
	
	

	// 스케쥴 리스트
	@RequestMapping(value = "/timeTableList.mt", method = RequestMethod.GET)
	public ModelAndView timeTableList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		if(request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty() || request.getParameter("currentPage").equals("0")){
			currentPage = 1;
		}else{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		 
		List<TimeTableListModel> timeList;
		List<AdminModel> timeMovie;
		List<RoomModel> timeRoom;
		
		timeList = adminService.timeList();
		
		totalCount = timeList.size();
		paging = new Paging(currentPage, totalCount, blockCount, blockpaging, "timeTableList");
		pagingHtml = paging.getPagingHtml().toString();
		
		int lastCount = totalCount;
		if(paging.getEndCount() < totalCount){
			lastCount = paging.getEndCount() + 1;
		}
		
		timeList = timeList.subList(paging.getStartCount(), lastCount);
		timeMovie = adminService.timeMovie();
		timeRoom = adminService.timeRoom();
		
		mav.addObject("timeList", timeList);
		mav.addObject("timeRoom", timeRoom);
		mav.addObject("timeMovie", timeMovie);
		mav.addObject("currentPage", currentPage);
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("totalCount", totalCount);
		mav.setViewName("timeTableList");
		 
		return mav;
	}
	
	// 스케쥴 등록
	@RequestMapping(value = "/timeTableWrite.mt", method = RequestMethod.POST)
	public String timeTableWrite(HttpServletRequest request) throws ParseException{
		TimetableMasterModel masterModel = new TimetableMasterModel();
		TimetableDetailModel detailModel = new TimetableDetailModel();
		
		Date start_date;
		Date end_date;
		
		// master parameters
		int movie_no = Integer.parseInt(request.getParameter("movie_no"));
		int room_no = Integer.parseInt(request.getParameter("room_no"));
		start_date = new SimpleDateFormat("yyyyMMdd").parse(request.getParameter("start_date"));
		end_date = new SimpleDateFormat("yyyyMMdd").parse(request.getParameter("end_date"));
		
		// detail parameters
		String time_name = request.getParameter("movie_no");
		String show_date = request.getParameter("show_date");
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		int adult_amt = Integer.parseInt(request.getParameter("adult_amt"));
		int child_amt = Integer.parseInt(request.getParameter("child_amt"));
		
		// master Model setting
		masterModel.setMovie_no(movie_no);
		masterModel.setRoom_no(room_no);
		masterModel.setStart_date(start_date);
		masterModel.setEnd_date(end_date);
		adminService.timeMasterInsert(masterModel);
		
		// detail Model setting
		detailModel.setTime_name(time_name);
		detailModel.setShow_date(show_date);
		detailModel.setStart_time(start_time);
		detailModel.setEnd_time(end_time);
		detailModel.setAdult_amt(adult_amt);
		detailModel.setChild_amt(child_amt);
		adminService.timeDetailInsert(detailModel);
		
		return "redirect:timeTableList.mt";
	}
	
	// 스케쥴 삭제
	@RequestMapping(value = "/timeTableDelete.mt", method = RequestMethod.GET)
	public String timeTableDelete(HttpServletRequest request){
		
		int time_no = Integer.parseInt(request.getParameter("time_no"));
		int time_detail_no = Integer.parseInt(request.getParameter("time_detail_no"));
		
		adminService.timeMasterDelete(time_no);
		adminService.timeDetailDelete(time_detail_no);
		
		return "redirect:timeTableList.mt";
	}
	
	// 회원정보 
	@RequestMapping(value = "/memberList.mt", method = RequestMethod.GET)
	public ModelAndView memberList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		if(request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty() || request.getParameter("currentPage").equals("0")){
			currentPage = 1;
		}else{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		List<MemberModel> memberlist;
		String isSearch  = null;
		int searchNum = 0;
		
		isSearch = request.getParameter("isSearch");
		
		if(isSearch != null){
			searchNum = Integer.parseInt(request.getParameter("searchNum"));
			
			if(searchNum == 0){
				memberlist = adminService.memberSearch0(isSearch);
			}else if(searchNum == 1){
				memberlist = adminService.memberSearch1(isSearch);
			}else{
				memberlist = adminService.memberSearch2(isSearch);
			}
			
			totalCount = memberlist.size();
			paging = new Paging(currentPage, totalCount, blockCount, blockpaging, "memberList", searchNum, isSearch);
			pagingHtml = paging.getPagingHtml().toString();
			
			int lastCount = totalCount;
			
			if(paging.getEndCount() < totalCount){
				lastCount = paging.getEndCount() + 1;
			}
			
			memberlist = memberlist.subList(paging.getStartCount(), lastCount);
			mav.addObject("pagingHtml", pagingHtml);
			mav.addObject("memberlist", memberlist);
			mav.setViewName("adminMemberList");
			return mav;
		}
		
		memberlist = adminService.memberList();
		
		totalCount = memberlist.size();
		paging = new Paging(currentPage, totalCount, blockCount, blockpaging, "memberList");
		pagingHtml = paging.getPagingHtml().toString();
		
		int lastCount = totalCount;
		
		if(paging.getEndCount() < totalCount){
			lastCount = paging.getEndCount() + 1;
		}
		
		memberlist = memberlist.subList(paging.getStartCount(), lastCount);
		
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("memberlist", memberlist);
		mav.setViewName("adminMemberList");
		return mav;
	}
	
	@RequestMapping(value = "/imgView.mt", method = RequestMethod.GET)
	public ModelAndView imgView(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName("/admin/imgView");
		return mav;
	}
	
	//이벤트리스트
	@RequestMapping(value = "/adminEventList.mt", method = RequestMethod.GET)
	public ModelAndView eventList(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		String isSearch  = null;
		int searchNum = 0;

		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty() || request.getParameter("currentPage").equals("0")) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		List<EventModel> eventList = null;
		
		//검색일 때 paging
		isSearch = request.getParameter("isSearch");
		
		if(isSearch != null){
			
			searchNum = Integer.parseInt(request.getParameter("searchNum"));
			
			if(searchNum == 0){
				eventList = eventService.eventSearch0(isSearch);
			} else if(searchNum == 1){
				eventList = eventService.eventSearch1(isSearch);
			}
			
			totalCount = eventList.size();
			paging = new Paging(currentPage, totalCount, blockCount, blockpaging, "adminEventList", searchNum, isSearch);
			pagingHtml = paging.getPagingHtml().toString();
			
			int lastCount = totalCount;
			
			if(paging.getEndCount() < totalCount){
				lastCount = paging.getEndCount() + 1;
			}
			
			eventList = eventList.subList(paging.getStartCount(), lastCount);
			
			mav.addObject("isSearch", isSearch);
			mav.addObject("searchNum", searchNum);
			mav.addObject("totalCount", totalCount);
			mav.addObject("pagingHtml", pagingHtml);
			mav.addObject("currentpaging", currentPage);
			mav.addObject("eventList", eventList);
			mav.setViewName("adminEventList");
			return mav;
				
		}
		
		//검색없을때  paging	
		eventList = eventService.eventList();

		totalCount = eventList.size();

		paging = new Paging(currentPage, totalCount, blockCount, blockpaging, "adminEventList");
		pagingHtml = paging.getPagingHtml().toString();

		int lastCount = totalCount;

		if (paging.getEndCount() < totalCount){
			lastCount = paging.getEndCount() + 1;
		}

		eventList = eventList.subList(paging.getStartCount(), lastCount);

		mav.addObject("totalCount", totalCount);
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("currentPage", currentPage);
		mav.addObject("eventList", eventList);
		mav.setViewName("adminEventList");

		return mav;
	}
		
	//이벤트 상세보기
	@RequestMapping("/adminEventView.mt")
	public ModelAndView eventView(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();

		int event_no = Integer.parseInt(request.getParameter("event_no"));

		EventModel eventModel = new EventModel();
		eventModel.setEvent_no(event_no);
		eventModel = eventService.eventView(event_no);

		mav.addObject("eventModel", eventModel);
		mav.setViewName("adminEventView");
		return mav;
	}
	
	//이벤트 글쓰기 폼
	@RequestMapping(value = "/adminEventWrite.mt", method = RequestMethod.GET)
	public ModelAndView eventWriteForm(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();

		mav.setViewName("adminEventWrite");
		return mav;
	}

	//이벤트 글쓰기
	@RequestMapping(value = "/adminEventWrite.mt", method = RequestMethod.POST)
	public ModelAndView eventWrite(@ModelAttribute("eventModel") EventModel eventModel, BindingResult result,
			HttpServletRequest request, MultipartHttpServletRequest multipartHttpServletRequest) throws IOException {
		
		ModelAndView mav = new ModelAndView();

		String content = eventModel.getContent().replace("/r/n", "<br/>");
		Date e_start_date;
		Date e_end_date;

		int seqName = eventService.getEventSEQ();
		eventModel.setEvent_no(seqName);

		try {
			e_start_date = new SimpleDateFormat("yyyyMMdd").parse(request.getParameter("e_start_date"));
			e_end_date = new SimpleDateFormat("yyyyMMdd").parse(request.getParameter("e_end_date"));
			eventModel.setContent(content);
			eventModel.setE_start_date(e_start_date);
			eventModel.setE_end_date(e_end_date);

			MultipartFile multipartFile = multipartHttpServletRequest.getFile("image1");
			String file_name = "image1_" + seqName;
			String file_ext = multipartFile.getOriginalFilename()
					.substring(multipartFile.getOriginalFilename().lastIndexOf('.') + 1);

			if (file_ext != "") {
				String full_name = file_name + "." + file_ext;
				File file = new File(filePath2 + full_name);

				if (!file.exists()) {
					file.mkdirs();
				}
				try {
					multipartFile.transferTo(file);
				} catch (Exception e) {
				}
				eventModel.setImage1(full_name);
			}

			eventService.eventWrite(eventModel);
			
			System.out.println("Event_no: " + eventModel.getEvent_no());
			System.out.println("Subject: " + eventModel.getSubject());
			System.out.println("Image1: " + eventModel.getImage1());
			System.out.println("Content: " + eventModel.getContent());
			System.out.println("E_start_date: " + eventModel.getE_start_date());
			System.out.println("E_end_date: " + eventModel.getE_end_date());
			
			
			mav.addObject("eventModel", eventModel);
			mav.setViewName("redirect:/admin/adminEventList.mt");
			return mav;

		} catch (ParseException e) {
			e.printStackTrace();
			mav.setViewName("adminEventWrite");
			return mav;
		}
	}
	
	//이벤트 글수정폼
	@RequestMapping(value = "/adminEventUpdate.mt", method = RequestMethod.GET)
	public ModelAndView eventUpdateForm(@ModelAttribute("eventModel") EventModel eventModel,
			HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();

		int event_no = Integer.parseInt(request.getParameter("event_no"));
		eventModel = eventService.eventView(event_no);

		String content = eventModel.getContent().replace("/r/n", "<br/>");
		eventModel.setContent(content);

		mav.addObject("eventModel", eventModel);
		mav.setViewName("adminEventUpdate");
		return mav;
	}

	//이벤트 글수정
	@RequestMapping(value = "/adminEventUpdate.mt", method = RequestMethod.POST)
	public ModelAndView eventUpdate(@ModelAttribute("eventModel") EventModel eventModel, BindingResult result,
			MultipartHttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();

		int event_no = Integer.parseInt(request.getParameter("event_no"));
		eventModel = eventService.eventView(event_no);
		
		eventModel.setEvent_no(event_no);
		eventModel.setSubject(request.getParameter("subject"));
		eventModel.setImage1(request.getParameter("image1"));
		eventModel.setContent(request.getParameter("content"));
		try {
			eventModel.setE_start_date(new SimpleDateFormat("yyyyMMdd").parse(request.getParameter("e_start_date")));
			eventModel.setE_end_date(new SimpleDateFormat("yyyyMMdd").parse(request.getParameter("e_end_date")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		

		if (request.getFile("image1") != null) {
			MultipartFile multipartFile = request.getFile("image1");
			String file_name = "image1_" + event_no;
			String file_ext = multipartFile.getOriginalFilename()
					.substring(multipartFile.getOriginalFilename().lastIndexOf('.') + 1);

			if (file_ext != "") {
				String full_name = file_name + "." + file_ext;
				File file = new File(filePath2 + full_name);

				if (!file.exists()) {
					file.mkdirs();
				}
				try {
					multipartFile.transferTo(file);
				} catch (Exception e) {
				}

				eventModel.setImage1(full_name);
			}
		} else {
			eventModel.setImage1(eventModel.getImage1());
		}
		
		eventService.eventUpdate(eventModel);
		
		System.out.println("Image1: " + eventModel.getImage1());

		mav.addObject("eventModel", eventModel);
		mav.setViewName("redirect:/admin/adminEventList.mt");
		return mav;

	}
	
	//이벤트 글삭제
	@RequestMapping(value = "/adminEventDelete.mt", method = RequestMethod.GET)
	public ModelAndView eventDelete(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		int event_no = Integer.parseInt(request.getParameter("event_no"));

		eventService.eventDelete(event_no);
		mav.setViewName("redirect:/admin/adminEventList.mt");
		return mav;
	}
	
	// 공지사항 리스트
	@RequestMapping(value = "/adminNoticeList.mt", method = RequestMethod.GET)
	public ModelAndView noticeList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		
		String isSearch = null;
		int searchNum = 0;
		
		// if문 현재페이지가 null이고,겟파라미터가 currentPage, 현재페이지가 0이면 현재페이지를1로설정한다.
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) {
			currentPage = 1;
		} else {
			// 아니면~~currentPage 받아서 인트타입으로 지정한다.
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		// NoticeModel 자바빈을 List에 noticeList이름으로 담는다. 값은 null이다.
		List<NoticeModel> noticeList = null;
		isSearch = request.getParameter("isSearch");
		// isSearch 쿼리를 받아서 isSearch에 담아쓴다.
		if (isSearch != null) {
			// isSearch값이 null 아닐때..

			// jsp에서 name값이 searchNum을 인트타입으로 받아서 searchNum이라는 이름으로 저장한다.
			searchNum = Integer.parseInt(request.getParameter("searchNum"));
			// searchNum이 0일때(제목) noticeSearch0에 isSearch를 담아서 noticeList로 실행
			if (searchNum == 0) {
				noticeList = noticeService.noticeSearch0(isSearch);
			} else if (searchNum == 1) {
				noticeList = noticeService.noticeSearch1(isSearch);
			} // searchNum이 1일때(내용) noticeSearch1에 isSearch를 담아서 noticeList로 실행
				// 총 갯수 = 리스트에 출력된 갯수 담는다.
			totalCount = noticeList.size();
			paging = new Paging(currentPage, totalCount, blockCount, blockpaging, "adminNoticeList", searchNum, isSearch);
			pagingHtml = paging.getPagingHtml().toString();
			// page 객체생성을 하고 내용물을 담는다

			int lastCount = totalCount;
			// 인트타입 마지막수 = 총갯수
			if (paging.getEndCount() < totalCount) {
				lastCount = paging.getEndCount() + 1;
			}
			// 페이지가 끝난 갯수가 총갯수보다 작으면 끝난갯수에 +1을해서 마지막갯수에 담는다.
			noticeList = noticeList.subList(paging.getStartCount(), lastCount);
			// 시작번호와 끝번호만큼 subList로 이용해서 자른다.

			mav.addObject("isSearch", isSearch);
			mav.addObject("searchNum", searchNum);
			mav.addObject("totalCount", totalCount);
			mav.addObject("pagingHtml", pagingHtml);
			mav.addObject("currentPage", currentPage);
			mav.addObject("noticeList", noticeList);
			mav.setViewName("adminNoticeList");

			return mav;
		}
		// 검색없을때 paging
		noticeList = noticeService.noticeList();
		// noticeList에 noticeService를 담아서 사용
		totalCount = noticeList.size();
		// 총갯수 = 리스트에 출력된 갯수
		paging = new Paging(currentPage, totalCount, blockCount, blockpaging, "adminNoticeList");
		pagingHtml = paging.getPagingHtml().toString();
		// page 객체생성후 Paging에 currentPage, totalCount, blockCount, blockPage,
		// noticeList를 담는다
		// page에 객체생성한 것들을 pagingHtml에 담는다.
		int lastCount = totalCount;
		// int타입으로 총갯수를 마지막갯수에 담는다.
		if (paging.getEndCount() < totalCount) {
			lastCount = paging.getEndCount() + 1;
		}
		// 끝에 갯수가 총 갯수보다 작으면 마지막수에 +1증가.
		noticeList = noticeList.subList(paging.getStartCount(), lastCount);

		mav.addObject("totalCount", totalCount);
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("currentPage", currentPage);
		mav.addObject("noticeList", noticeList);
		mav.setViewName("adminNoticeList");

		return mav;
	}

	// 공지사항 상세보기
	@RequestMapping("/adminNoticeView.mt")
	public ModelAndView noticeView(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		int no = Integer.parseInt(request.getParameter("no"));
		NoticeModel noticeModel = new NoticeModel();
		noticeModel.setNo(no);
		noticeModel = noticeService.noticeView(no);
		noticeService.noticeUpdateReadhit(no);

		mav.addObject("currentPage", currentPage);
		mav.addObject("noticeModel", noticeModel);
		mav.setViewName("adminNoticeView");
		return mav;
	}

	// 공지사항 글쓰기 폼
	@RequestMapping(value = "/adminNoticeWrite.mt", method = RequestMethod.GET)
	public ModelAndView noticeWriteForm(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("adminNoticeForm");
		return mav;
	}

	// 공지사항 글 쓰기
	@RequestMapping(value = "/adminNoticeWrite.mt", method = RequestMethod.POST)
	public ModelAndView noticeWrite(@ModelAttribute("noticeModel") NoticeModel noticeModel, BindingResult result,
			HttpServletRequest request) throws IOException {

		ModelAndView mav = new ModelAndView();

		String contents = noticeModel.getContents().replace("/r/n", "<br/>");
		noticeModel.setContents(contents);
		noticeService.noticeWrite(noticeModel);
		mav.addObject("noticeModel", noticeModel);
		mav.setViewName("redirect:/admin/adminNoticeList.mt");

		return mav;
	}

	// 글수정폼
	@RequestMapping(value = "/adminNoticeModify.mt", method = RequestMethod.GET)
	public ModelAndView noticeModifyForm(@ModelAttribute("noticeModel") NoticeModel noticeModel,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		int no = Integer.parseInt(request.getParameter("no"));
		noticeModel = noticeService.noticeView(no);

		mav.addObject("noticeModel", noticeModel);
		mav.setViewName("adminNoticeModify");
		return mav;
	}

	// 글수정
	@RequestMapping(value = "/adminNoticeModify.mt", method = RequestMethod.POST)
	public ModelAndView noticeModify(@ModelAttribute("noticeModel") NoticeModel noticeModel, HttpServletRequest request,
			String contents) {

		ModelAndView mav = new ModelAndView();

		int no = Integer.parseInt(request.getParameter("no"));
		noticeModel = noticeService.noticeView(no);

		noticeModel.setNo(no);
		noticeModel.setSubject(request.getParameter("subject"));
		noticeModel.setContents(contents);
		noticeService.noticeModify(noticeModel);

		mav.addObject("noticeModel", noticeModel);
		mav.setViewName("redirect:/admin/adminNoticeList.mt");
		return mav;

	}

	// 공지사항 글삭제
	@RequestMapping(value = "/adminNoticeDelete.mt", method = RequestMethod.GET)
	public ModelAndView noticeDelete(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		int no = Integer.parseInt(request.getParameter("no"));

		noticeService.noticeDelete(no);
		mav.setViewName("redirect:/admin/adminNoticeList.mt");
		return mav;

	}
		
	@RequestMapping(value="/adminMagazineList.mt",method=RequestMethod.GET)
	public ModelAndView magazineList(HttpServletRequest request){
		
		ModelAndView mav=new ModelAndView();
		List<MagazineModel> list=magazineService.magazineList();
		
		String isSearch  = null;
		int searchNum = 0;
	
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) {
			currentPage = 1;
		}
		else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		isSearch=request.getParameter("isSearch");
		
		if(isSearch!=null)
		{
			searchNum=Integer.parseInt(request.getParameter("searchNum"));
			
			if(searchNum==0)
				list=magazineService.magazineSearch0(isSearch);
			else if(searchNum==1)
				list=magazineService.magazineSearch1(isSearch);

		totalCount=list.size();
		paging =new Paging(currentPage, totalCount, blockCount, blockpaging, "magazineList", searchNum, isSearch);
		pagingHtml = paging.getPagingHtml().toString();
		
		int lastCount = totalCount;

		if (paging.getEndCount() < totalCount) {
			lastCount = paging.getEndCount() + 1;
		}
		list=list.subList(paging.getStartCount(), lastCount);
		
		mav.addObject("isSearch", isSearch);
		mav.addObject("searchNum", searchNum);
		mav.addObject("list",list);
		mav.addObject("totalCount", totalCount);
		mav.addObject("pagingHtml",pagingHtml);
		mav.addObject("currentPage", currentPage);
		mav.setViewName("adminMagazineList");
		return mav;

		}
		list=magazineService.magazineList();
		
		totalCount=list.size();
		paging=new Paging(currentPage,totalCount,blockCount,blockpaging,"adminMagazineList");
		pagingHtml=paging.getPagingHtml().toString();
		int lastCount=totalCount;
		
		if(paging.getEndCount()<totalCount)
			lastCount=paging.getEndCount()+1;
		
		list=list.subList(paging.getStartCount(), lastCount);
		
		mav.addObject("totalCount", totalCount);
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("currentPage", currentPage);
		mav.addObject("list",list);
		mav.setViewName("adminMagazineList");
		return mav;
	}

	@RequestMapping(value="/magazineView.mt",method=RequestMethod.GET)
	public ModelAndView magazineView(HttpServletRequest request){
		
		if (request.getParameter("currentPage2") == null || request.getParameter("currentPage2").trim().isEmpty() || request.getParameter("currentPage2").equals("0")) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage2"));
		}
		
		ModelAndView mav=new ModelAndView();
		
		int magazine_no=Integer.parseInt(request.getParameter("magazine_no"));
		int origin_no=Integer.parseInt(request.getParameter("magazine_no"));
		magazineService.magazineUpdateReadhit(magazine_no);
		List<MagazineCommentModel> commentlist=magazineService.commentList(origin_no);
		commentlist=magazineService.commentList(origin_no);
		
		MagazineCommentModel cmt = new MagazineCommentModel();
		cmt.setOrigin_no(origin_no);
		int cmtcount = magazineService.cmtcount(cmt.getOrigin_no());
		
		cmt.setOrigin_no(origin_no);
		totalCount2=commentlist.size();
		MagazineModel magazineModel=new MagazineModel();
		magazineModel.setMagazine_no(magazine_no);
		magazineModel=magazineService.magazineView(magazine_no);
		
		page2 = new commentPaging(currentPage, totalCount2, blockCount2, blockPage2,magazine_no);
		pagingHtml2 = page2.getPagingHtml2().toString();

		int lastCount2 = totalCount2;

		if (page2.getEndCount2() < totalCount2)
			lastCount2 = page2.getEndCount2() + 1;
		
		commentlist = commentlist.subList(page2.getStartCount2(), lastCount2);
		
		mav.addObject("cmtcount",cmtcount);
		mav.addObject("totalCount2", totalCount2);
		mav.addObject("pagingHtml2",pagingHtml2);
		mav.addObject("currentPage2", currentPage2);
		mav.addObject("magazine",magazineModel);
		mav.addObject("commentlist",commentlist);
		mav.setViewName("adminMagazineView");
		return mav;
		
	}

	//magazineDelete
	@RequestMapping(value="/adminMagazineDelete.mt",method=RequestMethod.GET)
	public String magazineDelete(HttpServletRequest request){
		int magazine_no=Integer.parseInt(request.getParameter("magazine_no"));
		
		magazineService.magazineDelete(magazine_no);
		return "redirect:adminMagazineList.mt";
	}
	
	//comment Write
	@RequestMapping("/adminCommentWrite.mt")
	public ModelAndView commentWrite(HttpServletRequest request,HttpSession session){

		ModelAndView mav=new ModelAndView();
		MagazineCommentModel mgModel=new MagazineCommentModel();
		
		if (request.getParameter("currentPage2") == null || request.getParameter("currentPage2").trim().isEmpty() || request.getParameter("currentPage2").equals("0")) {
			currentPage = 1;
		}
		else {
			currentPage = Integer.parseInt(request.getParameter("currentPage2"));
		}
		
		int origin_no=Integer.parseInt(request.getParameter("magazine_no"));
		mgModel.setContent(request.getParameter("content").replaceAll("\r\n", "<br />"));
		mgModel.setOrigin_no(origin_no);
		mgModel.setName(request.getParameter("name"));
		mgModel.setPassword(request.getParameter("password"));
		magazineService.writecomment(mgModel);
		
		mav.setViewName("redirect:magazineView.mt?magazine_no="+origin_no);
		return mav;
	}
	
	@RequestMapping(value="/adminCommentDelete.mt")
	public ModelAndView commentDelete(HttpServletRequest request,MagazineCommentModel magazineCommentModel){
	/*public ModelAndView commentDelete(HttpServletRequest request) {*/
		int magazine_no=Integer.parseInt(request.getParameter("magazine_no"));
		String mcomment_no=request.getParameter("mcomment_no");
		MagazineCommentModel mgModel=new MagazineCommentModel();
		ModelAndView mav=new ModelAndView();
		mgModel=magazineService.passwordfind(mcomment_no);
		magazineService.commentDelete(mgModel);
		mav.setViewName("redirect:magazineView.mt?magazine_no="+magazine_no);
		return mav;
	}
	
	@RequestMapping(value="/adminMagazineWrite.mt",method=RequestMethod.GET)
	public ModelAndView magazineWriteForm(HttpServletRequest request){
		mav.setViewName("adminMagazineWrite");
		return mav;
	}
	
	@RequestMapping(value="/adminMagazineWrite.mt",method=RequestMethod.POST)
	public ModelAndView magazineWrite(@ModelAttribute("magazineModel") MagazineModel magazineModel,BindingResult result,
			HttpServletRequest request,MultipartHttpServletRequest multipartHttpServletRequest) throws IOException{
	
		String sub_content2=magazineModel.getSub_content2().replaceAll("\r\n", "<br />");
		int seqName=magazineService.getMagazine_NO_SEQ();
		magazineModel.setMagazine_no(seqName);
		magazineModel.setSub_content2(sub_content2);
		magazineModel.setReadhit(0);
		
		MultipartFile multipartFile=multipartHttpServletRequest.getFile("image1");
		String file_name="image1_"+seqName;
		String file_ext=multipartFile.getOriginalFilename()
				.substring(multipartFile.getOriginalFilename().lastIndexOf('.')+1);
		if(file_ext!=""){
			String full_name=file_name+"."+file_ext;
			File file=new File(filePath3+full_name);
			
			if(!file.exists()){
				file.mkdirs();
			}
			try{
				multipartFile.transferTo(file);
			}catch(Exception e){
			}
			magazineModel.setImage1(full_name);
		}
		
		MultipartFile multipartFile1 = multipartHttpServletRequest.getFile("image2");
		String file_name1 = "image2_" + seqName;
		String file_ext1 = multipartFile1.getOriginalFilename()
				.substring(multipartFile1.getOriginalFilename().lastIndexOf('.') + 1);

		if (file_ext1 != "") {
			String full_name1 = file_name1 + "." + file_ext1;
			File file1 = new File(filePath3 + full_name1);

			if (!file1.exists()) {
				file1.mkdirs();
			}

			try {
				multipartFile1.transferTo(file1);
			} catch (Exception e) {
			}
			magazineModel.setImage2(full_name1);
		}

		magazineService.magazineWrite(magazineModel);
		mav = new ModelAndView();
		mav.addObject("magazineModel", magazineModel);
		mav.setViewName("redirect:adminMagazineList.mt");
		return mav;
	}
	
	
	//magazineUpdateForm
	@RequestMapping(value="/adminMagazineUpdateForm.mt",method=RequestMethod.GET)
	public ModelAndView magazineUpdateForm(HttpServletRequest request, MagazineModel magazineModel){
		int magazine_no=Integer.parseInt(request.getParameter("magazine_no"));
		magazineModel=magazineService.magazineView(magazine_no);
		
		String content=magazineModel.getContent().replaceAll("<br />","\r\n");
		String sub_content2=magazineModel.getSub_content2().replaceAll("<br />","\r\n");
		magazineModel.setContent(content);
		magazineModel.setSub_content2(sub_content2);
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("magazineModel",magazineModel);
		mav.setViewName("adminMagazineUpdate");
		return mav;
	}

	
	//magazineUpdate
	@RequestMapping(value="/adminMagazineUpdate.mt",method=RequestMethod.POST)
	public String magazineUpdate(@ModelAttribute("magazineModel")MagazineModel magazineModel,
			BindingResult result,MultipartHttpServletRequest request)throws IOException,ParseException{
		
		int magazine_no=Integer.parseInt(request.getParameter("magazine_no"));
		String sub_content2=magazineModel.getSub_content2().replaceAll("\r\n", "<br />");
		magazineModel=magazineService.magazineView(magazine_no);
		magazineModel.setSub_content2(sub_content2);
		
		magazineModel.setContent(request.getParameter("content"));
		magazineModel.setSubject(request.getParameter("subject"));
		magazineModel.setSubject2(request.getParameter("subject2"));
		magazineModel.setSub_subject1(request.getParameter("sub_subject1"));
		magazineModel.setSub_subject2(request.getParameter("sub_subject2"));
		magazineModel.setSub_content2(request.getParameter("sub_content2"));
		magazineModel.setImage1(request.getParameter("image1"));
		magazineModel.setImage2(request.getParameter("image2"));
		
		magazineModel.setMagazine_no(magazine_no);
		
		if(request.getFile("image1")!=null){
			MultipartFile multipartFile=request.getFile("image1");
			String file_name="image1_"+magazine_no;
			String file_ext=multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf('.') + 1);
			
			if (file_ext != "") {
				String full_name = file_name + "." + file_ext;
				File file = new File(filePath3 + full_name);

				if (!file.exists()) {
					file.mkdirs();
				}

				try {
					multipartFile.transferTo(file);
				} catch (Exception e) {
				}

				magazineModel.setImage1(full_name);

			}
		} else {
			magazineModel.setImage1(magazineModel.getImage1());
		}
		if (request.getFile("image2") != null) {
			MultipartFile multipartFile2 = request.getFile("image2");
			String file_name2 = "image2_" + magazine_no;
			String file_ext2 = multipartFile2.getOriginalFilename()
					.substring(multipartFile2.getOriginalFilename().lastIndexOf('.') + 1);

			if (file_ext2 != "") {
				String full_name2 = file_name2 + "." + file_ext2;
				File file2 = new File(filePath3 + full_name2);

				if (!file2.exists()) {
					file2.mkdirs();
				}

				try {
					multipartFile2.transferTo(file2);
				} catch (Exception e) {
				}
				magazineModel.setImage2(full_name2);
			}
		} else {
			magazineModel.setImage2(magazineModel.getImage2());
		}
		System.out.println(magazineModel.getSubject());
		magazineService.magazineUpdate(magazineModel);
		return "redirect:adminMagazineList.mt";
	}	
	
	@RequestMapping(value = "/adminQnaList.mt")
	public ModelAndView qnaList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String isSearch=null;
		int searchNum=0;
		List<QnaModel> qnaList = qnaService.qnaList();

		/* 페이징 */
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty() || request.getParameter("currentPage").equals("0")) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		totalCount = qnaList.size();

		/* 검색 */
		isSearch = request.getParameter("isSearch");

		if (isSearch != null) {
			searchNum = Integer.parseInt(request.getParameter("searchNum"));

			if (searchNum == 0)
				qnaList = qnaService.qnaSearch0(isSearch);
			else if (searchNum == 1)
				qnaList = qnaService.qnaSearch1(isSearch);
			else if (searchNum == 2)
				qnaList = qnaService.qnaSearch2(isSearch);
			
			totalCount = qnaList.size();//
			paging = new Paging(currentPage, totalCount, blockCount, blockpaging, "qnaList", searchNum, isSearch);//
			pagingHtml = paging.getPagingHtml().toString();//
			
			int lastCount = totalCount;
			
			if(paging.getEndCount() < totalCount)
				lastCount = paging.getEndCount() + 1;
			
			qnaList = qnaList.subList(paging.getStartCount(), lastCount);
		
			mav.addObject("isSearch", isSearch);
			mav.addObject("searchNum", searchNum);
			mav.addObject("totalCount", totalCount);
			mav.addObject("pagingHtml", pagingHtml);
			mav.addObject("currentPage", currentPage);
			mav.addObject("qnaList", qnaList);
			mav.setViewName("adminQnaList");
			return mav;
		
		}
		
		qnaList = qnaService.qnaList();
		totalCount = qnaList.size();
		paging = new Paging(currentPage, totalCount, blockCount, blockpaging, "adminQnaList");
		pagingHtml = paging.getPagingHtml().toString();

		int lastCount = totalCount;

		if (paging.getEndCount() < totalCount)
			lastCount = paging.getEndCount() + 1;

		qnaList = qnaList.subList(paging.getStartCount(), lastCount);

		mav.addObject("totalCount", totalCount);
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("qnaList", qnaList);
		mav.addObject("currentpaging", currentPage);
		mav.setViewName("adminQnaList");
		return mav;
	}
	
	@RequestMapping(value = "/adminQnaView.mt", method = RequestMethod.GET)
	public ModelAndView qnaView(HttpServletRequest request, HttpSession session) {

		ModelAndView mvv = new ModelAndView();
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));

		qnaService.qnaUpdateReadhit(qna_no);
		QnaModel qnaModel = qnaService.qnaView(qna_no);

		String s= (String) session.getAttribute("session_member_grade");
		if(qnaModel.getRef() == qnaModel.getQna_no()){
			//글이 답변글이 아닌경우(원본글)
			mvv.addObject("ref", 0);
		}else{
			mvv.addObject("ref", 1);
			//일반인이면 안보이게(답변글)
		}
		mvv.addObject("currentPage", currentPage);
		mvv.addObject("qnaModel", qnaModel);
		mvv.setViewName("adminQnaView");
		return mvv;
	}

	@RequestMapping(value = "/adminQnaWrite.mt", method = RequestMethod.GET)
	public ModelAndView qnaWrite(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminQnaWrite");
		return mav;
	}

	@RequestMapping(value = "/adminQnaWrite.mt", method = RequestMethod.POST)
	public String qnaWriteSql(@ModelAttribute("qnaModel") QnaModel qnaModel, HttpServletRequest request) {

		qnaModel.setRe_step(0);
		qnaModel.setReadhit(0);
		qnaModel.setPasswd("admin");//
		qnaService.qnaWrite(qnaModel);

		return "redirect:/admin/adminQnaList.mt";

	}
	
	@RequestMapping(value = "/adminQnaDelete.mt")
	public ModelAndView qnaDelete(QnaModel qnaModel, BindingResult result, HttpSession session,
			HttpServletRequest request) {
		int deleteCheck;
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		ModelAndView mav = new ModelAndView();
		String passwd = request.getParameter("passwd");
		qnaModel = qnaService.qnaView(qna_no);
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		System.out.println(currentPage);
	      if (qnaModel.getPasswd().equals(passwd)){
	    	  if(qnaModel.getRef()==qnaModel.getQna_no())
	    	  {
	    		  //System.out.println("원본글");
	    		  deleteCheck=1;
	    		  qnaService.qnaDelete2(qnaModel.getRef());
	    	  }else{
	    		  //System.out.println("원본글이 아님");
	    		  deleteCheck=1;
		         qnaService.qnaDelete(qna_no);
	    	  } 
	      } else {
	    	  deleteCheck=-1;
	    	  mav.setViewName("/checkForm.mt");
	      }
	      mav.addObject("deleteCheck",deleteCheck);
	      mav.addObject("currentPage", currentPage);
	      mav.setViewName("admin/adminQnaDeleteResult");
	      return mav;
	}
	
	@RequestMapping(value="/checkForm.mt",method=RequestMethod.GET)
	public ModelAndView qnaCheck(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		String qna_no = request.getParameter("qna_no");
		mav.addObject("qna_no",qna_no);
		mav.setViewName("admin/adminQnaCheck");
		return mav;
	}
	
	@RequestMapping(value = "/adminQnaReply.mt", method = RequestMethod.GET)
	public ModelAndView qnaReplyForm(QnaModel qnaModel, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		qnaModel = qnaService.qnaView(qna_no);

		String content = qnaModel.getContent().replaceAll("<br />", "\r\n");
		qnaModel.setContent(content);
		qnaModel.setRe_step(1);

		mav.addObject("qnaModel", qnaModel);
		mav.setViewName("adminQnaReply");
		return mav;
	}

	@RequestMapping(value = "/adminQnaReplySuccess.mt")
	public ModelAndView qnaReply(@ModelAttribute("QnaModel") QnaModel qnaModel, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		qnaModel.setRef(qna_no);
		qnaModel.setRe_step(1);
		//관리자용 비밀번호 설정
		qnaModel.setPasswd("admin");
		String content = qnaModel.getContent().replaceAll("\r\n", "<br />");
		qnaModel.setContent(content);
		qnaService.qnaWriteReply(qnaModel);
		mav.addObject("currentPage", currentPage);
		mav.setViewName("redirect:/admin/adminQnaList.mt");
		return mav;
	}
	
	 @RequestMapping(value = "/adminQnaModifyChk.mt")
	 public ModelAndView Modify(@ModelAttribute("qnaModel") QnaModel qnaModel, BindingResult result, HttpSession session, HttpServletRequest request) {
	  
		 int modifyCheck;
		 int qna_no=Integer.parseInt(request.getParameter("qna_no"));
		 ModelAndView mav=new ModelAndView();
		 String passwd=request.getParameter("passwd");
	   
		 QnaModel qnaModel2 = new QnaModel();
		 qnaModel2=qnaService.qnaView(qna_no);
	   
		 if (qnaModel2.getPasswd().equals(passwd)){
			 modifyCheck=1;
		 } else {
		  //틀리다면
			 modifyCheck=-1;
		 }
		 mav.addObject("qnaModel", qnaModel);
		 mav.addObject("modifyCheck",modifyCheck);
		 mav.setViewName("admin/adminQnaModifyResult");
		 return mav;
	 }
	 @RequestMapping(value ="/adminQnaModify.mt", method = RequestMethod.GET)
	 public ModelAndView qnaModifyForm(@ModelAttribute("qnaModel") QnaModel qnaModel, BindingResult result, HttpServletRequest request) {
		 ModelAndView mav = new ModelAndView();
		 
		 int qna_no=Integer.parseInt(request.getParameter("qna_no"));
		 
		 qnaModel = qnaService.qnaView(qna_no);
		 qnaModel.setQna_no(qna_no);
		 
		 mav.addObject("qnaModel", qnaModel);
		 mav.setViewName("adminQnaModify");
		return mav;
	 }
	 
	@RequestMapping(value ="/adminQnaModify.mt", method = RequestMethod.POST)
	public ModelAndView qnaModify(@ModelAttribute("qnaModel") QnaModel qnaModel, BindingResult result, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		qnaService.qnaModify(qnaModel);

		mav.setViewName("redirect:/admin/adminQnaList.mt");
		return mav;
	}
	 
}