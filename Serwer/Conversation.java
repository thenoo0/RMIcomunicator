/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serwer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mateusz
 */
public class Conversation extends UnicastRemoteObject
        implements InterfaceConversation {

    private List<Message> conversation;

    public Conversation() throws RemoteException {

        conversation = new LinkedList<Message>();
    }

    @Override
    public void addMessage(Message message) throws RemoteException {
        conversation.add(message);
        
    }
    
    @Override
    public List<Message> getAllConversation(int i) throws RemoteException {
        
        List<Message> conversationToSend = new LinkedList<Message>();
        
        for( ; i < conversation.size(); i++) {
            conversationToSend.add(conversation.get(i));
        }
        
        return conversationToSend;
    }

}
