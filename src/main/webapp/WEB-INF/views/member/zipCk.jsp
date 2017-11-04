<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String cp = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<title>우편번호 찾기</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Pragma" content="no-cache" />
<link rel="stylesheet" type="text/css" href="<%= cp %>/css/import.css" />
<script type="text/javascript">
	function dongCheck(){
		if(document.zipForm.area3.value == ""){
			alert("동이름을 입력하세요");
			document.zipForm.area3.focus();
			return false;
		}
		document.zipForm.submit();
	}
	function sendAddress(zipcode,area1,area2,area3,area4){
		var address = area1 + " " + area2 + " " + area3 + " " + area4;
		opener.document.joinform.zipcode.value = zipcode;
		opener.document.joinform.addr1.value = address;
		self.close();
	}
	
	function sendAddress2(zipcode,area1,area2,area3,area4){
		var address = area1 + " " + area2 + " " + area3 + " " + area4;
		opener.document.memberModifyForm.zipcode.value = zipcode;
		opener.document.memberModifyForm.addr1.value = address;
		self.close();
	}
</script>
</head>
<body>
<div class="sign_grp">
	<div class="idpw_grp">
		<h3 class="sub_tit tac">우편번호 찾기</h3>
		<form action="<%=cp %>/member/zipCheckAction.mt" method="post" name="zipForm" >
			<fieldset>
				<legend>우편번호 찾기</legend>
				<div class="zip_inp">
					<input type="text" class="txt w200" name="dong" value="${dong}" />
					<span class="btn btnC_05 btnF_04">
						<input type="submit" value="검색" onclick="dongCheck()" />
					</span>
				</div>
			</fieldset>
		</form>
		<div class="zip_view">
			<p class="first"><strong>동</strong> 으로 검색해주세요.</p>
			<p>(예 : 역삼1동, 개포1동 )</p>
			<p>검색결과가 나오고 해당되는 부분을 클릭하면</p>
			<p>자동으로 주소와 우편번호란에 등록됩니다.</p>
		</div>

		<ul class="zip_list">
			<c:forEach var="zipCode" items="${zipcodeList}" varStatus="rowStatus">
			<li>
				<c:if test="${session_member_name == null }">
				<a href="#none" onclick="javascript:sendAddress('${zipCode.zipcode}','${zipCode.area1}','${zipCode.area2}','${zipCode.area3}','${zipCode.area4}')">
					${zipCode.zipcode} ${zipCode.area1} ${zipCode.area2} ${zipCode.area3} ${zipCode.area4}
				</a>
				</c:if>
				<c:if test="${session_member_grade == 0}">
				<a href="#none" onclick="javascript:sendAddress2('${zipCode.zipcode}','${zipCode.area1}','${zipCode.area2}','${zipCode.area3}','${zipCode.area4}')">
					${zipCode.zipcode} ${zipCode.area1} ${zipCode.area2} ${zipCode.area3} ${zipCode.area4}
				</a>
				</c:if>
			</li>	
			</c:forEach>
		</ul>

		<div class="btn_type_04">
			<a href="javascript:this.close();" class="btn btnC_03 btnF_02">
				<span>닫기</span>
			</a>
		</div>
	</div>
</div>
</body>
</html>