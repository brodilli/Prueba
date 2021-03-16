package depurador;

import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * @author brodi
 */
public class Depurador {

    public static void main(String[] args) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String[] lineas = new String[18];
        int cont = 0;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("C:\\Users\\brodi\\Documents\\Documento.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas[cont] = linea;
                cont++;
            }
            String[] depurado=acomoda(lineas);
            crea(depurado);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public static String[] acomoda(String[] lineas) {
        String[] depurado = new String[lineas.length];
        String cad = "";
        String nue = "";
        boolean band = false;
        int adelante = 0, atras = 0;
        char[] aux;
        for (int i = 0; i < lineas.length; i++) {
            aux = lineas[i].toCharArray();
            for (int j = 0; j < aux.length; j++) {
                if (aux != null) {
                    if (j + 1 < lineas.length) {
                        if (aux[j] == '/' && aux[j + 1] == '/') {
                            break;
                        }
                        

                    }

                }

            }
            if (lineas[i].length() > 2) {
                if (lineas[i].charAt(0) != '/' && lineas[i].charAt(1) != '/') {
                    cad = String.valueOf(lineas[i]);
                    StringTokenizer toke = new StringTokenizer(cad);

                    while (toke.hasMoreElements()) {

                        nue += toke.nextElement();
                        nue += " ";
                    }
                }
            } if (lineas[i].length() < 2) {
                cad = String.valueOf(lineas[i]);
                StringTokenizer toke = new StringTokenizer(cad);

                while (toke.hasMoreElements()) {

                    nue += toke.nextElement();
                    nue += " ";
                }
            }

            depurado[i] = nue;
            nue = "";
            cad = "";
        }
         
        return depurado;
    }

    public static void crea(String [] depurado) {
        try {
            PrintWriter writer = new PrintWriter("C:\\Users\\brodi\\Documents\\Documento.depu", "UTF-8");
                                

            for (int i = 0; i < depurado.length; i++) {
                if (depurado[i].isEmpty()) {
                    
                }else{
                    writer.println(String.valueOf(i)+depurado[i]);
                }
                
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
