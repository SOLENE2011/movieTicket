package com.hotsix.reserve;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.hotsix.admin.AdminService;
import com.hotsix.member.MemberModel;
import com.hotsix.movie.MovieModel;

@Controller
@RequestMapping("/reserve")
public class ReserveController {
	
	String session_member_id;
	String category = null;
	String playdate = null;
	int movie_no ;
	List<TimetableModel> list = new ArrayList<TimetableModel>();
	int time_detail_no;
	List<TimetableDetailModel> timeDetailList = new ArrayList<TimetableDetailModel>();
	
	@Resource
	private AdminService adminService;
	@Resource
	private ReserveService reserveService;
	
	@RequestMapping(value="/reserveMain.mt",method = RequestMethod.GET)
	public ModelAndView reserveMain(HttpServletRequest request, HttpSession session){
		ModelAndView mv = new ModelAndView();
		
		List<MovieModel> timeList = new ArrayList<MovieModel>();
		//timeList = adminService.timeList();
		//session_member_id = (String) ;
		//Integer member_no = (Integer) session.getAttribute("session_member_no");
		//System.out.println(session.getAttribute("session_member_id"));
		
		if(session.getAttribute("session_member_id") == null){
			mv.setViewName("reserve/loginConfirm");
			
			return mv;
		}
		
		timeList = reserveService.getTimeMovieData();
		
		//System.out.println(timeList.size());
		mv.addObject("list", timeList);
		mv.setViewName("reserveMain");
		return mv;
	}
	
	
	
	
	@RequestMapping(value="/timeTableData.mt")
	public ModelAndView timeTableData(@ModelAttribute("timetableModel")TimetableModel timetableModel, HttpServletRequest request){
	
		category = request.getParameter("category");
		movie_no = Integer.parseInt(request.getParameter("movie_no"));
		playdate = request.getParameter("playdate");
		/*
		System.out.println(category);
		System.out.println(movie_no );
		System.out.println(playdate);
		*/
		ModelAndView mav = new ModelAndView();
		
		if(category.equals("movie")){
			
			//System.out.println(category);
			
			list = reserveService.getCurrentScreeningMovie();
			System.out.println(list);
			mav.addObject("list",list);
			mav.setViewName("reserve/timetable_data");
			return mav;
		}else if(category.equals("playdates")){
			
			list = reserveService.getPlaydates(movie_no);
			
			//System.out.println(list);
			
			mav.addObject("list", list);
			mav.setViewName("reserve/timetable_data");
			
			return mav;
		}else if(category.equals("list")){
			System.out.println("list");
			timetableModel.setMovie_no(movie_no);
			timetableModel.setShow_date(playdate);
			list=reserveService.getTimeList(timetableModel);
			
			mav.addObject("list", list);
			mav.setViewName("reserve/timetable_data");
		}
		
		mav.setViewName("reserve/timetable_data");
		return mav;
	}

	
	@RequestMapping("/reserveData.mt")
	public ModelAndView reserveData(HttpServletRequest request){
		category = request.getParameter("category");
		int key1, key2;
		key1 = Integer.parseInt(request.getParameter("key1"));
		key2 = Integer.parseInt(request.getParameter("key2"));
		
		List<?> tempList = new ArrayList<Object>(); 
		ModelAndView mav = new ModelAndView();
		
		System.out.println(category);
		System.out.println(key1);
		System.out.println(key2);
		
		
		
		if(category==null){
			mav.setViewName("reserve/reserve_data");
			return mav;
		}
		
		if(category.equals("movie")){
			tempList = new ArrayList<MovieModel>();
			tempList = reserveService.getTimeMovieData();
		}else if(category.equals("room")){
			tempList = new ArrayList<TimetableModel>();
			tempList = reserveService.getTimeRoomData();
		}else if(category.equals("seat")){
			SeatModel seatModel = new SeatModel();
			seatModel.setRoom_no(key1);
			seatModel.setSeat_no(key2);
			tempList = new ArrayList<SeatModel>();
			tempList = reserveService.getTimeSeatData(seatModel);
		}
		
		mav.addObject("category", category);
		mav.addObject("list", tempList);
		mav.setViewName("reserve/reserve_data");
		return mav;
	}
	
	
	@RequestMapping("/timeDetailData.mt")
	public ModelAndView timeDetailData(HttpServletRequest request){
		time_detail_no = Integer.parseInt(request.getParameter("time_detail_no"));
		ModelAndView mav = new ModelAndView();
		//Systemm.out.println("--------timedetail_no-----");
		//Systemm.out.println(time_detail_no);
		timeDetailList = reserveService.getTimeDetailList(time_detail_no);
		//Systemm.out.println("-------------");
		//Systemm.out.println(timeDetailList);
		//System.out.println("타임리스트 : "+timeDetailList);
		mav.addObject("timeDetailList", timeDetailList);
		mav.setViewName("reserve/timedetail_data");
		return mav;
	}
	
	@RequestMapping(value="/reserveComplete.mt", method=RequestMethod.POST)
	public ModelAndView reserveComplete(@ModelAttribute("reserveM")ReserveMasterModel reserveM ,HttpSession session, HttpServletRequest request,
			@RequestParam(value="seat") int[] seat){
	
		ModelAndView mav = new ModelAndView();
		
        //MemberModel mem = new MemberModel();
        
        session_member_id = (String) session.getAttribute("session_member_id");
		Integer member_no = (Integer) session.getAttribute("session_member_no");
		
		String reserve_no;
		int total_amount;
		int adult_cnt, child_cnt, torrent_coin;
		int cnt=0;
		
		adult_cnt = Integer.parseInt(request.getParameter("adult_cnt"));
		child_cnt = Integer.parseInt(request.getParameter("child_cnt"));
		torrent_coin = Integer.parseInt(request.getParameter("torrentcal"));
		total_amount = Integer.parseInt(request.getParameter("total_amount"));
		
		
		
		//test 
		//Systemm.out.println(adult_cnt );
		//Systemm.out.println(child_cnt);
		//Systemm.out.println(teracal);
		
		
		reserve_no= getReserveNo();
		reserveM.setTime_detail_no(time_detail_no);
		reserveM.setReserve_master_no(reserve_no);
		reserveM.setMember_no(member_no);
		reserveM.setAdult(adult_cnt);
		reserveM.setChild(child_cnt);
		reserveM.setTotal_amount(total_amount);
		
		if(session_member_id == null){
			mav.setViewName("reserve/loginConfirm");
			return mav;
		}
		
		reserveService.insertReserveMaster(reserveM);
		
		MemberModel memberM = new MemberModel();
		
		memberM.setMticket_coin(torrent_coin);
		memberM.setMember_no(member_no);
		System.out.println("업데이트 코인 전 : "+memberM.getMticket_coin());
		reserveService.updateTorrentcoin(memberM);
		System.out.println("업데이트 코인 후 : "+memberM.getMticket_coin());
		ReserveDetailModel reserveD = new ReserveDetailModel();
		
		//Detail Insert : All selected Seat
		for (int i=0; i<seat.length; i++) {
			if(seat[i]>0) {
				reserveD.setReserve_no(reserve_no); 
				reserveD.setSeat_no(seat[i]); 
				reserveService.insertReserveDetail(reserveD);
				reserveService.updateTimeDetailSeat(time_detail_no);
				cnt++;
			}
		}
		
		mav.setViewName("reserve/reserveComplete");
		return mav;
	}
	
	private String getReserveNo(){
		String maxNoStr = "", startWith="", reserve_no="";
		try {
			reserve_no = reserveService.getReserveDetailNo();
		} catch(Exception e) {}		 
		startWith = reserve_no.substring(0,8);
		int maxNoInt = Integer.parseInt(reserve_no.substring(9,14)) + 1;
		maxNoStr = ("000000" + maxNoInt);  
		int startIndex = maxNoStr.length() - 6;
		reserve_no = startWith + maxNoStr.substring(startIndex, maxNoStr.length());
		
		return reserve_no;
	}
}
