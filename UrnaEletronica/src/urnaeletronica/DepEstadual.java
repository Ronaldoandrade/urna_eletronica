package urnaeletronica;

import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Larissa Souza
 */
public class DepEstadual extends javax.swing.JFrame {

    /**
     * Creates new form DepEstadual
     */
    public DepEstadual() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDepEst = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblSigla = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        jpnFoto = new javax.swing.JPanel();
        lblFoto2 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtSigla = new javax.swing.JTextField();
        txtFoto = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro do Deputado Federal");

        lblDepEst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDepEst.setText("Cadastro de Deputado Estadual");

        lblNumero.setText("Número:");

        lblNome.setText("Nome:");

        lblSigla.setText("Sigla do Partido:");

        lblFoto.setText("Foto:");

        javax.swing.GroupLayout jpnFotoLayout = new javax.swing.GroupLayout(jpnFoto);
        jpnFoto.setLayout(jpnFotoLayout);
        jpnFotoLayout.setHorizontalGroup(
            jpnFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFoto2, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnFotoLayout.setVerticalGroup(
            jpnFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFoto2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAdd.setText("Adicionar foto");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnSalvar)
                        .addGap(89, 89, 89)
                        .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(90, 90, 90)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFoto)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSigla)
                                .addGap(18, 18, 18)
                                .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNumero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDepEst)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblDepEst)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSigla)
                    .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd))
                    .addComponent(lblFoto))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSair)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvar)
                        .addComponent(btnEditar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       int numero = Integer.parseInt(txtNumero.getText());
       String nome = txtNome.getText();
       String sigla = txtSigla.getText();
       String foto = txtFoto.getText();
       int totalVotos = 0;
       
       String sql = "insert depestadual values (?, ?, ?, ?, ?)";
       
       String url = "jdbc:mysql://127.0.0.1:3306/eleicao";
       String usuario = "root";
       String senha = "bluetooth007";
       
       try {
           //Conecta com o banco de dados
       Connection conexao = DriverManager.getConnection(url, usuario, senha);
       
       
           //Preparar o comando que será executado
       PreparedStatement comando = conexao.prepareStatement(sql);
       
       
       //Definir o valor de cada interrogação
       comando.setInt(1 , numero);
       comando.setString(2, nome);
       comando.setString(3, sigla);
       comando.setString(4, foto);
       comando.setInt(5, totalVotos);
   
       //executa o comando
       comando.executeUpdate();
       
       //Libera os recursos
       comando.close();
       conexao.close();
       
       //Exibir uma mensagem de sucesso
       JOptionPane.showMessageDialog(null,"Acesso permitido");
       
       //Limpar os campos de inserção
            txtNumero.setText("");
            txtNome.setText("");
            txtSigla.setText("");
            txtFoto.setText("");
            lblFoto2.setText("");
            
            txtNumero.requestFocus();
   
            
       } catch(SQLException erro) {
           //Exibe uma mensagem de erro
       JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados");
       
       //Exibe o erro no console
       erro.printStackTrace();
       }
       
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        JOptionPane.showMessageDialog(null, "SAINDO DO CADASTRO DEPUTADO ESTADUAL");
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        JFileChooser buscarFoto = new JFileChooser();
            buscarFoto.setDialogTitle("Carregar imagem");
            buscarFoto.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            int opcao = buscarFoto.showOpenDialog(this);
            if(opcao == JFileChooser.APPROVE_OPTION){
                File file = new File("Caminho");
                file = buscarFoto.getSelectedFile(); //Recebe o caminho
                String foto = file.getAbsolutePath();
                
                txtFoto.setText(foto);
                
                ImageIcon imagem = new ImageIcon(buscarFoto.getSelectedFile().getPath());
                
                lblFoto2.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(lblFoto2.getWidth(),
                        lblFoto2.getHeight(), Image.SCALE_DEFAULT)));
                
            }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int numero = Integer.parseInt(txtNumero.getText());
        String nome = txtNome.getText();
        String siglaPartido = (txtSigla.getText());
        String foto = txtFoto.getText();
        
        //Definição dos dadso da conexão
        String url = "jdbc:mysql://127.0.0.1:3306/eleicao";
        String usuario = "root";
        String senha = "bluetooth007";
        
        //Definição da sql
        String sql = "UPDATE depestadual SET nome = ?, siglaPartido = ?, foto = ? where numero = ?";
        
        try{
            //Captura uma conexão
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            
            //Criar um comando
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            //Substituir as interrogações (mapeamento objeto relacional)
            comando.setInt(1, numero);
            comando.setString(2, nome);
            comando.setString(3, siglaPartido);
            comando.setString(4, foto);
            
            //Executa o comando
            comando.executeUpdate();
            
            //Libera os recursos
            comando.close();
            conexao.close();
            
            //Exibe uma mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Deputado estadual editado com sucesso");
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar editar o deputado estadual");
            erro.printStackTrace();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(DepEstadual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepEstadual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepEstadual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepEstadual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepEstadual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel jpnFoto;
    private javax.swing.JLabel lblDepEst;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblFoto2;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblSigla;
    private javax.swing.JTextField txtFoto;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtSigla;
    // End of variables declaration//GEN-END:variables
}
