
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clinica")
public class Clinica implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_clinica;
    
    @Column(name = "clinica")
    private String clinica;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "sitio_web")
    private String sitio_web;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "estado")
    private int estado;

    public Clinica() {
    }

    public int getId_clinica() {
        return id_clinica;
    }

    public void setId_clinica(int id_clinica) {
        this.id_clinica = id_clinica;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSitio_web() {
        return sitio_web;
    }

    public void setSitio_web(String sitio_web) {
        this.sitio_web = sitio_web;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id_clinica;
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
        final Clinica other = (Clinica) obj;
        if (this.id_clinica != other.id_clinica) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clinica{" + "id_clinica=" + id_clinica + '}';
    }
        
}
