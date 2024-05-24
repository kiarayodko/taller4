package aed;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int contador;

    private class Nodo {
        T valor; 
        Nodo sig;
        Nodo ant;

      
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
        Nodo actual = primero;
        int indice = 0;

        this.contador =(this.contador - 1);

        while (indice < i) {
            actual = actual.sig;
            indice++;
        }

        if (actual.ant != null) {
            actual.ant.sig = actual.sig;
        } else {
       
            primero = actual.sig;
        }

        if (actual.sig != null) {
            actual.sig.ant = actual.ant;
        } else {
            ultimo = actual.ant;
        }
       
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primero;
        int i = 0;
        while (i < indice ){
            actual = actual.sig;
            i++;
        }
        actual.valor = elem;
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T>  copy = new ListaEnlazada<>();
        Nodo actual = primero;
        int i = 0;
        while (i< this.contador){
            copy.agregarAtras(actual.valor);
            actual = actual.sig;
            i++;
        }
        return copy;

    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        primero = null;
        ultimo = null;

        for (int i=0; i<lista.longitud();i++){
            this.agregarAtras(lista.obtener(i));
        }
    }
    
    @Override
    public String toString() {
        String res = "[";
        int i = 0;
        while (i< this.longitud()-1){
            res = res + (this.obtener(i)).toString() + ", ";
            i++;
        }
        res = res + this.ultimo.valor.toString() + "]";
        return  res;
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados
        private Nodo actual;

        public ListaIterador() {
            actual = primero;
        }

        public boolean haySiguiente() {
            boolean res =false;
	        if (actual == null){
                res= false;
            }else{ 
                actual=actual.sig;
                res = actual != null;
            }
            return res;
        }
        
        public boolean hayAnterior() {
	        if (actual == null){
                return false;
            }else{ 
                return actual.ant != null;
            }
        }

        public T siguiente() {
            T res = actual.valor;
            if(actual == ultimo){
                res= actual.valor;
                actual = null;

            }else{
                res=actual.valor;
                actual=actual.sig;
            }
            return  res;

        }
        

        public T anterior() {
	        return actual.ant.valor;
        }
    }

    public Iterador<T> iterador() {
	    Iterador<T> it = new  ListaIterador();
        return it;
    }

}
