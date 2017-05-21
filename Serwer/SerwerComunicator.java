/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serwer;

import Client.InterfaceClient;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mateusz
 */
public class SerwerComunicator extends UnicastRemoteObject
        implements InterfaceSerwerComunicator {

    private Registry rej;
    private Conversation conversation;
    List<InterfaceClient> clients;

    public SerwerComunicator() throws Exception {

        try {
            rej = LocateRegistry.createRegistry(1099);
            rej.rebind(name, this);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        conversation = new Conversation();
        clients = new ArrayList<InterfaceClient>();
    }

    @Override
    public Remote getConversation() throws RemoteException {
        return conversation;
    }

    @Override
    public void createMessage(String sender, String message) throws RemoteException {
        conversation.addMessage(new Message(sender, message));
        broadcastMessages();
    }

    @Override
    public void registerClient(InterfaceClient client) throws RemoteException {
        clients.add(client);
    }
    
    public void broadcastMessages() throws RemoteException {
        for(InterfaceClient client : clients) {
            client.getConversation();
        }
    }

    public static void main(String[] args) throws Exception {
        new SerwerComunicator();
    }

}
