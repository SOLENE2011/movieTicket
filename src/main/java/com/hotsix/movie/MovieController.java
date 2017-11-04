package com.hotsix.movie;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotsix.common.Paging;



@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Resource
	private MovieService movieService;
	
	private int currentPage = 1;
	private int totalCount;
	private int blockCount = 10;
	private int blockPage = 5;
	private String pagingHtml;
	private Paging paging;
	
	
	// 상영작 리스트
	// /project/admin/movieList.mt
	@RequestMapping(value="/movieList.mt",method = RequestMethod.GET)
	public ModelAndView movieList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		
		List<MovieModel> movieList = movieService.movieList();
		
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) {
			currentPage = 1;
		}
		else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		totalCount = movieList.size();
		
		paging = new Paging(currentPage, totalCount, blockCount, blockPage, "movieList");
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
		
		
		mv.setViewName("movieList");
		return mv;
	}
	
	// 상영작 상세보기
	// movieView.mt
	@RequestMapping(value="/movieView.mt",method = RequestMethod.GET)
	public ModelAndView movieView(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		
		int no = Integer.parseInt(request.getParameter("movie_no"));
		
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().isEmpty()
				|| request.getParameter("currentPage").equals("0")) {
			currentPage = 1;
		}
		else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		List<MovieModel> list2 = movieService.movieList_one(no);
		
		
		mv.addObject("currentPage", currentPage);
		mv.addObject("list", list2);
		mv.setViewName("movieView");
		return mv;
	}
	
	@RequestMapping(value="/movieGrade.mt",method = RequestMethod.POST)
	public ModelAndView movieGrade(@ModelAttribute("list") MovieModel movieModel, HttpServletRequest request, HttpSession session){
		
		ModelAndView mav = new ModelAndView();
		Integer session_member_no;
		
		int movie_no = Integer.parseInt(request.getParameter("movie_no"));
		session_member_no = (Integer)session.getAttribute("session_member_no");
		
		// 로그인 세션 여부 검사
		if(session.getAttribute("session_member_id") == null){
			mav.setViewName("common/loginConfirm");
			return mav;
		}
		
		MovieGradeModel movieGradeModel = new MovieGradeModel();
		movieGradeModel.setMember_no(session_member_no);
		movieGradeModel.setMovie_no(Integer.parseInt(request.getParameter("movie_no")));
		
		MovieGradeModel movieGradeCheck = movieService.gradecheck(movieGradeModel);
		
		// 중복이면
		if(movieGradeCheck != null){
			mav.setViewName("movie/GradeCheckConfirm");
			return mav;
		}
		
		movieModel.setMovie_no(movieModel.getMovie_no());
		movieModel.setMovie_score(movieModel.getMovie_score());
		
		movieService.updatemovieScore(movieModel);
		movieService.insertgradecheck(movieGradeModel);
		
		movieModel = movieService.movieList_one_(movieModel.getMovie_no());
		mav.addObject("list", movieModel);
		mav.setViewName("redirect:movieView.mt?movie_no="+movie_no);
		
		return mav;
	}
}
