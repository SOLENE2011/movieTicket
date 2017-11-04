package com.hotsix.mypage;


import java.util.List;

import com.hotsix.member.MemberModel;
/**
 * 마이페이지에서 Mybatis를 사용할 인터페이스
 * @author 이명필, 백종경
 *
 */
public interface MypageDAO {
	
	
	//M_COIN
	public MemberModel getMemberModel(int member_no);
	
	public Object updateMticket(MemberModel member_no);

	List<MypageModel> reserveList(int session_member_no);
	
	List<MypageModel> cancelList(int session_member_no);
	
	Object cancelReserve(MypageModel mypageModel);
	
	Object cancelReserve2(MypageModel mypageModel);
	
	Object addWishlist(WishlistModel wishlistModel);
	
	List<WishlistModel> selectWishlist(int session_member_no);
	
	Object deleteWishlist(WishlistModel wishlistModel);
	
	List<WishlistModel_2> selectWishlistCheck(WishlistModel_2 wishlistModel);
	
	MypageModel2 selectReserveView(MypageModel2 mypageModel2);
	
	MypageModel3 reserveList_ACT(Long no);
	
}
