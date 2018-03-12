/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    
    public static void main (String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String nom;
        String message;
        String IP;
        
        //System.out.println("Entrer IP");
        //IP = sc.next();
        IP = "10.154.127.223";
        //System.out.println("Entrer port");
        //int portNumber = sc.nextInt();
        int portNumber = 1234;
        
        try (
            Socket objSocket = new Socket(IP, portNumber);
            ObjectOutputStream out = new ObjectOutputStream(objSocket.getOutputStream());
            //ObjectInputStream in = new ObjectInputStream(objSocket.getInputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(objSocket.getInputStream()));
        ) {
        	//out.writeObject();
            Message m = new Message();
            System.out.println("Entrer nom");
            nom = sc.next();
            m.nom = nom;            
            String answer;

            /*System.out.println("Entrer message");
            message = sc.next();
            m = new Message(nom, message);
            out.writeObject(m);
            out.flush();
                answer = input.readLine();
                System.out.println(answer);*/
            
            
            while(true){
                System.out.println("Entrer message");
                message = sc.next();
                m = new Message(nom, message);
                out.writeObject(m);
                out.flush();
                if(sc.nextLine() != null) {
                    answer = input.readLine();
                    System.out.println(answer);
            	}
            }
                
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + IP);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + IP);
            System.exit(1);
        }
    }
}
