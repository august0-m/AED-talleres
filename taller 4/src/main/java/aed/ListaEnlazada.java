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
    
        if (this.longitud() == 0){
        this.primero = nuevo;    
        this.ultimo = nuevo;
        }
        else{
        (this.primero).anterior = nuevo;
        nuevo.siguiente = this.primero;
        this.primero = nuevo;
        }
        _longitud++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(null,elem,null);
        if (this.longitud() == 0){
        this.primero = nuevo;    
        this.ultimo = nuevo;
        }
        else{
        (this.ultimo).siguiente = nuevo;
        nuevo.anterior = this.ultimo;
        this.ultimo = nuevo;
        }
        _longitud++;
    }

    public T obtener(int i) {
        Nodo actual = this.primero;
        int j = 0;
        while (i != j){
            j++;
            actual = actual.siguiente;
        }
        return actual.valor;
    }

    public void eliminar(int i) {
     Nodo actual = this.primero;
     int j = 0;
     if(i == 0){
      this.primero = (this.primero).siguiente;
      _longitud--;
      return;
     }
     while(i != j){
      j++;
      actual = actual.siguiente;
     }
     (actual.anterior).siguiente = actual.siguiente;
     _longitud--;

    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = this.primero;
        int j=0;
        while(indice != j){
            j++;
            actual = actual.siguiente;
        }
        actual.valor = elem;
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> ListaNueva = new ListaEnlazada<T>();
        Nodo actual = this.primero ;
        while (actual != null) {
            ListaNueva.agregarAtras(actual.valor);
            actual = actual.siguiente;
        }
        return ListaNueva; 
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {     
      //  ListaEnlazada<T> ListaNueva = new ListaEnlazada<T>();   //no inicio una lista, uso this porq es el objeto que estoy creando
        Nodo actual = lista.primero ;                           //inicio la lista q quiero copiar
        while (actual != null) {                                //mientras no sea null q siga
            this.agregarAtras(actual.valor);              
            actual = actual.siguiente;                          //voy al siguiente
        }
        
       // throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        StringBuffer sBuffer = new StringBuffer();
        //sBuffer.append(fechaActual().toString());
        sBuffer.append("[");
        for (int i = 0;i<this.longitud();i++){
            if (i == 0){
                sBuffer.append(this.obtener(i));
                sBuffer.append(",");
            }
            if (i != 0 && i < this.longitud() - 1){
                sBuffer.append(" ");
                sBuffer.append(this.obtener(i));
                sBuffer.append(",");
            }
            if (i == this._longitud -1){
                sBuffer.append(" ");
                sBuffer.append(this.obtener(i));
            }
        }
        sBuffer.append("]");
        return sBuffer.toString();
    }

    private class ListaIterador implements Iterador<T> {
        Nodo actual;                        //no entendi muy bien porque hay q poner esto

        public ListaIterador(){
            actual = primero;
        }

        public boolean haySiguiente() {
            boolean res = false;
            if ( actual != null){     // no entiendo porq no seria actual.siguiente 
                return true;
            }
            return res;
        }
        
        public boolean hayAnterior() {
            boolean res = false;
            if(actual == primero){
                return false;
            }
            if (actual == ultimo.siguiente){
                return true;
            }
            if ( actual != null ){
                return true;
            }
           // if (actual.anterior != null ){
             //   return true;
            //}
            //if ()
            return res;
        }

        public T siguiente() {
            if (actual != null){
                T valor = actual.valor;
                actual = actual.siguiente;
                return valor;
            }
            else{
                return null;
            }
        }
        
        public T anterior() {
            if (actual != null){
                T valor = (actual.anterior).valor;
                actual = actual.anterior;
                return valor;
            }
            if (actual == null && hayAnterior()== true){
                T valor = ultimo.valor;
                return valor;
            }
            else{
                return null;
            }
        }
        }
    

    public Iterador<T> iterador() {
         return new ListaIterador();
    }
 

}