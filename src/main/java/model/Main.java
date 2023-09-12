
package model;

public class Main {
    public static void main(String[] args) {
        //ClienteDAO.getInstance().create("Nataly", "Limeira", "13482-385", "natalysapeca", "(11)99495-5410");
         
        //AnimalDAO.getInstance().create("Nataly", 2004, "F", 14, 07);
        System.out.println(AnimalDAO.getInstance().retrieveAll());
    }
}
