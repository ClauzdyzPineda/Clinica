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

@Entity
@Table(name = "auditoria")
public class Auditoria implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_auditoria;
    
     @Column(name = "accion")
     private String accion;
     
    @ManyToOne
    @JoinColumn(name = "id_user")    
    private Usuario id_user;
    
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;

    public Auditoria() {
    }

    public int getId_auditoria() {
        return id_auditoria;
    }

    public void setId_auditoria(int id_auditoria) {
        this.id_auditoria = id_auditoria;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Usuario getId_user() {
        return id_user;
    }

    public void setId_user(Usuario id_user) {
        this.id_user = id_user;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id_auditoria;
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
        final Auditoria other = (Auditoria) obj;
        if (this.id_auditoria != other.id_auditoria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Auditoria{" + "id_auditoria=" + id_auditoria + '}';
    }
        
}
