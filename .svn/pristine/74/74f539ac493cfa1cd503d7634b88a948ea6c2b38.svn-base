package com.hotsix.event;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hotsix.common.Paging;

@Controller
@RequestMapping("/event")
public class EventController {
	// 공통으로 쓰는 부분
	@Resource(name = "eventService")
	private EventService eventService;

	// filepath
	// private static final String filePath = "C:\\java\\app\\MovieTicket\\src\\main\\webapp\\upload\\";
	
	//검색
	private int searchNum;
	private String isSearch;

	// paging
	private int currentPage = 1; // 현재 페이지
	private int totalCount; // 총 게시물의 수
	private int blockCount = 4; // 현재 페이지에 보여줄 게시물의 갯수
	private int blockPage = 5; // 보여줄 페이지의 갯수
	private String pagingHtml; // paging을 구현한 HTML
	private Paging page; // 페이징 클래스의 변수 선언
	

	ModelAndView mav = new ModelAndView();

	// 유효성검사시 EventModel객체로 리턴
	@ModelAttribute("eventModel")
	public EventModel formBack() {
		return new EventModel();
	}

	// 리스트
	@RequestMapping(value = "/eventList.mt", method = RequestMethod.GET)
	public ModelAndView eventList(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();

		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) {
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
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "eventList", searchNum, isSearch);
			pagingHtml = page.getPagingHtml().toString();
			
			int lastCount = totalCount;
			
			if(page.getEndCount() < totalCount){
				lastCount = page.getEndCount() + 1;
			}
			
			eventList = eventList.subList(page.getStartCount(), lastCount);
			
			mav.addObject("isSearch", isSearch);
			mav.addObject("searchNum", searchNum);
			mav.addObject("totalCount", totalCount);
			mav.addObject("pagingHtml", pagingHtml);
			mav.addObject("currentPage", currentPage);
			mav.addObject("eventList", eventList);
			mav.setViewName("eventList");
			return mav;
				
		}
		
		//검색없을때  paging	
		eventList = eventService.eventList();

		totalCount = eventList.size();

		page = new Paging(currentPage, totalCount, blockCount, blockPage, "eventList");
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount){
			lastCount = page.getEndCount() + 1;
		}

		eventList = eventList.subList(page.getStartCount(), lastCount);

		mav.addObject("totalCount", totalCount);
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("currentPage", currentPage);
		mav.addObject("eventList", eventList);
		mav.setViewName("eventList");

		return mav;
	}
	
	// 상세보기
	@RequestMapping("/eventView.mt")
	public ModelAndView eventView(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();

		int event_no = Integer.parseInt(request.getParameter("event_no"));

		EventModel eventModel = new EventModel();
		eventModel.setEvent_no(event_no);
		eventModel = eventService.eventView(event_no);

		mav.addObject("eventModel", eventModel);
		mav.setViewName("eventView");
		return mav;
	}

	/*// 글쓰기 폼
	@RequestMapping(value = "/eventWrite.mt", method = RequestMethod.GET)
	public ModelAndView eventWriteForm(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();

		mav.setViewName("eventWrite");
		return mav;
	}

	// 글쓰기
	@RequestMapping(value = "/eventWrite.mt", method = RequestMethod.POST)
	public ModelAndView eventWrite(@ModelAttribute("eventModel") EventModel eventModel,
			HttpServletRequest request, MultipartHttpServletRequest multipartHttpServletRequest) throws IOException {
		
		ModelAndView mav = new ModelAndView();

		String content = eventModel.getContent().replace("/r/n", "<br/>");
		Date e_start_date;
		Date e_end_date;

		int seqName = eventService.getEventSEQ();
		eventModel.setEvent_no(seqName);

		try {
			e_start_date = new SimpleDateFormat("yyyy.MM.dd").parse(request.getParameter("e_start_date"));
			e_end_date = new SimpleDateFormat("yyyy.MM.dd").parse(request.getParameter("e_end_date"));
			eventModel.setContent(content);
			eventModel.setE_start_date(e_start_date);
			eventModel.setE_end_date(e_end_date);

			MultipartFile multipartFile = multipartHttpServletRequest.getFile("image1");
			String file_name = "image1_" + seqName;
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
				eventModel.setImage1(full_name);
			}

			eventService.eventWrite(eventModel);

			mav.addObject("eventModel", eventModel);
			mav.setViewName("redirect:/event/eventList.mt");
			return mav;

		} catch (ParseException e) {
			e.printStackTrace();
			mav.setViewName("eventWrite");
			return mav;
		}
	}*/


	/*// 글수정폼
	@RequestMapping(value = "/eventUpdate.mt", method = RequestMethod.GET)
	public ModelAndView eventUpdateForm(@ModelAttribute("eventModel") EventModel eventModel,
			HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();

		int event_no = Integer.parseInt(request.getParameter("event_no"));
		eventModel = eventService.eventView(event_no);

		String content = eventModel.getContent().replace("/r/n", "<br/>");
		eventModel.setContent(content);

		mav.addObject("eventModel", eventModel);
		mav.setViewName("eventUpdate");
		return mav;
	}

	// 글수정
		@RequestMapping(value = "/eventUpdate.mt", method = RequestMethod.POST)
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
				eventModel.setE_start_date(new SimpleDateFormat("yyyy.MM.dd").parse(request.getParameter("e_start_date")));
				eventModel.setE_end_date(new SimpleDateFormat("yyyy.MM.dd").parse(request.getParameter("e_end_date")));
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
					File file = new File(filePath + full_name);

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

			mav.addObject("eventModel", eventModel);
			mav.setViewName("redirect:/event/eventList.mt");
			return mav;

		}

	// 글삭제
	@RequestMapping(value = "/eventDelete.mt", method = RequestMethod.GET)
	public ModelAndView eventDelete(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		int event_no = Integer.parseInt(request.getParameter("event_no"));

		eventService.eventDelete(event_no);
		mav.setViewName("redirect:/event/eventList.mt");
		return mav;
	}*/

}
