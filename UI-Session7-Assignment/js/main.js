var errorMap = new Map();
 
function send(){

var message = "";
   
  if(!validateFirstName() && !validateLastName() && !validateEmail() && !validateCity() && !validateAddress() && !validatePhone()){

  var keys = errorMap.keys();
              
      for(var key of keys){
      message += "Name : " + key + " , Description : " + errorMap.get(key) + "\n";
      }
   alert(message); 
   return false;
   }else{
       if(localStorage){
          localStorage.clear();
        for (var i = 1; i < document.getElementById("contact-us").elements.length; i++) {

                localStorage.setItem(document.getElementById("contact-us").elements[i].name,document.getElementById("contact-us").elements[i].value);	
       
        }
     return true;   
    }else{
        console.log("browser dosent support localStorage");
        return false;
    }
   } 
}

function validateFirstName(){
    var pattern = new RegExp("^[A-Z]{1}[a-z]+$");
    var firstname = document.getElementById("first-name");
    if(firstname.value == ""){
     errorMap.set("firstname","Firstname Cannot be Empty");
     validationResponse(false, firstname);
     return false;
    }else if(pattern.test(firstname.value) && firstname.value.length > 2){
    errorMap.delete("firstname");
    validationResponse(true, firstname);
    return true;
    }else{
    errorMap.set("firstname","Invalid Field ! First Letter Should be Capital !");
    validationResponse(false, firstname);
    return false;
    }
}
function validateLastName(){
    var pattern = new RegExp("^[A-Z]{1}[a-z]+$");
    var lastname = document.getElementById("last-name");
    if(lastname.value == ""){
    errorMap.set("lastname","lastname Cannot be Empty");
    validationResponse(false, lastname);
    return false;
    }else if(pattern.test(lastname.value) && lastname.value.length > 2 ){
    errorMap.delete("lastname");
    validationResponse(true, lastname);
    return true;
    }else{
    errorMap.set("lastname","Invalid Field ! Last Letter Should be Capital !");
    validationResponse(false, lastname);
    return false;
    }
}
function validateEmail(){
	var pattern = new RegExp("^[A-Za-z]+[.A-Za-z0-9]+@+[A-Za-z0-9]+(.[a-zA-Z]{2,4})+$");
    var email = document.getElementById("email");
    if(email.value == ""){
    errorMap.set("email","Email Cannot be Empty");
    validationResponse(false, email);
    return false;
    }else if(pattern.test(email.value)){
    errorMap.delete("email");    
	validationResponse(true, email);
    return true;
	}else{
    errorMap.set("email","Invalid Field Email");    
    validationResponse(false, email);
    return false;	
	}
}
function validatePhone(){
    var pattern = new RegExp("^[0-9]+$");
    var phone = document.getElementById("phone");
    if(phone.value == ""){
    errorMap.set("phone","Phone cannot be Empty");
    validationResponse(false, phone);
    return false;
    }else if(pattern.test(phone.value) && phone.value.length == 10){
    errorMap.delete(phone);    
    validationResponse(true, phone);
    return true;
    }else{
    errorMap.set("phone","Invalid Field Phone");
    validationResponse(false, phone);
    return false;
    }
}
function validateAddress(){
    var pattern = new RegExp("^[A-Z0-9a-z,-]+$");
    var address = document.getElementById("address");
    if(address.value == ""){
    errorMap.set("address","Address cannot be Empty");
    validationResponse(false, address);
    return false;
    }else if(pattern.test(address.value)){
    errorMap.delete(address);
    validationResponse(true, address);
    return true;
    }else{
    errorMap.set("address","Invalid Field Address");    
    validationResponse(false, address);
    return false;
    }
}
function validateCity(){
    var pattern = new RegExp("^[A-Z0-9,a-z]+$");
    var city = document.getElementById("city");
    if(city.value == ""){
    errorMap.set("city","City cannot be Empty");
    validationResponse(false, city);
    return false;
    }
    if(pattern.test(city.value)){
    errorMap.delete("city");
    validationResponse(true, city);
    return true;
    }else{
    errorMap.set("city","Invalid Field City");    
    validationResponse(false, city);
    return false;
    }
}

function validationResponse(response, object){
    if(response){
        object.style.border = "3px solid green";
    }
    else{
        object.style.border = "3px solid red";
    }
}

function addZip(referenceNode,buttonGroup){
       var zipcode = document.createElement('div');
       zipcode.id = "zipcode-field";
       zipcode.className = "form-field";
       zipcode.innerHTML = "<div class='label'>Zip Code</div><div class='component'><i class='fa fa-home component-icon'></i><input type='text' id='zipcode' placeholder='Zip Code' onblur='validateZipcode()'></div>";

       referenceNode.insertBefore(zipcode,buttonGroup); 
}

function addWebsite(referenceNode,buttonGroup){
    var website = document.createElement('div');
    website.id = "website-field";
    website.className = "form-field";
    website.innerHTML = "<div class='label'>Website or domain name</div><div class='component'><i class='fa fa-globe component-icon'></i><input type='text' name='website' placeholder='Website or domain name'></div>";

    referenceNode.insertBefore(website,buttonGroup);
}

function addProject(referenceNode,buttonGroup){
    var project = document.createElement('div');
    project.id = "project-field"
    project.className = "form-field";
    project.innerHTML = "<div class='label'>Project Description</div><div class='component'><i class='fas fa-pencil-alt component-icon'></i><textarea id='project_description' name='project' rows='3' placeholder='Project Description' onblur='validateProject()'></textarea></div>"; 

    referenceNode.insertBefore(project,buttonGroup);
}

function addHosting(referenceNode,buttonGroup){
    var hosting = document.createElement('div');
    hosting.id = "hosting-field";
    hosting.className = "form-field";
    hosting.innerHTML = "<div class='label'>Do you have hosting?</div><div class='component-radio-btn'><label><input type='radio' name='hosting' value='true'> Yes</label><label><input type='radio' name='hosting' value='false'> No</label></div>";
   
    referenceNode.insertBefore(hosting,buttonGroup);
}

function stateChange(){

   var text = document.getElementById("state");
   var referenceNode = document.getElementById("contact-us");
   var buttonGroup = document.getElementById('btn-group');
  
        if(text.value == "Rajasthan") {
            removeFields(referenceNode); 
            addWebsite(referenceNode,buttonGroup);
            addProject(referenceNode,buttonGroup);
        }else if(text.value == "Haryana") {
            removeFields(referenceNode); 
            addHosting(referenceNode,buttonGroup);
            addZip(referenceNode,buttonGroup);
        }else if(text.value == "Maharashtra") {
            removeFields(referenceNode); 
            addProject(referenceNode,buttonGroup);
            addZip(referenceNode,buttonGroup);
        }   
}

function removeFields(referenceNode){

      if(referenceNode.contains(document.getElementById('project-field'))){
        referenceNode.removeChild(document.getElementById('project-field'));
      }
      if(referenceNode.contains(document.getElementById('hosting-field'))){
       referenceNode.removeChild(document.getElementById('hosting-field'));
      }
      if(referenceNode.contains(document.getElementById('website-field'))){
       referenceNode.removeChild(document.getElementById('website-field'));
      }
      if(referenceNode.contains(document.getElementById('zipcode-field'))){
       referenceNode.removeChild(document.getElementById('zipcode-field'));
      }      
}
