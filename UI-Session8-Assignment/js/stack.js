//Class for Stack Implementation
function Stack(){
		this.elements = [];
}

Stack.prototype.pushElement = function(data) {
    this.elements.push(data);
    console.log("Element Added : "+data);
}

Stack.prototype.popElement = function() {
	if (this.isEmpty()) {
        return "Stack Underflow"; 
    }
    console.log("Element removed : "+this.elements.pop());
    return this.elements.pop(); 
}

Stack.prototype.isEmpty = function() {
	if (this.elements.length == 0) {
        return true; 
	}
	return false;
}

Stack.prototype.display = function() {
    for (var i = 0; i < this.elements.length; i++) { 
        console.log(this.elements[i]); 
    }
}