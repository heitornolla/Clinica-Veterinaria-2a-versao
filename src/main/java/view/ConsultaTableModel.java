package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;
import model.Consulta;
import model.ConsultaDAO;
import model.Veterinario;
import model.VeterinarioDAO;


public class ConsultaTableModel extends GenericTableModel{
    public ConsultaTableModel(List vDados){
        super(vDados, new String[]{"ID", "Animal", "Dono", "Data", "Horario", "Veterinario", "Comentario", "Status"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return int.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class; 
            case 4:
                return String.class;   
            case 5:
                return String.class;
            case 6:
                return String.class;
            case 7:
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
                return c.getId();
                
            case 1:
             
                Animal animal = AnimalDAO.getInstance().retrieveById(c.getIdAnimal());
                if(animal != null){
                return animal.getNome();
                }
                else{
                    return "Sem dados";
                }
                
            case 2:
                Animal animal1 = AnimalDAO.getInstance().retrieveById(c.getIdAnimal());
                if(animal1 != null){
                Cliente cliente = ClienteDAO.getInstance().retrieveById(animal1.getIdCliente());
                      if(cliente != null) {
                        return cliente.getNome();
                    }
                    else{
                        return "Sem dados";
                    }
                }else{
                    return "Sem dados";
                }
                
            case 3:
                return c.getData();
                
            case 4:
                return c.getHorario(); 
                
            case 5:
                Veterinario veterinario = VeterinarioDAO.getInstance().retrieveById(c.getIdVeterinario());
                if (veterinario != null) {
                    return veterinario.getNome();
                } else {
                    return "";
                }
                
            case 6:
                return c.getComentario();
                
            case 7:
                return c.getTerminado();
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }    
       
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Consulta c = (Consulta) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                break;
                
            case 1:
                break;
                
            case 2:
                break;
            
            case 3:
                String textoData = (String)aValue;
                
                if (!textoData.matches("[0-9()-/]*")) {
                    return;
                }

                String diaString = textoData.substring(0, 2);
                String mesString = textoData.substring(textoData.indexOf('/') + 1, textoData.lastIndexOf('/'));
                String anoString = textoData.substring(textoData.lastIndexOf('/') + 1);

                int diaInserido = Integer.parseInt(diaString);
                int mesInserido = Integer.parseInt(mesString);
                int anoInserido = Integer.parseInt(anoString);

                LocalDate dataAtual = LocalDate.now();
                int diaAtual = dataAtual.getDayOfMonth();
                int mesAtual = dataAtual.getMonthValue();
                int anoAtual = dataAtual.getYear();

                if ((diaInserido < diaAtual && mesInserido <= mesAtual && anoInserido <= anoAtual)
                        || diaInserido > 31 || mesInserido > 12) {
                    return;
                } else {
                    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar dataCalendar = Calendar.getInstance();

                    try {
                        dataCalendar.setTime(formatoData.parse(textoData));
                    } catch (ParseException e) {
                        e.printStackTrace(); 
                    }
                    
                    c.setData(dataCalendar);
                }
                break;
                                
            case 4:
                String horario = (String)aValue;
                if (!horario.matches("[0-9()-:]*") || horario.length() != 5) {
                    return;
                }
                c.setHorario(horario);
                break;
                
            case 5:
                break;
                
            case 6:
                c.setComentario((String)aValue);
                break;
            case 7:
                int status = (Integer)aValue;
                if (status < 0 || status > 1) {
                    return;
                } else {
                    c.setTerminado((Integer)aValue);
                }
                break;
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        ConsultaDAO.getInstance().update(c);
    }    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }

}
