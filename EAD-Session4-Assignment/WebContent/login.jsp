<!doctype HTML>
<html>
<head>

<title>Login_Page</title>
<link rel='stylesheet' href='css/login.css'/>
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
<div id='navigator_table'>
	  <table>
	  
	        <tr>
			    <td><img src='images\emp.png' width='10%'/></td>
				
				<td align = 'right'>
				                  <a href='index.jsp'>Home</a>	
				                  <a href='signup.jsp'>Signup</a>								  			                 
				                  <a href='contactus.jsp'>Contact Us</a>
				</td>
				
			</tr>
			
			<tr>
			
			<td colspan='2'><hr/></td>
			
			</tr>
</div>			
			
	 	  
	  </table>
</div>
<div id="form_container">
	       
		   <form id="form_login" action="LoginController">
		   <table align="center" cellpadding="10" cellspacing="20">
		   
		   <tr>
		       <th align='left'>Email :</th>			   
			    <td>
		       <input type = 'text' id='email' name='email' required='required' placeholder='Enter Email' onkeypress='validateEmail()'/>
		       </td>						       
		   
		   </tr>
		   
		   <tr>
		   
		      <th align='left'>Password :</th>
			   <td>
		       <input type = 'password' id='password' name='password' placeholder='Enter Password' required='required'/><br/><br/>
			   <a href='#'>forgot Password?</a>
		       </td>				    
		   
		   </tr>
		   		   
		   <tr>
		   
		   <td colspan="2">
		   <input type='submit' value='Submit' height='150px'>
		   </td>
		   
		   </tr>
		   
		   </table>
		   </form>
	
	</div>





</body>




</html>