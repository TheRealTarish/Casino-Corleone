/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.complementaria.pkg1;

import java.util.Scanner;

/**
 *
 * @author Hector
 */
public class ActividadComplementaria1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada=new Scanner(System.in);
        double apuesta;
        double saldo=1000;
        double deuda=0;
        int dado;
        String r;
        boolean muerto=false;
        
        System.out.println("Bienvenido al Maravilloso Y Nada Sospechoso Casino de Vito Corleone.\n"
                + "Has ahorrado toda tu vida para venir aqui, y has conseguido reunir 1000€.\n"
                + "Has oido hablar de las grandes fortunas conseguidas en la mesa de dados,\n"
                + "asi que te acercas a ella y empiezas a jugar.");
        
        //Pedimos una apuesta inicial.
        System.out.print("Introduce la cantidad a apostar.\nSi no quieres apostar, introduce 0.");
        if (deuda>0){
            System.out.println("Tambien puedes introducir una cantidad negativa para pagarsela a\n"
                    + "Corleone y reducir tu deuda.");
        }
        System.out.println("\nApuesta: ");
        apuesta=entrada.nextInt();
        
        //Evitamos que el jugador apueste mas de lo que tiene
        while (Math.abs(apuesta)>saldo){
            System.out.print("No tienes tanto dinero. Introduce una apuesta valida.\nApuesta:");
            apuesta=entrada.nextInt();
        }
        //Seguimos apostando mientras al jugador le quede dinero, o decida salir.
        while (saldo>0&&apuesta!=0){
            
            saldo-=Math.abs(apuesta);
            
            if (apuesta>0){
                deuda+=(int)deuda*0.03;
                //Decidimos aleatoriamente el valor del dado, para que contenga un valor entre 1 y 6
                dado=(int)(Math.random()*100)%6+1;
            
                //Y aplicamos el modificador adecuado segun el resultado.
                switch(dado){
                    case 1:
                    case 3:
                    case 5: System.out.println("Ha salido "+dado+", un numero impar. Pierdes lo apostado");
                            break;
                    case 2: saldo+=apuesta*3;
                            System.out.println("Ha salido un 2. Obtienes "+apuesta*3+"€.");
                            break;
                    case 4: saldo+=apuesta*2;
                            System.out.println("Ha salido un 4. Obtienes "+apuesta*2+"€.");
                            break;
                    case 6: saldo+=apuesta;
                            System.out.println("Ha salido un 6. Recuperas lo apostado.");
                            break;
                }
            }else{
                deuda+=apuesta;
                System.out.println("Le has pagado "+apuesta*-1+" a Corleone. Sigues debiendole "+deuda+"€.");
            }
            
                //Mostramos el saldo restante
                System.out.println("Actualmente dispones de "+saldo+"€.");
                
                if (deuda>0){
                    System.out.printf("Le debes %.2f a Corleone.",deuda);
                }
                
                if (deuda>10000){
                    System.out.println("Le debes demasiado dinero a Corleone, y no cree que puedas devolverselo."
                            + "\nPara recuperar su dinero, decide matarte y vender tus organos.");
                    muerto=true;
                    break;
                }
            //Comprobamos que no se haya quedado sin dinero
            if(saldo>0){
                //Preguntamos si quiere seguir apostando y cuanto.
                System.out.print("Si quieres seguir apostando, introduce la cantidad.\nSi no quieres apostar, introduce 0.");
                if (deuda>0){
                    System.out.println("Tambien puedes introducir una cantidad negativa para pagarsela a\n"
                            + "Corleone y reducir tu deuda.");
                }
                System.out.println("\nApuesta: ");
                apuesta=entrada.nextInt();
            
                while (apuesta>saldo){
                    System.out.print("No tienes tanto dinero. Introduce una apuesta valida.\nApuesta:");
                    apuesta=entrada.nextInt();
                }
            }else{
                System.out.println("Te has quedado sin dinero. No puedes seguir apostando.");
                System.out.println("Ha aparecido el hijo de Corleone.\nTe ofrece otros 1000€.\n¿Aceptas? (Si/No)");
                r=entrada.next().toLowerCase();
                
                switch (r){
                    case "si":System.out.println("Te has endeudado. Mas te vale poder devolverlo pronto...\n"
                            + "Cada vez que vuelvas a tirar el dado, la deuda aumentara un 3%. No dejes que aumente demasiado.");
                              saldo=1000;
                              deuda+=1000;
                              System.out.println("Si quieres seguir apostando, introduce la cantidad.\nSi no quieres apostar, introduce 0.");
                              if (deuda>0){
                                System.out.println("Tambien puedes introducir una cantidad negativa para pagarsela a\n"
                                    + "Corleone y reducir tu deuda.");
                              }
                              System.out.print("\nApuesta: ");
                              apuesta=entrada.nextInt();
            
                              while (apuesta>saldo){
                                System.out.print("No tienes tanto dinero. Introduce una apuesta valida.\nApuesta:");
                                apuesta=entrada.nextInt();
                              }
                
                              while (apuesta==0&&deuda>0){
                                System.out.println("Debes dinero a Corleone.\n"
                                    + "No puedes retirarte hasta que se lo devuelvas.");
                              }
                              break;
                    case "no":System.out.println("Buena eleccion. Lo has perdido todo, pero sigues vivo.");
                              break;
                    default:System.out.println("Corleone se ha enfadado por tu ambiguedad. Mueres.");
                            muerto=true;
                }
            }
        }
        
        System.out.print("Has terminado con "+saldo+"€");
        if (muerto==true){
            System.out.print(" y muerto");
        }
        System.out.println(".");
    }
    
}
