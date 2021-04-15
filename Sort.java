import java.util.*;

public class Sort <T extends Comparable <T>>{
    int contador;

    public int getContador() {
        return this.contador;
    }

    public void setContador(int valor) {
        this.contador = valor;
    }

    public int insercion(ArrayList<T> array){
        T aux;
        for(int i = 1; i < array.size(); i++){
            aux = array.get(i);
            for(int j = (i-1); j>=0; j--){
                contador ++;
                if(array.get(j).compareTo(aux)  > 0){
                    array.set(j+1, array.get(j));
                    array.set(j, aux);
                    contador ++;
                }

            }
        }
        //System.out.println("Iteraciones: "+contador);
        return contador;
    }

    public int quickSort(ArrayList<T> array, int left, int right){
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
            quickSort(array, left, index - 1);
        }
        if(index < right){
            quickSort(array, index, right);
        }

        return contador;
    }

    //private int partition(ArrayList<T> array, int left, int right) {
    //  return i;
    //}

    public void mergesort(ArrayList<T> array, int izq, int der){

        if(izq < der){
            int middle = (izq + der) / 2;
            mergesort(array, izq, middle);
            mergesort(array, middle+1, der );
            merge(array, izq, middle, der);

        }


    }

    private void merge(ArrayList<T> array, int izq, int middle, int der) {
        int n1 = middle - izq + 1;
        int n2 = der - middle;

        //ArrayList temporales.
        ArrayList<T> leftArray = new ArrayList<>();
        ArrayList<T> rightArray = new ArrayList<>();

        //Se rellenan los arraylist
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
            contador ++;
            if(leftArray.get(i).compareTo(rightArray.get(j)) <= 0){
                array.set(k,leftArray.get(i));
                i++;
            }else{
                array.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }
        //Se almacenan los valores restantes
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
    }

    public int cycleSort(ArrayList<T> array, int tam) {
        int posicion;
        T elemento, temp;
        for (int inicio = 0; inicio <= tam - 2; inicio++) {
            elemento = array.get(inicio);
            posicion = inicio;
            for (int i = inicio + 1; i < tam; i++) {

                if (array.get(i).compareTo(elemento) < 0) {
                    posicion++;
                    contador++;
                }
            }
            if (posicion == inicio) {
                continue;
            }
            while (elemento.compareTo(array.get(posicion)) == 0) {
                posicion += 1;
                contador++;
            }
            if (posicion != inicio) {
                temp = elemento;
                elemento = array.get(posicion);
                array.set(posicion, temp);

            }
            while (posicion != inicio) {
                posicion = inicio;
                for (int i = inicio + 1; i < tam; i++) {

                    if (array.get(i).compareTo(elemento) < 0) {
                        posicion += 1;
                    }
                    contador++;
                }
                while (elemento.compareTo(array.get(posicion)) == 0) {
                    posicion += 1;
                    contador++;
                }
                if (elemento.compareTo(array.get(posicion)) != 0) {
                    temp = elemento;
                    elemento = array.get(posicion);
                    array.set(posicion, temp);
                }
                contador++;
            }
        }
        // System.out.println("Iteraciones: "+contador);
        return contador;
    }


    public int fisherYates(ArrayList<T> array){
        for(int i = array.size() - 1; i >= 0; i--) {
            contador ++;
            int random = (int)Math.floor(Math.random() * (i + 1));
            T tmp = array.get(i);
            array.set(i, array.get(random));
            array.set(random, tmp);
        }
        //System.out.println("Iteraciones: "+contador);
        return contador;
    }
}
