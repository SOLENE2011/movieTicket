package com.hotsix.member;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotsix.validator.MemberValidator;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	ModelAndView mav = new ModelAndView();
	
	// 로그인 페이지
	@RequestMapping(value="/login.mt", method = RequestMethod.GET)
	public String loginForm(){
		return "loginForm";
	}
	
	// 로그인 여부
	@RequestMapping(value="/login.mt", method = RequestMethod.POST)
	public ModelAndView memberLogin(HttpServletRequest request, MemberModel mem){
		
		MemberModel result = memberService.memberLogin(mem);
		
		if(result != null){
			//System.out.println("로그인 성공");
			HttpSession session = request.getSession();
			
			session.setAttribute("mem", result);
			session.setAttribute("session_member_id", result.getId());
			session.setAttribute("session_member_name" ,result.getName());
			session.setAttribute("session_member_no" ,result.getMember_no());
			session.setAttribute("session_member_grade", result.getGrade());	// default = 0(일반회원) ,default = 1(admin/admin)
			
			//mav.setViewName("member/loginSuccess");
			mav.setViewName("redirect:/main.mt");
			return mav;
		}
		
		// 로그인 실패
		mav.setViewName("member/loginError");
		return mav;
	}
	
	// 로그아웃
	@RequestMapping("/logout.mt")
	public ModelAndView memberLogout(HttpServletRequest request, MemberModel mem){
		HttpSession session = request.getSession(false);
		
		if(session != null){
			//System.out.println("로그아웃 성공");
			session.invalidate();
		}
		
		//mav.setViewName("member/logout");
		mav.setViewName("redirect:/main.mt");
		return mav;
	}
	// 유효성 검사시 에러발생시 넘어가게 하는 로직 ( joinStep2 의 commandName )
	@ModelAttribute("member")
	public MemberModel formBack(){
		return new MemberModel();
	}
	
	// 이용약관 , 개인정보 동의
	@RequestMapping("/member.mt")
	public ModelAndView memberStep1(){
		mav.setViewName("member");
		return mav;
	}
	
	// 회원정보 입력
	@RequestMapping("/memberinfo.mt")
	public ModelAndView memberStep2(){
		mav.setViewName("memberInfo");
		return mav;
	}
	
	// 회원가입완료
	@RequestMapping("/memberEnd.mt")
	public ModelAndView memberStep3(@ModelAttribute("member") MemberModel member, BindingResult result){
		
		// Validate Binding
		new MemberValidator().validate(member, result);
		
		// 에러가 있으면 회원가입폼으로 넘어감
		if(result.hasErrors()){
			mav.setViewName("memberInfo");
			return mav;
		}
		try{
			// 유효성 검사에 통과하면 회원가입완료
			memberService.insertMember(member);
			mav.setViewName("memberEnd");
			return mav;
		}catch(DuplicateKeyException e){
			// https://msdn.microsoft.com/ko-kr/library/system.data.linq.duplicatekeyexception(v=vs.110).aspx
			// db에서 id의 제약조건을 unique로 바꿨기 때문에 중복된 아이디로 가입하려하면 DuplicateKeyException이 뜨게되고
			// 예외처리로 properties파일에 등록된 "invalid"의 내용이 나오게 만들고 회원가입폼으로 돌아가게했음.
			// 아이디 중복검사
			result.reject("invalid", null);
			mav.setViewName("memberInfo");
			return mav;
		}
	}
	
	// 우편번호
	@RequestMapping("/zipCheckAction.mt")
	public ModelAndView zipCheck(HttpServletRequest request){
		List<ZipcodeModel> zipcodeList = new ArrayList<ZipcodeModel>();
		String dong;
		
		dong = request.getParameter("dong");
		
		if(dong != null){
			//System.out.println("우편번호 !!!!!");
			zipcodeList = memberService.zipCheckAction(dong);
			mav.addObject("dong",dong);
			mav.addObject("zipcodeList",zipcodeList);
		}
		mav.setViewName("zipCheck");
		return mav;
	}
	
	// 회원정보 수정
	@RequestMapping("/memberModify.mt")
	public ModelAndView memberModify(@ModelAttribute("member") MemberModel member, BindingResult result, HttpSession session){
		
		if(session.getAttribute("session_member_id") == null){
			mav.setViewName("common/loginConfirm");
			return mav;
		}
		
		MemberModel memberModel = new MemberModel();
		
		if(session.getAttribute("session_member_id") != null){
			memberService.memberModify(member);
			mav.addObject("member",memberModel);
			
			mav.setViewName("redirect:/main.mt");
			return mav;
		}
		
		mav.setViewName("common/loginConfirm");
		return mav;
	}
	
	// 회원탈퇴폼
	@RequestMapping("/memberWith.mt")
	public ModelAndView memberWidth(){
		mav.setViewName("memberwith");
		return mav;
	}
	
	// 회원탈퇴
	@RequestMapping("/memberDelete.mt")
	public ModelAndView memberDelete(@ModelAttribute("member") MemberModel member, BindingResult result, HttpServletRequest requeset, HttpSession session){
		MemberModel memberModel;
		String id;
		String passwd;
		int deleteCheck;
		
		passwd = requeset.getParameter("passwd");
		
		id = session.getAttribute("session_member_id").toString();
		memberModel = (MemberModel)memberService.getMember(id);
		
		if(memberModel.getPasswd().equals(passwd)){
			deleteCheck = 1;
			
			memberService.memberDelete(id);
			session.removeAttribute("session_member_id");
			session.removeAttribute("session_member_name");
			session.removeAttribute("session_member_no");
		}else{
			deleteCheck = -1;	// 패스워드가 틀릴 때
		}
		
		mav.addObject("deleteCheck",deleteCheck);
		mav.setViewName("member/deleteResult");
		return mav;
	}
	
	@RequestMapping("/memberIdFind.mt")
	public ModelAndView memberFindForm(){
		mav.setViewName("idFind");
		return mav;
	}
	
	@RequestMapping("/memberIdFindAction.mt")
	public ModelAndView memberFind(@ModelAttribute("member") MemberModel member, HttpServletRequest request){
		
		int memberFindChk;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		member.setName(name);
		member.setEmail(email);
		
		member = memberService.idFindByName(member);
		
		if(member == null){
			memberFindChk = 0;
			mav.addObject("memberFindChk",memberFindChk);
			mav.setViewName("member/idFindError");
			return mav;
		}else{
			if(member.getName().equals(name) && member.getEmail().equals(email)){
				memberFindChk = 1;
				mav.addObject("member",member);
				mav.addObject("memberFindChk",memberFindChk);
				mav.setViewName("idFindOk");
				return mav;
			}else{
				memberFindChk = -1;
				mav.addObject("memberFindChk",memberFindChk);
				mav.setViewName("member/idFindError");
				return mav;
			}
		}
	}
	
}
