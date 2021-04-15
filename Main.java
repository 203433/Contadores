import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

//Marisol Solis Lopez 203411
//Azul Gissele Briones Zavala 203720
//Enrique Verdi Cruz 203433

public class Main {

    static Random rn = new Random();
    static Scanner teclado = new Scanner(System.in);
    public static void main(String [] args) {

        Sort s = new Sort<>();
        int opcion, contador;
        
        do{
            System.out.println("Menu: \n1) Ordenamiento QuickSort \n2) Ordenamiento MergeSort"+
                            "\n3) Ordenamiento CycleSort \n4) Ordenamiento Fisher-Yates \n5) Salir");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("- Q U I C K S O R T -");
                    System.out.println("Tamanio del array \tIteraciones");
                    for(int i = 0; i < 5; i++){
                        contador = 0;
                        ArrayList array = generarObjetos(rn.nextInt(10000));
                        int iter = s.quickSort(array, 0, array.size()-1, contador);
                        System.out.println(array.size()+"\t\t\t"+iter);
                    }
                    break;
                case 2:
                    System.out.println("- M E R G E S O R T -");
                    System.out.println("Tamanio del array \tIteraciones");
                    for(int i = 0; i < 5; i++){
                        contador = 0;
                        ArrayList array = generarObjetos(rn.nextInt(10000));
                        int iter = s.mergesort(array, 0, array.size()-1);
                        System.out.println(array.size()+"\t\t\t"+iter);
                    }
                    break;
                case 3:
                    System.out.println("- C Y C L E S O R T -");
                    System.out.println("Tamanio del array \tIteraciones");
                    for(int i = 0; i < 5; i++){
                        contador = 0;
                        ArrayList array = generarObjetos(rn.nextInt(10000));
                        int iter = s.cycleSort(array, array.size());
                        System.out.println(array.size()+"\t\t\t"+iter);
                    }
                    break;

                case 4:
                    System.out.println("- F I S H E R - Y A T E S -");
                    System.out.println("Tamanio del array \tIteraciones");
                    for(int i = 0; i < 5; i++){
                        contador = 0;
                        ArrayList array = generarObjetos(rn.nextInt(10000));
                        int iter = s.fisherYates(array);
                        System.out.println(array.size()+"\t\t\t"+iter);
                    }
                    break;
            }
        }while(opcion!=5);
    }

    private static ArrayList<Datos> generarObjetos(int cantidad) {

        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<Datos> list = new ArrayList<>();
        for(int i = 0; i < cantidad; i++){
            int numero = rn.nextInt(10001);
            int posicion = rn.nextInt(alfabeto.length());
            String letra = Character.toString(alfabeto.charAt(posicion));
            //System.out.println("Numero: "+numero+" | Letra: "+letra);
            Datos dato = new Datos(numero, letra);
            list.add(dato);
        }
        return list;
    }
}
