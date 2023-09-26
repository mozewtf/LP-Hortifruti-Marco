/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.FornecedorMabs;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MARCO
 */
public class FornecedorControle extends AbstractTableModel{
    
    List lista;
    
    public void setList(List lista){
    this.lista = lista;
    };
    public FornecedorMabs getBean(int row){
    return (FornecedorMabs)lista.get(row);
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
       
      FornecedorMabs fornecedorMabs = (FornecedorMabs) lista.get(rowIndex);
        if (columnIndex == 0){
        return fornecedorMabs.getIdFornecedorMabs();
        }
        if (columnIndex == 1){
        return fornecedorMabs.getTelefoneMabs();
        }
        if (columnIndex == 2){
        return fornecedorMabs.getSexoMabs();
        }
        if (columnIndex == 3){
        return fornecedorMabs.getNacionalidadeMabs();
        }
      return "";
    }
    
    @Override
    public String getColumnName(int column){
        if (column == 0){
        return "id";
        }
        if (column == 1){
        return "Telefone";
        }
        if (column == 2){
        return "Sexo";
        }
        if (column == 3){
        return "Nacionalidade";
        }
               
        return "";
    };
}