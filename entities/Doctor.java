package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "doctor")
public class Doctor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_doctor;
    
    @ManyToOne
    @JoinColumn(name = "id_especialidad")    
    private Especialidad id_especialidad;
    
    @ManyToOne
    @JoinColumn(name = "id_persona")    
    private Persona id_persona;
    
    @ManyToOne
    @JoinColumn(name = "id_clinica")    
    private Clinica id_clinica;
    
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

    public Persona getId_persona() {
        return id_persona;
    }

    public void setId_persona(Persona id_persona) {
        this.id_persona = id_persona;
    }   

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Clinica getId_clinica() {
        return id_clinica;
    }

    public void setId_clinica(Clinica id_clinica) {
        this.id_clinica = id_clinica;
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

    @Override
    public String toString() {
        return "Doctor{" + "id_doctor=" + id_doctor + '}';
    }
    
    
    
    
    
    
}
