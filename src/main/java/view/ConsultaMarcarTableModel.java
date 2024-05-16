package view;

import java.util.List;
import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;


public class ConsultaMarcarTableModel extends GenericTableModel{
    public ConsultaMarcarTableModel(List vDados){
        super(vDados, new String[]{"ID", "Animal","Cliente"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal a = (Animal) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return a.getId();
                
            case 1:
                int idAnimal = a.getId();
                Animal animal2 = AnimalDAO.getInstance().retrieveById(idAnimal);
                return animal2.getNome();
                
            case 2:
                Cliente cliente = ClienteDAO.getInstance().retrieveById(a.getIdCliente());
                return cliente.getNome();
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }    
       
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //Animal a = (Animal) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                break;
                
            case 1:               
                break;
                
            case 2:
                break;
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        //AnimalDAO.getInstance().update(a);
    }    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
