<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="ko">
<meta charset="utf-8" />
<title>파일업로드</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
</head>
<body>
	<form id="fileform" name="fileform" method="post">
		<input type="hidden" name="filename" value="${filename }" />
		<input type="hidden" name="path" value="${path }" />
	</form>
	
	<script type="text/javascript">
		function fileAttach(){ 
			var form = document.fileform;
		    var fname = form.filename.value;
		    try{
		    	alert("되라2");
	    		window.opener.window.parent.pasteHTML(fname);
	    		alert("됐다2");
		    	window.close();
		    }catch(e){alert('업로드에 실패했습니다.'); }
		}
		fileAttach();
		this.window.close();
	</script>
</body>
</html>