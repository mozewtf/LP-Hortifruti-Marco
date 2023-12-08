/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;


import bean.ComprasMabs;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marco
 */
public class ComprasControle extends AbstractTableModel{
      List lista;
    
    public void setList(List lista){
    this.lista = lista;
    this.fireTableDataChanged();
    };
    public ComprasMabs getBean(int row){
    return (ComprasMabs)lista.get(row);
    }
    
    @Override
    public int getRowCount() {
       return lista.size();
    }
  
    @Override
    public int getColumnCount() {
return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
      ComprasMabs comprasMabs = (ComprasMabs) lista.get(rowIndex);
        if (columnIndex == 0){
        return comprasMabs.getIdComprasMabs();
        }
        if (columnIndex == 1 && comprasMabs.getFornecedorMabs() != null){
        return comprasMabs.getFornecedorMabs().getIdFornecedorMabs();
        }

        if (columnIndex == 2){
        return comprasMabs.getQuantidadeMabs();
        }
        if (columnIndex == 3){
        return comprasMabs.getTotalMabs();
        }
      return "";
    }
    
    @Override
    public String getColumnName(int column){
        if (column == 0){
        return "Numero da Compras";
        }
        if (column == 1){
        return "Cliente";
        }
        if (column == 2){
        return "Quantidade";
        }
        if (column == 3){
        return "Total";
        }
               
        return "";
    };
}
