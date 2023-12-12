/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import bean.ComprasProdutoMabs;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marco
 */
public class ComprasProdutoControle extends AbstractTableModel {

  
         List lista;


     public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

   
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

     public ComprasProdutoMabs getBean(int linha) {
        return (ComprasProdutoMabs) lista.get(linha);
    }
    
    public void addBean(ComprasProdutoMabs comprasProdutoMabs) {
            lista.add(comprasProdutoMabs);
            this.fireTableDataChanged();
    }
    
    public void removeBean(int index) {
            lista.remove(index);
            this.fireTableDataChanged();
    }
    
    public void updateBean(int index, ComprasProdutoMabs comprasProdutoMabs){
        lista.set(index, comprasProdutoMabs);
        this.fireTableDataChanged();
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       ComprasProdutoMabs comprasProduto = (ComprasProdutoMabs) lista.get(rowIndex);
        if (columnIndex == 0) {
            return comprasProduto.getIdComprasProdutoMabs();
        }
        if (columnIndex == 1) {
            return comprasProduto.getProdutosMabs();
        }
        if (columnIndex == 2) {
            return comprasProduto.getQuantidadeMabs();
        }
        if (columnIndex == 3) {
            return comprasProduto.getValorunitarioMabs();
        }
        
        return "";
    }
    
    
    
    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "ID da compra do Produto";
        }
        if (columnIndex == 1) {
            return "Produto";
        }
        if (columnIndex == 2) {
            return "Quantidade";
        }
        if (columnIndex == 3) {
            return "Valor Unitário";
        }
        
        return null;
    }
    
}
