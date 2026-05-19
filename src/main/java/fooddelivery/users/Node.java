/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fooddelivery.users;

/**
 *
 * @author Izzat
 */
public class Node<E> {
    E element ;
    Node<E> next ;
    
    public Node(E element , Node<E> next){ 
        
        this.element = element ;
        this.next = next ;
    
    }
    
    public Node(E element){
    this(element,null);
    }
    
    
}

