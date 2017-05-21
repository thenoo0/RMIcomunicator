/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serwer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Mateusz
 */
public class Message extends UnicastRemoteObject
        implements InterfaceMessage {

    private String name;
    private String content;

    public Message(String name, String content) throws RemoteException {
        this.name = name;
        this.content = content;
    }

    public String read() throws RemoteException {
        return  "[" + this.name+ "]: " + this.content;
    }

}
