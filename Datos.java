//HOLA

public class Datos implements Comparable<Datos>{
    private int numero;
    private String letra;

    public Datos(int numero, String letra){
        this.numero = numero;
        this.letra = letra;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLetra() {
        return this.letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    @Override
    public int compareTo(Datos d) {
        
        if(this.numero == d.numero){
            return this.letra.compareTo(d.letra);
        }else{
            if(this.numero > d.numero){
                return 1;
            }else{
                return -1;
            }
        }
    }

    @Override
    public String toString(){
        return numero +" : "+ letra;
    }
}
