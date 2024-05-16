package view;

import java.util.Calendar;
import java.util.List;
import model.Consulta;
import model.Exame;
import model.ExameDAO;

public class ConsultaHistoricoTableModel extends GenericTableModel{
    public ConsultaHistoricoTableModel(List vDados){
        super(vDados, new String[]{"Data", "Horario","Comentario", "Exame", "Status"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Calendar.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class; 
            case 4:
                return Integer.class;

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Consulta c = (Consulta) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return c.getData();
                
            case 1:
                return c.getHorario(); 
                
            case 2:
                return c.getComentario();
                
            case 3:
                Exame exame = ExameDAO.getInstance().retrieveById(c.getId());
                if(exame != null) { 
                    return exame.getNome();
                } else {
                    return "";
                }
                
            case 4:
                return c.getTerminado();
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }    
       
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //Consulta c = (Consulta) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                break;
                
            case 1:
                break;
                
            case 2:
                break;
                
            case 3:
                break;
                
            case 4:
                break;
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        //ConsultaDAO.getInstance().update(c);
    }    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
