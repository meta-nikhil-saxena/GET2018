alert('Singly Linked List');
// User defined class node 
function Node(element){ 
        this.element = element; 
        this.next = null 
} 

function LinkedList(){
    this.size = 0;
    this.head = null;
}

LinkedList.prototype.add = function(element){ 
    // creates a new node 
    var node = new Node(element); 
  
    // to store current node 
    var current; 
  
    // if list is Empty add the 
    // element and make it head 
    if (this.head == null){ 
        this.head = node; 
    } else { 
        current = this.head;  
        // iterate to the end of the 
        // list 
        while (current.next) { 
        current = current.next; 
        } 
        // add node 
        current.next = node; 
    } 
    this.size++; 
    console.log('Element added : '+element);
  } 

  LinkedList.prototype.remove = function(element){                                                                                                                                                                                                                                                                                                     var prev = null; 
    var current = this.head;
    // iterate over the list 
    while (current != null) { 
        // comparing element with current 
        // element if found then remove
        if (current.element === element) { 
            if (prev == null) { 
                this.head = current.next; 
            } else { 
                prev.next = current.next; 
            } 
            this.size--; 
            console.log('Element removed : '+element);
        }
        prev = current; 
        current = current.next; 
    } 
  }