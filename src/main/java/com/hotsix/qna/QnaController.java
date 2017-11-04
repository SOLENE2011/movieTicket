package com.hotsix.qna;
import java.security.Provider.Service;
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

@Controller
@RequestMapping("/qna")
public class QnaController {
	@Resource
	private QnaService qnaService;

	private int searchNum;
	private String isSearch;

	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 4;
	private int blockPage = 5;
	private String pagingHtml;
	private Paging page;

	@ModelAttribute
	public QnaModel formBack() {
		return new QnaModel();
	}

	@RequestMapping(value = "/qnaList.mt")
	public ModelAndView qnaList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<QnaModel> qnaList = qnaService.qnaList();

		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		totalCount = qnaList.size();

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
			page = new Paging(currentPage, totalCount, blockCount, blockPage, "qnaList", searchNum, isSearch);//
			pagingHtml = page.getPagingHtml().toString();//
			
			int lastCount = totalCount;
			
			if(page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;
			
			qnaList = qnaList.subList(page.getStartCount(), lastCount);
		
			mav.addObject("isSearch", isSearch);
			mav.addObject("searchNum", searchNum);
			mav.addObject("totalCount", totalCount);
			mav.addObject("pagingHtml", pagingHtml);
			mav.addObject("currentPage", currentPage);
			mav.addObject("qnaList", qnaList);
			mav.setViewName("qnaList");
			return mav;
		
		}
		qnaList=qnaService.qnaList();
		totalCount=qnaList.size();
		page = new Paging(currentPage, totalCount, blockCount, blockPage, "qnaList");
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		qnaList = qnaList.subList(page.getStartCount(), lastCount);

		mav.addObject("totalCount", totalCount);
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("qnaList", qnaList);
		mav.addObject("currentPage", currentPage);
		mav.setViewName("qnaList");
		return mav;
	}

	@RequestMapping(value = "/qnaView.mt", method = RequestMethod.GET)
	public ModelAndView qnaView(HttpServletRequest request, HttpSession session) {

		ModelAndView mvv = new ModelAndView();
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));

		qnaService.qnaUpdateReadhit(qna_no);
		QnaModel qnaModel = qnaService.qnaView(qna_no);

		String s= (String) session.getAttribute("session_member_grade");
		if(qnaModel.getRef() == qnaModel.getQna_no()){
			mvv.addObject("ref", 0);
			
		}else{
			mvv.addObject("ref", 1);
			if(s==null){
				
			}
			
			
		}
	//	mvv.addObject("list", list);
		mvv.addObject("currentPage", currentPage);
		mvv.addObject("qnaModel", qnaModel);
		mvv.setViewName("qnaView");
		return mvv;
	}

	@RequestMapping(value = "/qnaWrite.mt", method = RequestMethod.GET)
	public ModelAndView qnaWrite(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qnaWrite");
		return mav;
	}

	@RequestMapping(value = "/qnaWrite.mt", method = RequestMethod.POST)
	public String qnaWriteSql(@ModelAttribute("qnaModel") QnaModel qnaModel, HttpServletRequest request) {

		qnaModel.setRe_step(0);
		qnaModel.setReadhit(0);
		qnaService.qnaWrite(qnaModel);

		return "redirect:/qna/qnaList.mt";

	}

	@RequestMapping(value = "/qnaDelete.mt")
	public ModelAndView qnaDelete(QnaModel qnaModel, BindingResult result, HttpSession session,
			HttpServletRequest request) {
		int deleteCheck;
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		ModelAndView mav = new ModelAndView();
		String passwd = request.getParameter("passwd");
		qnaModel = qnaService.qnaView(qna_no);

		System.out.println(qnaModel.getRef());
		System.out.println("@@@");
		System.out.println(qnaModel.getQna_no());
		
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
	      mav.setViewName("qna/qnaDeleteResult");
			return mav;
		}

	@RequestMapping(value="/checkForm.mt",method=RequestMethod.GET)
	public ModelAndView qnaCheck(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		String qna_no = request.getParameter("qna_no");
		mav.addObject("qna_no",qna_no);
		mav.setViewName("qna/qnaCheck");
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
		mav.setViewName("qnaReply");
		return mav;
	}

	@RequestMapping(value = "/adminQnaReplySuccess.mt")
	public ModelAndView qnaReply(@ModelAttribute("QnaModel") QnaModel qnaModel, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		//System.out.println(qnaModel.getPasswd());
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));

		qnaModel.setRef(qna_no);
		qnaModel.setRe_step(1);

		
		qnaModel.setPasswd("admin");
		
		String content = qnaModel.getContent().replaceAll("\r\n", "<br />");
		qnaModel.setContent(content);
		
		qnaService.qnaWriteReply(qnaModel);

		mav.addObject("currentPage", currentPage);
		mav.setViewName("redirect:/qna/qnaList.mt");
		return mav;
	}
	
	
	
	 @RequestMapping(value = "/qnaModifyChk.mt")
	   public ModelAndView Modify(@ModelAttribute("qnaModel") QnaModel qnaModel, BindingResult result, HttpSession session, HttpServletRequest request) {
		  
		   int modifyCheck;
	       int qna_no=Integer.parseInt(request.getParameter("qna_no"));
	      /* QnaModel qnaModel=new QnaModel();*/
	       ModelAndView mav=new ModelAndView();
	       String passwd=request.getParameter("passwd");
	       
	       QnaModel qnaModel2 = new QnaModel();
	       qnaModel2=qnaService.qnaView(qna_no);
	       
	       
	      if (qnaModel2.getPasswd().equals(passwd)){
	    	  modifyCheck=1;
	      } else {
	    	  modifyCheck=-1;
	      }
	      mav.addObject("qnaModel", qnaModel);
	      mav.addObject("modifyCheck",modifyCheck);
	      mav.setViewName("qna/qnaModifyResult");
			return mav;
		}
	   
		/*@RequestMapping(value="/checkForm.mt",method=RequestMethod.GET)
		public ModelAndView modifyCheck(HttpServletRequest request){
			ModelAndView mav=new ModelAndView();
			
			String qna_no = request.getParameter("qna_no");
			
			
			mav.addObject("qna_no",qna_no);
			mav.setViewName("qna/qnaModifyCheck");
			return mav;
		}*/
	 @RequestMapping(value ="/qnaModify.mt", method = RequestMethod.GET)
		public ModelAndView qnaModifyForm(@ModelAttribute("qnaModel") QnaModel qnaModel, BindingResult result,
				HttpServletRequest request) {
		 ModelAndView mav = new ModelAndView();
		 
		 int qna_no=Integer.parseInt(request.getParameter("qna_no"));
		 
		 qnaModel = qnaService.qnaView(qna_no);
		 qnaModel.setQna_no(qna_no);
		 
		 mav.addObject("qnaModel", qnaModel);
		 mav.setViewName("qnaModify");
		return mav;
	 }
	 
	 
		@RequestMapping(value ="/qnaModify.mt", method = RequestMethod.POST)
		public ModelAndView qnaModify(@ModelAttribute("qnaModel") QnaModel qnaModel, BindingResult result,
				HttpServletRequest request) {

			ModelAndView mav = new ModelAndView();
			
			
			qnaService.qnaModify(qnaModel);

			mav.setViewName("redirect:/qna/qnaList.mt");
			return mav;
		}
		
}