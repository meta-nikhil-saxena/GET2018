function validateEmail(){
	var pattern = new RegExp("^[A-Za-z]+[.A-Za-z0-9]+@+[A-Za-z0-9]+(.[a-zA-Z]{2,4})+$");
	var email = document.getElementById("email");
	if(pattern.test(email.value)){
		email.style.borderColor = "green";
		return true;
	}else{
	  email.style.borderColor = "red";	
	}
}

function validateAge(){
	 var pattern = new RegExp("(^[0-9]+$)");
	 var contact = document.getElementById("age");
	 if(pattern.test(contact.value) && contact.value.length < 3){
	  contact.style.borderColor = "green";
	  return true;
	 }else{
	  contact.style.borderColor = "red";	 
	 }
	 	   
}

function validateFirstName(){
	     var pattern = new RegExp("(^[A-Za-z]+$)");  
		 var firstname = document.getElementById('firstname');
        if(firstname.value.length > 2 && pattern.test(firstname.value)){
		firstname.style.borderColor = "green";
		return true;
		}else{
		firstname.style.borderColor = "red";	
		}
}

function validateLastName(){
	     var pattern = new RegExp("(^[A-Za-z]+$)");  
		 var lastname = document.getElementById('lastname');
        if(lastname.value.length > 2 && pattern.test(lastname.value)){
		lastname.style.borderColor = "green";		
		return true;
		}else{
		lastname.style.borderColor = "red";	
		}
}

function send(){
	if(validateEmail() && validateAge() && validateFirstName() && validateLastName()){
		alert('Success !!');
		document.form_addemp.action = 'AddEmp';
		document.form_addemp.submit();
	}else{
		alert('Enter valid Input ! All fields are mandatory !!');
	}
}