package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bondesan_Luca
 */
public class Receiver extends Thread{
    DatagramSocket peer;
    InetAddress lastAddress=null;
    int lastPort=0;
    
    
    public Receiver() throws SocketException {
        peer = new DatagramSocket(2003);
    }
    
        public Messaggio Ricevi() throws IOException
    {
        byte[] buffer= new byte[1500];
        DatagramPacket p = new DatagramPacket(buffer,buffer.length);
        peer.receive(p);
        
        lastAddress = p.getAddress();
        lastPort = p.getPort();
        String messaggio= new String(p.getData(),0,p.getLength());
        return Messaggio.FromCSV(messaggio);
    }

    @Override
    public void run() {

       
        while(true)
        { 
        try 
            {
              Messaggio messaggio = Ricevi();
              if(messaggio.comando == "c")//cercando di aprire la connessione 
              {
                //quando ricevo messaggio richiamo il message box (if per capire se si vuole aprire la connessione)
                //JOptionPane classe grafica
                
              }else if(messaggio.comando == "e")//cercando di chiudere la connessione
              {
                  
              }else if(messaggio.comando == "m")//sta arrivando un messaggio
              {
                 String message = messaggio.dato;
              }
                
            } catch (IOException ex) {
                Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            

        }
    }
            
        
        
      
}
