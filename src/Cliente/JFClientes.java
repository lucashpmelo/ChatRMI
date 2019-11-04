/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Servidor.Chat;
import Servidor.I_RMI;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class JFClientes extends javax.swing.JFrame {

    /**
     * Creates new form JFClientes
     */
    I_RMI o;
    public String usuario;
    //ArrayList<Integer> listaClienteChats = new ArrayList<>();
    ArrayList<Chat> listaClienteChats = new ArrayList<>();
    DefaultListModel modelListaUsuariosMensagens = new DefaultListModel();
    boolean flag;

    public JFClientes() {
        initComponents();
        try {
            o = (I_RMI) Naming.lookup("rmi://localhost:1099/ServidorRMI");
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtAreaMensagem.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEnviar = new javax.swing.JButton();
        txtFieldMensagem = new javax.swing.JTextField();
        btcCriarGrupo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaMensagem = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        listChats = new javax.swing.JList<>();
        btnMensagens = new javax.swing.JButton();
        btnContatos = new javax.swing.JButton();
        labelUsuario = new javax.swing.JLabel();
        btnEnviarArquivo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnEnviar.setBackground(new java.awt.Color(0, 102, 102));
        btnEnviar.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(0, 51, 51));
        btnEnviar.setText("ENVIAR");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        txtFieldMensagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));

        btcCriarGrupo.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        btcCriarGrupo.setForeground(new java.awt.Color(3, 52, 52));
        btcCriarGrupo.setText("Criar Chat");
        btcCriarGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcCriarGrupoActionPerformed(evt);
            }
        });

        txtAreaMensagem.setColumns(20);
        txtAreaMensagem.setRows(5);
        txtAreaMensagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jScrollPane2.setViewportView(txtAreaMensagem);

        listChats.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        listChats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listChatsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listChats);

        btnMensagens.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        btnMensagens.setForeground(new java.awt.Color(3, 52, 52));
        btnMensagens.setText("Mensagens");
        btnMensagens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMensagensActionPerformed(evt);
            }
        });

        btnContatos.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        btnContatos.setForeground(new java.awt.Color(3, 52, 52));
        btnContatos.setText("Contatos");
        btnContatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContatosActionPerformed(evt);
            }
        });

        labelUsuario.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        labelUsuario.setForeground(new java.awt.Color(0, 102, 102));
        labelUsuario.setText("Usuário: ");

        btnEnviarArquivo.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        btnEnviarArquivo.setForeground(new java.awt.Color(3, 52, 52));
        btnEnviarArquivo.setText("Enviar Arquivo");
        btnEnviarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarArquivoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("UTFPRChat");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMensagens)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnContatos))
                            .addComponent(btcCriarGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(134, 134, 134)
                                .addComponent(btnEnviarArquivo))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtFieldMensagem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEnviar))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelUsuario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnMensagens)
                                    .addComponent(btnContatos))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btcCriarGrupo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFieldMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEnviar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEnviarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        try {
            if(!o.verificaBAN(usuario)){
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                Date hora = Calendar.getInstance().getTime();
                String dataFormatada = sdf.format(hora);
                o.enviarMensagem(retornaIdChat(listChats.getSelectedValue()), "[" + dataFormatada + "] " + usuario + ": " + txtFieldMensagem.getText());
                txtFieldMensagem.setText(null);
            }else{
                JOptionPane.showMessageDialog(null, "Você esta BANIDO do servidor!!!");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btcCriarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcCriarGrupoActionPerformed
        ArrayList<String> m = new ArrayList<>();
        List<String> listaUsers;
        String nome = null;

        try {
            if(o.verificaBAN(usuario)){
                JOptionPane.showMessageDialog(null, "Você esta BANIDO do servidor!!!");
                return;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

        listaUsers = listChats.getSelectedValuesList();
        int listaSize = listaUsers.size();

        if (listaSize == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um ou mais Contatos!!!");
            return;
        } else {
            if(flag){
                JOptionPane.showMessageDialog(null, "Selecione um contato e não uma mensagem!!!");
                return;
            }else{
                nome = JOptionPane.showInputDialog(null, "De um nome ao Grupo");
            }
        }

        for (int i = 0; i < listaSize; i++) {
            m.add(listaUsers.get(i));
        }

        m.add(usuario);

        try {
            abrirChat(m, nome);
            flag = true;
            listarGruposMensagens();
        } catch (RemoteException ex) {
            Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btcCriarGrupoActionPerformed

    private void btnEnviarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarArquivoActionPerformed
        try {
            if(o.verificaBAN(usuario)){
                JOptionPane.showMessageDialog(null, "Você esta BANIDO do servidor!!!");
                return;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i= file.showSaveDialog(null);

        if(i != 1){
            //String PATH = "C:/Users/lucas/Desktop/UTFBox/arquivo.txt";
            //String PATH2 = "C:/Users/lucas/Desktop/UTFBox/User1/";
            File arquivo = file.getSelectedFile();
            //JOptionPane.showMessageDialog(null, arquivo.getName());

            String PATH = arquivo.toString();
            String PATHServidor = null;

            try {
                //PATH = new File(".").getCanonicalPath() + "/Arquivos/" + usuario + "/" + "arquivo.txt";
                PATHServidor = new File(".").getCanonicalPath() + "/Arquivos/Server/Servidor/";
            } catch (IOException ex) {
                Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
            }

            byte[] filedata = null;

            try {
                filedata = o.downloadFile(PATH);
            } catch (RemoteException ex) {
                Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
            }

            File fileServer = new File(PATHServidor + arquivo.getName());

            try {
                BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(fileServer));

                output.write(filedata, 0, filedata.length);

                output.flush();

                output.close();
            } catch (IOException ex) {
                Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
            }

            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date hora = Calendar.getInstance().getTime();
            String dataFormatada = sdf.format(hora);
            try {
                o.enviarMensagem(retornaIdChat(listChats.getSelectedValue()),"[" + dataFormatada + "] " + usuario + ": envio " + arquivo.getName());
                o.salvarArquivo(retornaIdChat(listChats.getSelectedValue()), arquivo.getName());
            } catch (RemoteException ex) {
                Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_btnEnviarArquivoActionPerformed

    private void btnContatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContatosActionPerformed
        try {
            if(o.verificaBAN(usuario)){
                JOptionPane.showMessageDialog(null, "Você esta BANIDO do servidor!!!");
                return;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        flag = false;
        try {
            listaUsuariosOnline();
        } catch (RemoteException ex) {
            Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnContatosActionPerformed

    private void btnMensagensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMensagensActionPerformed
        try {
            if(o.verificaBAN(usuario)){
                JOptionPane.showMessageDialog(null, "Você esta BANIDO do servidor!!!");
                return;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        flag = true;
        listarGruposMensagens();
    }//GEN-LAST:event_btnMensagensActionPerformed

    private void listChatsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listChatsMouseClicked
        if(flag)
        populaTxtArea();
    }//GEN-LAST:event_listChatsMouseClicked

    public void populaTxtArea() {
        int listaSize = listaClienteChats.size();
        int idLista = 0;
        for (int i = 0; i < listaSize; i++) {
            if (listaClienteChats.get(i).nomeGrupo == null ? listChats.getSelectedValue() == null : listaClienteChats.get(i).nomeGrupo.equals(listChats.getSelectedValue())) {
                idLista = i;
            }
        }

        listaSize = listaClienteChats.get(idLista).listaMensagens.size();
        txtAreaMensagem.setText(null);
        for (int i = 0; i < listaSize; i++) {
            txtAreaMensagem.append(listaClienteChats.get(idLista).listaMensagens.get(i) + "\n");
        }
    }
    
    public int retornaIdChat(String nome){
        int listaSize = listaClienteChats.size();
        for(int i = 0; i < listaSize; i++){
            if(listaClienteChats.get(i).nomeGrupo.equals(nome)){
                return listaClienteChats.get(i).codChat;
            }
        }
        return 0;
    }

    public void atualizaChat(int codChat) throws RemoteException {

        Thread thread = new Thread(new Runnable() {
            int cont = o.lerMensagem(codChat).size();
            int idChat = codChat;
            int idLista;

            @Override
            public void run() {
                int listaSize = listaClienteChats.size();
                for (int i = 0; i < listaSize; i++) {
                    if (listaClienteChats.get(i).codChat == idChat) {
                        idLista = i;
                    }
                }
                try {
                    while (true) {
                        if (o.lerMensagem(idChat).size() > cont && !o.verificaBAN(usuario)) {
                            //txtAreaMensagem.append(o.lerMensagem(codChat).get(o.lerMensagem(codChat).size() - 1) + "\n");
                            listaClienteChats.get(idLista).listaMensagens.add(o.lerMensagem(codChat).get(o.lerMensagem(codChat).size() - 1));
                            if (listChats.getSelectedValue() == null ? listaClienteChats.get(idLista).nomeGrupo == null : listChats.getSelectedValue().equals(listaClienteChats.get(idLista).nomeGrupo)) {
                                txtAreaMensagem.append(o.lerMensagem(codChat).get(o.lerMensagem(codChat).size() - 1) + "\n");
                            }
                            cont++;
                        }

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public void abrirChat(ArrayList<String> membros, String nome) throws RemoteException {

        int novoChat = o.criarGrupo(membros, nome);
        
        if(novoChat < 0){
            JOptionPane.showMessageDialog(null, "Não pode ter dois chats com mesmo nome!!!");
            return;
        }
        Chat chat = new Chat();
        chat.codChat = novoChat;
        chat.nomeGrupo = nome;

        listaClienteChats.add(chat);
        atualizaChat(chat.codChat);
    }

    public void verificaNovosChats() throws RemoteException {
        
        ArrayList<Integer> codsNovos = new ArrayList<>();
        ArrayList<Integer> codsUsuario = new ArrayList<>();

        codsNovos = o.retornaChats(usuario);
        //System.out.println(usuario + "  Ta chegando aqui pelo menos!!!!");
        
        int listaClienteSize = listaClienteChats.size();
        
        for (int i = 0; i < listaClienteSize; i++) {
            codsUsuario.add(listaClienteChats.get(i).codChat);
        }

        codsNovos.removeAll(codsUsuario);
        //System.out.println(usuario + " " + codsNovos);
        if (!codsNovos.isEmpty()) {
            int listaSize = codsNovos.size();
            for (int i = 0; i < listaSize; i++) {
                Chat chat = new Chat();
                chat.codChat = codsNovos.get(i);
                chat.nomeGrupo = o.retornaNomeGrupo(codsNovos.get(i));
                listaClienteChats.add(chat);
                atualizaChat(codsNovos.get(i));
            }
        }

    }

    public void listaUsuariosOnline() throws RemoteException {
        ArrayList<String> lista = new ArrayList<>();
        lista = o.retornaUsuarios();
        modelListaUsuariosMensagens.clear();
        listChats.setModel(modelListaUsuariosMensagens);
        int listaSize = lista.size();
        for (int i = 0; i < listaSize; i++) {
            if (!lista.get(i).equals(usuario)) {
                modelListaUsuariosMensagens.addElement(lista.get(i));
            }
        }
    }

    public void listarGruposMensagens() {
        modelListaUsuariosMensagens.clear();
        listChats.setModel(modelListaUsuariosMensagens);
        int listaSize = listaClienteChats.size();
        for (int i = 0; i < listaSize; i++) {
            modelListaUsuariosMensagens.addElement(listaClienteChats.get(i).nomeGrupo);
        }
    }

    public void addUsuarios() throws RemoteException {
        labelUsuario.setText("Usuário: " + usuario);
        o.addUsuarios(usuario,true);
    }

    public void atualiza() throws RemoteException {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        verificaNovosChats();
                        Thread.sleep(1000);
                    } catch (RemoteException ex) {
                        Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(JFClientes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        thread.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcCriarGrupo;
    private javax.swing.JButton btnContatos;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnEnviarArquivo;
    private javax.swing.JButton btnMensagens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JList<String> listChats;
    private javax.swing.JTextArea txtAreaMensagem;
    private javax.swing.JTextField txtFieldMensagem;
    // End of variables declaration//GEN-END:variables
}