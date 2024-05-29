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

        public Nodo(T v){
            valor = v ;
            izq = null;
            der = null;
            padre = null;
        }

    }

    public ABB() {              //inicializo el abb
        this.raiz = null;
        this._cardinal = 0;
    }

    public int cardinal() {     // da cant elementos
        return this._cardinal;
    }

    public T minimo(){
        Nodo actual = this.raiz;
        if(actual == null){
            return null;
        }
        while(actual.izq != null){      //recorro rama izq porq esta ordenado 
         actual = actual.izq;
        }
        return actual.valor;      //  doy el q mas "a la izq este"
    }

    public T maximo(){                  // lo mismo q izq pero al reves
        Nodo actual = this.raiz;
        if(actual == null){
            return null;
        }
        while(actual.der != null){
            actual = actual.der;
        }
        return actual.valor;
    }

    public void insertar(T elem){
        Nodo actual = this.raiz;
        Nodo nodo_con_elem = new Nodo(elem);
        Nodo padre = null;
          
        if (pertenece(elem)){   
             return;                       //si pertenece no hago nada(no funciona pertenece)
        }
        if (actual == null ) {          //si no hay nada lo pongo como raiz
            this._cardinal++;
            this.raiz = nodo_con_elem;
        }
        else{
            while (actual != null) {
                padre = actual;
                if(elem.compareTo(actual.valor) > 0){                   //si es mas grande q el actual voy xa la derecha
                    actual = actual.der;
                }
                else{                                               //si no, a la izq
                actual=actual.izq;
                }
            }
            if (elem.compareTo(padre.valor) < 0) {          //y ahora lo comparo con el "padre" para ver donde lo ubico
                padre.izq = nodo_con_elem;
            } 
            else {
                padre.der = nodo_con_elem;
            }
            this._cardinal++;
        }
    }
       
        

    public boolean pertenece(T elem){
        Nodo actual = this.raiz;
        boolean res = false;
        if (actual == null){
            return false;
        }
        if (actual.valor == elem){
            res = true;
        }
        while(actual != null && elem.compareTo(actual.valor) != 0 ){   //si no es elem
            if(elem.compareTo(actual.valor) > 0 && actual.der ==  null ){
                return false;
               }
            if(elem.compareTo(actual.valor) < 0 && actual.izq ==  null ){
                return false;
               }
            if(elem.compareTo(actual.valor) > 0 && actual.der != null){
                actual = actual.der;
            }
            if(elem.compareTo(actual.valor) < 0 && actual.izq != null ){
                actual = actual.izq;
            }  
        }
        if (elem.compareTo(actual.valor) == 0) {
            return true;            
        }
        return res;
        }

    public void eliminar(T elem){   //primero lo tengo q encontrar, tengo q estar en ese nodo(hacer esa parte de codigo)
        Nodo eliminar = this.raiz;
        Nodo padre = null;
        if(pertenece(elem) == false){
            return;
        }
        else{
            if (eliminar.izq == null && eliminar.der == null) {
                if(elem.compareTo(padre.valor) > 0){
                    padre.der = null;
                }
                else{
                    padre.izq = null;
                }
            }
            if(eliminar.izq !=null && eliminar.der == null){
                if((eliminar.izq).valor.compareTo(padre.valor) > 0){
                    padre.der = eliminar.izq;
                }
                else{
                    padre.izq = eliminar.izq;
                }
            }
            if(eliminar.der !=null && eliminar.izq == null){
                if((eliminar.der).valor.compareTo(padre.valor) > 0){
                    padre.der = eliminar.der;
                }
                else{
                    padre.izq = eliminar.der;
                }
            }
            else{
                return;
            }
    }
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
