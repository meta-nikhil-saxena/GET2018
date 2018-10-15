function stringManipulation(inputString){
    var count;
    //String to store new resulting String 
    var stringNew = "";
    var i=0;
    for(;i<inputString.length;i++){
        count = 0;
        if(inputString[i] === inputString[i+1]){
           for(var j=i+1;j<inputString.length;j++){
                if(inputString[i] === inputString[j]){
                count++;
                }else{
                i=j-1;
                break;
                }
            }
        }
        if(count === 0){ 
            stringNew += inputString[i];
        }
    }
    console.log("String is : "+stringNew);    
}