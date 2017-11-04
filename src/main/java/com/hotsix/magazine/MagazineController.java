package com.hotsix.magazine;

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
import com.hotsix.member.MemberModel;
import com.hotsix.magazine.MagazineModel;
import com.hotsix.magazine.MagazineService;
import com.hotsix.magazine.MagazineValidator;
import com.hotsix.magazine.MagazineCommentModel;
/*import com.hotsix.movie.MovieService;
import com.hotsix.notice.NoticeModel;
import com.hotsix.notice.NoticeService;
import com.hotsix.reserve.RoomModel;
import com.hotsix.reserve.TimetableDetailModel;
import com.hotsix.reserve.TimetableMasterModel;
import com.hotsix.validator.MagazineValidator;
import com.hotsix.validator.NoticeValidator;*/

@Controller
@RequestMapping("/magazine")
public class MagazineController {
	String session_member_id;
	Integer session_member_no;
	
	
	@Resource
	private MagazineService magazineService;
	private int searchNum;
	private String isSearch;
	/*@Resource(name="magazineService")*/
	//private static final String filePath = "C:\\Java\\app\\MovieTicket\\src\\main\\webapp\\upload\\";
	private static final String filePath = "E:\\App\\MovieTicket\\src\\main\\webapp\\upload\\";
	
	private int currentPage = 1; 
	private int totalCount; 
	private int blockCount = 3; 
	private int blockPage = 5; 
	private String pagingHtml; 
	private Paging page; 
	
	private int currentPage2 = 1; 
	private int totalCount2; 
	private int blockCount2 = 3; 
	private int blockPage2 = 5; 
	private String pagingHtml2; 
	private commentPaging page2; 
	private ModelAndView mav=new ModelAndView();
	
	//magazineList
	@RequestMapping(value="/magazineList.mt",method=RequestMethod.GET)
	public ModelAndView magazineList(HttpServletRequest request){
		
		ModelAndView mav=new ModelAndView();
		List<MagazineModel> list=magazineService.magazineList();
		

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
		page =new Paging(currentPage, totalCount, blockCount, blockPage, "magazineList", searchNum, isSearch);
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount = totalCount;

		if (page.getEndCount() < totalCount) {
			lastCount = page.getEndCount() + 1;
		}
		list=list.subList(page.getStartCount(), lastCount);
		
		mav.addObject("isSearch", isSearch);
		mav.addObject("searchNum", searchNum);
		mav.addObject("list",list);
		mav.addObject("totalCount", totalCount);
		mav.addObject("pagingHtml",pagingHtml);
		mav.addObject("currentPage", currentPage);
		mav.setViewName("magazineList");
		return mav;

		}
		list=magazineService.magazineList();
		
		totalCount=list.size();
		page=new Paging(currentPage,totalCount,blockCount,blockPage,"magazineList");
		pagingHtml=page.getPagingHtml().toString();
		int lastCount=totalCount;
		
		if(page.getEndCount()<totalCount)
			lastCount=page.getEndCount()+1;
		
		list=list.subList(page.getStartCount(), lastCount);
		
		mav.addObject("totalCount", totalCount);
		mav.addObject("pagingHtml", pagingHtml);
		mav.addObject("currentPage", currentPage);
		mav.addObject("list",list);
		mav.setViewName("magazineList");
		return mav;
	}
	
	@ModelAttribute
	public MagazineModel formBack(){
		return new MagazineModel();
	}
	
/*	@RequestMapping(value="/magazineWrite.mt",method=RequestMethod.GET)
	public ModelAndView magazineWriteForm(HttpServletRequest request){
		mav.setViewName("magazineWrite");
		return mav;
	}
	@Resource
	private MagazineService magazineService;

	//magazineWrite
	@RequestMapping(value="/magazineWrite.mt",method=RequestMethod.POST)
	public ModelAndView magazineWrite(@ModelAttribute("magazineModel") MagazineModel magazineModel,BindingResult result,
			HttpServletRequest request,MultipartHttpServletRequest multipartHttpServletRequest) throws IOException{
	
		String content=magazineModel.getContent().replaceAll("\r\n", "<br />");
		String sub_content1=magazineModel.getSub_content1().replaceAll("\r\n", "<br />");
		String sub_content2=magazineModel.getSub_content2().replaceAll("\r\n", "<br />");
		Date reg_date;
		int seqName=magazineService.getMagazine_NO_SEQ();
		magazineModel.setMagazine_no(seqName);
		

	
			if(request.getParameter("reg_date") == null){
				System.out.println("@@@@ 占쎈쐻占쎈윞占쎄숱占쎈쨬占쎈즸占쎌굲 �뜝�럥�돯�뜝�럥痢듿뜝�럩議�");
			}
			
			reg_date=new SimpleDateFormat("yyyyMMdd").parse(request.getParameter("reg_date"));
			magazineModel.setContent(content);
			magazineModel.setSub_content1(sub_content1);
			magazineModel.setSub_content2(sub_content2);
			magazineModel.setReadhit(0);
			magazineModel.setReg_date(reg_date);
			
			MultipartFile multipartFile=multipartHttpServletRequest.getFile("image1");
			String file_name="image1_"+seqName;
			String file_ext=multipartFile.getOriginalFilename()
					.substring(multipartFile.getOriginalFilename().lastIndexOf('.')+1);
			if(file_ext!=""){
				String full_name=file_name+"."+file_ext;
				File file=new File(filePath+full_name);
				
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
				File file1 = new File(filePath + full_name1);

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
			mav.addObject("magazineModel", magazineModel);
			mav.setViewName("redirect:/magazine/magazineList.mt");
			return mav;
	
	}*/
	
	@RequestMapping(value="/magazineView.mt",method=RequestMethod.GET)
	public ModelAndView magazineView(HttpServletRequest request){
		
		if (request.getParameter("currentPage2") == null || request.getParameter("currentPage2").trim().isEmpty()
				|| request.getParameter("currentPage2").equals("0")) {
			currentPage2 = 1;
		} else {
			currentPage2 = Integer.parseInt(request.getParameter("currentPage2"));
		}
		
		ModelAndView mav=new ModelAndView();
		
		int magazine_no=Integer.parseInt(request.getParameter("magazine_no"));
		int origin_no=Integer.parseInt(request.getParameter("magazine_no"));
		
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
		
		page2 = new commentPaging(currentPage2, totalCount2, blockCount2, blockPage2,magazine_no);
		pagingHtml2 = page2.getPagingHtml2().toString();

		int lastCount2 = totalCount2;

		if (page2.getEndCount2() < totalCount2)
			lastCount2 = page2.getEndCount2() + 1;
		
		commentlist = commentlist.subList(page2.getStartCount2(), lastCount2);
		magazineService.magazineUpdateReadhit(magazine_no);
		mav.addObject("cmtcount",cmtcount);
		mav.addObject("totalCount2", totalCount2);
		mav.addObject("pagingHtml2",pagingHtml2);
		mav.addObject("currentPage2", currentPage2);
		mav.addObject("magazine",magazineModel);
		mav.addObject("commentlist",commentlist);
		mav.setViewName("magazineView");
		return mav;
		
	}
	
/*	//magazineUpdateForm
	@RequestMapping(value="/magazineUpdate.mt",method=RequestMethod.GET)
	public ModelAndView magazineUpdateForm(@ModelAttribute("magazineModel")MagazineModel magazineModel,
			HttpServletRequest request){
		
		int magazine_no=Integer.parseInt(request.getParameter("magazine_no"));
		
		magazineModel=magazineService.magazineView(magazine_no);
		
		String content=magazineModel.getContent().replaceAll("<br />","\r\n");
		String sub_content1=magazineModel.getSub_content1().replaceAll("<br />","\r\n");
		String sub_content2=magazineModel.getSub_content2().replaceAll("<br />","\r\n");
		magazineModel.setContent(content);
		magazineModel.setSub_content1(sub_content1);
		magazineModel.setSub_content2(sub_content2);
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("magazineModel",magazineModel);
		mav.setViewName("magazineUpdate");
		return mav;
	}
	
	//checkForm
	
	//magazineUpdate
	@RequestMapping(value="/magazineUpdate.mt",method=RequestMethod.POST)
	public String magazineUpdate(@ModelAttribute("magazineModel")MagazineModel magazineModel,
			BindingResult result,MultipartHttpServletRequest request)throws IOException,ParseException{
		
		ModelAndView mav=new ModelAndView();
		int magazine_no=Integer.parseInt(request.getParameter("magazine_no"));
		String content=magazineModel.getContent().replaceAll("\r\n", "<br />");
		String sub_content1=magazineModel.getSub_content1().replaceAll("\r\n", "<br />");
		String sub_content2=magazineModel.getSub_content2().replaceAll("\r\n", "<br />");
		Date reg_date;
		magazineModel=magazineService.magazineView(magazine_no);
		
		reg_date=new SimpleDateFormat("yyyyMMdd").parse(request.getParameter("reg_date"));
		magazineModel.setContent(content);
		magazineModel.setSub_content1(sub_content1);
		magazineModel.setSub_content2(sub_content2);
		
		magazineModel.setContent(request.getParameter("content"));
		magazineModel.setSubject(request.getParameter("subject"));
		magazineModel.setSubject2(request.getParameter("subject2"));
		magazineModel.setSub_subject1(request.getParameter("sub_subject1"));
		magazineModel.setSub_subject2(request.getParameter("sub_subject2"));
		magazineModel.setSub_content1(request.getParameter("sub_content1"));
		magazineModel.setSub_content2(request.getParameter("sub_content2"));
		magazineModel.setImage1(request.getParameter("image1"));
		magazineModel.setImage2(request.getParameter("image2"));
		
		if(request.getFile("image1")!=null){magazineModel.setImage1(fileCopy(magazine_no,"image1"));
		if(request.getFile("image2")!=null){magazineModel.setImage2(fileCopy(magazine_no,"image2"));
		
		magazineModel.setReg_date(reg_date);
		magazineModel.setMagazine_no(magazine_no);
		
	
		if(request.getFile("image1")!=null){
			MultipartFile multipartFile=request.getFile("image1");
			String file_name="image1_"+magazine_no;
			String file_ext=multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf('.') + 1);
			
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
				File file2 = new File(filePath + full_name2);

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
		return "redirect:magazineList.mt";
	}	
	
	//magazineDelete
	@RequestMapping(value="/magazineDelete.mt",method=RequestMethod.GET)
	public String magazineDelete(HttpServletRequest request){
		int magazine_no=Integer.parseInt(request.getParameter("magazine_no"));
		
		magazineService.magazineDelete(magazine_no);
		return "redirect:magazineList.mt";
	}*/
	

	@RequestMapping(value="/checkForm.mt",method=RequestMethod.GET)
	public ModelAndView commentCheck(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		
		String mcomment_no = request.getParameter("mcomment_no");
		String magazine_no = request.getParameter("magazine_no");
		
		mav.addObject("mcomment_no",mcomment_no);
		mav.addObject("magazine_no",magazine_no);
		mav.setViewName("commentCheck");
		return mav;
	}
	
	@RequestMapping(value="/checkForm2.mt",method=RequestMethod.GET)
	public ModelAndView commentCheck2(HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		
		String mcomment_no = request.getParameter("mcomment_no");
		String magazine_no = request.getParameter("magazine_no");
		
		mav.addObject("mcomment_no",mcomment_no);
		mav.addObject("magazine_no",magazine_no);
		mav.setViewName("commentCheck2");
		return mav;
	}
	
	@RequestMapping(value="/commentDelete.mt")
	/*public ModelAndView commentDelete(HttpServletRequest request,MagazineCommentModel magazineCommentModel){*/
	public ModelAndView commentDelete(MagazineCommentModel magazineCommentModel,BindingResult result, HttpSession session, HttpServletRequest request) {
		
		int deleteCheck;
		String mcomment_no=request.getParameter("mcomment_no");
		MagazineCommentModel mgModel=new MagazineCommentModel();
		ModelAndView mav=new ModelAndView();
		String password=request.getParameter("password");
		
		mgModel=magazineService.passwordfind(mcomment_no);
	
		
		if(mgModel.getPassword().equals(password)){
			deleteCheck = 1;
			magazineService.commentDelete(magazineCommentModel);
		}else{
			deleteCheck = -1;
			mav.setViewName("/checkForm.mt");
		}
		mav.addObject("deleteCheck",deleteCheck);
		mav.setViewName("magazine/deleteResult");
		return mav;
	}
	

	//comment Write
	@RequestMapping("/commentWrite.mt")
	public ModelAndView commentWrite(HttpServletRequest request,HttpSession session){

		ModelAndView mav=new ModelAndView();
		MagazineCommentModel mgModel=new MagazineCommentModel();
		
		if (request.getParameter("currentPage2") == null || request.getParameter("currentPage2").trim().isEmpty()
				|| request.getParameter("currentPage2").equals("0")) {
			currentPage2 = 1;
		}
		else {
			currentPage2 = Integer.parseInt(request.getParameter("currentPage2"));
		}
		/*if(request.getParameter("content").equals("") || request.getParameter("content").trim().isEmpty()) {
			mav.setViewName("magazine/Confirm");
			return mav;
		}*/
		
		
		int origin_no=Integer.parseInt(request.getParameter("magazine_no"));
		mgModel.setContent(request.getParameter("content").replaceAll("\r\n", "<br />"));
		mgModel.setOrigin_no(origin_no);
		mgModel.setName(request.getParameter("name"));
		mgModel.setPassword(request.getParameter("password"));
		magazineService.writecomment(mgModel);
		
		mav.setViewName("redirect:magazineView.mt?magazine_no="+origin_no);
		return mav;
	
	}
	

}
