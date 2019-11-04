/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public interface I_RMI extends Remote {

    public int criarGrupo(ArrayList<String> membros, String nome) throws RemoteException;

    public void enviarMensagem(int codChat, String mensagem) throws RemoteException;

    public ArrayList<String> lerMensagem(int codChat) throws RemoteException;

    public ArrayList<Integer> retornaChats(String usuario) throws RemoteException;

    public void addUsuarios(String usuario, boolean flag) throws RemoteException;
    
    public ArrayList<String> retornaUsuarios() throws RemoteException;
    
    public String retornaNomeGrupo(int codChat) throws RemoteException;
    
    public boolean verificaBAN(String usuario) throws RemoteException;
    
    public byte[] downloadFile(String fileName) throws RemoteException;    
    
    public void banirUsuario(String nome) throws RemoteException;   
    
    public void liberarUsuario(String nome) throws RemoteException;
    
    public void salvarArquivo(int codChat, String nomeArquivo) throws RemoteException;
    
    public ArrayList<String> retornaChats() throws RemoteException;
    
    public ArrayList<String> retornaListaArquivos() throws RemoteException;
    
    public boolean cadastroCliente(String nome, String senha, String email) throws RemoteException, IOException;
    
    public boolean verificaLogin(String nome, String senha) throws RemoteException, IOException;
}
