package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EspecieDAO extends DAO {
    private static EspecieDAO instance;
    
    private EspecieDAO(){
        getConnection();
        createTable();
    }
    
    public static EspecieDAO getInstance(){
        return (instance==null?(instance = new EspecieDAO()):instance);
    }
    
    public Especie create(String nome){
        try{
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO especie (nome) VALUES (?)");
            stmt.setString(1,nome);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(EspecieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("especie","id"));
    }
    
    private Especie buildObject(ResultSet rs){
        Especie especie = null;
        try{
            especie = new Especie(rs.getInt("id"), rs.getString("nome"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return especie;
    }
    
    public List retrieve(String query){
        List<Especie> especies = new ArrayList();
        ResultSet rs = getResultSet(query);
        try{
            while(rs.next()) {
                especies.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return especies;
    }
    
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM especie");
    }
    
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM especie WHERE id = " + lastId("especie", "id"));
    }
    
    public Especie retrieveById(int id){
        List<Especie> especies = this.retrieve("SELECT * FROM especie WHERE id = " + id);
        return (especies.isEmpty() ? null : especies.get(0));
    }
    
    public Especie retrieveByName(String nome){
        List<Especie> especies = this.retrieve("SELECT * FROM especie WHERE nome = '" + nome + "'");
        return (especies.isEmpty() ? null : especies.get(0));
    }
    
    public List retrieveBySimilarName(String nome){
        return this.retrieve("SELECT * FROM especie WHERE nome LIKE '%" + nome + "%'");
    }
    
    public void update(Especie especie){
        try{
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE especie SET nome=? WHERE id=?");
            stmt.setString(1, especie.getNome());
            stmt.setInt(2, especie.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    public void delete(Especie especie){
        PreparedStatement stmt;
        try{
           stmt = DAO.getConnection().prepareStatement("DELETE FROM especie WHERE id = ?");
            stmt.setInt(1, especie.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}