<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
</head>
<body>
	<div class="div1">
	</div>
	<button id="btn1"></button>
<script type="text/javascript">
	$("#btn1").click(function(e) {
		$("div1").html("123");
	});
</script>
</body>
</html>