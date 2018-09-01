<!doctype HTML>

<html>

<head>

<link rel='stylesheet' href='css/home.css' />

<%
	String message = (String) request.getAttribute("message");
	try {
		if (message != null && message.length() > 1
				&& !message.equals("logout")) {
%>
<script> alert(" <%out.print(message);%>");
<%}
  if (message.equals("logout") && message!=null) {%>
	alert('logged Out');
<%
  session.invalidate();
}%>
	
</script>
<%
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
</head>

<body align='center'>

	<div id="container" align='center'>

		<div id='navigator_table'>
			<table>

				<tr>
					<td><img src='images\emp.png' width='10%' /></td>

					<td align='right'><a href='login.jsp'>Login</a> <a
						href='signup.jsp'>Signup</a> <a href='contactus.jsp'>Contact
							Us</a></td>

				</tr>

				<tr>

					<td colspan='2'><hr /></td>

				</tr>



			</table>


			<img src='images\connect.jpg' align='center' />

		</div>


	</div>
</body>



</html>