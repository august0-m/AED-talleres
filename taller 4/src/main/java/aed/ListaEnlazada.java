package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int _longitud;

    private class Nodo {
         T valor;
         Nodo siguiente;
         Nodo anterior;

        public Nodo(Nodo anterior,T valor, Nodo siguiente){
            this.valor = valor;
            this.siguiente = siguiente;
            this.anterior = anterior;
        }

    }

    public ListaEnlazada() {
       primero = null;
       ultimo = null;
       _longitud = 0;
    }

    public int longitud() {
        return _longitud;
        
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(null,elem,null);
    
        if (this.longitud()==0){
        this.primero= nuevo;    
        this.ultimo=nuevo;
        }
        else{
        (this.primero).anterior= nuevo;
        nuevo.siguiente = this.primero;
        this.primero = nuevo;
        }
        _longitud++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(null,elem,null);
        if (this.longitud()==0){
        this.primero= nuevo;    
        this.ultimo=nuevo;
        }
        else{
        (this.ultimo).siguiente= nuevo;
        nuevo.anterior = this.ultimo;
        this.ultimo = nuevo;
        }
        _longitud++;
    }

    public T obtener(int i) {
        Nodo actual = this.primero;
        int j=0;
        while (i != j){
            j++;
            actual= actual.siguiente;
        }
        return actual.valor;
    }

    public void eliminar(int i) {
       // Nodo actual =this.primero;
       // int j=0;
       // if(i==0){
       //  this.primero = (this.primero).siguiente;
       // }
       // while(i!= j){
       //  j++;
       //  actual=actual.siguiente;
       // }
       // (actual.anterior).siguiente= actual.siguiente;
       // _longitud--;

       Nodo actual = this.primero;
       int j=0;

       if(i==0){

            Nodo next = primero.siguiente;

            next.anterior = null;

            this.primero = next;

            _longitud--;
         return;
       }

       if(i==_longitud-1){
            Nodo back = ultimo.anterior;

            back.siguiente = null;

            this.ultimo= back;

            _longitud--;
        return;
      }


       while (i != j){
           j++;
           actual= actual.siguiente;
       }
        // actual va a ser eliminado

        Nodo back = actual.anterior;
        Nodo next = actual.siguiente;
        
        next.anterior= back;
        back.siguiente= next;

        _longitud--;

    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada<T> copiar() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}