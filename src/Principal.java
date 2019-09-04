


import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Principal {

    
    public static void main(String[] args)throws Exception{
       CrearCliente();
    }
    public static void CrearCliente(){
        try {
         Socket socket =new Socket("127.0.0.1",2500);
          EscribirCliente(socket);
        } catch (Exception e) {
          System.out.println("Error al crear socket del cliente "+e);
        }
    }
    public static void EscribirCliente(Socket socket) {
        PrintWriter escritor;
        try {
            escritor = new PrintWriter(socket.getOutputStream(), true);
            try {
                BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String datos;
                String datosEntrada;
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    datos = scanner.nextLine();
                    try {
                        escritor.println(datos);
                        datosEntrada = lector.readLine();
                        System.out.println(datosEntrada);
                    } catch (Exception e) {
                        System.out.println("error al mandar mensaje");
                    }
                }
            } catch (Exception ex) {
                System.out.println("Error al crear lector" + ex);
            }

        } catch (IOException ex) {
            System.out.println("Error al crear escrito " + ex);
        }
    }

}
