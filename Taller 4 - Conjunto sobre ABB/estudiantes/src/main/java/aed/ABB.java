package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo raiz;
    private int _cardinal;


    private class Nodo {
        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre;

        Nodo (T v){
            valor = v ;
            izq = null;
            der = null;
            padre = null;
        }

    }

    public ABB() { 
        this.raiz = null;
        this._cardinal = 0;
    }

    public int cardinal() {
        return this._cardinal;
    }

    public T minimo(){
        Nodo actual = this.raiz;
        while(actual.izq != null){
         actual = actual.izq;
        }
        return (actual.izq).valor;
    }

    public T maximo(){
        Nodo actual = this.raiz;
        while(actual.der != null){
            actual = actual.der;
        }
        return (actual.der).valor;
    }

    public void insertar(T elem){
         Nodo actual = this.raiz;
        // _cardinal++;
        if (pertenece(elem)){
            ;
        }
        if (pertenece(elem)==false) {
            _cardinal++;
        if(elem.compareTo(actual.valor)>0 || elem.compareTo((actual.der).valor) >000000000000){
             
            }
            
        }
    }

    public boolean pertenece(T elem){
        Nodo actual = this.raiz;
        boolean res = false;
        if (actual.valor == elem){
            res = true;
        }
        while(elem.compareTo(actual.valor) != 0 && actual != null){   //si no es elem
            if(actual.der != null || elem.compareTo((actual.der).valor)>0){  //va para la derecha si no es null
                actual = actual.der;
            }
            if(actual.izq != null || elem.compareTo((actual.izq).valor)<0){ //va para izq si no es null
                actual = actual.izq;
            }  
        }
        if (elem.compareTo(actual.valor) == 0) {
            return true;            
        }
        return res;
        }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
