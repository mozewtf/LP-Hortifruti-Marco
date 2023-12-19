/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClienteMabs;
import bean.UsuariosMabs;
import dao.ClientesDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;
/**
 *
 * @author MARCO
 */
public class JDlgClientes extends javax.swing.JDialog {
    private boolean incluindo;
    MaskFormatter mascaraData;
    MaskFormatter mascaraCpf;
    MaskFormatter mascaraCep;
    MaskFormatter mascaraRG;
    MaskFormatter mascaraTele;
    public ClientesDAO clientesDAO;
    public ClienteMabs clienteMabs;
    
    /**
     * Creates new form JDlgClientes
     */
    JDlgClientesPesquisa jDlgClientesPesquisa;
    public JDlgClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clientesDAO = new ClientesDAO();
         setTitle("Clientes");
      setLocationRelativeTo(null);
        Util.habilitar(false,jFmtDataNasce, jTxtRua, jTxtComplemento,jTxtIdUsuario ,jTxtIdCliente, jTxtEmail, jTxtNome, jTxtCidade, jTxtNome, jTxtNumerocasa,
                jTxtNacionalidade, jFmtCep, jFmtTelefone, jFmtRg, jFmtCPF ,jCboSexo, jBtnExcluir, jBtnConfirmar, jBtnCancelar, jTxtEstado);
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnPesquisar);
        jDlgClientesPesquisa = new JDlgClientesPesquisa(null, true);
         try{
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraData = new MaskFormatter("##/##/####");
            mascaraCep = new MaskFormatter("#####-###");
            mascaraRG = new MaskFormatter("##.###.###-##");
            mascaraTele= new MaskFormatter("(##)# #####-####");
      } catch(ParseException ex) {
          Logger.getLogger(JDlgClientes.class.getName()).log(Level.SEVERE, null, ex);
      }
        jFmtCPF.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf));
        jFmtDataNasce.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
        jFmtCep.setFormatterFactory(new DefaultFormatterFactory(mascaraCep));
        jFmtRg.setFormatterFactory(new DefaultFormatterFactory(mascaraRG));
        jFmtTelefone.setFormatterFactory(new DefaultFormatterFactory(mascaraTele));
    }
    public ClienteMabs viewBean(){
    ClienteMabs clienteMabs = new ClienteMabs();
    clienteMabs.setIdClienteMabs(Util.strInt(jTxtIdCliente.getText()));
    UsuariosMabs usuariosMabs = new UsuariosMabs();
    usuariosMabs.setIdUsuariosMabs(Util.strInt(jTxtIdUsuario.getText()));
    clienteMabs.setUsuariosMabs(usuariosMabs);
    clienteMabs.setNomeMabs(jTxtNome.getText());
    clienteMabs.setTelefoneMabs(jFmtTelefone.getText());
    clienteMabs.setRgMabs(jFmtRg.getText());
    clienteMabs.setEmailMabs(jTxtEmail.getText());
    if (jCboSexo.getSelectedIndex() == 0){
    clienteMabs.setSexoMabs("M");
    } else {
    clienteMabs.setSexoMabs("F");}
    clienteMabs.setNacionalidadeMabs(jTxtNacionalidade.getText());
    clienteMabs.setEstadoMabs(jTxtEstado.getText());
    clienteMabs.setCidadeMabs(jTxtCidade.getText());
    clienteMabs.setCpfMabs(jFmtCPF.getText());
    clienteMabs.setCepMabs(jFmtCep.getText());
    clienteMabs.setNumerocasaMabs(jTxtNumerocasa.getText());
    clienteMabs.setComplementoMabs(jTxtComplemento.getText());
    clienteMabs.setRuaMabs(jTxtRua.getText());
     SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            clienteMabs.setNascimentoMabs(formato.parse(jFmtDataNasce.getText()));
        } catch (ParseException ex) {
            System.out.println("Erro data no ViewBean" + ex.getMessage());
        }
    
    return clienteMabs;
    }
    
    public void beanView(ClienteMabs clienteMabs){
    jTxtIdCliente.setText(Util.intStr(clienteMabs.getIdClienteMabs()));
    //UsuariosMabs usuariosMabs = clienteMabs.getUsuariosMabs();
    //jTxtIdUsuario.setText(String.valueOf(usuariosMabs.getIdUsuariosMabs()));
    UsuariosMabs usuariosMabs = clienteMabs.getUsuariosMabs();
    jTxtIdUsuario.setText(String.valueOf(usuariosMabs.getIdUsuariosMabs()));
    jTxtNome.setText(clienteMabs.getNomeMabs());
    jFmtTelefone.setText(clienteMabs.getTelefoneMabs());
    jFmtRg.setText(clienteMabs.getRgMabs());
    if (clienteMabs.getSexoMabs() == "M"){
    jCboSexo.setSelectedIndex(0);
    }else{
    jCboSexo.setSelectedIndex(1);} //perguntar pq nao ta alterando o sexo
    jTxtNacionalidade.setText(clienteMabs.getNacionalidadeMabs());
    jTxtEstado.setText(clienteMabs.getEstadoMabs());
    jTxtEmail.setText(clienteMabs.getEmailMabs());
    jFmtCep.setText(clienteMabs.getCepMabs());
    jTxtNumerocasa.setText(clienteMabs.getNumerocasaMabs());
    jTxtComplemento.setText(clienteMabs.getComplementoMabs());
    jTxtRua.setText(clienteMabs.getRuaMabs());
    jTxtCidade.setText(clienteMabs.getCidadeMabs());
    jFmtCPF.setText(clienteMabs.getCpfMabs());
    jFmtDataNasce.setText(Util.dateStr(clienteMabs.getNascimentoMabs()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jFmtTelefone = new javax.swing.JFormattedTextField();
        jCboSexo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jFmtRg = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jTxtNacionalidade = new javax.swing.JTextField();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTxtEstado = new javax.swing.JTextField();
        jBtnIncluir = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jBtnAlterar = new javax.swing.JButton();
        jFmtCep = new javax.swing.JFormattedTextField();
        jBtnExcluir = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jBtnConfirmar = new javax.swing.JButton();
        jTxtCidade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTxtIdCliente = new javax.swing.JTextField();
        jTxtEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTxtNumerocasa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTxtRua = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTxtComplemento = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTxtIdUsuario = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jFmtCPF = new javax.swing.JFormattedTextField();
        jFmtDataNasce = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();

        jLabel16.setText("jLabel16");

        jLabel17.setText("jLabel17");

        jLabel19.setText("jLabel19");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setText("Telefone");

        jCboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        jCboSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboSexoActionPerformed(evt);
            }
        });

        jLabel6.setText("Sexo");

        jLabel8.setText("RG");

        jFmtRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtRgActionPerformed(evt);
            }
        });

        jLabel9.setText("País");

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jLabel10.setText("Estado");

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnIncluir.setText("incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jLabel11.setText("CEP");

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterar.setText("alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jLabel12.setText("Cidade");

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmar.png"))); // NOI18N
        jBtnConfirmar.setText("confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jLabel2.setText("Id Cliente");

        jLabel13.setText("Email");

        jTxtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtIdClienteActionPerformed(evt);
            }
        });

        jTxtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtEmailActionPerformed(evt);
            }
        });

        jLabel14.setText("Numero");

        jLabel4.setText("Nome");

        jLabel1.setText("Rua");

        jTxtRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtRuaActionPerformed(evt);
            }
        });

        jLabel7.setText("Complemento");

        jTxtComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtComplementoActionPerformed(evt);
            }
        });

        jLabel15.setText("Id Usuário");

        jTxtIdUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtIdUsuarioActionPerformed(evt);
            }
        });

        jLabel18.setText("CPF");

        jFmtDataNasce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtDataNasceActionPerformed(evt);
            }
        });

        jLabel20.setText("Data Nascimento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jFmtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnAlterar)
                                .addGap(28, 28, 28)
                                .addComponent(jBtnExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnPesquisar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTxtNumerocasa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFmtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(69, 69, 69))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(108, 108, 108)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTxtNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTxtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(133, 133, 133)
                                        .addComponent(jLabel1))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(236, 236, 236)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jFmtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFmtDataNasce, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(213, 213, 213)
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jFmtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTxtNome, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jTxtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTxtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15))))
                                .addGap(18, 18, 18)
                                .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel8)
                        .addComponent(jLabel3)))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtDataNasce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFmtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNumerocasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnIncluir)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnConfirmar)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnPesquisar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCboSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboSexoActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        Util.habilitar(false, jFmtDataNasce,jFmtCPF,jTxtRua,jTxtComplemento, jTxtIdUsuario , jTxtIdCliente, jTxtEmail, jTxtNome, jTxtCidade, jTxtNome, jTxtNumerocasa, jTxtNacionalidade, jFmtCep, jFmtTelefone, jFmtRg, jCboSexo, jBtnExcluir, jBtnConfirmar, jBtnCancelar, jTxtEstado);
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnPesquisar);
        Util.limparCampos(jFmtDataNasce,jFmtCPF,jTxtRua, jTxtComplemento, jTxtIdUsuario, jTxtIdCliente, jTxtEmail, jTxtNome, jTxtCidade, jTxtNome, jTxtNumerocasa, jTxtNacionalidade, jFmtCep, jFmtTelefone, jFmtRg, jCboSexo, jTxtEstado);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        //Util.habilitar(true, jBtnAlterar, jBtnExcluir, jBtnConfirmar, jBtnCancelar);
        //Util.habilitar(false, jBtnIncluir, jBtnPesquisar);
        JDlgClientesPesquisa jDlgClientesPesquisa = new JDlgClientesPesquisa(null, true);
        jDlgClientesPesquisa.setTelaAnterior(this);
        jDlgClientesPesquisa.setVisible(true);
        Util.habilitar(false,jFmtDataNasce,jFmtCPF,jTxtRua,jTxtComplemento, jTxtIdUsuario , jTxtIdCliente, jTxtEmail, jTxtNome, jTxtCidade, jTxtNome, jTxtNumerocasa, jTxtNacionalidade, jFmtCep, jFmtTelefone, jFmtRg, jCboSexo, jBtnExcluir, jBtnConfirmar, jBtnCancelar, jTxtEstado);
        Util.habilitar(true,  jBtnAlterar, jBtnPesquisar, jBtnCancelar,jBtnExcluir);
        Util.habilitar(false, jBtnIncluir, jBtnConfirmar);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        Util.habilitar(false ,jBtnAlterar, jBtnIncluir, jBtnExcluir, jBtnPesquisar);
        Util.habilitar(true, jFmtDataNasce,jFmtCPF,jTxtRua, jTxtComplemento, jTxtIdUsuario, jTxtIdCliente, jTxtEmail, jTxtNome, jTxtCidade, jTxtNome, jTxtNumerocasa, jTxtNacionalidade, jFmtCep, jFmtTelefone, jFmtRg, jCboSexo, jBtnConfirmar, jBtnCancelar, jTxtEstado);
        Util.limparCampos(jFmtDataNasce,jFmtCPF,jTxtRua, jTxtComplemento, jTxtIdUsuario, jTxtIdCliente, jTxtEmail, jTxtNome, jTxtCidade, jTxtNome, jTxtNumerocasa, jTxtNacionalidade, jFmtCep, jFmtTelefone, jFmtRg, jCboSexo, jTxtEstado);
        incluindo = true;
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        incluindo = false;
        Util.habilitar(false, jBtnAlterar, jBtnIncluir, jBtnExcluir, jBtnPesquisar);
        Util.habilitar(true,jFmtDataNasce, jTxtRua, jFmtCPF,jTxtComplemento, jTxtIdCliente, jTxtEmail, jTxtNome, jTxtCidade, jTxtNome, jTxtNumerocasa, jTxtNacionalidade, jFmtCep, jFmtTelefone, jFmtRg, jCboSexo, jBtnConfirmar, jBtnCancelar, jTxtEstado);
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
         Util.habilitar(true, jFmtDataNasce,jFmtCPF, jTxtRua,jTxtComplemento, jTxtIdUsuario , jTxtIdCliente, jTxtEmail, jTxtNome, jTxtCidade, jTxtNome, jTxtNumerocasa, jTxtNacionalidade, jFmtCep, jFmtTelefone, jFmtRg, jCboSexo, jBtnCancelar, jBtnConfirmar, jTxtEstado);
        Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);

        if (Util.perguntar("deseja excluir o registro?")== true) {
        Util.habilitar(false, jFmtDataNasce,jFmtCPF ,jTxtRua,jTxtIdUsuario ,jTxtIdCliente, jTxtComplemento ,jTxtEmail, jTxtNome, jTxtCidade, jTxtNome, jTxtNumerocasa,jTxtNacionalidade, jFmtCep, jFmtTelefone, jFmtRg, jCboSexo, jTxtEstado, jBtnCancelar, jBtnConfirmar, jBtnExcluir);
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        clienteMabs = viewBean();
        clientesDAO.delete(clienteMabs);
        Util.mensagem("Registro excluido");
        } else {
            Util.mensagem("Exclusão cancelada");
        }
        Util.limparCampos(jFmtCPF ,jFmtDataNasce,jTxtRua,jTxtIdUsuario ,jTxtIdCliente,jTxtComplemento , jTxtEmail, jTxtNome, jTxtCidade, jTxtNome, jTxtNumerocasa,
                jTxtNacionalidade, jFmtCep, jFmtTelefone, jFmtRg, jCboSexo, jTxtEstado, jBtnCancelar);

                                          
       
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        //Util.habilitar(false, jFmtCPF,jTxtRua,jTxtComplemento, jTxtIdUsuario ,jTxtIdCliente, jTxtEmail, jTxtNome, jTxtCidade, jTxtNome, jTxtNumerocasa, jTxtNacionalidade, jFmtCep, jFmtTelefone, jFmtRg, jCboSexo, jBtnExcluir, jBtnConfirmar, jBtnCancelar, jTxtEstado);
        //Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnPesquisar);
        ClienteMabs clienteMabs = viewBean();
        ClientesDAO clientesDAO = new ClientesDAO();

        if(incluindo==true){
        clientesDAO.insert(clienteMabs);
        }else{
        clientesDAO.update(clienteMabs);
        }
        Util.habilitar(false,jFmtDataNasce,jFmtCPF,jTxtRua,jTxtComplemento, jTxtIdUsuario ,jTxtIdCliente, jTxtEmail, jTxtNome, jTxtCidade, jTxtNome, jTxtNumerocasa, jTxtNacionalidade, jFmtCep, jFmtTelefone, jFmtRg, jCboSexo, jBtnExcluir, jBtnConfirmar, jBtnCancelar, jTxtEstado);
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnPesquisar);
        Util.limparCampos( jFmtDataNasce,jFmtCPF,jTxtRua,jTxtComplemento, jTxtIdUsuario ,jTxtIdCliente, jTxtEmail, jTxtNome, jTxtCidade, jTxtNome, jTxtNumerocasa, jTxtNacionalidade, jFmtCep, jFmtTelefone, jFmtRg, jCboSexo);
                                     

    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jTxtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtIdClienteActionPerformed

    private void jTxtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtEmailActionPerformed

    private void jFmtRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtRgActionPerformed

    private void jTxtRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtRuaActionPerformed

    private void jTxtComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtComplementoActionPerformed

    private void jFmtDataNasceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtDataNasceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtDataNasceActionPerformed

    private void jTxtIdUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtIdUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtIdUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgClientes dialog = new JDlgClientes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<String> jCboSexo;
    private javax.swing.JFormattedTextField jFmtCPF;
    private javax.swing.JFormattedTextField jFmtCep;
    private javax.swing.JFormattedTextField jFmtDataNasce;
    private javax.swing.JFormattedTextField jFmtRg;
    private javax.swing.JFormattedTextField jFmtTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTxtCidade;
    private javax.swing.JTextField jTxtComplemento;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtEstado;
    private javax.swing.JTextField jTxtIdCliente;
    private javax.swing.JTextField jTxtIdUsuario;
    private javax.swing.JTextField jTxtNacionalidade;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtNumerocasa;
    private javax.swing.JTextField jTxtRua;
    // End of variables declaration//GEN-END:variables
}
