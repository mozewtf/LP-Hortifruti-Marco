/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import bean.ClienteMabs;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MARCO
 */
public class ClientesControle extends AbstractTableModel {
  List lista;
    
    public void setList(List lista){
    this.lista = lista;
    this.fireTableDataChanged();
    };
    public ClienteMabs getBean(int row){
    return (ClienteMabs)lista.get(row);
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
       
        ClienteMabs clienteMabs = (ClienteMabs) lista.get(rowIndex);
        if (columnIndex == 0){
        return clienteMabs.getIdClienteMabs();
        }
        if (columnIndex == 1 && clienteMabs.getUsuariosMabs() != null){
        return clienteMabs.getUsuariosMabs().getIdUsuariosMabs();        
        }
        if (columnIndex == 2){
        return clienteMabs.getTelefoneMabs();
        }
        if (columnIndex == 3){
        return clienteMabs.getEmailMabs();
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        if (column == 0){
        return "ID cliente";
        }
        
        if (column == 1){
        return "FK usuario";
        }
        if (column == 2){
        return "telefone";
        }
        if (column == 3){
        return "estado";
        }
               
        return "";
      };
}
