package Listas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class leer {

    static int totalCoincidencias = 0;

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("Inserte palabra a buscar");
        String palabrabuscar = leer.nextLine();

        File archivo = new File("C:\\Users\\jesus\\Downloads\\divina_comedia.txt");


        buscarCoincidenciaPalabra(palabrabuscar, archivo);

    }

    public static void buscarCoincidenciaPalabra(String letraBuscar, File archivo) {
        totalCoincidencias = 0;

        try {
            if(archivo.exists()) {

                BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));
                String lineaLeida;

                while((lineaLeida = archivoLeer.readLine()) != null) {

                    String[] partes = lineaLeida.split(" ");

                    for(int i = 0 ; i < partes.length ; i++) {
                        if(partes[i].equals(letraBuscar)) {
                            totalCoincidencias = totalCoincidencias + 1;
                        }
                    }
                }

                archivoLeer.close();
            }

            System.out.println("\nELa plabra: " + letraBuscar +
                    " se encuentra: " + totalCoincidencias +
                    " veces en el archivo buscando por PALABRA");

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}