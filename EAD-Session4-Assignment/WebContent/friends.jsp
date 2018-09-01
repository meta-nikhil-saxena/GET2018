<!doctype HTML>

<%@page import="com.view.Friend"%>
<%@page import="java.util.List"%>
<%@page import="com.view.User"%>
<%@page import="com.facade.UserFacade"%>
<html>

<head>

<title>Login_Page</title>
<link rel='stylesheet' href='css/login.css' />
<link rel='stylesheet' href='css/home.css' />


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
					<a href='profile.jsp'>Profile</a>
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
	
	<%
    List<Friend> listOfFriends = userfacade.getFriendList(email);
	for(Friend list : listOfFriends){
	%>
	<div id="form_container">

		<form id="friendform" name="friendform" action='friendinfo.jsp'>
			<table align="center" cellpadding="10" cellspacing="20">

				<tr>
				
					<td>
						<%
							out.print(list.getFirstName()+" "+list.getLastName());
						%>
					</td>
              
               <td>
               <input type='hidden' name='emailfriend' value='<% out.print(list.getEmail()); %>'/>
               <input type='submit' value='Show Profile' 
						id='showprofile' name='showprofile' />
			   </td>
				</tr>

	

			</table>
		</form>

	</div>
<%
} 
%>

	<%
		} else {
	%>
	<h1>!! Login First !!</h1>
	<%
		}
	%>


</body>




</html>