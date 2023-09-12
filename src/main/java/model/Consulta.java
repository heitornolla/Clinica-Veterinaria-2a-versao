/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Calendar;

/**
 *
 * @author Naty
 */
public class Consulta {

    private int id;
    private Calendar data;
    private String horario;
    private String comentario;
    private int id_animal;
    private int id_vet;
    private int id_tratamento;
    private int terminado;
    
    public Consulta(int id, Calendar data, String horario, String comentario, int id_animal, int id_vet, int id_tratamento, int terminado) {
        this.id = id;
        this.data = data;
        this.horario = horario;
        this.comentario = comentario;
        this.id_animal = id_animal;
        this.id_vet = id_vet;
        this.id_tratamento = id_tratamento;
        this.terminado = terminado;
    }

    public int getId() {
        return id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public int getId_vet() {
        return id_vet;
    }

    public void setId_vet(int id_vet) {
        this.id_vet = id_vet;
    }

    public int getId_tratamento() {
        return id_tratamento;
    }

    public void setId_tratamento(int id_tratamento) {
        this.id_tratamento = id_tratamento;
    }

    public int getTerminado() {
        return terminado;
    }

    public void setTerminado(int terminado) {
        this.terminado = terminado;
    }
    
    @Override
    public String toString() {        
        String desc = "Consulta{" + "id=" + id + ", data=" + data + ", horario=" + horario + ", comentario=" + comentario + ", id_animal" + id_animal + ", id_vet=" + id_vet + ", id_tratamento=" + id_tratamento + ", terminado=" + terminado + '}';
        return desc;
    }    
}
