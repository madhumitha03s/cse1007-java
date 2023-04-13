<!DOCTYPE html>
<html>
<head>
	<title>Student Information</title>
</head>
<body>
	<h1>Student Information</h1>
	<%
		String name = request.getParameter("name");
		String regno = request.getParameter("regno");
		String password = name.length() + regno.substring(regno.length() - 4);
	%>
	<p>Name: <%= name %></p>
	<p>Reg No: <%= regno %></p>
	<p>Password: <%= password %></p>
</body>
</html>
