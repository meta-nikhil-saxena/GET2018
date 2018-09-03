<!doctype HTML>

<%@page import="com.models.Organization"%>
<%@page import="java.util.List"%>
<%@page import="com.facade.OrganizationFacade"%>
<html>

<head>

<link rel='stylesheet' href='css/home.css' />

<%
	String message = (String)request.getAttribute("message");
try{
if(message!=null && message.length()>1){
%>
<script> alert(" <%out.print(message);%>");
	
</script>
<%
	}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>

</head>

<body>

	<div id="container">

		<div id='navigator_table'>
			<table>

				<tr>
					<td><img src='images\emp.png' width='10%' /></td>

					<td align='right'><a href='index.jsp'>Home</a> <a
						href='signup.jsp'>Signup</a> <a href='contactus.jsp'>Contact
							Us</a></td>

				</tr>

				<tr>

					<td colspan='2'><hr /></td>

				</tr>



			</table>

		</div>
	</div>

	<h1 align='center'>--------Signup-------</h1>

	<div id=signup>

		<form id="form_signup" name="signupform" action='SignupController'>
			<table align="center" cellpadding="10" cellspacing="20">

				<tr>
					<th align='left'>First Name :</th>
					<td><input type='text' id='firstname' name='firstname'
						placeholder='Enter First Name' /></td>

				</tr>

				<tr>
					<th align='left'>Last Name :</th>
					<td><input type='text' id='lastname' name='lastname'
						placeholder='Enter Last Name' /></td>

				</tr>

				<tr>
					<th align='left'>Profile Image :</th>
					<td>
						<div class="content-wrap">
							<br /> <img id="profileimage" name="profileimage"
								src="images/profile.png" height='70px'><br /> <input
								type='file' name='Upload' />
						</div>
					</td>
				</tr>

				<tr>

					<th align='left'>Enter Email :</th>
					<td><input type='text' id='email' name='email'
						placeholder='Enter Email' /></td>

				</tr>

				<tr>

					<th align='left'>Enter Password :</th>
					<td><input type='password' id='password' name='password'
						placeholder='Enter Password' /></td>

				</tr>

				<tr>

					<th align='left'>Confirm Password :</th>
					<td><input type='password' id='confirmpassword'
						name='confirmpassword' placeholder='Enter Confirm password' /></td>

				</tr>

				<tr>
					<th align='left'>City :</th>

					<td><select id="s_cities" name="cities">
							<option value="select" selected="select">select</option>
							<option value="jaipur">Jaipur</option>
							<option value="udaipur">Udaipur</option>
							<option value="ajmer">Ajmer</option>
							<option value="aligarh">Aligarh</option>
							<option value="mount">Mount Abu</option>
					</select></td>

				</tr>

				<tr>
					<th align='left'>Organization :</th>

					<td><select id="s_company" name="company">
							<option value="select" selected="select">select</option>
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

					<th align='left'>Contact No. :</th>
					<td><input type='text' id='contact' name='contact'
						placeholder='Enter contact number' /></td>

				</tr>

				<tr>

					<th align='left'>Address :</th>
					<td><textarea rows="4" cols="40" id="address" name="address"
							placeholder='Enter Address'></textarea></td>

				</tr>

				<tr>

					<td colspan="2"><input type='submit' value='Submit'
						width='50%'></td>

				</tr>

			</table>
		</form>

	</div>


</body>

</html>
