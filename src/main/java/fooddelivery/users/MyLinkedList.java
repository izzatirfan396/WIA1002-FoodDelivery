/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fooddelivery.users;

/**
 *
 * @author Izzat
 */
public class MyLinkedList<E> {
    
    Node<E> head = null;
    Node<E> tail = null;
    int size = 0 ; 
    public MyLinkedList(){
    
    }
    
    public void addFirst(E e){
        
        Node<E> newNode = new Node<>(e);
        if(head == null){
            
            head = tail = newNode ;
          
        }else{
            
            newNode.next = head;
            head = newNode ;
            
        }
        
        size ++ ;
    
    }
    
    public void addLast(E e){
        
        Node<E> newNode = new Node<>(e);
        if(head == null){
            
            head = tail = newNode ;
          
        }else{
            
            tail.next = newNode;
            tail = newNode ;
            
        }
        size ++;
    
    }
    
    public void add(int index, E e) {
        
        if(index < 0 || index > size ){
        throw new IndexOutOfBoundsException();
        }
            
    if (index ==0){
    addFirst(e);
    }else if(index==size){
    addLast(e);
    }else{
    Node<E> newNode= new Node<>(e);
    Node<E> current = head;
    for(int i = 1; i < index ; i++){
    current = current.next;
    }
    newNode.next = current.next; 
    current.next = newNode;
    size++; 
    }
} 
    public E get(int index){
    Node<E> temp ;
    if(index<0 || index >= size){
        throw new IndexOutOfBoundsException();
    }else{
        temp = head;
        for (int i = 0; i <=index ; i++) {
            if(i==index){
                break;
            }
            temp=temp.next ;
        }

    }
    return temp.element ;
}
    
    
public E removeFirst(){ 
    Node<E> temp;
if(head == null){ 
    return null; 
}else{
temp = head;
head = head.next;
if (head == null){
tail = head;
}
size -- ;
}

return temp.element;
}
     public E removeLast(){
Node<E> temp;
if(head==null){ 
    return null;
}else if (head==tail){
temp = head; 
head=tail=null;
size-- ;
return temp.element ;
}else{
Node<E> current = head;
for(int i = 1; i<size-1 ; i++){
current = current.next;
}
temp = current.next;
current.next = null; tail = current; 
size--;
return temp.element;
}
    
}    
     
     
public E remove(int index) {
Node<E> temp;
if(index < 0 || index >= size){
return null;
}
else if(index==0){
return removeFirst();
}
else if(index == (size-1)){ 
    return removeLast();
}
else{
Node<E> current=head ;
for(int i = 1; i<index ; i++){
current = current.next;
}
temp = current.next; 
current.next = temp.next;
}
size--;
return temp.element ;
}

public String remove(E e){

    if(head == null){
        return "There is no User/Restaurant stored in the list";
    }

    // Case 1: remove head
    if(head.element.equals(e)){
        head = head.next;
        size--;
        return "Successfully removed";
    }

    Node<E> current = head;
    Node<E> previous = null;

    while(current != null){

        if(current.element.equals(e)){

            previous.next = current.next;

            size--;

            return "Successfully removed";
        }

        previous = current;
        current = current.next;
    }

    return "Object not found";
}

public void add(E e){

    addLast(e);
    
}

public boolean contains(E e ){
    
    Node<E> current = head ; 
    for (int i = 0; i < size; i++) {
        if(current.element.equals(e) ){
            return true ;
        }
        current = current.next ;
        
    }
    
    return false ; 
    
}


public void clear(){
    
    Node<E> temp = head ;
    for (int i = 0; i < size; i++) {
        temp = head.next ; 
        head.next = null ; 
        head = temp;
    }
    tail = null ;
    size=0;
    
}

}
