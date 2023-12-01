package torneo;

import java.util.Scanner;
import torneo.Jugador;
import static torneo.Jugador.sc;

public class Torneo {
    
    static Scanner sc = new Scanner(System.in);
    static int marcador1 = 0;
    static int marcador2 = 0;
    static int resposta;
    static int numSecret;
    static int turnos;
    static int elegir;
    static boolean jugador1 = true;
    static String nombre1;
    static String nombre2;
    static String genero;
    static String genero1;
    static String genero2;
    static String a = "";
    static Jugador[] jugadores = new Jugador[8];
    static Jugador[] semis = new Jugador[4];
    static Jugador[] finals = new Jugador[2];
    
    public static void main(String[] args) {
        
        for ( int i = 0 ; i < jugadores.length ; i++ ){
            System.out.println("Jugador/a " + (i + 1) + " escribe tu nombre" );
            jugadores[i] = new Jugador(sc.nextLine());
            System.out.println("Jugador/a " + (i + 1) + " elige tu genero, M(Mujer) o H (Hombre)" );
            genero = sc.nextLine().toUpperCase();
            while(!genero.equals("M") && !genero.equals("H")){
                System.out.println("Elige tu genero(M/H)");
                genero = sc.nextLine().toUpperCase();
            }
            if(!Jugador.binario(genero)){
                jugadores[i].setGenero(genero);
            }        
            else{
                jugadores[i].setGenero(genero);
            }
        }        
        for ( int i = 0 ; i < 4 ; i++){
            marcador1 = 0;
            marcador2 = 0;
            for ( int j = 0 ; j < 2 ; ){
                elegir = random2(8);
                if(jugadores[elegir] == null){//En la primera iteracion todas las posiciones tienen un nombre pero en las demas tenemos que evitar que elija uno que sea null
                    continue;
                }            
                else{
                    if (j == 0){
                        nombre1 = jugadores[elegir].getNombre();
                        genero1 = jugadores[elegir].getGenero();
                        jugadores[elegir] = null;
                        j++;
                    }
                    else{
                        nombre2 = jugadores[elegir].getNombre();
                        genero2 = jugadores[elegir].getGenero();
                        jugadores[elegir] = null;
                        j++;
                    }
                }
            }
            System.out.println("1 ronda");
            if (!Jugador.binario(genero1)){
                System.out.println("Jugadora 1: " + nombre1);
            }
            else{
                System.out.println("Jugador 1: " + nombre1);
            }
            if (!Jugador.binario(genero2)){
                System.out.println("Jugadora 2: " + nombre2);
            }
            else{
                System.out.println("Jugador 2: " + nombre2);
            }
                
            juego();
            ganador();
            if(marcador1 == 1){
                semis[i] = new Jugador(nombre1, genero1);
            }
            else{
                semis[i] = new Jugador(nombre2, genero2);
            }
        
        }    
        for ( int i = 0 ; i < 2 ; i++){
            marcador1 = 0;
            marcador2 = 0;
            while(marcador1 < 2 && marcador2 < 2){
                
                for ( int j = 0 ; j < 2 ; ){
                    elegir = random2(4);
                    if(semis[elegir] == null){
                        continue;
                    }            
                    else{
                        if (j == 0){
                            nombre1 = semis[elegir].getNombre();
                            semis[elegir] = null;
                            j++;
                        }
                        else{
                            nombre2 = semis[elegir].getNombre();
                            semis[elegir] = null;
                            j++;
                        }
                    }
                }
                System.out.println("Semifinales");
                if (!Jugador.binario(genero1)){
                System.out.println("Jugadora 1: " + nombre1);
                }
                else{
                    System.out.println("Jugador 1: " + nombre1);
                }
                if (!Jugador.binario(genero2)){
                    System.out.println("Jugadora 2: " + nombre2);
                }
                else{
                    System.out.println("Jugador 2: " + nombre2);
                }
            
                juego();
                ganador();
            }
            if(marcador1 == 2){
                finals[i] = new Jugador(nombre1, genero1);
            }
            else{
                finals[i] = new Jugador(nombre2, genero2);
            }
        }
        marcador1 = 0;
        marcador2 = 0;
        nombre1 = finals[0].getNombre();
        nombre2 = finals[1].getNombre();
        genero1 = finals[0].getGenero();
        genero2 = finals[1].getGenero();
        while(marcador1 < 3 && marcador2 < 3){
            if (!Jugador.binario(genero1)){
                System.out.println("Jugadora 1: " + nombre1);
            }
            else{
                System.out.println("Jugador 1: " + nombre1);
            }
            if (!Jugador.binario(genero2)){
                System.out.println("Jugadora 2: " + nombre2);
            }
            else{
                System.out.println("Jugador 2: " + nombre2);
            }
            juego();
            ganador();
        }
        if(marcador1 == 3){
            if(!Jugador.binario(genero1)){
                System.out.println(nombre1 + " ES LA CAMPEONA!!!");
            }
            else{
                System.out.println(nombre1 + " ES  CAMPEON!!!");
            }
        }
        else{
            if(!Jugador.binario(genero2)){
                System.out.println(nombre2 + " ES LA CAMPEONA!!!");
            }
            else{
                System.out.println(nombre2 + " ES EL CAMPEON");
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    static boolean validacion(Object resposta){     
        return resposta instanceof Integer;
    }
    
    static int random(int x){
        return (int)(Math.random() * x + 1);
    }   
    static int random2(int x){
        return (int)(Math.random() * x);
    }   
    static void entrada(){
        System.out.print("Jugador 1 escribe tu nombre: ");
        nombre1=sc.nextLine();
        System.out.print("Jugador 2 escribe tu nombre: " );
        nombre2=sc.nextLine();
    }
    static void marcador(){
        System.out.println("Marcador:");
        System.out.println(nombre1+": "+marcador1);
        System.out.println(nombre2+": "+marcador2);
    }
    static void validaint(){
        /*Con el siguiente do... while nos aseguramos de que el numero
            introducido es un int*/
        do {
            System.out.println("Introduce un numero:");
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, introduce un numero valido.");
                sc.next();  
            }
            resposta = sc.nextInt();
        } while (!validacion(resposta));
    }
    static void buclejuego(){
        System.out.println("Adivina el numero entre 1 i 100"); 
        while(turnos > 0 && resposta != numSecret){
            turnos--;
            if(resposta < numSecret){
                System.out.println("MAS!!");
            }
            else{
                System.out.println("MENOS!!");
            }  
            validaint();
            if(resposta == numSecret){
                System.out.println("CORRECTO!!");
            }
        }
    }
    static void juego(){
        turnos = random(20);
        while(turnos > 0){

            if(jugador1){
                System.out.println("Turno de " + nombre1);
            }
            else{
                System.out.println("Turno de " + nombre2);
            }
            /*Creo otro número secreto esta vez dentro del bucle, ya
            que en un principio lo cree fuera y luego eso dio problemas
            porque no canmbiaba aunque se acertase*/
            numSecret = random(100);
            /*Aquí es donde se va a llevar a cabo el juego, solo se sale
            acertando o cuando explota*/         
            validaint();                  
            buclejuego();
            if(resposta!=numSecret){
                System.out.println("El numero era " + numSecret);
            }
               
            /*Si la respuesta se ha acertado se cambia el turno del jugador*/
            if(jugador1){
                if(numSecret == resposta){
                    jugador1=false;
                }
            }
            else{
                if(numSecret == resposta){
                    jugador1=true;
                }
            }
        }        
    }
    static void ganador(){
        if(jugador1)
            {
                System.out.println("BOOM!");
                System.out.println("Gana " + nombre2);
                marcador2++;
            }
            else{
                System.out.println("BOOM!");
                System.out.println("Gana " + nombre1);
                marcador1++;
            }
    }
}
