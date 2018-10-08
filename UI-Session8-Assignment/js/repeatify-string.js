//Function to print the String as the number specified by user
String.prototype.repeatify = function(number) {
    var repeatedString = '';
   for (var i = 0; i < number; i++) {
       repeatedString += this.toString();
   }
   return repeatedString;
};