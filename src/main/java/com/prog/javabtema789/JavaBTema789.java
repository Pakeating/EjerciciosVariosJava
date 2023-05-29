
package com.prog.javabtema789;
import java.util.Scanner;

/**
 *Autor: Francisco Linares Santamaria
 */
public class JavaBTema789 {

    public static void main(String[] args) {
        byte menu=11;
        Scanner sc= new Scanner(System.in);
        while(menu!=10){
        
        System.out.println("==================================================================================================================================");
        System.out.println("INTRODUZCA NUMERO PARA ELEGIR UNA OPCION");
        System.out.println("0 --> Revertir una cadena");
        System.out.println("1 --> Crea un array unidimensional de Strings y lo recorre");
        System.out.println("2 --> Crea un array bidimiensional de enteros y lo recorre mostrando valor y posicion");
        System.out.println("3 --> Crea un Vector y le añade 5 elementos. Se elimina el 2º y 3º y lo muestra");
        System.out.println("4 --> Indica el problema de utilizar un vector por defecto para añadir 1000 elementos");
        System.out.println("5 --> Crea un ArrayList de 4 elementos, se copia a un LinkedList y se recorren ambos mostrando valores");
        System.out.println("6 --> Crea un ArrayList de enteros y lo rellena con un bucle. Se recorre con otro y se eliminan los numeros pares. Se muestra");
        System.out.println("7 --> Divide por cero y lo gestiona mediante un throws y se captura la excepcion desde main, mostrando un mensaje");
        System.out.println("8 --> Mediante InputStream y PrintStream se copia un fichero fileIn  a uno fileOut");
        System.out.println("9 --> Programa Propio");
        System.out.println("10 --> SALIR");
        System.out.println("==================================================================================================================================");
        
        menu=sc.nextByte();
        sc.nextLine(); //limpiar scanner
        
        switch (menu){
                case 0:
                    System.out.println("Introduce una cadena");
                    String texto= sc.nextLine();
                    System.out.println(reverse(texto));
                    break;
                case 1:
                    System.out.println("Mostrando el array");
                    recorreArray();
                    break;
                case 2:
                    arrayBi();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                    
        }
    }
    }
    
    public static String reverse(String texto){
        String invertida="";
        
        for(int i=(texto.length()-1);i>=0;i--){
            invertida=invertida+texto.charAt(i);
        }
        
        return invertida;
    }
    public static void recorreArray(){
        String[] myArray={"hola","que tal está?", "bien y tu?","bien tambien","me alegro","que tengas un buen día" ,"adios"};
        for(String mensaje : myArray){
            System.out.println(mensaje);
        }
    }
    public static void arrayBi(){
        int [][] arrayDoble=new int[3][10];
        System.out.println("Rellenando Array con numeros aleatorios entre 0 y 9");
        for (int i=0;i<3;i++){
           for (int j=0;j<10;j++){
               arrayDoble[i][j]=(int)(Math.random()*10);
           }
        }
        System.out.println("Mostrando numeros y su posicion en dos tablas:");
        System.out.println("================================================================");
        for (int i=0;i>3;i++){
            
            for(int j=0;j<10;j++){
                System.out.print(arrayDoble[i][j]+" ");
            }
            System.out.println("     ------>     fila : "+i+" columnas: ");
            for(int j=0;j>=10;j++){
                System.out.print(j+" ");
            }
        }
        System.out.println("================================================================");
    }
    
}
