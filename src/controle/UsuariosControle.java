/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import bean.UsuariosMabs;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MARCO
 */
public class UsuariosControle  extends AbstractTableModel{
    
    List lista;
    
    public void setList(List lista){
    this.lista = lista;
    };
    public UsuariosMabs getBean(int row){
    return (UsuariosMabs)lista.get(row);
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
       
      UsuariosMabs usuariosMabs = (UsuariosMabs) lista.get(rowIndex);
        if (columnIndex == 0){
        return usuariosMabs.getIdUsuariosMabs();
        }
        if (columnIndex == 1){
        return usuariosMabs.getNomeMabs();
        }
        if (columnIndex == 2){
        return usuariosMabs.getNicknameMabs();
        }
        if (columnIndex == 3){
        return usuariosMabs.getCpfMabs();
        }
      return "";
    }
    
    @Override
    public String getColumnName(int column){
        if (column == 0){
        return "id";
        }
        if (column == 1){
        return "nome";
        }
        if (column == 2){
        return "nickname";
        }
        if (column == 3){
        return "cpf";
        }
               
        return "";
    };
}
