<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String cp = request.getContextPath(); %>

<script type="text/javascript">
	function memberFindChk(){
		
		var mem = eval("document.memberFindForm");
		
		if(mem.name.value=="") {
	        alert('이름을 입력하세요');
	        mem.name.focus();
	        return false;
	    }

	    if(mem.email.value=="") {
	        alert('이메일을 입력해 주세요.');
	        mem.email.focus();
	        return false;
	    }
		return true;
	}
</script>

<div class="sign_grp">
	<div class="idpw_grp">
		<h3 class="sub_tit">아이디 &#47; 비밀번호 찾기</h3>
		<form action="memberIdFindAction.mt" method="post" name="memberFindForm" onsubmit="return memberFindChk()" >
			<fieldset>
				<legend>아이디 찾기</legend>
				<div class="tbl_type_01">
					<table>
						<caption>이름,주민번호로 아이디 찾기</caption>
						<colgroup>
							<col style="width:120px;" />
							<col />
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">이름</th>
								<td><input type="text" class="txt w220" name="name" /></td>
							</tr>
							<tr>
								<th scope="row">이메일</th>
								<td><input type="text" class="txt w220" name="email" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="btn_type_04">
					<a href="<%=cp %>/main.mt" class="btn btnC_03 btnF_02 mr10">
						<span>취소</span>
					</a>
					<span class="btn btnC_04 btnF_02">
						<input type="submit" value="찾기" />
					</span>
				</div>
			</fieldset>
		</form>
	</div>
</div>