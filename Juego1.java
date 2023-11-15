package juego1;

import java.util.Scanner;

public class Juego1 {

    public static void main(String[] args) {
        boolean on=true;
        /*Este bucle do-while nos permitirá mantener abierto el juego 
        e iniciar nuevas partidas*/
        Scanner sc = new Scanner(System.in);
        boolean jugador1 = true;
        System.out.print("Jugador 1 escribe tu nombre: ");
        String nombre1=sc.nextLine();
        System.out.print("Jugador 2 escribe tu nombre: ");
        String nombre2=sc.nextLine();
        int marcador1=0;   
        int marcador2=0;
        do{
            /*La variable turnos marcará cuantos turnos durará la partida*/
            int turnos = (int)(Math.random() * 20 + 1);

            /*Inicializo la variable i en 0 para que permitiese como mínimo jugar
            1 turno*/
            
            marcador(nombre1, nombre2, marcador1, marcador2);
            for(int i=0; i<turnos; i++){
                if(jugador1){
                    System.out.println("Turno de "+nombre1);
                }
                else{
                    System.out.println("Turno de "+nombre2);
                }
                /*Creo otro número secreto esta vez dentro del bucle, ya
                que en un principio lo cree fuera y luego eso dio problemas
                porque no canmbiaba aunque se acertase*/
                
                int numSecret = (int)(Math.random() * 100 + 1);
                
                /*Aquí es donde se va a llevar a cabo el juego, solo se sale
                acertando o cuando explota*/
                System.out.println("Adivina el numero entre 1 i 100");              
                int resposta;
                
                do {
                    System.out.println("Introduce un numero:");
                    while (!sc.hasNextInt()) {
                        System.out.println("Por favor, introduce un numero valido.");
                        sc.next();  
                    }
                    resposta = sc.nextInt();
                } while (!validacion(resposta));
                                
                /*System.out.println(numSecret);*/
                while(i < turnos && resposta != numSecret){
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
                                        
                  /*System.out.println(numSecret);*/
                    i++;
                    if(resposta == numSecret){
                        System.out.println("CORRECTO!!");
                    }
                }
                if(resposta!=numSecret){
                    System.out.println("El numero era "+numSecret);
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
                i--;
            }
            /*Se menciona al ganador*/
            if(jugador1)
            {
                System.out.println("BOOM!");
                System.out.println("Gana " + nombre2);
                marcador2++;
            }
            else{
                System.out.println("¡BOOM!");
                System.out.println("Gana " + nombre1);
                marcador1++;
            }
            /*Repetición del juego o salida*/
            /*String a="";
            while(!"S".equals(a) && !"N".equals(a)){
                a = sc.nextLine().toUpperCase();
                if((!"S".equals(a) && !"N".equals(a))){
                    System.out.println("Quieres jugar otra partida? S/N: ");
                }
            }
            if("N".equals(a)){
                on=false;
                marcador(nombre1, nombre2, marcador1, marcador2);
            } */
            if(marcador1==3||marcador2==3){
                marcador(nombre1, nombre2, marcador1, marcador2);
            }
            
        }while(marcador1<3 && marcador2<3);
    }  
    public static boolean validacion(Object resposta){     
        
        return resposta instanceof Integer;
    }
    public static void marcador(String nombre1, String nombre2, int marcador1, int marcador2){
        System.out.println("Marcador:");
        System.out.println(nombre1+": "+marcador1);
        System.out.println(nombre2+": "+marcador2);
    }
}
/*Tareas*/