/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Serwer.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mateusz
 */
public class Client {

    private String name;
    private Registry registry;
    private InterfaceSerwerComunicator remoteObject;
    private Scanner reader;
    List<InterfaceMessage> savedMessages;

    public Client(String serwerAddress, String name) throws Exception {

        try {
            registry = LocateRegistry.getRegistry(serwerAddress);
            remoteObject = (InterfaceSerwerComunicator) registry.lookup(InterfaceSerwerComunicator.name);

        } catch (RemoteException e) {
            e.printStackTrace();
        }

        reader = new Scanner(System.in);
        this.name = name;
        savedMessages = new LinkedList<InterfaceMessage>();

    }

    public void newMessage() throws RemoteException {
        String input = reader.nextLine();
        remoteObject.createMessage(name, input);
    }

    public void getConversation() throws RemoteException {
        InterfaceConversation conversation = (InterfaceConversation) remoteObject.getConversation();

        List<Message> allMessages = conversation.getAllConversation(savedMessages.size());

        
        for (InterfaceMessage m : allMessages) {
            System.out.println(m.read());
            savedMessages.add(m);
        }
        

        
    }

    public void start() throws RemoteException {
        while (true) {
            getConversation();
            newMessage();

        }
    }

    public static void main(String[] args) throws Exception { //uruchamiamy adres serwera, nazwa uzytkownika

        if (args.length < 2) {
            System.out.println("blad danych");
            return;
        }

        Client k = new Client(args[0], args[1]);
        k.start();
    }

}
