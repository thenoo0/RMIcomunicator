/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serwer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Mateusz
 */
public interface InterfaceConversation extends Remote {
    
    public void addMessage(Message message) throws RemoteException;
    public List<Message> getAllConversation(int i) throws RemoteException;
    
}
