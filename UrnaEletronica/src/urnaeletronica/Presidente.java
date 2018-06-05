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
public class Presidente extends javax.swing.JFrame {

    /**
     * Creates new form Presidente
     */
    public Presidente() {
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
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Presidente");

        lblDepEst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDepEst.setText("Cadastro de Presidente");

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
                .addComponent(lblFoto2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnFotoLayout.setVerticalGroup(
            jpnFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFoto2, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        btnAdicionar.setText("Adicionar foto");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFoto)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSigla)
                        .addGap(18, 18, 18)
                        .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnSalvar)
                .addGap(46, 46, 46)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDepEst)
                .addGap(72, 72, 72))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFoto)
                            .addComponent(jpnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionar)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addComponent(btnSair))
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
       
       
       String sql = "insert presidente values (?, ?, ?, ?, ?)";
       String url = "jdbc:mysql://127.0.0.1:3306/eleicao";
       String usuario = "root";
       String senha = "bluetooth007";
       
       try {
       Connection conexao = DriverManager.getConnection(url, usuario, senha);
       PreparedStatement comando = conexao.prepareStatement(sql);
       
       comando.setInt(1 , numero);
       comando.setString(2, nome);
       comando.setString(3, sigla);
       comando.setString(4, foto);
       comando.setInt(5, totalVotos);
    
       
       comando.executeUpdate();
       comando.close();
       conexao.close();
       
       JOptionPane.showMessageDialog(null,"Acesso permitido");
       
       //Limpar os campos de inserção
            txtNumero.setText("");
            txtNome.setText("");
            txtSigla.setText("");
            txtFoto.setText("");
            lblFoto2.setText("");
            
            txtNumero.requestFocus();
            
       } catch(SQLException erro) {
       JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados");
       erro.printStackTrace();
       }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        JOptionPane.showMessageDialog(null, "SAINDO DO CADASTRO PRESIDENTE");
        System.exit(1);
        
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
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
    }//GEN-LAST:event_btnAdicionarActionPerformed

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
            java.util.logging.Logger.getLogger(Presidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Presidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Presidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Presidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Presidente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
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
