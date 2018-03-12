/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends Thread{
    Socket clientSocket_1;
    static List<PrintWriter> _tabClients = new ArrayList<PrintWriter>(); // contiendra tous les flux de sortie vers les clients
    //Socket clientSocket_2;
    List<Message> clients;
    //PrintWriter _out;
	
	public Server(Socket clientSocket){
		this.clientSocket_1 = clientSocket;
        //clients = new ArrayList<>();
	}
	
	/*public void add_player_2(Socket clientSocket_2) {
		this.clientSocket_2 = clientSocket_2;
	}*/

    @Override
	public void run() {
            try (
                //ObjectOutputStream out = new ObjectOutputStream(clientSocket_1.getOutputStream());
            	PrintWriter out = new PrintWriter(clientSocket_1.getOutputStream(), true);
                ObjectInputStream in = new ObjectInputStream(clientSocket_1.getInputStream());
            ) {
            	
            Object o;
            while (( o = in.readObject()) != null) {
                //Si ce qui est envoyé au server est de type Message
                if (o instanceof Message){
                    Message m = (Message) o;
                    System.out.println(out);
                    for(PrintWriter _out : _tabClients){
                    	if(out != _out) {
                    		System.out.println(_out);
                        	_out.println("Message de " + m.nom + ": " + m.message);
                        	_out.flush();
                    	}
                        //_out.writeObject("Message de " + m.nom + ": " + m.message);
                    }
    	            //out.println(m.toString());
    	            //out.flush();
               }
            
	            //out.println(new Date().toString());
            }
	    } catch (IOException e) {
            System.out.println("Exception caught in Thread. Connection closed by client?");
	    } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
			try {
              clientSocket_1.close();
              //clientSocket_2.close();
			} catch (IOException e) {
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        //System.out.println("Entrer port");
        //int portNumber = sc.nextInt();
        int portNumber = 1234;
        
        try (
            ServerSocket serverSocket = new ServerSocket(portNumber, 2);
        ) {
        	while(true) {
        		Socket client = serverSocket.accept();
        		Server serverMultiObj = new Server(client);
        		Server._tabClients.add(new PrintWriter(client.getOutputStream()));
                //System.out.println(serverMultiObj);
        		//serverMultiObj.add_player_2(new ServerSocket(portNumber).accept());
        		serverMultiObj.start();
        	}
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
