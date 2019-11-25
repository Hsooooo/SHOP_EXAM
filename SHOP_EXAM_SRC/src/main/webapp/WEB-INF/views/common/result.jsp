<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<script type="text/javascript">
	alert("<%=request.getAttribute("result_message")%>");
	parent.location.href="<%=request.getAttribute("result_link")%>";
</script>
</body>
</html>