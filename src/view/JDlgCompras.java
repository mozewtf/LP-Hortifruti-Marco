/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import bean.ClienteMabs;
import bean.FornecedorMabs;
import bean.ComprasMabs;
import bean.ComprasProdutoMabs;
import dao.ClientesDAO;
import dao.FornecedorDAO;
import dao.ProdutosDAO;
import dao.ComprasDAO;
import dao.ComprasProdutoDAO;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;
import controle.ComprasControle;
import controle.ComprasProdutoControle;


/**
 *
 * @author marco
 */
public class JDlgCompras extends javax.swing.JDialog {
   
    private boolean incluindo;
    ComprasDAO comprasDAO;
    ComprasMabs comprasMabs;
    ComprasControle comprasControle;
    ComprasProdutoMabs comprasProdutoMabs;
    ComprasProdutoDAO comprasProdutoDAO;
    ComprasProdutoControle comprasProdutoControle;
    ClienteMabs clienteMabs;
    JDlgComprasPesquisa  jDlgComprasPesquisa;
    FornecedorDAO fornecedorDAO;
    FornecedorMabs fornecedorMabs;
    JDlgComprasProdutos jDlgComprasProdutos;
    
    /**
     * Creates new form JDlgCompras
     */
   public JDlgCompras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Tela compra");
        Util.habilitar(false, jTxtIdCompra, jTxtQuantidade, jTxttotal, jCboCliente, jCboFornecedor, jBtnAlterarVp, jBtnExcluirVp,jBtnIncluirVp, jBtnConfirmar, jBtnCancelar );
        setLocationRelativeTo(null);
        comprasDAO = new ComprasDAO();
       
       
        
        ClientesDAO clientesDAO = new ClientesDAO();
        List listaCli = clientesDAO.listAll(); 
        for (int i = 0; i < listaCli.size(); i++) {
        jCboCliente.addItem((ClienteMabs) listaCli.get(i));
        }
        
         fornecedorDAO = new FornecedorDAO();
        List listaFornecedor = fornecedorDAO.listAll();
        for (int i = 0; i < listaFornecedor.size(); i++) {
            fornecedorMabs = (FornecedorMabs) listaFornecedor.get(i);
            jCboFornecedor.addItem(fornecedorMabs);
        }
        
         comprasProdutoControle = new ComprasProdutoControle();
         List lista = new ArrayList();
        comprasProdutoControle.setList(lista);
        jTable1.setModel(comprasProdutoControle);

    }


     public ComprasMabs viewBean() {
       comprasMabs = new ComprasMabs();
       int id = Util.strInt(jTxtIdCompra.getText());
       comprasMabs.setIdComprasMabs(id);
       comprasMabs.setQuantidadeMabs(jTxtQuantidade.getText());
       comprasMabs.setClienteMabs((ClienteMabs) jCboCliente.getSelectedItem());
       comprasMabs.setFornecedorMabs((FornecedorMabs)jCboFornecedor.getSelectedItem());
       double total = Util.strDouble(jTxttotal.getText());
        comprasMabs.setTotalMabs(total);
        return comprasMabs;
    }
     

    public void beanView(ComprasMabs compras) {
        comprasMabs = compras;
        jTxtIdCompra.setText(String.valueOf(compras.getIdComprasMabs()));
        jTxtQuantidade.setText((compras.getQuantidadeMabs()));
        jCboCliente.setSelectedItem(compras.getClienteMabs());
        jCboFornecedor.setSelectedItem(compras.getFornecedorMabs());
        jTxttotal.setText(String.valueOf(compras.getTotalMabs()));

       comprasProdutoDAO = new ComprasProdutoDAO();
       List listaProd = (List) comprasProdutoDAO.listProduct(comprasMabs);
       comprasProdutoControle.setList(listaProd);
    }

    
    public int getSelectedRowProd() {
        return jTable1.getSelectedRow();
    
    }
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jBtnIncluir = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTxtIdCompra = new javax.swing.JTextField();
        jCboCliente = new javax.swing.JComboBox<ClienteMabs>();
        jCboFornecedor = new javax.swing.JComboBox<FornecedorMabs>();
        jTxttotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBtnIncluirVp = new javax.swing.JButton();
        jBtnAlterarVp = new javax.swing.JButton();
        jBtnExcluirVp = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTxtQuantidade = new javax.swing.JFormattedTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto", "Quantidade", "Valor Unitario", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jCboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboClienteActionPerformed(evt);
            }
        });

        jLabel1.setText("Num. Compra");

        jLabel2.setText("Quantidade");

        jLabel3.setText("Cliente");

        jLabel4.setText("Fornecedor");

        jBtnIncluirVp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnIncluirVp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirVpActionPerformed(evt);
            }
        });

        jBtnAlterarVp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterarVp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarVpActionPerformed(evt);
            }
        });

        jBtnExcluirVp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBtnExcluirVp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirVpActionPerformed(evt);
            }
        });

        jLabel5.setText("Total");

        jTxtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtQuantidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1)
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTxtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jTxttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnIncluirVp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnAlterarVp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnExcluirVp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jTxtIdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(680, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluirVp, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAlterarVp, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnExcluirVp, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jTxtIdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(455, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAlterarVpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarVpActionPerformed
        jDlgComprasProdutos = new JDlgComprasProdutos(null, true);
        jDlgComprasProdutos.setTitle("Alteração de produtos");
        jDlgComprasProdutos.setTelaAnterior(this);
        int linSel = jTable1.getSelectedRow();
        ComprasProdutoMabs comprasProdutoMabs = (ComprasProdutoMabs)comprasProdutoControle.getBean(linSel);
        jDlgComprasProdutos.beanView(comprasProdutoMabs);
        jDlgComprasProdutos.setVisible(true);
    }//GEN-LAST:event_jBtnAlterarVpActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
      Util.habilitar(false, jBtnExcluir, jBtnIncluir, jBtnAlterar, jBtnPesquisar);

        if (comprasMabs != null) {
            
           comprasDAO = new ComprasDAO();
                ComprasProdutoMabs comprasProdutoMabs;
                for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                    comprasProdutoMabs = comprasProdutoControle.getBean(linha);
                    comprasDAO.delete(comprasProdutoMabs);}
                
                
            Util.habilitar(true, jTxtIdCompra, jTxtQuantidade, jTxttotal, jCboFornecedor, jCboCliente, jBtnAlterarVp, jBtnExcluirVp,jBtnIncluirVp, jBtnConfirmar, jBtnCancelar);
            Util.habilitar(false, jBtnExcluir, jBtnAlterar, jBtnIncluir, jBtnPesquisar);

        } else {
            Util.mensagem("faz pesquisa");
        }
        incluindo = false;
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnIncluirVpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirVpActionPerformed
       jDlgComprasProdutos = new JDlgComprasProdutos(null, true);
        jDlgComprasProdutos.setTitle("Inclusão produtos");
        jDlgComprasProdutos.setTelaAnterior(this);
        jDlgComprasProdutos.setVisible(true);
        
    }//GEN-LAST:event_jBtnIncluirVpActionPerformed

    private void jTxtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtQuantidadeActionPerformed

    private void jCboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboClienteActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
       Util.habilitar(true, jTxtIdCompra, jTxtQuantidade, jTxttotal, jCboCliente, jBtnConfirmar, jCboFornecedor);
        Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);

        if (Util.perguntar("deseja excluir o registro?")== true) {
        Util.habilitar(false, jTxtIdCompra, jTxtQuantidade, jTxttotal, jCboCliente, jCboFornecedor, jBtnCancelar, jBtnConfirmar, jBtnExcluir);
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        comprasMabs = viewBean();
        comprasDAO.delete(comprasMabs);
        Util.mensagem("Registro excluido");
        } else {
            Util.mensagem("Exclusão cancelada");
        }
       comprasProdutoControle.setList(new ArrayList());
        Util.limparCampos(jTxtIdCompra, jTxtQuantidade, jTxttotal, jCboCliente, jCboFornecedor, jBtnCancelar);
        comprasMabs = null;
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
 
        
        comprasMabs = viewBean();
        if (incluindo == true) {
           comprasDAO.insert(comprasMabs);
             comprasProdutoDAO = new ComprasProdutoDAO();
            
            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                comprasProdutoMabs = comprasProdutoControle.getBean(linha);
               comprasProdutoMabs.setComprasMabs(comprasMabs);
                  comprasProdutoDAO.insert(comprasProdutoMabs);  
            }
        } else {
            comprasDAO.update(comprasMabs);
            //remover todos os pedidos produtos deste pedido
            comprasProdutoDAO = new ComprasProdutoDAO();
            
        
            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
               comprasProdutoMabs = comprasProdutoControle.getBean(linha);
               comprasProdutoMabs.setComprasMabs(comprasMabs);
                comprasProdutoDAO.insert(comprasProdutoMabs);
               
            }
            
           
        }
        //habilitar(false);
        Util.limparCampos(jTxtIdCompra, jTxtQuantidade, jCboCliente, jCboFornecedor, jTxttotal);
        comprasProdutoControle.setList(new ArrayList());

        comprasMabs = null;
        
        Util.habilitar(false, jTxtIdCompra, jTxtQuantidade, jTxttotal, jCboCliente, jCboFornecedor, jBtnAlterarVp, jBtnExcluirVp,jBtnIncluirVp, jBtnConfirmar, jBtnCancelar);
        Util.habilitar(true, jBtnExcluir, jBtnAlterar, jBtnIncluir, jBtnPesquisar);



//       comprasMabs = viewBean();
// 
//        if(incluindo==true){
//        comprasDAO.insert(comprasMabs);
//        }else{
//        comprasDAO.update(comprasMabs);
//        }
//        Util.habilitar(false,  jTxtIdCompra, jTxtQuantidade, jTxttotal, jCboCliente, jCboFornecedor, jBtnExcluir, jBtnConfirmar, jBtnCancelar);
//        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnPesquisar);
//        Util.limparCampos(jTxtIdCompra, jTxtQuantidade, jTxttotal, jCboCliente, jCboFornecedor);
                      
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
       Util.limparCampos(jTxtIdCompra, jTxtQuantidade, jCboCliente, jCboFornecedor, jTxttotal);
        comprasProdutoControle.setList(new ArrayList());
        comprasMabs = null;
         Util.habilitar(false, jTxtIdCompra, jTxtQuantidade, jCboCliente, jCboFornecedor, jTxttotal, jBtnAlterarVp, jBtnExcluirVp,jBtnIncluirVp, jBtnConfirmar, jBtnCancelar);
        Util.habilitar(true, jBtnExcluir, jBtnAlterar, jBtnIncluir, jBtnPesquisar);
        
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        Util.habilitar(false ,jBtnAlterar, jBtnIncluir, jBtnExcluir, jBtnPesquisar);
        Util.habilitar(true, jTxtIdCompra, jTxtQuantidade, jTxttotal, jCboCliente, jBtnConfirmar, jBtnCancelar, jCboFornecedor);
        Util.limparCampos(jTxtIdCompra, jTxtQuantidade, jTxttotal, jCboCliente, jCboFornecedor);
        incluindo = true;
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
    JDlgComprasProdutos jDlgComprasProdutos = new JDlgComprasProdutos(null, true);
    jDlgComprasProdutos.setTelaAnterior(this);
    jDlgComprasProdutos.setVisible(true);
    Util.habilitar(false, jTxtIdCompra, jTxtQuantidade, jTxttotal, jCboCliente, jBtnExcluir, jBtnConfirmar, jBtnCancelar, jCboFornecedor);
    Util.habilitar(true,  jBtnAlterar, jBtnPesquisar, jBtnCancelar,jBtnExcluir);
    Util.habilitar(false, jBtnIncluir, jBtnConfirmar);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jBtnExcluirVpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirVpActionPerformed
       if (getSelectedRowProd() == -1) {
            Util.mensagem("no line selected brooo");
        } else {
            if (Util.perguntar("Confirmar a exclusion do produto") == true) {
                comprasProdutoControle.removeBean(getSelectedRowProd());
            }
        }
    }//GEN-LAST:event_jBtnExcluirVpActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgCompras dialog = new JDlgCompras(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnAlterarVp;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnExcluirVp;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnIncluirVp;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<ClienteMabs> jCboCliente;
    private javax.swing.JComboBox<FornecedorMabs> jCboFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtIdCompra;
    private javax.swing.JFormattedTextField jTxtQuantidade;
    private javax.swing.JTextField jTxttotal;
    // End of variables declaration//GEN-END:variables
}
