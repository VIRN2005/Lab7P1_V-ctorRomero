package lab7p1_víctorromero;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Lab7P1_VíctorRomero {

    static Scanner leer = new Scanner(System.in);
    static Random aleatorio = new Random();

    public static void main(String[] args) {
        // menu();
        int opcion = menu();

        while (opcion != 4) {

            switch (opcion) {

                case 1: {
                    System.out.println(".: NUMERO DE FILAS :.");
                    System.out.println(">> Ingrese un NUMERO de FILAS: ");
                    int fila = leer.nextInt();

                    System.out.println(".: NUMERO DE COLUMNAS :.");
                    System.out.println(">> Ingrese un NUMERO de COLUMNAS: ");
                    int columna = leer.nextInt();

                    int[][] numeros = new int[fila][columna];
                    int[][] numero = lectura(fila, columna);

                    while (fila != columna) {
                        JOptionPane.showMessageDialog(null, "LA MATRIZ ES: \n\n" + imprimir(numero)
                                + (">> LA SUMA DE LA MATRIZ ES: \n" + imprimir(portrait(numero))));
                    }
                }
                break;

                case 2: {
                    System.out.println(".: NUMERO DE FILAS :.");
                    System.out.println(">> Ingrese un NUMERO de FILAS: ");
                    int fila = leer.nextInt();

                    System.out.println(".: NUMERO DE COLUMNAS :.");
                    System.out.println(">> Ingrese un NUMERO de COLUMNAS: ");
                    int columna = leer.nextInt();

                    int[][] numeros = new int[fila][columna];
                    int[][] numero = lectura(fila, columna);

                    JOptionPane.showMessageDialog(null, "LA MATRIZ ES: \n\n" + imprimir(numero)
                            + Contorno(numero));
                }
                break;

                case 3: {
                    System.out.print(">> Ingrese la PRIMERA Palabra: ");
                    String word1 = leer.next();
                    System.out.print(">> Ingrese la SEGUNDA Palabra: ");
                    String word2 = leer.next();
                    word2='-'+word2;
                    word1='-'+word1;

                    JOptionPane.showMessageDialog(null, (">> LA SUMA DE LA MATRIZ ES: \n" + imprimir(subsecuencia(word1, word2))));

                }
                break;

            }

            opcion = menu();
        }
    }

    public static int menu() {
        int opcion = 0;
        System.out.println("_____________________________________________________________ ");
        System.out.println(" ");
        System.out.println(">> MENU <<");
        System.out.println("----------------------- ");

        System.out.println("1 -> EJERCICIO 1 - PORTRAIT");
        System.out.println("2 -> EJERCICIO 2 - NUMERO MAGICO");
        System.out.println("3 -> EJERCICIO 3 - SUBSECUENCIA");

        System.out.println("4 -> SALIDA");
        System.out.println(" ");
        System.out.println(" ");

        System.out.print("Ingrese su Opcion: ");
        opcion = leer.nextInt();
        System.out.println("=> La Opcion escojida es: " + opcion);
        System.out.println(" ");

        return opcion;
    }

    public static int[][] lectura(int fila, int columna) {
        int[][] temporal = new int[fila][columna];

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                temporal[i][j] = 1 + aleatorio.nextInt(9);
            }
        }
        return temporal;
    }

    public static String imprimir(int[][] numero) {
        String cadena = "";

        for (int i = 0; i < numero.length; i++) {
            for (int j = 0; j < numero[i].length; j++) {
                cadena += "[" + numero[i][j] + "]" + " ";
            }
            cadena += "\n";
        }

        return cadena;
    }

    public static int[][] portrait(int[][] matriz) {
        int[][] temporal = new int[matriz[0].length][matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                temporal[j][matriz.length - i - 1] = matriz[i][j];
            }
        }

        return temporal;
    }

    public static String Contorno(int[][] a) {
        int suma = 0;
        int mult = 1;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (i == 0 || j == 0 || i == a.length - 1 || j == a[1].length - 1) {
                    suma += a[i][j];
                } else {
                    mult *= a[i][j];
                }
            }
        }
        int total = suma + mult;

        String Resp = ">> LA SUMA DE LA MATRIZ (OP1) ES: " + suma + "\n"
                + ">> LA SUMA DE LA MATRIZ (OP2) ES: " + mult + "\n";

        return Resp;
    }

    public static int[][] subsecuencia(String Palabra1, String Palabra2) {
        int[][] temporal = new int[Palabra1.length()][Palabra2.length()];

        for (int i = 0; i < Palabra1.length(); i++) {
            for (int j = 0; j < Palabra2.length(); j++) {
                if (Palabra1.charAt(i) == '-' || Palabra2.charAt(j) == '-') {
                    temporal[i][j] = 0;
                } else if (Palabra1.charAt(i) == Palabra2.charAt(j)) {
                    temporal[i][j] += temporal[i-1][j-1]+1;
                } else {
                    temporal[i][j] = Math.max(temporal[i][j - 1], temporal[i - 1][j]);
                }
            }
        }
        int valor = ValorFinal(temporal);
        JOptionPane.showMessageDialog(null, "El valor de la subsecuencia es: "+valor);
        return temporal;
    }
    
    public static int ValorFinal(int [][] arreglo){
        int num=0;
        
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                num = arreglo[i][j];
            }
        }
        return num;
    }
    
    

}
