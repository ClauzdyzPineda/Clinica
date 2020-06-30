/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author Saker
 */
@Entity
@Table(name = "doctor")
public class Doctor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_doctor;
    
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad")
    @ManyToOne
    private Especialidad id_especialidad;
    
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne
    private Especialidad id_persona;
    
    @Column(name = "info")
    private String info;

    public Doctor() {
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public Especialidad getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(Especialidad id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public Especialidad getId_persona() {
        return id_persona;
    }

    public void setId_persona(Especialidad id_persona) {
        this.id_persona = id_persona;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_doctor;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Doctor other = (Doctor) obj;
        if (this.id_doctor != other.id_doctor) {
            return false;
        }
        return true;
    }
    
    
    
    
}
