/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Cliente.JFLogin;
import Servidor.JFServidor;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author lucas
 */
public class ChatRMI {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.rmi.RemoteException
     * @throws java.security.NoSuchAlgorithmException
     */
    public static void main(String[] args) throws InterruptedException, RemoteException, NoSuchAlgorithmException {

        JFServidor s = new JFServidor();
        
        s.atualiza();
        
        s.setVisible(true);
        
        int numeroUsuarios = 3;
        
        for (int i = 0; i < numeroUsuarios; i++){
            JFLogin JLog = new JFLogin();
            JLog.setVisible(true);
        }
    }
}
