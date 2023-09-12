
package model;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        //ClienteDAO.getInstance().create("Nataly", "Limeira", "13482-385", "natalysapeca", "(11)99495-5410");
         
        //AnimalDAO.getInstance().create("Nataly", 2004, "F", 14, 07);
        
        //EspecieDAO.getInstance().create("natali");
        
        //VetDAO.getInstance().create("Naty", "natalysty@", "1234532");
        
       //ConsultaDAO.getInstance().create(a, 12, "aceitas", 1, 1, 1, 1);
       //nao sei testar essa bomba
       
       ExameDAO.getInstance().create("natyc", 13);
        System.out.println(ExameDAO.getInstance().retrieveAll());
    }
}
