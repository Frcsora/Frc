package torneo;

import java.util.Scanner;


public class Jugador {
    static Scanner sc = new Scanner(System.in);
    private String nombre;
    private String genero;
    
    public Jugador(){
        
    }
    public Jugador(String nombre){
        this.nombre = nombre;
    }
    public Jugador(String nombre, String genero){
        this.nombre = nombre;
        this.genero = genero;
    }
    public String getNombre(){
        return nombre;
    }
    public String getGenero(){
        return genero;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public static boolean binario(String g){
        return "H".equals(g);
    }
    
}
