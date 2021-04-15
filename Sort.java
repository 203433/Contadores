
import java.util.*;

public class Sort <T extends Comparable <T>>{
    
    public int insercion(ArrayList<T> array){
        T aux;
        for(int i = 1; i < array.size(); i++){
            aux = array.get(i);
            for(int j = (i-1); j>=0 && (array.get(j).compareTo(aux)  > 0); j--){
                contador ++;
                //Contador del método de inserción
                array.set(j+1, array.get(j));
                array.set(j, aux);
            }
        }
        //System.out.println("Iteraciones: "+contador);
        return contador; //Se retorna el contador
    }
    
    public int quickSort(ArrayList<T> array, int left, int right, int contador){
        int i = left, j = right;

        T tmp;
        int centro = (left + right)/2;
        T pivot = array.get(centro);
        while(i <= j){
            while(array.get(i).compareTo(pivot) < 0){
                i++;
                contador ++;
            }
            while(array.get(j).compareTo(pivot) > 0){
                j--;
                contador ++;
                //Contador del método de QuickSort
            }
            if(i <= j){
                tmp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, tmp);
                i++;
                j--;
            }
        }
        //System.out.println("Iteraciones: "+contador);
        int index = i;

        if(left < (index-1)){
            quickSort(array, left, index - 1, contador);
        }
        if(index < right){
            quickSort(array, index, right, contador);
        }
        
        return contador; //Se retorna el contador
    }

    //private int partition(ArrayList<T> array, int left, int right) {
    //  return i;
    //}

    public int mergesort(ArrayList<T> array, int izq, int der){
        int contador = 0;
        if(izq < der){
            int middle = (izq + der) / 2;
            mergesort(array, izq, middle);
            mergesort(array, middle+1, der);
            contador = contador + merge(array, izq, middle, der);
            //Se acumulan los valores retornados por el metodo merge
        }

        return contador;//Se retorna el contador del método mergesort
        
    }

    private int merge(ArrayList<T> array, int izq, int middle, int der) {
        int contador = 0;
        int n1 = middle - izq + 1;
        int n2 = der - middle;

        //ArrayList temporales.
        ArrayList<T> leftArray = new ArrayList<>();
        ArrayList<T> rightArray = new ArrayList<>();
      
        for (int i=0; i < n1; i++) {
            leftArray.add(array.get(izq+i));
        }
        for (int j=0; j < n2; j++) {
            rightArray.add(array.get(middle + j + 1));
        }
        int i = 0, j = 0;
        int k = izq;

        //Ordenamiento.
        while (i < n1 && j < n2) {
            if(leftArray.get(i).compareTo(rightArray.get(j)) <= 0){
                array.set(k,leftArray.get(i));
                contador++; //Contador del metodo MergeSort
                i++;
            }else{
                array.set(k, rightArray.get(j));
                j++;
                contador ++;
            }
            k++;
        }
        while (i < n1) {
            array.set(k, leftArray.get(i));
            i++;
            k++;

        }
        while (j < n2) {
            array.set(k, rightArray.get(j));
            j++;
            k++;
        }
        return contador; //Se retorna el contador
    }

    public int cycleSort(ArrayList<T> array, int tam){  
        int posicion;
        T elemento, temp;  
        int contador = 0;
        for (int inicio = 0; inicio <= tam - 2; inicio++) {
            contador ++;
            elemento = array.get(inicio);
            posicion = inicio;  
            for (int i = inicio + 1; i < tam; i++){ 
                if(array.get(i).compareTo(elemento) < 0){ 
                    posicion++;  
                }
            }
            if (posicion == inicio){  
                continue;  
            }
            while(elemento.compareTo(array.get(posicion)) == 0){

                posicion += 1; 
            } 
            if (posicion != inicio) {  
                temp = elemento;  
                elemento = array.get(posicion);
                array.set(posicion, temp);
                contador++;
            }  
            while (posicion != inicio) {  
                posicion = inicio;  
                for (int i = inicio + 1; i < tam; i++){  
                    if(array.get(i).compareTo(elemento) < 0){
                        posicion += 1;  
                    }
                }
                while(elemento.compareTo(array.get(posicion)) == 0){
                    posicion += 1;  
                }
                if(elemento.compareTo(array.get(posicion)) != 0){

                    temp = elemento;  
                    elemento = array.get(posicion);
                    array.set(posicion, temp);
                    contador++;
                }  
            }  
        } 
        //System.out.println("Iteraciones: "+contador);
        return contador;//Se retorna el contador del método cyclesort
    }

    
    public int fisherYates(ArrayList<T> array) {
        int contador = 0;
        for(int i = array.size() - 1; i > 0; i--) {
            contador ++;
            int random = (int)Math.floor(Math.random() * (i + 1));
            T tmp = array.get(i);
            array.set(i, array.get(random));
            array.set(random, tmp);
        }
        //System.out.println("Iteraciones: "+contador);
        return contador;//Se retorna el contador del método fisherYates
    }
}
