/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Cliente.JFClientes;
import static Servidor.JFServidor.flagList;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class RMI_Impl extends UnicastRemoteObject implements I_RMI {

    static int contCodChat = 0;
    static ArrayList<String> listaUsuariosON = new ArrayList<>();
    static ArrayList<String> listaUsuariosBAN = new ArrayList<>();
    static ArrayList<String> listaArquivos = new ArrayList<>();
    ArrayList<Chat> listaChats;

    public RMI_Impl() throws RemoteException {
        super();
        this.listaChats = new ArrayList<>();        
    }

    private int incCodChat() {
        return contCodChat++;
    }

    @Override
    public synchronized int criarGrupo(ArrayList<String> membros, String nome) throws RemoteException {
        Chat chat = new Chat();

        chat.codChat = incCodChat();
        chat.nomeGrupo = nome;
        chat.listaMembros = membros;
        
        int sizeChats = listaChats.size();
        for (int i = 0; i < sizeChats; i++) {
            if (listaChats.get(i).nomeGrupo.equals(nome)) {                
                return -1;
            }
        }
        
        listaChats.add(chat);                
        
        return chat.codChat;
    }

    @Override
    public void enviarMensagem(int codChat, String mensagem) throws RemoteException {
        int sizeChats = listaChats.size();

        for (int i = 0; i < sizeChats; i++) {
            if (listaChats.get(i).codChat == codChat) {
                listaChats.get(i).listaMensagens.add(mensagem);
                return;
            }
        }
    }

    @Override
    public ArrayList<String> lerMensagem(int codChat) throws RemoteException {
        int sizeChats = listaChats.size();

        for (int i = 0; i < sizeChats; i++) {
            if (listaChats.get(i).codChat == codChat) {
                return listaChats.get(i).listaMensagens;
            }
        }
        return null;
    }
    

    @Override
    public ArrayList<Integer> retornaChats(String usuario) throws RemoteException {
        ArrayList<Integer> retornoChats = new ArrayList<>();
        int sizeChats = listaChats.size();

        for (int i = 0; i < sizeChats; i++) {

            int sizeMembros = listaChats.get(i).listaMembros.size();

            for (int k = 0; k < sizeMembros; k++) {
                if (listaChats.get(i).listaMembros.get(k) == null ? usuario == null : listaChats.get(i).listaMembros.get(k).equals(usuario)) {
                    retornoChats.add(listaChats.get(i).codChat);
                }
            }
        }

        return retornoChats;
    }
    
    @Override
    public String retornaNomeGrupo(int codChat) throws RemoteException {
        int sizeChats = listaChats.size();
        
        for (int i = 0; i < sizeChats; i++){
            if(listaChats.get(i).codChat == codChat){
                return listaChats.get(i).nomeGrupo;
            }
        }
        return null;
    }
    
    @Override
    public boolean verificaBAN(String usuario) throws RemoteException {
        boolean flag = false;
        int sizeChats = listaUsuariosBAN.size();
        
        for(int i = 0; i < sizeChats; i++){
            if(listaUsuariosBAN.get(i).equals(usuario))
                flag = true;
        }
        
        return flag;
    }

    @Override
    public synchronized void addUsuarios(String usuario, boolean flag) throws RemoteException {
        
        if(flag){
            listaUsuariosON.add(usuario);        
            JFServidor.flagList = true;
        }else{
            JFServidor.flagList = false;
        }        
    }
    
    @Override
    public ArrayList<String> retornaUsuarios() throws RemoteException {
        return listaUsuariosON;
    }
    
    @Override
    public ArrayList<String> retornaChats() throws RemoteException {
        ArrayList<String> retornoChats = new ArrayList<>();
        int sizeChats = listaChats.size();

        for (int i = 0; i < sizeChats; i++) {
            retornoChats.add(listaChats.get(i).nomeGrupo);
        }

        return retornoChats;
    }
    
    @Override
    public ArrayList<String> retornaListaArquivos() throws RemoteException {
        return listaArquivos;
    }
    
    @Override
    public void banirUsuario(String nome) throws RemoteException {
        listaUsuariosBAN.add(nome);
    }
    
    @Override
    public void liberarUsuario(String nome) throws RemoteException {
        listaUsuariosBAN.remove(nome);
    }
    
    @Override
    public byte[] downloadFile(String fileName) throws RemoteException {

        try {

            File file = new File(fileName);

            byte buffer[] = new byte[(int) file.length()];

            BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileName));

            input.read(buffer, 0, buffer.length);

            input.close();

            return (buffer);

        } catch (Exception e) {

            System.out.println("FileImpl: " + e.getMessage());

            e.printStackTrace();

            return (null);

        }

    }
    
    private void salvarArquivoCliente(String usuario, String nomeArquivo){
        
        String PATHServidor = null;
        String PATHCliente = null;

        try {            
            PATHServidor = new File(".").getCanonicalPath() + "/Arquivos/Server/Servidor/" + nomeArquivo;
            PATHCliente = new File(".").getCanonicalPath() + "/Arquivos/Cliente/" + usuario + "/";
        } catch (IOException ex) {
            Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        byte[] filedata = null;

        try {
            filedata = downloadFile(PATHServidor);
        } catch (RemoteException ex) {
            Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File fileServer = new File(PATHCliente + nomeArquivo);
        
        try {
                BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(fileServer));

                output.write(filedata, 0, filedata.length);

                output.flush();

                output.close();
            } catch (IOException ex) {
                Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @Override
    public void salvarArquivo(int codChat, String nomeArquivo) throws RemoteException {
        int sizeChats = listaChats.size();
        
        for (int i = 0; i < sizeChats; i++){            
            if(listaChats.get(i).codChat == codChat){
                int sizeMembros = listaChats.get(i).listaMembros.size();                
                for(int k = 0; k < sizeMembros; k++){
                    salvarArquivoCliente(listaChats.get(i).listaMembros.get(k), nomeArquivo);
                }
            }
        }
        listaArquivos.add(nomeArquivo);
    }
    
    @Override
    public synchronized boolean cadastroCliente(String nome, String senha, String email) throws RemoteException, IOException {
        
        if(verificaLoginRepetido(nome, email)){
            FileWriter arq = new FileWriter(new File(".").getCanonicalPath() + "/Arquivos/Server/Login.txt",true);
        
            PrintWriter gravarArq = new PrintWriter(arq);

            gravarArq.printf(nome + "\r\n");
            gravarArq.printf(senha + "\r\n");
            gravarArq.printf(email + "\r\n");

            arq.close();
            
            new File(new File(".").getCanonicalPath() + "/Arquivos/Cliente/" + nome).mkdir();
            
            return true;
        }else{            
            return false;
        }
        
    }
    
    private boolean verificaLoginRepetido(String nome, String email) throws IOException{
        String linhaNome = null;
        String linhaEmail = null;
        
        String PATH = new File(".").getCanonicalPath() + "/Arquivos/Server/Login.txt";
        
        FileReader arq = new FileReader(PATH);
        BufferedReader lerArq = new BufferedReader(arq);
        
        linhaNome = lerArq.readLine();
        
        while (linhaNome != null){
            linhaEmail = lerArq.readLine();
            linhaEmail = lerArq.readLine();
            
            if(linhaNome.equals(nome) || linhaEmail.equals(email)){
                return false;
            }
            
            linhaNome = lerArq.readLine();
        }
        
        return true;
    }
    
    @Override
    public synchronized boolean verificaLogin(String nome, String senha) throws RemoteException, IOException {
        String linhaNome = null;
        String linhaSenha = null;
        
        String PATH = new File(".").getCanonicalPath() + "/Arquivos/Server/Login.txt";
        
        FileReader arq = new FileReader(PATH);
        BufferedReader lerArq = new BufferedReader(arq);
        
        linhaNome = lerArq.readLine();
        
        while (linhaNome != null){
            linhaSenha = lerArq.readLine();            
            
            if(linhaNome.equals(nome) && linhaSenha.equals(senha)){
                return true;
            }
            
            linhaSenha = lerArq.readLine();
            linhaNome = lerArq.readLine();
        }
        
        return false;
    }
}
