/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urnaeletronica;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vitor
 */
public class Eleicao extends javax.swing.JFrame {
    
    //variaveis
    String candidato;
    int numCandidato;
    String num;

    //Colocar a foto do candidato na urna quando digitado o seu numero
    public void fotoCand(String foto) {
        File img = new File(foto);
        ImageIcon fotoCandidato = new ImageIcon(img.getPath());
        lblFoto.setIcon(fotoCandidato);
        
        
    }
    /**
     * Creates new form Eleicao
     */
    
    //Impossibilita o usuario digitar nos campos de numeros
    public Eleicao() {
        initComponents();
        txtCampo1.setEditable(false);
        txtCampo2.setEditable(false);
        txtCampo3.setEditable(false);
        txtCampo4.setEditable(false);
        txtCampo5.setEditable(false);
    }
    
    public void limpaTela() {
        lblNome.setText("");
        lblNomeCandidato.setText("");
        lblPartido.setText("");
        lblSigla.setText("");
        lblFoto.setIcon(null);
    }
    
    //Método para deixar os campos visiveis conforme o cargo
    public void CampoVisivel(String cargo) {
        if (cargo.equals("DEPUTADO ESTADUAL")) {
            txtCampo1.setVisible(true);
            txtCampo2.setVisible(true);
            txtCampo3.setVisible(true);
            txtCampo4.setVisible(true);
            txtCampo5.setVisible(true);
            
        } else if (cargo.equals("DEPUTADO FEDERAL")) {
            txtCampo1.setVisible(true);
            txtCampo2.setVisible(true);
            txtCampo3.setVisible(true);
            txtCampo4.setVisible(true);
            txtCampo5.setVisible(false);
            
        } else if (cargo.equals("SENADOR")) {
            txtCampo1.setVisible(true);
            txtCampo2.setVisible(true);
            txtCampo3.setVisible(true);
            txtCampo4.setVisible(false);
            txtCampo5.setVisible(false);
            
        } else if (cargo.equals("GOVERNADOR")) {
            txtCampo1.setVisible(true);
            txtCampo2.setVisible(true);
            txtCampo3.setVisible(false);
            txtCampo4.setVisible(false);
            txtCampo5.setVisible(false);
            
        } else if (cargo.equals("PRESIDENTE")) {
            txtCampo1.setVisible(true);
            txtCampo2.setVisible(true);
            txtCampo3.setVisible(false);
            txtCampo4.setVisible(false);
            txtCampo5.setVisible(false);
        }
    }
    
    //Limpar os campos
    public void limpaCampo() {
        txtCampo1.setText("");
        txtCampo2.setText("");
        txtCampo3.setText("");
        txtCampo4.setText("");
        txtCampo5.setText("");
    }
    
    //Metodo para os números
    public void validarNumeros(String numero) {
        
        //Cargo Deputado estadual na tela
        
        //Verifica se é Deputado estadual que está sendo votado
        if (lblCargo.getText().equals("DEPUTADO ESTADUAL")) {
            
            //Verifica se está preenchido o primeiro campo dos números do candidato
            //para adicionar o primeiro número
            if (txtCampo1.getText().equals("")) {
                txtCampo1.setText(numero);
                
            //Verifica se está preenchido o segundo campo dos números do candidato
            //para adicionar o segundo número
            } else if (txtCampo2.getText().equals("")) {
                       txtCampo2.setText(numero);
                       
            //Verifica se está preenchido o terceiro campo dos números do candidato
            //para adicionar o terceiro número
            } else if (txtCampo3.getText().equals("")) {
                       txtCampo3.setText(numero);
                       
            //Verifica se está preenchido o quarto campo dos números do candidato
            //para adicionar o quarto número
            } else if (txtCampo4.getText().equals("")) {
                       txtCampo4.setText(numero);
                       
            //Verifica se está preenchido o quinto campo dos números do candidato
            //para adicionar o quinto número
            } else if (txtCampo5.getText().equals("")) {
                       txtCampo5.setText(numero);

                candidato = txtCampo1.getText() + txtCampo2.getText() + txtCampo3.getText()
                        + txtCampo4.getText() + txtCampo5.getText();

                String sql = "select * from depEstadual where numero = ?";

                String url = "jdbc:mysql://127.0.0.1:3306/eleicao";
                String user = "root";
                String senha = "bluetooth007";

                try {
                    //Conecta com o banco de dados
                    Connection conexao = DriverManager.getConnection(url, user, senha);

                    //Preparar o comando que será executado
                    PreparedStatement comando = conexao.prepareStatement(sql);

                    
                    comando.setString(1, candidato);
                    ResultSet buscar = comando.executeQuery();

                    if (buscar.next() == true) {
                        String nome = buscar.getString("nome");
                        String partido = buscar.getString("siglaPartido");
                        String foto = buscar.getString("foto");

                        //Coloca os nomes e siglas em label na tela 
                        lblNome.setText("NOME:");
                        lblNomeCandidato.setText(nome);
                        lblPartido.setText("PARTIDO:");
                        lblSigla.setText(partido);
                        fotoCand(foto);
                        
                    } else {
                        //Se o numero tiver errado, da uma mensagem de erro em uma label
                        lblNumErrado.setText("NÚMERO ERRADO");
                    }
                    
                    //Libera os recursos
                    comando.close();
                    conexao.close();

                    //mensagem de erro
                } catch (SQLException erro) {
                    erro.printStackTrace();
                }

                
            }
            
            //Verifica se é Deputado federal que está sendo votado
        } else if (lblCargo.getText().equals("DEPUTADO FEDERAL")) {
            
            //Verifica se está preenchido o primeiro campo dos números do candidato
            //para adicionar o primeiro número
            if (txtCampo1.getText().equals("")) {
                txtCampo1.setText(numero);
                
            //Verifica se está preenchido o segundo campo dos números do candidato
            //para adicionar o segundo número
            } else if (txtCampo2.getText().equals("")) {
                       txtCampo2.setText(numero);
                       
            //Verifica se está preenchido o terceiro campo dos números do candidato
            //para adicionar o terceiro número
            } else if (txtCampo3.getText().equals("")) {
                       txtCampo3.setText(numero);
                       
            //Verifica se está preenchido o quarto campo dos números do candidato
            //para adicionar o quarto número
            } else if (txtCampo4.getText().equals("")) {
                       txtCampo4.setText(numero);

                candidato = txtCampo1.getText() + txtCampo2.getText() + txtCampo3.getText()
                        + txtCampo4.getText();

                String sql = "select * from depFederal where numero = ?";

                String url = "jdbc:mysql://127.0.0.1:3306/eleicao";
                String user = "root";
                String senha = "bluetooth007";

                try {
                    //Conecta com o banco de dados
                    Connection conexao = DriverManager.getConnection(url, user, senha);

                    //Preparar o comando que será executado
                    PreparedStatement comando = conexao.prepareStatement(sql);

                    comando.setString(1, candidato);
                    ResultSet busca = comando.executeQuery();

                    if (busca.next() == true) {
                        String nome = busca.getString("nome");
                        String partido = busca.getString("siglaPartido");
                        String foto = busca.getString("foto");

                        //Coloca os nomes e siglas em label na tela 
                        lblNome.setText("NOME:");
                        lblNomeCandidato.setText(nome);
                        lblPartido.setText("PARTIDO:");
                        lblSigla.setText(partido);
                        fotoCand(foto);
                        
                    } else {
                        //Se o numero tiver errado, da uma mensagem de erro em uma label
                        lblNumErrado.setText("NÚMERO ERRADO");
                    }
                    
                    //Libera os recursos
                    comando.close();
                    conexao.close();

                    //Mensagem de erro
                } catch (SQLException erro) {
                    erro.printStackTrace();
                }
            }
            
        //Verifica se é Senador que está sendo votado
        } else if (lblCargo.getText().equals("SENADOR")) {
            //Verifica se está preenchido o primeiro campo dos números do candidato
            //para adicionar o primeiro número
            if (txtCampo1.getText().equals("")) {
                txtCampo1.setText(numero);
                
            //Verifica se está preenchido o segundo campo dos números do candidato
            //para adicionar o segundo número
            } else if (txtCampo2.getText().equals("")) {
                       txtCampo2.setText(numero);
                       
            //Verifica se está preenchido o terceiro campo dos números do candidato
            //para adicionar o terceiro número
            } else if (txtCampo3.getText().equals("")) {
                       txtCampo3.setText(numero);

                candidato = txtCampo1.getText() + txtCampo2.getText() + txtCampo3.getText();

                String sql = "select * from senador where numero = ?";

                String url = "jdbc:mysql://127.0.0.1:3306/eleicao";
                String user = "root";
                String senha = "bluetooth007";

                try {
                    //Conecta com o banco de dados
                    Connection conexao = DriverManager.getConnection(url, user, senha);

                    //Preparar o comando que será executado
                    PreparedStatement comando = conexao.prepareStatement(sql);

                    comando.setString(1, candidato);
                    ResultSet busca = comando.executeQuery();

                    if (busca.next() == true) {
                        String nomeCand = busca.getString("nome");
                        String partido = busca.getString("siglaPartido");
                        String foto = busca.getString("foto");

                        //Coloca os nomes e siglas em label na tela 
                        lblNome.setText("NOME:");
                        lblNomeCandidato.setText(nomeCand);
                        lblPartido.setText("PARTIDO:");
                        lblSigla.setText(partido);
                        fotoCand(foto);
                        
                    } else {
                        //Se o número do candidato estiver errado, da uma mensagem de erro em uma label
                        lblNumErrado.setText("NÚMERO ERRADO");
                    }
                    
                    //libera os recursos
                    comando.close();
                    conexao.close();

                    //Mensagem de erro
                } catch (SQLException erro) {
                    erro.printStackTrace();
                }
            }
            
        //Verifica se é Governador que está sendo votado
        } else if (lblCargo.getText().equals("GOVERNADOR")) {
            //Verifica se está preenchido o primeiro campo dos números do candidato
            //para adicionar o primeiro número
            if (txtCampo1.getText().equals("")) {
                txtCampo1.setText(numero);
                
            //Verifica se está preenchido o segundo campo dos números do candidato
            //para adicionar o segundo número
            } else if (txtCampo2.getText().equals("")) {
                       txtCampo2.setText(numero);

                candidato = txtCampo1.getText() + txtCampo2.getText() + txtCampo3.getText()
                        + txtCampo4.getText() + txtCampo5.getText();

                String sql = "select * from governador where numero = ?";

                String url = "jdbc:mysql://127.0.0.1:3306/eleicao";
                String user = "root";
                String senha = "bluetooth007";

                try {
                    //Conecta com o banco de dados
                    Connection conexao = DriverManager.getConnection(url, user, senha);

                    //Preparar o comando que será executado
                    PreparedStatement comando = conexao.prepareStatement(sql);

                    comando.setString(1, candidato);
                    ResultSet busca = comando.executeQuery();

                    if (busca.next() == true) {
                        String nome = busca.getString("nome");
                        String partido = busca.getString("siglaPartido");
                        String foto = busca.getString("foto");

                        //Coloca os nomes e siglas em label na tela
                        lblNome.setText("NOME:");
                        lblNomeCandidato.setText(nome);
                        lblPartido.setText("PARTIDO:");
                        lblSigla.setText(partido);
                        fotoCand(foto);
                        
                    } else {
                        //Se o número do candidato estiver errado, da uma mensagem de erro em uma label
                        lblNumErrado.setText("NÚMERO ERRADO");
                    }
                    
                    //Libera os recursos
                    comando.close();
                    conexao.close();

                    //Mensagem de erro
                } catch (SQLException erro) {
                    erro.printStackTrace();
                }
            }
            
        //Verifica se é Presidente que está sendo votado
        } else if (lblCargo.getText().equals("PRESIDENTE")) {
            
            //Verifica se está preenchido o primeiro campo dos números do candidato
            //para adicionar o primeiro número
            if (txtCampo1.getText().equals("")) {
                txtCampo1.setText(numero);
                
            //Verifica se está preenchido o segundo campo dos números do candidato
            //para adicionar o segundo número
            } else if (txtCampo2.getText().equals("")) {
                       txtCampo2.setText(numero);

                candidato = txtCampo1.getText() + txtCampo2.getText() + txtCampo3.getText()
                        + txtCampo4.getText() + txtCampo5.getText();

                String sql = "select * from presidente where numero = ?";

                String url = "jdbc:mysql://127.0.0.1:3306/eleicao";
                String user = "root";
                String senha = "bluetooth007";

                try {
                    //Conecta com o banco de dados
                    Connection conexao = DriverManager.getConnection(url, user, senha);

                    //Preparar o comando que será executado
                    PreparedStatement comando = conexao.prepareStatement(sql);

                    comando.setString(1, candidato);
                    ResultSet busca = comando.executeQuery();

                    if (busca.next() == true) {
                        String nome = busca.getString("nome");
                        String partido = busca.getString("siglaPartido");
                        String foto = busca.getString("foto");

                        //Coloca os nomes e siglas em label na tela
                        lblNome.setText("NOME:");
                        lblNomeCandidato.setText(nome);
                        lblPartido.setText("PARTIDO:");
                        lblSigla.setText(partido);
                        fotoCand(foto);
                        
                    } else {
                         //Se o número do candidato estiver errado, da uma mensagem de erro em uma label
                        lblNumErrado.setText("NÚMERO ERRADO");
                    }
                    
                    //Libera os recursos
                    comando.close();
                    conexao.close();

                    //Mensagem de erro
                } catch (SQLException erro) {
                    erro.printStackTrace();
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTeclado = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnBranco = new javax.swing.JButton();
        btnCorrige = new javax.swing.JButton();
        btnCorfirma = new javax.swing.JButton();
        painelTela = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        lblSeuVotoPara = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblNomeCandidato = new javax.swing.JLabel();
        lblPartido = new javax.swing.JLabel();
        lblSigla = new javax.swing.JLabel();
        txtCampo1 = new javax.swing.JTextField();
        txtCampo2 = new javax.swing.JTextField();
        txtCampo3 = new javax.swing.JTextField();
        txtCampo4 = new javax.swing.JTextField();
        txtCampo5 = new javax.swing.JTextField();
        lblAperteTecla = new javax.swing.JLabel();
        lblVerde = new javax.swing.JLabel();
        lblPara = new javax.swing.JLabel();
        lblConfirmar = new javax.swing.JLabel();
        lblLaranja = new javax.swing.JLabel();
        lblPara2 = new javax.swing.JLabel();
        lblCorrigir = new javax.swing.JLabel();
        lblNumErrado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eleição");

        btn1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn0.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        btnBranco.setBackground(new java.awt.Color(255, 255, 255));
        btnBranco.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnBranco.setText("BRANCO");
        btnBranco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrancoActionPerformed(evt);
            }
        });

        btnCorrige.setBackground(new java.awt.Color(255, 153, 0));
        btnCorrige.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnCorrige.setText("CORRIGE");
        btnCorrige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorrigeActionPerformed(evt);
            }
        });

        btnCorfirma.setBackground(new java.awt.Color(0, 255, 0));
        btnCorfirma.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnCorfirma.setText("CONFIRMAR");
        btnCorfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorfirmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelTecladoLayout = new javax.swing.GroupLayout(painelTeclado);
        painelTeclado.setLayout(painelTecladoLayout);
        painelTecladoLayout.setHorizontalGroup(
            painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTecladoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTecladoLayout.createSequentialGroup()
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTecladoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTecladoLayout.createSequentialGroup()
                                .addComponent(btnBranco, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCorrige, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTecladoLayout.createSequentialGroup()
                                .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTecladoLayout.createSequentialGroup()
                                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn9, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addComponent(btn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnCorfirma))
                .addContainerGap())
        );
        painelTecladoLayout.setVerticalGroup(
            painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTecladoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(btn5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCorrige, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCorfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBranco, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        lblSeuVotoPara.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lblSeuVotoPara.setText("SEU VOTO PARA");

        lblCargo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblCargo.setText("DEPUTADO ESTADUAL");

        lblNumero.setFont(new java.awt.Font("Arial", 0, 21)); // NOI18N
        lblNumero.setText("NÚMERO:");

        lblNome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        lblNomeCandidato.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        txtCampo1.setFont(new java.awt.Font("Arial", 1, 42)); // NOI18N

        txtCampo2.setFont(new java.awt.Font("Arial", 1, 42)); // NOI18N

        txtCampo3.setFont(new java.awt.Font("Arial", 1, 42)); // NOI18N

        txtCampo4.setFont(new java.awt.Font("Arial", 1, 42)); // NOI18N

        lblAperteTecla.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        lblAperteTecla.setText("Aperte a tecla");

        lblVerde.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lblVerde.setText("VERDE");

        lblPara.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        lblPara.setText("para");

        lblConfirmar.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lblConfirmar.setText("CONFIRMAR");

        lblLaranja.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lblLaranja.setText("LARANJA");

        lblPara2.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        lblPara2.setText("para");

        lblCorrigir.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lblCorrigir.setText("CORRIGIR");

        lblNumErrado.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        javax.swing.GroupLayout painelTelaLayout = new javax.swing.GroupLayout(painelTela);
        painelTela.setLayout(painelTelaLayout);
        painelTelaLayout.setHorizontalGroup(
            painelTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelTelaLayout.createSequentialGroup()
                            .addComponent(lblLaranja)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblPara2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblCorrigir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(painelTelaLayout.createSequentialGroup()
                            .addComponent(lblVerde)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblPara, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblConfirmar)))
                    .addComponent(lblAperteTecla)
                    .addGroup(painelTelaLayout.createSequentialGroup()
                        .addGroup(painelTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSeuVotoPara)
                            .addComponent(lblCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelTelaLayout.createSequentialGroup()
                                .addComponent(lblNumero)
                                .addGap(8, 8, 8)
                                .addComponent(txtCampo1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCampo2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCampo3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCampo4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCampo5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelTelaLayout.createSequentialGroup()
                                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNomeCandidato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelTelaLayout.createSequentialGroup()
                        .addComponent(lblPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumErrado, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        painelTelaLayout.setVerticalGroup(
            painelTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSeuVotoPara, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelTelaLayout.createSequentialGroup()
                        .addGroup(painelTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCampo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(lblNumero, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCampo2)
                            .addComponent(txtCampo3)
                            .addComponent(txtCampo4)
                            .addComponent(txtCampo5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(painelTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelTelaLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblNomeCandidato, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                            .addGroup(painelTelaLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSigla, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(lblPartido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(83, 83, 83)
                .addComponent(lblNumErrado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblAperteTecla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblVerde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelTelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCorrigir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPara2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLaranja, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelTela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(painelTeclado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelTeclado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelTela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCorfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorfirmaActionPerformed
        if (lblCargo.getText().equals("DEPUTADO ESTADUAL") && lblNumErrado.getText().equals("")) {
                candidato = txtCampo1.getText() + txtCampo2.getText() + txtCampo3.getText()
                        + txtCampo4.getText() + txtCampo5.getText();
                numCandidato = Integer.parseInt(candidato);

                String sql = "update depEstadual set totalVotos = (totalVotos + 1) where numero = ?";

                String url = "jdbc:mysql://127.0.0.1:3306/eleicao";
                String user = "root";
                String senha = "bluetooth007";

                try {
                    //Captura uma conexão
            Connection conexao = DriverManager.getConnection(url, user, senha);
            
            //Criar um comando
            PreparedStatement comando = conexao.prepareStatement(sql);

                    comando.setInt(1, numCandidato);
                    comando.executeUpdate();

                    //Libera os recursos
                    comando.close();
                    conexao.close();

                    lblCargo.setText("DEPUTADO FEDERAL");
                    limpaCampo();
                    limpaTela();
                    CampoVisivel(lblCargo.getText());
                    
                    //Mensagem de erro
                } catch (SQLException erro) {
                    lblNumErrado.setText("NÚMERO ERRADO");
                    erro.printStackTrace();
                }
                
            } else if (lblCargo.getText().equals("DEPUTADO FEDERAL") && lblNumErrado.getText().equals("")) {
                candidato = txtCampo1.getText() + txtCampo2.getText() + txtCampo3.getText()
                        + txtCampo4.getText();
                numCandidato = Integer.parseInt(candidato);

                String sql = "update depfederal set totalVotos = (totalVotos + 1) where numero = ?";

                String url = "jdbc:mysql://127.0.0.1:3306/eleicao";
                String user = "root";
                String senha = "bluetooth007";

                try {
                    //Captura uma conexão
            Connection conexao = DriverManager.getConnection(url, user, senha);
            
            //Criar um comando
            PreparedStatement comando = conexao.prepareStatement(sql);

                    comando.setInt(1, numCandidato);
                    comando.executeUpdate();

                    //Libera os recursos
                    comando.close();
                    conexao.close();

                    lblCargo.setText("SENADOR");
                    limpaCampo();
                    limpaTela();
                    CampoVisivel(lblCargo.getText());
                    
                    //Mensagem de erro
                } catch (SQLException erro) {
                    erro.printStackTrace();
                }
                
            } else if (lblCargo.getText().equals("SENADOR") && lblNumErrado.getText().equals("")) {
                candidato = txtCampo1.getText() + txtCampo2.getText() + txtCampo3.getText();
                numCandidato = Integer.parseInt(candidato);

                String sql = "update senador set totalVotos = (totalVotos + 1) where numero = ?";

                String url = "jdbc:mysql://127.0.0.1:3306/eleicao";
                String user = "root";
                String senha = "bluetooth007";

                try {
                    //Captura uma conexão
            Connection conexao = DriverManager.getConnection(url, user, senha);
            
            //Criar um comando
            PreparedStatement comando = conexao.prepareStatement(sql);

                    comando.setInt(1, numCandidato);
                    comando.executeUpdate();

                    //Libera os recursos
                    comando.close();
                    conexao.close();

                    lblCargo.setText("GOVERNADOR");
                    limpaCampo();
                    limpaTela();
                    CampoVisivel(lblCargo.getText());
                    
                } catch (SQLException erro) {
                    erro.printStackTrace();
                }
                
            } else if (lblCargo.getText().equals("GOVERNADOR") && lblNumErrado.getText().equals("")) {
                candidato = txtCampo1.getText() + txtCampo2.getText();
                numCandidato = Integer.parseInt(candidato);

                String sql = "update governador set totalVotos = (totalVotos + 1)  where numero = ?";

                String url = "jdbc:mysql://127.0.0.1:3306/eleicao";
                String user = "root";
                String senha = "bluetooth007";

                try {
                     //Captura uma conexão
            Connection conexao = DriverManager.getConnection(url, user, senha);
            
            //Criar um comando
            PreparedStatement comando = conexao.prepareStatement(sql);

                    comando.setInt(1, numCandidato);
                    comando.executeUpdate();

                    //Libera os recursos
                    comando.close();
                    conexao.close();

                    lblCargo.setText("PRESIDENTE");
                    limpaCampo();
                    limpaTela();
                    CampoVisivel(lblCargo.getText());
                    
                    //Mensagem de erro
                } catch (SQLException erro) {
                    erro.printStackTrace();
                }
                
            } else if (lblCargo.getText().equals("PRESIDENTE") && lblNumErrado.getText().equals("")) {
                candidato = txtCampo1.getText() + txtCampo2.getText();
                numCandidato = Integer.parseInt(candidato);

                String sql = "update presidente set totalVotos = (totalVotos + 1)  where numero = ?";

                String url = "jdbc:mysql://127.0.0.1:3306/eleicao";
                String user = "root";
                String senha = "bluetooth007";

                try {
                     //Captura uma conexão
            Connection conexao = DriverManager.getConnection(url, user, senha);
            
            //Criar um comando
            PreparedStatement comando = conexao.prepareStatement(sql);

                    comando.setInt(1, numCandidato);
                    comando.executeUpdate();

                    //Libera os recursos
                    comando.close();
                    conexao.close();

                    
                    limpaTela();
                    txtCampo1.setVisible(false);
                    txtCampo2.setVisible(false);
                    
                    JOptionPane.showMessageDialog(null, "OBRIGADO!");
                            
                } catch (SQLException erro) {
                    erro.printStackTrace();
                }
            }
        
            //Condição para voto em branco ou nulo
        if (lblNumErrado.getText().equals("NÚMERO ERRADO") || lblNumErrado.getText().equals("VOTO EM BRANCO")) {
            if (lblCargo.getText().equals("DEPUTADO ESTADUAL")) {
                lblNumero.setText("NÚMERO:");
                lblNumErrado.setText("");
                lblCargo.setText("DEPUTADO FEDERAL");
                limpaCampo();
                limpaTela();
                CampoVisivel(lblCargo.getText());
                
            } else if (lblCargo.getText().equals("DEPUTADO FEDERAL")) {
                lblNumero.setText("NÚMERO:");
                lblNumErrado.setText("");
                lblCargo.setText("SENADOR");
                limpaCampo();
                limpaTela();
                CampoVisivel(lblCargo.getText());
                
            } else if (lblCargo.getText().equals("SENADOR")) {
                lblNumero.setText("NÚMERO:");
                lblNumErrado.setText("");
                lblCargo.setText("GOVERNADOR");
                limpaCampo();
                limpaTela();
                CampoVisivel(lblCargo.getText());
                
            } else if (lblCargo.getText().equals("GOVERNADOR")) {
                lblNumero.setText("NÚMERO:");
                lblNumErrado.setText("");
                lblCargo.setText("PRESIDENTE");
                limpaCampo();
                limpaTela();
                CampoVisivel(lblCargo.getText());
                
            } else if (lblCargo.getText().equals("PRESIDENTE")) {
                JOptionPane.showMessageDialog(null, "OBRIGADO!");
            }
        }
    }//GEN-LAST:event_btnCorfirmaActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        num = "0";
        validarNumeros(num);
    }//GEN-LAST:event_btn0ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        num = "1";
        validarNumeros(num);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        num = "2";
        validarNumeros(num);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        num = "3";
        validarNumeros(num);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        num = "4";
        validarNumeros(num);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        num = "5";
        validarNumeros(num);
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        num = "6";
        validarNumeros(num);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        num = "7";
        validarNumeros(num);
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        num = "8";
        validarNumeros(num);
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        num = "9";
        validarNumeros(num);
    }//GEN-LAST:event_btn9ActionPerformed

    private void btnCorrigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorrigeActionPerformed
        lblNumero.setText("NÚMERO:");
        lblNumErrado.setText("");

        CampoVisivel(lblCargo.getText());
        limpaCampo();
        limpaTela();
    }//GEN-LAST:event_btnCorrigeActionPerformed

    private void btnBrancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrancoActionPerformed
        limpaCampo();

        txtCampo1.setVisible(false);
        txtCampo2.setVisible(false);
        txtCampo3.setVisible(false);
        txtCampo4.setVisible(false);
        txtCampo5.setVisible(false);

        lblNumero.setText("");
        limpaTela();
        lblNumErrado.setText("VOTO EM BRANCO");
    }//GEN-LAST:event_btnBrancoActionPerformed

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
            java.util.logging.Logger.getLogger(Eleicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eleicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eleicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eleicao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eleicao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnBranco;
    private javax.swing.JButton btnCorfirma;
    private javax.swing.JButton btnCorrige;
    private javax.swing.JLabel lblAperteTecla;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblConfirmar;
    private javax.swing.JLabel lblCorrigir;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblLaranja;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeCandidato;
    private javax.swing.JLabel lblNumErrado;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblPara;
    private javax.swing.JLabel lblPara2;
    private javax.swing.JLabel lblPartido;
    private javax.swing.JLabel lblSeuVotoPara;
    private javax.swing.JLabel lblSigla;
    private javax.swing.JLabel lblVerde;
    private javax.swing.JPanel painelTeclado;
    private javax.swing.JPanel painelTela;
    private javax.swing.JTextField txtCampo1;
    private javax.swing.JTextField txtCampo2;
    private javax.swing.JTextField txtCampo3;
    private javax.swing.JTextField txtCampo4;
    private javax.swing.JTextField txtCampo5;
    // End of variables declaration//GEN-END:variables
}
