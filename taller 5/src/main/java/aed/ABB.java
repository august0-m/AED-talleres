package aed;                                    //voy a empezar a comentar el codigo porq me divierto jaja asi hablo con vos q me lees hola como estas yo estoy perdiendo el cerebro

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
             return;                                            //si pertenece no hago nada(no funciona pertenece)
        }
        if (actual == null ) {                                  //si no hay nada lo pongo como raiz
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
        while(actual != null && elem.compareTo(actual.valor) != 0 ){                                    //si no es elem
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

    public void eliminar(T elem){                                       //no entiendo como funciona si le falta un caso segun mi logica pero bueno  
                                                                        //esta mal hecho porq esta planteado para todos nodos que tengan padre
                                                                        // me falta caso raiz y no se si estoy asignando bien los valores cuando lo reemplazo
                                                                        // hacer caso raiz= hacer caso con dos hijos creo
        Nodo eliminar = this.raiz;
        Nodo padre = null;

        if(pertenece(elem) == false){                                   //si no esta no elimino nada
            return;
        }
        if(this.cardinal() ==1){                                        //caso_0 hay un solo elem
            this.raiz =null;
            _cardinal--;
        }

        else{
            _cardinal--;                                                //le saco uno a su long
            while(eliminar.valor != elem){                             //busco el nodo en el que esta y me "paro" en el 
                padre = eliminar;                         
                if(eliminar.valor.compareTo(elem) < 0){                 //eliminar en este momento no es el quiero eliminar, por eso voy para la der si el que "tengo" es mas chico que el que quiero eliminar   
                    eliminar = eliminar.der;
                }
                else{
                    eliminar = eliminar.izq;
                }
                if(padre == eliminar){                                          //caso_raiz, le tengo q asignar algo a raiz. el sucesor mas cercano(el min a su derecha)
                                                                                //si hago eso creo q lo completo pero agregaria un while para buscar el min a su derecha
                    if(eliminar.izq != null && eliminar.der == null){
                        eliminar = eliminar.izq;
                        return;
                    }
                    if(eliminar.der != null && eliminar.izq == null ){
                        eliminar = eliminar.der;
                        return;
                    }
                }
                if (eliminar.izq == null && eliminar.der == null) {         //caso_1 el que elimino es una hoja, no tiene hijos
                    if(elem.compareTo(padre.valor) > 0){
                        padre.der = null;
                    }
                    else{
                        padre.izq = null;
                    }
                }
                if(eliminar.izq !=null && eliminar.der == null){          //caso_2 el que elimino tiene un hijo a la izq
                    if((eliminar.izq).valor.compareTo(padre.valor) > 0){
                        padre.der = eliminar.izq;
                    }
                    else{
                        padre.izq = eliminar.izq;
                    }
                }
                if(eliminar.der !=null && eliminar.izq == null){                 //caso_3 el que elimino tiene un hijo a la der
                    if((eliminar.der).valor.compareTo(padre.valor) > 0){
                        padre.der = eliminar.der;
                    }
                    else{
                        padre.izq = eliminar.der;
                    }
                }
                }
                //if(eliminar != null){
                //    if(eliminar.izq != null && eliminar.der == null){
                //        eliminar = eliminar.izq;
                //    }
                //    if(eliminar.der != null && eliminar.izq == null ){
                //        eliminar = eliminar.der;
                //    }
                //}

                //else{                                                        //caso_4 + dificil 2 descendientes bueno no se porque pero funciona sin haber hecho esto jaja salu2
                  //  return;
                //}
    
        }
    }

    public String toString(){                                               //la idea que tengo es, agrego min, lo elimino y asi hasta q no haya nada pero no puedo llamar al min asi de una ese es mi problema
        StringBuffer sietelibertadores = new StringBuffer();

        Nodo actual = this.raiz;
        Nodo padre = null;
        Nodo aux = null;

        if(actual == null){
            return null;
        }
        if(this.cardinal() ==1){                                        //caso_0 hay un solo elem
            sietelibertadores.append("{");
            sietelibertadores.append(this.raiz.valor);
            sietelibertadores.append("}");
            return sietelibertadores.toString();
        }

        sietelibertadores.append("{");
        while(this.raiz != null && ( ( (this.raiz).der != null ) || ( (this.raiz).der  != null ) ) ){
            while (actual.izq != null) {
                padre = actual;
                actual = actual.izq;
            }
            sietelibertadores.append(actual.valor);

            eliminar(actual.valor);
        }
        //while(actual.izq != null){   
        //    aux = actual;                                //voy hasta el minimo y lo agrego a la lista, y me quedo con padre que es el q esta uno arriba del min
        //    actual = actual.izq;
        //}
//
        //sietelibertadores.append(actual.valor);
        //eliminar(actual.valor);
        //actual = aux;
        //while(this.raiz != null){
        //    while (actual.izq != null) {
        //        sietelibertadores.append(actual.valor);
        //        eliminar(actual.valor);
        //        actual = padre;
        //    sietelibertadores.append(actual.valor);
        //    eliminar(actual.valor);
        //    actual=padre; 
        //    }
        //}
        //sietelibertadores.append(actual.valor);
        // while (padre!= null) {
        //     if(actual.izq == null && actual.der == null){
        //         sietelibertadores.append(actual.valor);
        //         eliminar(actual.valor);      
        //         padre = actual; 
        //     }
        //     if(actual.der != null && actual.izq ==)
            
        
            //}
        if ((this.raiz).izq == null && (this.raiz).der == null) {
            sietelibertadores.append((this.raiz).valor);
        }
        sietelibertadores.append("}");
        return sietelibertadores.toString();
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
