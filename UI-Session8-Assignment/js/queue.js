//Class for Queue Implementation
function Queue(){
		this.elements = [];
}

Queue.prototype.enqueue = function(data) {
	this.elements.push(data);
	console.log("Element Added : "+data);
}

Queue.prototype.dequeue = function() {
	if (this.isEmpty()) {
        return "Queue Underflow"; 
	}
	console.log("Element removed : "+this.elements.shift());
    return this.elements.shift(); 
}

Queue.prototype.isEmpty = function() {
	if (this.elements.length == 0) {
        return true; 
	}
	return false;
}

Queue.prototype.display = function() {
    for (var i = 0; i < this.elements.length; i++) { 
        console.log(this.elements[i]); 
    }
}