alert('Doubly link list');

//Creating Node
function Node(element){
    this.element = element;
    this.next = null;
    this.prev = null;
}

//Creating link list doubly
function LinkedList(){
    this.size = 0;
    this. head = null;
}

LinkedList.prototype.add = function(element){
     var node = new Node(element);

     var current;
     var  prev;

     if(this.head == null){
      this.head = node;
     }else{
         current = this.head;

         while(current.next){
          prev = current;   
          current = current.next;
         }
         current.next = node;
         current.prev = prev;
     }
     this.size++;
     console.log('Element Added : '+element);
}

LinkedList.prototype.remove = function(element){
    var current = this.head;
    var prev = null;
    while(current != null){
       if(current.element === element){
              
               if(prev == null){
                this.head = current.next;
               }else{
                prev.next = current.next;
                current.next.prev = prev;
               }
               this.size--; 
            console.log('Element removed : '+element);
        }
      
       prev = current;
       current = current.next;
    }   
}
