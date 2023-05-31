
package com.prog.javabtema789;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        System.out.println("9 --> Programa Propio: Calculo de costes de una obra");
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
                    vectores();
                    break;
                case 4:
                    problemasVectores();
                    break;
                case 5:
                    arrayListYLinkedList();
                    break;
                case 6:
                    recorreArrayList();
                    break;
                case 7:
                    try {
                    divideporcero();
                } catch (ArithmeticException arithmeticException) {
                    System.out.println("No se puede dividir por cero!");
                }
                    break;
                case 8:
            
                    try {
                        PrintStream creafichero=new PrintStream("Fichero1.txt");
                        creafichero.write(1);       //creo un fichero con datos que he metido aleatoriamente, solo para realizar el ejercicio.
                        creafichero.write(23);
                        creafichero.write(53456);
                        creafichero.close();
                    
                    } catch (FileNotFoundException ex) {
                        System.out.println("Error!");
                    }
                    copiafichero("Fichero1.txt","Fichero2.txt");
                    break;

                case 9:     //Se trata de un programa que lee las tarifas de distintos profesionales en una supuesta reforma, 
                            //calcula el coste dadas las horas de trabajo  y lo almacena en un archivo local.
                            
                    HashMap <String,Integer> horasTrabajadas=new HashMap<String,Integer>();
                    horasTrabajadas.put("Diseñador",10);//Almacenamos los datos del hashmap que nos pide la funcion, con las horas de cada trabajador:
                    horasTrabajadas.put("Electricista",40);
                    horasTrabajadas.put("Albañil",100);
                    horasTrabajadas.put("Fontanero",40);
                    horasTrabajadas.put("Arquitecto",20);
                    horasTrabajadas.put("Pintor",40);
                    horasTrabajadas.put("Carpintero",20);
                    
                    try {
                        obrasCasa(horasTrabajadas);
                    } catch (FileNotFoundException ex) {
                        System.out.println("No se ha encontrado el fichero");
                    }
                    System.out.println("Calculo realizado, las salidas están en el archivo Costo_total_mano_obra.txt ");
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
        for (int i=0;i<3;i++){
            
            for(int j=0;j<10;j++){
                System.out.print(arrayDoble[i][j]+" ");
            }
            System.out.print("     ------>     fila : "+(i)+" columnas: ");
            for(int j=0;j<10;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println("================================================================");
    }
    public static void vectores(){
        Vector <Integer> vector=new Vector();
        for(int i=1; i<6;i++){
            vector.add(i);
        }
        vector.remove(1); // Se usa el uno en ambos ya que como cuenta desde 0, la segunda y tercera posicion son la numero 1 y 2, pero al eliminar la primera, disminuye el tamaño y la tercera pasa a ser la segunda.
        vector.remove(1); 
        System.out.println("Valores almacenados en el vector tras el borrado: ");
        for(Integer i : vector){
                System.out.println(i);
        }
    }
    public static void problemasVectores(){
    System.out.println(" Un problema claro a la hora de usar los vectores para esa labor, es que cuando se supera el tamaño fijado, este se duplica, ");
    System.out.println("pudiendo resultar en una clara perdida de rendimiento por la copia de los valores y de memoria por poder estar reservando una memoria necesaria que no se está utilizando.");
    }
    public static void arrayListYLinkedList(){
        System.out.println("Almacenamos los numeros del 0 al 3 en formato numérico como String y se muestran por pantalla:");
        ArrayList <String> miArrayList=new ArrayList<String>();
        for (int i=0;i<4;i++){
            miArrayList.add(""+i);
        }
        LinkedList <String> miLinkedList=new LinkedList <String>();
        for (String e:miArrayList){
            miLinkedList.add(e);
        }
        for (int i=0;i<4;i++){
            System.out.println("Valor del ArrayList en la posicion "+i+" : "+miArrayList.get(i)+" | Valor del LinkedList "+ miLinkedList.get(i));
        }
    }
    public static void recorreArrayList(){
        ArrayList <Integer> miArrayList=new ArrayList();       
        for (Integer i=1;i<11;i++){
            miArrayList.add(i);
        }
        miArrayList.removeIf(n->(n%2==0));
        
        for (Integer i=0;i<miArrayList.size();i++){
            System.out.println(miArrayList.get(i));
        }
    }
    public static void divideporcero()throws ArithmeticException{
        int a=3;
        int b=0;
        int c=a/b;
    }
    public static void copiafichero(String fileIn, String fileOut){
        
        try {
            InputStream fichero=new FileInputStream(fileIn);
            BufferedInputStream ficheroBuffer=new BufferedInputStream(fichero);
            PrintStream ficheroNuevo=new PrintStream(fileOut);
            
            int dato=ficheroBuffer.read();
            while (dato!=-1){
                ficheroNuevo.write(dato);
                dato=ficheroBuffer.read();
            }
            ficheroBuffer.close();
            fichero.close();
            ficheroNuevo.close();
            
        } catch (FileNotFoundException ex ) {
            System.out.println("no existe el fichero! "+ ex.getMessage());
        }
        catch(IOException e){
            System.out.println("error! "+ e.getMessage());
        }
        
        
    }
    public static void obrasCasa(HashMap<String,Integer> horasTrabajo) throws FileNotFoundException{
        //Se trata de un programa que lee las tarifas de distintos profesionales en una supuesta reforma, calcula el coste dadas las horas de trabajo  y lo almacena en un archivo local.
        // El formato del archivo es el siguiente: NombreProfesional numeroTarifa(int), por ejemplo: Albañil 15
        //Tras esto habrá un salto de linea.
        InputStream fichero=new FileInputStream("profesionales.txt");
        Scanner sc=new Scanner(fichero);
        HashMap<String,Integer> tarifas= new HashMap<String,Integer>();
        String nombre="";
        Integer sueldo;
        while(sc.hasNextLine()){        //Se lee el fichero y se almacena en el hashmap
            nombre=sc.next();
            sueldo=sc.nextInt();
            tarifas.put(nombre,sueldo);
            
            try{sc.nextLine();}
            catch(Exception e){}
        }
       
        int[] manodeObra=new int[tarifas.size()];
       PrintStream aPagar=new PrintStream("Costo_total_mano_obra.txt");
        int contador=0;
        for (String oficios : horasTrabajo.keySet()){ //extraigo los profesionales del hashmap que nos dan
            manodeObra[contador]=tarifas.get(oficios);
            manodeObra[contador]=horasTrabajo.get(oficios)*manodeObra[contador];
            aPagar.println("Al "+oficios+" se le deben "+manodeObra[contador]+" euros");
            contador++;
        }
        int total=0;
        for(int i : manodeObra){
            total+=i;
        }
        aPagar.println("En total se deben: "+ total+" euros a los profesionales contratados");
               
    }
}
