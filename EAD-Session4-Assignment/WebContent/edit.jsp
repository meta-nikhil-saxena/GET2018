<!doctype HTML>
<%@page import="java.util.List"%>
<%@page import="com.models.Organization"%>
<%@page import="com.facade.OrganizationFacade"%>
<%@page import="java.io.OutputStream"%>
<%@page import="com.view.User"%>
<%@page import="com.facade.UserFacade"%>
<html>
<head>

<title>Login_Page</title>
<link rel='stylesheet' href='css/login.css' />
<link rel='stylesheet' href='css/home.css' />
<script src='js/login.js'>
	
</script>

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
					</h1> <a href='index.jsp'>Log Out</a>
				</td>

			</tr>

			<tr>

				<td colspan='2'><hr /></td>

			</tr>

		</table>
	</div>
	<div id="form_container">

		<form id="profileform" name="profileform" action='UpdateController'>
			<table align="center" cellpadding="10" cellspacing="20">

				<tr>
					<th>Email</th>
					<td>				
						<input type='text'  name='email' value = '<% out.print(user.getEmail()); %>' />	
					</td>

				</tr>

				<tr>
					<th>First Name</th>
					<td>
	
						<input type='text' name='firstname' value = '<% out.print(user.getFirstName()); %>'/>	

					</td>

				</tr>

				<tr>
					<th>Last Name</th>
					<td>
						<input type='text'  name='lastname' value = '<% out.print(user.getLastName()); %>' />	
					</td>

				</tr>

				<tr>
					<th>Image</th>
					<td><img src='<%out.print(user.getProfileImage());%>'
						height='70px'/>
						<input type='file' name='upload'/>
						</td>

				</tr>


				<tr>

					<th>Contact</th>
					<td>
						<input type='text' name='contact' value = '<% out.print(user.getContact()); %>'/>	
					</td>

				</tr>

				<tr>
					<th>Organization</th>

					<td><select id="s_company" name="company">
							<option value="<% out.print(user.getCompany()); %>" selected="select"><% out.print(user.getCompany()); %></option>
							<%
								OrganizationFacade organization = OrganizationFacade.getInstance();

								List<Organization> listOfOrganization = organization
										.getListOfOrganization();

								for (Organization list : listOfOrganization) {
							%>


							<option>
								<%
									out.print(list.getName());
								%>
							</option>


							<%
								}
							%>
					</select></td>
				</tr>

				<tr>

					<th>Address</th>
					<td>
						<input type='text'  name='address' value = '<% out.print(user.getAddress()); %>'/>	
					</td>

				</tr>

				<tr>

					<td colspan='2'><input type='submit' value='Update'
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