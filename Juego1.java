package juego1;

import java.util.Scanner;

public class Juego1 {

    static Scanner sc = new Scanner(System.in);
    static int marcador1 = 0;
    static int marcador2 = 0;
    static int resposta;
    static int numSecret;
    static boolean jugador1 = true;
    static boolean on = true;
    static String nombre1;
    static String nombre2;
    static String a = "";
   
    public static void main(String[] args) {
        /*Se piden los nombres*/
        entrada();
        /*Este bucle do-while nos permitirá mantener abierto el juego 
        e iniciar nuevas partidas*/
        do{
            /*Se muestra el marcador*/
            marcador();
            /*Se ejecuta el bucle principal del juego*/
            juego();
            /*Se menciona al ganador*/
            ganador();      
            /*Repetición del juego o salida*/
            salida();
        }while(on);
    }  
   
    static void salida(){
        while(!"S".equals(a) && !"N".equals(a)){
                a = sc.nextLine().toUpperCase();
                if((!"S".equals(a) && !"N".equals(a))){
                    System.out.println("Quieres jugar otra partida? S/N: ");
                }
            }
            if("N".equals(a)){
                on=false;
                marcador();
            } 
    }
    static void entrada(){
        System.out.print("Jugador 1 escribe tu nombre: ");
        nombre1=sc.nextLine();
        System.out.print("Jugador 2 escribe tu nombre: " );
        nombre2=sc.nextLine();
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
    public static boolean validacion(Object resposta){     
        
        return resposta instanceof Integer;
    }
    public static void marcador(){
        System.out.println("Marcador:");
        System.out.println(nombre1+": "+marcador1);
        System.out.println(nombre2+": "+marcador2);
    }
    public static int random(int x){
        return (int)(Math.random() * x + 1);
    }   

    static void juego(){
        int turnos = random(20);
        for(  ; turnos > 0; ){

                if(jugador1){
                    System.out.println("Turno de "+nombre1);
                }
                else{
                    System.out.println("Turno de "+nombre2);
                }
                /*Creo otro número secreto esta vez dentro del bucle, ya
                que en un principio lo cree fuera y luego eso dio problemas
                porque no canmbiaba aunque se acertase*/
                
                numSecret = random(100);
                
                /*Aquí es donde se va a llevar a cabo el juego, solo se sale
                acertando o cuando explota*/
                System.out.println("Adivina el numero entre 1 i 100");              
                
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
                                
                /*System.out.println(numSecret);*/
                while(turnos > 0 && resposta != numSecret){
                    if(resposta < numSecret){
                        System.out.println("MAS!!");
                    }
                    else{
                        System.out.println("MENOS!!");
                    }
                    
                    do {
                        System.out.println("Introduce un numero:");
                        while (!sc.hasNextInt()) {
                            System.out.println("Por favor, introduce un numero valido.");
                            sc.next();
                        }
                        resposta = sc.nextInt();
                    } while (!validacion(resposta));
                    turnos--;
                    
                    if(resposta == numSecret){
                        System.out.println("CORRECTO!!");
                    }
                }
                
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
}