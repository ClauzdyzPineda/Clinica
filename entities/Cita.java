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
@Table(name = "cita")
public class Cita implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cita;
    
     @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona id_persona;
     
     @JoinColumn(name = "id_doctor", referencedColumnName = "id_doctor")
    @ManyToOne
    private Doctor id_doctor;
     
     @Column(name = "comentario")
     private String comentario;

    public Cita() {
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public Persona getId_persona() {
        return id_persona;
    }

    public void setId_persona(Persona id_persona) {
        this.id_persona = id_persona;
    }

    public Doctor getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Doctor id_doctor) {
        this.id_doctor = id_doctor;
    }

    
    

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id_cita;
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
        final Cita other = (Cita) obj;
        if (this.id_cita != other.id_cita) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cita{" + "id_cita=" + id_cita + '}';
    }
     
     
    
}
