/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import bean.UsuariosMabs;
import bean.FornecedorMabs;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;
import dao.FornecedorDAO;
/**
 *
 * @author MARCO    
 */
public class JDlgFornecedorNovoIA extends javax.swing.JDialog {
    MaskFormatter mascaraCep;
    
    /**
     * Creates new form JDlgVendedorIA
     */
    public JDlgFornecedorNovoIA(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
                setLocationRelativeTo(null);
                try{  
            mascaraCep = new MaskFormatter("#####-###");
      } catch(ParseException ex) {
          Logger.getLogger(JDlgProdutoNovoIA.class.getName()).log(Level.SEVERE, null, ex);
      }
        jFmtCep.setFormatterFactory(new DefaultFormatterFactory(mascaraCep));
 
    }
    public FornecedorMabs viewBean(){
    FornecedorMabs fornecedorMabs = new FornecedorMabs();
    fornecedorMabs.setIdFornecedorMabs(Util.strInt(jTxtIdFornecedor.getText()));
    UsuariosMabs usuariosMabs = new UsuariosMabs();
    fornecedorMabs.setUsuariosMabs(Util.strInt(jTxtIdUsuario.getText()));
    fornecedorMabs.setUsuariosMabs(usuariosMabs);
    if (jCboSexo.getSelectedIndex() == 0){
    fornecedorMabs.setSexoMabs("M");
    } else {
    fornecedorMabs.setSexoMabs("F");}
    fornecedorMabs.setTelefoneMabs(jFmtTelefone.getText());
    fornecedorMabs.setRuaMabs(jTxtRua.getText());
    fornecedorMabs.setNumerohomeMabs(jTxtNumeroHome.getText());
    fornecedorMabs.setComplementoMabs(jTxtComplemento.getText());
    fornecedorMabs.setEstadoMabs(jTxtEstado.getText());
    fornecedorMabs.setNacionalidadeMabs(jTxtNacionalidade.getText());
    fornecedorMabs.setCepMabs(jFmtCep.getText());
    fornecedorMabs.setCidadeMabs(jTxtCidade.getText());
    return fornecedorMabs;
    }
    
    public void beanView(FornecedorMabs fornecedorMabs){
    jTxtIdFornecedor.setText(Util.intStr(fornecedorMabs.getIdFornecedorMabs()));
//    
    if(fornecedorMabs.getSexoMabs()=="M"){
    jCboSexo.setSelectedIndex(0);
    }else{
    jCboSexo.setSelectedIndex(1);}
    fornecedorMabs.setTelefoneMabs(jFmtTelefone.getText());
    fornecedorMabs.setRuaMabs(jTxtRua.getText());
    fornecedorMabs.setNumerohomeMabs(jTxtNumeroHome.getText());
    fornecedorMabs.setComplementoMabs(jTxtComplemento.getText());
    fornecedorMabs.setEstadoMabs(jTxtEstado.getText());
    fornecedorMabs.setNacionalidadeMabs(jTxtNacionalidade.getText());
    fornecedorMabs.setCepMabs(jFmtCep.getText());
    fornecedorMabs.setCidadeMabs(jTxtCidade.getText());
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jTxtIdUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCboSexo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTxtNacionalidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtEstado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxtCidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBtnOk1 = new javax.swing.JButton();
        jBTnCancelar1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTxtIdFornecedor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTxtRua = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTxtNumeroHome = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTxtComplemento = new javax.swing.JTextField();
        jFmtCep = new javax.swing.JFormattedTextField();
        jFmtTelefone = new javax.swing.JFormattedTextField();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTxtIdUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtIdUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Id de usuário");

        jLabel2.setText("jLabel2");

        jLabel3.setText("Telefone");

        jLabel4.setText("Sexo");

        jCboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        jCboSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboSexoActionPerformed(evt);
            }
        });

        jLabel5.setText("Nacionalidade");

        jTxtNacionalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNacionalidadeActionPerformed(evt);
            }
        });

        jLabel6.setText("Estado");

        jTxtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtEstadoActionPerformed(evt);
            }
        });

        jLabel7.setText("Cidade");

        jLabel8.setText("CEP");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jBtnOk1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmar.png"))); // NOI18N
        jBtnOk1.setText("OK");
        jBtnOk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOk1ActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnOk1);

        jBTnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBTnCancelar1.setText("Cancelar");
        jBTnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTnCancelar1ActionPerformed(evt);
            }
        });
        jPanel1.add(jBTnCancelar1);

        jLabel9.setText("Id de Fornecedor");

        jLabel10.setText("Rua");

        jTxtRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtRuaActionPerformed(evt);
            }
        });

        jLabel11.setText("Numero");

        jLabel12.setText("Complemento");

        jTxtComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtComplementoActionPerformed(evt);
            }
        });

        jFmtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtCepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtIdFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTxtRua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1))
                            .addComponent(jTxtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jFmtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtNumeroHome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jTxtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 54, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(125, 125, 125))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(jTxtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(jFmtCep))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTxtNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(179, 179, 179))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtIdUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTxtIdFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jFmtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNumeroHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCboSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboSexoActionPerformed

    private void jTxtNacionalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNacionalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNacionalidadeActionPerformed

    private void jTxtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtEstadoActionPerformed

    private void jBtnOk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOk1ActionPerformed
   FornecedorMabs fornecedorMabs  = viewBean();
   FornecedorDAO.insert(fornecedorMabs);
        setVisible(false);
    }//GEN-LAST:event_jBtnOk1ActionPerformed

    private void jBTnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTnCancelar1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jBTnCancelar1ActionPerformed

    private void jTxtRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtRuaActionPerformed

    private void jTxtComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtComplementoActionPerformed

    private void jFmtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtCepActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgFornecedorNovoIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgFornecedorNovoIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgFornecedorNovoIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgFornecedorNovoIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgFornecedorNovoIA dialog = new JDlgFornecedorNovoIA(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBTnCancelar1;
    private javax.swing.JButton jBtnOk1;
    private javax.swing.JComboBox<String> jCboSexo;
    private javax.swing.JFormattedTextField jFmtCep;
    private javax.swing.JFormattedTextField jFmtTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTxtCidade;
    private javax.swing.JTextField jTxtComplemento;
    private javax.swing.JTextField jTxtEstado;
    private javax.swing.JTextField jTxtIdFornecedor;
    private javax.swing.JTextField jTxtIdUsuario;
    private javax.swing.JTextField jTxtNacionalidade;
    private javax.swing.JTextField jTxtNumeroHome;
    private javax.swing.JTextField jTxtRua;
    // End of variables declaration//GEN-END:variables
}
