/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urnaeletronica;

/**
 *
 * @author Ronaldo
 */
public class SistemaUrna extends javax.swing.JFrame {

    /**
     * Creates new form SistemaUrna
     */
    public SistemaUrna() {
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

        jMenuBar1 = new javax.swing.JMenuBar();
        MnPresidente = new javax.swing.JMenu();
        ImnCadastPresidente = new javax.swing.JMenuItem();
        ImnConsPrasidente = new javax.swing.JMenuItem();
        MnGovernador = new javax.swing.JMenu();
        ImnCadastGovernador = new javax.swing.JMenuItem();
        ImnConsGovernador = new javax.swing.JMenuItem();
        MnSenador = new javax.swing.JMenu();
        ImnCadastSenador = new javax.swing.JMenuItem();
        ImnConsSenador = new javax.swing.JMenuItem();
        MnDepFederam = new javax.swing.JMenu();
        ImnCadastDepFederal = new javax.swing.JMenuItem();
        ImnConsDepFederal = new javax.swing.JMenuItem();
        MnDepEstadual = new javax.swing.JMenu();
        ImnCadastDepEstadual = new javax.swing.JMenuItem();
        ImnConsultaDepEstadual = new javax.swing.JMenuItem();
        MnEleitor = new javax.swing.JMenu();
        ImnCadastEleitor = new javax.swing.JMenuItem();
        ImnConsEleitor = new javax.swing.JMenuItem();
        MnEleicao = new javax.swing.JMenu();
        MnIniciarEleicao = new javax.swing.JMenuItem();
        MnRelatorioEleicao = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        MnPresidente.setText("Presidente");

        ImnCadastPresidente.setText("Novo");
        ImnCadastPresidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImnCadastPresidenteActionPerformed(evt);
            }
        });
        MnPresidente.add(ImnCadastPresidente);

        ImnConsPrasidente.setText("Consulta");
        ImnConsPrasidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImnConsPrasidenteActionPerformed(evt);
            }
        });
        MnPresidente.add(ImnConsPrasidente);

        jMenuBar1.add(MnPresidente);

        MnGovernador.setText("Governador");

        ImnCadastGovernador.setText("Novo");
        ImnCadastGovernador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImnCadastGovernadorActionPerformed(evt);
            }
        });
        MnGovernador.add(ImnCadastGovernador);

        ImnConsGovernador.setText("Consulta");
        MnGovernador.add(ImnConsGovernador);

        jMenuBar1.add(MnGovernador);

        MnSenador.setText("Senador");

        ImnCadastSenador.setText("Novo");
        ImnCadastSenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImnCadastSenadorActionPerformed(evt);
            }
        });
        MnSenador.add(ImnCadastSenador);

        ImnConsSenador.setText("Consulta");
        MnSenador.add(ImnConsSenador);

        jMenuBar1.add(MnSenador);

        MnDepFederam.setText("Deputado Federal");

        ImnCadastDepFederal.setText("Novo");
        MnDepFederam.add(ImnCadastDepFederal);

        ImnConsDepFederal.setText("Consulta");
        MnDepFederam.add(ImnConsDepFederal);

        jMenuBar1.add(MnDepFederam);

        MnDepEstadual.setText("Deputado Estadual");

        ImnCadastDepEstadual.setText("Novo");
        MnDepEstadual.add(ImnCadastDepEstadual);

        ImnConsultaDepEstadual.setText("Consulta");
        MnDepEstadual.add(ImnConsultaDepEstadual);

        jMenuBar1.add(MnDepEstadual);

        MnEleitor.setText("Eleitor");

        ImnCadastEleitor.setText("Novo");
        MnEleitor.add(ImnCadastEleitor);

        ImnConsEleitor.setText("Consulta");
        MnEleitor.add(ImnConsEleitor);

        jMenuBar1.add(MnEleitor);

        MnEleicao.setText("Elei��o");

        MnIniciarEleicao.setText("Iniciar Vota��o");
        MnIniciarEleicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnIniciarEleicaoActionPerformed(evt);
            }
        });
        MnEleicao.add(MnIniciarEleicao);

        MnRelatorioEleicao.setText("Relat�rio Elei��o");
        MnEleicao.add(MnRelatorioEleicao);

        jMenuBar1.add(MnEleicao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ImnCadastPresidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImnCadastPresidenteActionPerformed
        Presidente tela = new Presidente();
        tela.setVisible(true);
    }//GEN-LAST:event_ImnCadastPresidenteActionPerformed

    private void ImnCadastGovernadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImnCadastGovernadorActionPerformed
        Governador tela = new Governador();
        tela.setVisible(true);
    }//GEN-LAST:event_ImnCadastGovernadorActionPerformed

    private void ImnCadastSenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImnCadastSenadorActionPerformed
        Senador tela = new Senador();
        tela.setVisible(true);
    }//GEN-LAST:event_ImnCadastSenadorActionPerformed

    private void ImnConsPrasidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImnConsPrasidenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImnConsPrasidenteActionPerformed

    private void MnIniciarEleicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnIniciarEleicaoActionPerformed
        Eleicao tela = new Eleicao();
        tela.setVisible(true);
    }//GEN-LAST:event_MnIniciarEleicaoActionPerformed

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
            java.util.logging.Logger.getLogger(SistemaUrna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SistemaUrna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SistemaUrna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaUrna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemaUrna().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ImnCadastDepEstadual;
    private javax.swing.JMenuItem ImnCadastDepFederal;
    private javax.swing.JMenuItem ImnCadastEleitor;
    private javax.swing.JMenuItem ImnCadastGovernador;
    private javax.swing.JMenuItem ImnCadastPresidente;
    private javax.swing.JMenuItem ImnCadastSenador;
    private javax.swing.JMenuItem ImnConsDepFederal;
    private javax.swing.JMenuItem ImnConsEleitor;
    private javax.swing.JMenuItem ImnConsGovernador;
    private javax.swing.JMenuItem ImnConsPrasidente;
    private javax.swing.JMenuItem ImnConsSenador;
    private javax.swing.JMenuItem ImnConsultaDepEstadual;
    private javax.swing.JMenu MnDepEstadual;
    private javax.swing.JMenu MnDepFederam;
    private javax.swing.JMenu MnEleicao;
    private javax.swing.JMenu MnEleitor;
    private javax.swing.JMenu MnGovernador;
    private javax.swing.JMenuItem MnIniciarEleicao;
    private javax.swing.JMenu MnPresidente;
    private javax.swing.JMenuItem MnRelatorioEleicao;
    private javax.swing.JMenu MnSenador;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
