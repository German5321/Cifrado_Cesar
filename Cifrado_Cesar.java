/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cifrado_cesar;

/**
 *
 * @author DELL
 */
import java.io.IOException;
import java.util.Scanner;

public class Cifrado_Cesar {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String texto, codigo, r;
        char opcion;
        Cifrado_Cesar v = new Cifrado_Cesar();

            //Introducir un texto
            do {
                System.out.print("Introduce un texto: ");
                texto = sc.nextLine();
            } while (texto.isEmpty());

            //Introducir el valor del desplazamiento
            do {
                System.out.print("Introduce el código: ");
                codigo = sc.nextLine();
            } while (codigo.isEmpty());  



            //Valida y realiza acción
            if(v.validarCodigo(codigo) && v.validaTexto(texto)){
                System.out.println("Texto cifrado: " + cifradoCesar(texto, codigo));
            }
            else{
                System.out.println("Los valores no son correctos intentelo de nuevo.");
            }
    }
    
    
    //Validar la cadena
    public boolean validaTexto(String t){
        int valorASCII=0;
        for(int i=0 ; i<t.length() ; i++){
            char c=t.charAt(i);
            valorASCII=(int) c;
            if(valorASCII < 65 && valorASCII > 90 || valorASCII<97 && valorASCII > 122){
                return false;
            }
        }
        return true;
    }
    
    
    //Validar numero
    public boolean validarCodigo(String c) {
                int c2;
		try
                {
                    c2=Integer.parseInt(c);
                    return true;
                }catch(Exception e){
                    return false;
                }
	}
    
    
    //método para cifrar el texto
    public static String cifradoCesar(String texto, String c) {
        StringBuilder cifrado = new StringBuilder();
        int codigo=Integer.parseInt(c);
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + codigo) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + codigo) > 'Z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
    }
}
