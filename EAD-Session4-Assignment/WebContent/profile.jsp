<!doctype HTML>
<%@page import="java.io.OutputStream"%>
<%@page import="com.view.User"%>
<%@page import="com.facade.UserFacade"%>
<html>
<head>

<title>Login_Page</title>
<link rel='stylesheet' href='css/login.css' />
<link rel='stylesheet' href='css/home.css' />

<%
	String message = (String)request.getAttribute("message");
try{
if(message!=null && message.length()>1){
%>
<script> alert(" <%out.print(message);%>	");
</script>
<%
	}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
</head>

<body>
	<%
		if (null != session.getAttribute("email")) {
			String email = session.getAttribute("email").toString();

			UserFacade userfacade = UserFacade.getInstance();
			User user = userfacade.getListOfUser(email);
	%>
	<div id='navigator_table'>
		<table>

			<tr>
				<td><img src='images\emp.png' width='10%' /></td>

				<td align='right'>
					<h1>
						<%
							out.print(user.getEmail());
						%>
					</h1> 
					<a href='friends.jsp'>Friends</a>
					<a href='index.jsp'><% out.print("Log Out");
					   request.setAttribute("message", "logout");					
					%></a>
					     
				</td>

			</tr>

			<tr>

				<td colspan='2'><hr /></td>

			</tr>

		</table>
	</div>
	<div id="form_container">

		<form id="profileform" name="profileform" action='edit.jsp'>
			<table align="center" cellpadding="10" cellspacing="20">

				<tr>
					<th>Email</th>
					<td>
						<%
							out.print(user.getEmail());
						%>
					</td>

				</tr>

				<tr>
					<th>First Name</th>
					<td>
						<%
							out.print(user.getFirstName());
						%>
					</td>

				</tr>

				<tr>
					<th>Last Name</th>
					<td>
						<%
							out.print(user.getLastName());
						%>
					</td>

				</tr>

				<tr>
					<th>Image</th>
					<td><img src='<%out.print(user.getProfileImage());%>'
						height='70px' width='70px' /></td>

				</tr>


				<tr>

					<th>Contact</th>
					<td>
						<%
							out.print(user.getContact());
						%>
					</td>

				</tr>

				<tr>

					<th>Organization</th>
					<td>
						<%
							out.print(user.getCompany());
						%>
					</td>

				</tr>

				<tr>

					<th>Address</th>
					<td>
						<%
							out.print(user.getAddress());
						%>
					</td>

				</tr>

				<tr>

					<td colspan='2'><input type='submit' value='Edit Info'
						id='edit_info' name='edit' /></td>

				</tr>

			</table>
		</form>

	</div>


	<%
		} else {
	%>
	<h1>!! Login First !!</h1>
	<%
		}
	%>


</body>




</html>