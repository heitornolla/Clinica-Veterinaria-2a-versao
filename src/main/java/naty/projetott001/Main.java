
package naty.projetott001;

public class Main {
    public static void main(String[] args) {
        //ClienteDAO.getInstance().create("Nataly", "Limeira", "13482-385", "natalysapeca", "(11)99495-5410");
            
        System.out.println(ClienteDAO.getInstance().retrieveAll());
    }
}
