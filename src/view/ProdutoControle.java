/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ProdutosMabs;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MARCO
 */

 public class ProdutoControle  extends AbstractTableModel{
    
    List lista;
    
    public void setList(List lista){
    this.lista = lista;
    this.fireTableDataChanged();
    };
    public ProdutosMabs getBean(int row){
    return (ProdutosMabs)lista.get(row);
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
       
      ProdutosMabs usuariosMabs = (ProdutosMabs) lista.get(rowIndex);
        if (columnIndex == 0){
        return usuariosMabs.getIdProdutosMabs();
        }
        if (columnIndex == 1){
        return usuariosMabs.getTipoMabs();
        }
        if (columnIndex == 2){
        return usuariosMabs.getPesoMabs();
        }
        if (columnIndex == 3){
        return usuariosMabs.getConservantesMabs();
        }
      return "";
    }
    
    @Override
    public String getColumnName(int column){
        if (column == 0){
        return "id";
        }
        if (column == 1){
        return "Tipo";
        }
        if (column == 2){
        return "Peso";
        }
        if (column == 3){
        return "Conservante";
        }
               
        return "";
    };
    
}
