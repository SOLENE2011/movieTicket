package com.hotsix.notice;

// paging
public class commentPaging{
	private int currentPage2;
	private int totalCount2;
	private int totalPage2;
	private int blockCount2;
	private int blockPage2;
	private int startCount2;
	private int endCount2;
	private int startPage2;
	private int endPage2;
	private int no;
	private StringBuffer pagingHtml2;
	private String viewName;
	
	public commentPaging(int currentPage2, int totalCount2, int blockCount2, int blockPage2, int no){
		this.currentPage2 = currentPage2;
		this.totalCount2 = totalCount2;
		this.blockCount2 = blockCount2;
		this.blockPage2 = blockPage2;
	    this.no = no;
	    
		totalPage2 = (int)Math.ceil((double)totalCount2 / blockCount2);
		if(totalPage2 == 0){
			totalPage2 = 1;
		}
		
		
		if(currentPage2 > totalPage2){
			currentPage2 = totalPage2;
		}
		
		
		startCount2 = (currentPage2 - 1) * blockPage2;
		endCount2 = startCount2 + blockPage2 - 1;
		
		startCount2 = (currentPage2 - 1) * blockCount2;
		endCount2 = startCount2 + blockCount2 - 1;
		
		
		startPage2 = (int)((currentPage2 -1) / blockPage2) * blockPage2 + 1;
		endPage2 = startPage2 + blockPage2 - 1;
		
		
		if(endPage2 > totalPage2){
			endPage2 = totalPage2;
		}
		
		
		pagingHtml2 = new StringBuffer();
		if(currentPage2 > blockPage2){
			/*if(session_member_grade == 1){
			pagingHtml2.append("<a class='page prv' href='adminMagazineView.mt?magazine_no="+ magazine_no +"&currentPage2=" + (startPage2 - 1));
			}
			else {*/
				pagingHtml2.append("<a class='page prv' href='noticeView.mt?no="+ no +"&currentPage2=" + (startPage2 - 1));
	
			pagingHtml2.append("'>");
			pagingHtml2.append("&lt;");
			pagingHtml2.append("</a>");
		}
		
		
		for(int i = startPage2; i <= endPage2; i++){
			if(i > totalPage2){
				break;
			}
			if(i == currentPage2){
				pagingHtml2.append("<strong>");
				pagingHtml2.append(i);
				pagingHtml2.append("</strong>");
			}else{
				/*if(session_member_grade == 1){
				pagingHtml2.append("<a class='page' href='adminMagazineView.mt?magazine_no="+ magazine_no +"&currentPage2=");
				}
				
				else {*/
					pagingHtml2.append("<a class='page' href='noticeView.mt?no="+ no +"&currentPage2=");
				
				pagingHtml2.append(i);
				pagingHtml2.append("'>");
				pagingHtml2.append(i);
				pagingHtml2.append("</a>");
			}
		}
		
		// 占쎈뼄占쎌벉 block 占쎈읂占쎌뵠筌욑옙
		if(totalPage2 - startPage2 >= blockPage2){
			/*if(session_member_grade == 1){
			pagingHtml2.append("<a class='page next' href='adminMagazineView.mt?magazine_no="+ magazine_no +"&currentPage2=" + (endPage2 + 1));
			}
			else{*/
				pagingHtml2.append("<a class='page next' href='noticeView.mt?no="+ no +"&currentPage2=" + (endPage2 + 1));
			
			pagingHtml2.append("'>");
			pagingHtml2.append("&gt;");
			pagingHtml2.append("</a>");
		}
	}

	public int getCurrentPage2() {
		return currentPage2;
	}

	public void setCurrentPage2(int currentPage2) {
		this.currentPage2 = currentPage2;
	}

	public int getTotalCount2() {
		return totalCount2;
	}

	public void setTotalCount2(int totalCount2) {
		this.totalCount2 = totalCount2;
	}

	public int getTotalPage2() {
		return totalPage2;
	}

	public void setTotalPage2(int totalPage2) {
		this.totalPage2 = totalPage2;
	}

	public int getBlockCount2() {
		return blockCount2;
	}

	public void setBlockCount2(int blockCount2) {
		this.blockCount2 = blockCount2;
	}

	public int getBlockPage2() {
		return blockPage2;
	}

	public void setBlockPage2(int blockPage2) {
		this.blockPage2 = blockPage2;
	}

	public int getStartCount2() {
		return startCount2;
	}

	public void setStartCount2(int startCount2) {
		this.startCount2 = startCount2;
	}

	public int getEndCount2() {
		return endCount2;
	}

	public void setEndCount2(int endCount2) {
		this.endCount2 = endCount2;
	}

	public int getStartPage2() {
		return startPage2;
	}

	public void setStartPage2(int startPage2) {
		this.startPage2 = startPage2;
	}

	public int getEndPage2() {
		return endPage2;
	}

	public void setEndPage2(int endPage2) {
		this.endPage2 = endPage2;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public StringBuffer getPagingHtml2() {
		return pagingHtml2;
	}

	public void setPagingHtml2(StringBuffer pagingHtml2) {
		this.pagingHtml2 = pagingHtml2;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	/*public int getSession_member_grade() {
		return session_member_grade;
	}

	public void setSession_member_grade(int session_member_grade) {
		this.session_member_grade = session_member_grade;
	}
*/

}
