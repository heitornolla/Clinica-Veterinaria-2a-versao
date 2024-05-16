package view;

import java.util.List;
import model.Cliente;
import model.ClienteDAO;

public class ClienteNomeTableModel extends GenericTableModel {
    public ClienteNomeTableModel(List vDados) {
        super(vDados, new String[]{"ID", "Nome"});
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0:
                return Integer.class;
            
            case 1:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = (Cliente) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return cliente.getId();
            
            case 1:
                return cliente.getNome();

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Cliente cliente = (Cliente) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                break;
            
            case 1:
                cliente.setNome((String) value);
                break;

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        ClienteDAO.getInstance().update(cliente);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0 && columnIndex != 4;
    }
}