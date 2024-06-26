package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExameDAO extends DAO{
    private static ExameDAO instance;
    
    private ExameDAO(){
        getConnection();
        createTable();
    }
    
    public static ExameDAO getInstance(){
        return (instance==null?(instance = new ExameDAO()):instance);
    }
    
    public Exame create(String nome, int idConsulta){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO exame (nome, id_consulta) VALUES (?,?)");
            stmt.setString(1,nome);
            stmt.setInt(2,idConsulta);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("exame","id"));
    }
    
    private Exame buildObject(ResultSet rs){
        Exame exame = null;
        try{
            exame = new Exame(rs.getInt("id"), rs.getString("nome"), rs.getInt("id_consulta"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return exame;
    }
    
    public List retrieve(String query){
        List<Exame> exames = new ArrayList();
        ResultSet rs = getResultSet(query);
        try{
            while(rs.next()) {
                exames.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return exames;
    }
    
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM exame");
    }
    
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM exame WHERE id = " + lastId("exame", "id"));
    }
    
    public Exame retrieveById(int id){
        List<Exame> exames = this.retrieve("SELECT * FROM exame WHERE id = " + id);
        return (exames.isEmpty() ? null : exames.get(0));
    }
    
    public List retrieveBySimilarName(String nome){
        return this.retrieve("SELECT * FROM exame WHERE nome LIKE '%" + nome + "%'");
    }
    
    public List retrieveByAppointment(int id){
        return this.retrieve("SELECT * FROM exame WHERE id_consulta = " + id);
    }
    
    public void update(Exame exame){
        try{
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE exame SET nome=?, id_consulta=? WHERE id=?");
            stmt.setString(1, exame.getNome());
            stmt.setInt(2, exame.getIdConsulta());
            stmt.setInt(3, exame.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    public void delete(Exame exame){
        PreparedStatement stmt;
        try{
           stmt = DAO.getConnection().prepareStatement("DELETE FROM exame WHERE id = ?");
            stmt.setInt(1, exame.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}