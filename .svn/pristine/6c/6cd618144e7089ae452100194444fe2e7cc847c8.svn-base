package com.hotsix.notice;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotsix.common.Paging;
import com.hotsix.magazine.MagazineCommentModel;
import com.hotsix.notice.commentPaging;
import com.hotsix.notice.NoticeCommentModel;
import com.hotsix.notice.NoticeModel;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Resource(name = "noticeService")
	private NoticeService noticeService;

	// 검색
	private int searchNum;
	private String isSearch;

	// paging
	private int currentPage = 1; // 현재 페이지
	private int totalCount; // 총 게시물의 수
	private int blockCount = 4; // 현재 페이지에 보여줄 게시물의 갯수
	private int blockPage = 5; // 보여줄 페이지의 갯수
	private String pagingHtml; // paging을 구현한 HTML
	private Paging page; // 페이징 클래스의 변수 선언

	private int currentPage2 = 1;
	private int totalCount2;
	private int blockCount2 = 3;
	private int blockPage2 = 5;
	private String pagingHtml2;
	private commentPaging page2;

	ModelAndView mav = new ModelAndView();

	// 리스트
	@RequestMapping(value = "/noticeList.mt", method = RequestMethod.GET)
	public ModelAndView noticeList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

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
			// isSearch값이 null 일떄..

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
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "noticeList", searchNum, isSearch);
			pagingHtml = page.getPagingHtml().toString();
			// page 객체생성을 하고 내용물을 담는다

			int lastCount = totalCount;
			// 인트타입 마지막수 = 총갯수
			if (page.getEndCount() < totalCount) {
				lastCount = page.getEndCount() + 1;
			}
			// 페이지가 끝난 갯수가 총갯수보다 작으면 끝난갯수에 +1을해서 마지막갯수에 담는다.
			noticeList = noticeList.subList(page.getStartCount(), lastCount);
			// 시작번호와 끝번호만큼 subList로 이용해서 자른다.

			mav.addObject("isSearch", isSearch);
			mav.addObject("searchNum", searchNum);
			mav.addObject("totalCount", totalCount);
			mav.addObject("pagingHtml", pagingHtml);
			mav.addObject("currentPage", currentPage);
			mav.addObject("noticeList", noticeList);
			mav.setViewName("noticeList");

			return mav;
		}
		// 검색없을때 paging
		noticeList = noticeService.noticeList();
		// noticeList에 noticeService를 담아서 사용
		totalCount = noticeList.size();
		// 총갯수 = 리스트에 출력된 갯수
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "noticeList");
		pagingHtml = page.getPagingHtml().toString();
		// page 객체생성후 Paging에 currentPage, totalCount, blockCount, blockPage,
		// noticeList를 담는다
		// page에 객체생성한 것들을 pagingHtml에 담는다.
		int lastCount = totalCount;
		// int타입으로 총갯수를 마지막갯수에 담는다.
		if (page.getEndCount() < totalCount) {
			lastCount = page.getEndCount() + 1;
		}
		// 끝에 갯수가 총 갯수보다 작으면 마지막수에 +1증가.
		noticeList = noticeList.subList(page.getStartCount(), lastCount);

		mav.addObject("totalCount", totalCount);
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("currentPage", currentPage);
		mav.addObject("noticeList", noticeList);
		mav.setViewName("noticeList");

		return mav;
	}

	// 글쓰기 폼
	// 맵핑 noticeWrite.mt 하고 GET방식으로 받는다
	@RequestMapping(value = "/noticeWrite.mt", method = RequestMethod.GET)
	public ModelAndView noticeWriteForm(HttpServletRequest request) {
		// request값을 받아서 noticeWriteForm으로 받아 ModelAndView로 받는다.
		ModelAndView mav = new ModelAndView();
		// 객체생성
		mav.setViewName("noticeForm");// 다 작업을 맞치면 폼으로 이동
		return mav;
		/* return "noticeWrite"; */
	}

	// 글 쓰기
	@RequestMapping(value = "/noticeWrite.mt", method = RequestMethod.POST)
	public ModelAndView noticeWrite(@ModelAttribute("noticeModel") NoticeModel noticeModel, BindingResult result,
			HttpServletRequest request) throws IOException {

		ModelAndView mav = new ModelAndView();
		// 객체생성
		String contents = noticeModel.getContents().replace("/r/n", "<br/>");
		/* Date regdate; */
		// noticeModel에 Contents값을 받아서 String 값에 담는다.
		/*
		 * regdate = new
		 * SimpleDateFormat("yyyy.MM.dd").parse(request.getParameter("regdate"))
		 * ;
		 */
		noticeModel.setContents(contents);// noticeModel에 Contents값을 설정
		noticeService.noticeWrite(noticeModel);
		mav.addObject("noticeModel", noticeModel);
		mav.setViewName("redirect:/notice/noticeList.mt");
		// 작업을다끝마쳤으면 리스트로 이동
		return mav;
	}

	// 상세보기
	@RequestMapping("/noticeView.mt")
	public ModelAndView noticeView(HttpServletRequest request) {
		if (request.getParameter("currentPage2") == null || request.getParameter("currentPage2").trim().isEmpty()
				|| request.getParameter("currentPage2").equals("0")) {
			currentPage2 = 1;
		} else {
			currentPage2 = Integer.parseInt(request.getParameter("currentPage2"));
		}

		ModelAndView mav = new ModelAndView();
		int no = Integer.parseInt(request.getParameter("no"));
		int notice_no = Integer.parseInt(request.getParameter("no"));

		List<NoticeCommentModel> noticecommentlist = noticeService.noticecommentList(notice_no);
		noticecommentlist = noticeService.noticecommentList(notice_no);
		NoticeCommentModel cmt = new NoticeCommentModel();
		cmt.setNotice_no(notice_no);
		int cmtcount = noticeService.cmtcount(cmt.getNotice_no());
		cmt.setNotice_no(notice_no);
		totalCount2 = noticecommentlist.size();
		NoticeModel noticeModel = new NoticeModel();
		noticeModel.setNo(no);
		noticeModel = noticeService.noticeView(no);

		page2 = new commentPaging(currentPage2, totalCount2, blockCount2, blockPage2, no);
		pagingHtml2 = page2.getPagingHtml2().toString();

		int lastCount2 = totalCount2;

		if (page2.getEndCount2() < totalCount2)
			lastCount2 = page2.getEndCount2() + 1;

		noticecommentlist = noticecommentlist.subList(page2.getStartCount2(), lastCount2);
		noticeService.noticeUpdateReadhit(no);
       
		mav.addObject("cmtcount", cmtcount);
		mav.addObject("totalCount2", totalCount2);
		mav.addObject("pagingHtml2", pagingHtml2);
		mav.addObject("currentPage2", currentPage2);
	    mav.addObject("currentPage", currentPage); 
		mav.addObject("noticeModel", noticeModel);
		mav.addObject("noticecommentlist", noticecommentlist);
		mav.setViewName("noticeView");
		return mav;
	}

	@RequestMapping(value = "/noticeCommentDelete.mt", method = RequestMethod.GET)
		public ModelAndView noticecommentDelete(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		NoticeCommentModel ncModel = new NoticeCommentModel();
		//뷰페이지에 넘어가려면 no값을 notice_no에 담아서 리다이렉트에서 안고가야댐
		int notice_no = Integer.parseInt(request.getParameter("no"));		
		int noticecomment_no = Integer.parseInt(request.getParameter("noticecomment_no"));
		//글삭제하려고 번호를 담아가야됨
		ncModel.setNoticecomment_no(noticecomment_no);
		//noModel에 코멘트넘버 설정
		noticeService.noticedeletecomment(noticecomment_no);
		//쿼리문 불러오는것 코멘트델리트쿼리문
		//System.out.println("코멘트번호:" + noticecomment_no);
		//다마친후 뷰페이지로 notice_no을 데리고 간다.
		mav.setViewName("redirect:/notice/noticeView.mt?no="+notice_no);
		return mav;
	}

	@RequestMapping("/noticeWriteComment.mt")
	public ModelAndView commentWrite(HttpServletRequest request,HttpSession session) {
		
		ModelAndView mav=new ModelAndView();
		NoticeCommentModel ncModel = new NoticeCommentModel();
		int notice_no = Integer.parseInt(request.getParameter("no"));
		//리스트 넘버를 파라미터값으로 받는다
		ncModel.setContents(request.getParameter("contents").replaceAll("\r\n", "<br />"));
		ncModel.setNotice_no(notice_no);
		//notice_no값을 ncModel값으로설정
		ncModel.setName(request.getParameter("name"));
		noticeService.noticewritecomment(ncModel);
		mav.addObject("ncModel", ncModel);
		mav.setViewName("redirect:noticeView.mt?no="+notice_no);
		//작업을 마친후 위에설정한 notice_no값을 안고 뷰페이지로간다.
		
		return mav;
	}
	/*@RequestMapping("/noticeWriteComment.mt")
	public ModelAndView commentWrite(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		NoticeCommentModel ncModel = new NoticeCommentModel();

		if (request.getParameter("currentPage2") == null || request.getParameter("currentPage2").trim().isEmpty()
				|| request.getParameter("currentPage2").equals("0")) {
			currentPage2 = 1;
		} else {
			currentPage2 = Integer.parseInt(request.getParameter("currentPage2"));
		}
		
		 * if(request.getParameter("content").equals("") ||
		 * request.getParameter("content").trim().isEmpty()) {
		 * mav.setViewName("magazine/Confirm"); return mav; }
		 

		int notice_no = Integer.parseInt(request.getParameter("no"));
		ncModel.setContents(request.getParameter("contents").replaceAll("\r\n", "<br />"));
		ncModel.setNotice_no(notice_no);
		ncModel.setName(request.getParameter("name"));
		noticeService.noticewritecomment(ncModel);

		mav.setViewName("redirect:noticeView.mt?no="+notice_no);
		return mav;

	}*/

	// 글수정폼
	@RequestMapping(value = "/noticeModify.mt", method = RequestMethod.GET)
	public ModelAndView noticeModifyForm(@ModelAttribute("noticeModel") NoticeModel noticeModel,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		int no = Integer.parseInt(request.getParameter("no"));
		noticeModel = noticeService.noticeView(no);
		// noticeView에 no값을 noticeService에담아서 noticeModel로 사용
		mav.addObject("noticeModel", noticeModel);
		mav.setViewName("noticeModify");
		return mav;
	}

	// 글수정
	@RequestMapping(value = "/noticeModify.mt", method = RequestMethod.POST)
	public ModelAndView noticeModify(@ModelAttribute("noticeModel") NoticeModel noticeModel, HttpServletRequest request,
			String contents) {

		ModelAndView mav = new ModelAndView();

		int no = Integer.parseInt(request.getParameter("no"));
		noticeModel = noticeService.noticeView(no);
		// noticeModel = noticeService에있는 noticeView설정한값에 no값을 담는다.
		noticeModel.setNo(no);// no값을 설정
		noticeModel.setSubject(request.getParameter("subject"));
		// subject값을 받아서 설정한다
		noticeModel.setContents(contents);// contents값 설정
		noticeService.noticeModify(noticeModel);
		// noticeService에 noticeModify값에 noticeModel을 담는다.
		mav.addObject("noticeModel", noticeModel);
		mav.setViewName("redirect:/notice/noticeList.mt");
		return mav;

	}

	/*
	 * // 글삭제
	 * 
	 * @RequestMapping(value = "/noticeDelete.mt", method = RequestMethod.GET)
	 * public ModelAndView noticeDelete(HttpServletRequest request) {
	 * ModelAndView mav = new ModelAndView();
	 * 
	 * int no = Integer.parseInt(request.getParameter("no"));
	 * 
	 * noticeService.noticeDelete(no);
	 * mav.setViewName("redirect:/notice/noticeList.mt"); return mav;
	 * 
	 * }
	 */
}