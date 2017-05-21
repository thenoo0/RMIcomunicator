/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serwer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Mateusz
 */
public interface InterfaceSerwerComunicator extends Remote {

    public final static String name = "InterfaceSerweraComunicator";

    public Remote getConversation() throws RemoteException;
    public void createMessage(String sender, String message) throws RemoteException;

    }
