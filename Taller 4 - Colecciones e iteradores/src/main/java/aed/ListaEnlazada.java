package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int contador;

    private class Nodo {
        T valor; 
        Nodo sig;
        Nodo ant;

        //public Nodo( Nodo ant, T valor, Nodo sig){
        //    this.valor = valor;
        //    this.ant= ant;
        //    this.sig= sig;
        //}
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
        contador= 0;
    }

    public int longitud() {
        return contador;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevoPrimerNodo = new Nodo();
        
        
        if (this.longitud() == 0){
            nuevoPrimerNodo.ant=null;
            nuevoPrimerNodo.sig=null;
            nuevoPrimerNodo.valor=elem;

            this.primero = nuevoPrimerNodo;
            this.ultimo = nuevoPrimerNodo;
        }
        
        else{
   
            nuevoPrimerNodo.ant=null;
            nuevoPrimerNodo.sig= primero;
            nuevoPrimerNodo.valor=elem;
            
            
            this.primero.ant= nuevoPrimerNodo;

            this.primero= nuevoPrimerNodo;
        }
        
        contador++;

    }

    public void agregarAtras(T elem) {
        Nodo nuevoUltimoNodo = new Nodo();
        
        
        if (this.longitud() == 0){
            nuevoUltimoNodo.ant=null;
            nuevoUltimoNodo.sig=null;
            nuevoUltimoNodo.valor=elem;

            this.primero = nuevoUltimoNodo;
            this.ultimo = nuevoUltimoNodo;
        }
        
        else{
          
            nuevoUltimoNodo.sig=null;
            nuevoUltimoNodo.ant= ultimo;
            nuevoUltimoNodo.valor=elem;
            
            
            this.ultimo.sig= nuevoUltimoNodo;
            
            this.ultimo= nuevoUltimoNodo;
        }
        
        contador++;
    }

    public T obtener(int i) {
        Nodo aux= primero;
        for (int j=0; j<i; j++){
            aux = aux.sig;
        }
        return aux.valor;
    }

    public void eliminar(int i) {
        Nodo aux= primero;
        for (int j=0; j<i; j++){
            aux = aux.sig;
        }
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
