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
		<ul></ul>
	</div>
	<button id="btn1">test</button>
<script type="text/javascript">
	$("#btn1").click(function(e) {
		e.preventDefault();
		
// 		$(".div1 ul").append('<li><a href="/user/messages"><span class="tab">Message Center</span></a></li>');
		
		$('.div1 ul').append(
		    $('<li>').append(
		        $('<a>')
		        .attr('href','/user/messages')
		        .append(
		            $('<span>')
		            	.attr('class', 'tab')
	            		.append("Message center")
				)
			)
		); 
	});
</script>
</body>
</html>