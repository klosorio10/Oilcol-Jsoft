/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kl.osorio10
 */
@Entity
public class ReporteEntity implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
            @NotNull
    @Column(name = "create_at", updatable = false)
    @Temporal(TemporalType.DATE)
    private Calendar createdAt;
 
    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Calendar updatedAt;
    
    private String zonaGeo;
    
    private String estado;

    private String region;
    
    private CampoEntity[] campos;
    
    private String emergencia;
    
    private double consumoCrudo;
    
    private double consumoAgua;
    
    private String temporalidad;

    public ReporteEntity(String zona, String estado,String region, String emergencia, double consumoCrudo, double consumoagua, String temporalidad) {
        zonaGeo =zona;
        this.estado=estado;
        this.region=region;
        this.emergencia=emergencia;
        this.consumoCrudo = consumoCrudo;
        this.consumoAgua = consumoagua;
        this.temporalidad = temporalidad;
    }
    
            @PreUpdate
    private void updateTimestamp() {
        this.updatedAt = Calendar.getInstance();
    }
 
    @PrePersist
    private void creationTimestamp() {
        this.createdAt = this.updatedAt = Calendar.getInstance();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZonaGeo() {
        return zonaGeo;
    }

    public void setZonaGeo(String zonaGeo) {
        this.zonaGeo = zonaGeo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public CampoEntity[] getCampos() {
        return campos;
    }

    public void setCampos(CampoEntity[] campos) {
        this.campos = campos;
    }

    public String getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(String emergencia) {
        this.emergencia = emergencia;
    }

    public double getConsumoCrudo() {
        return consumoCrudo;
    }

    public void setConsumoCrudo(double consumoCrudo) {
        this.consumoCrudo = consumoCrudo;
    }

    public double getConsumoAgua() {
        return consumoAgua;
    }

    public void setConsumoAgua(double consumoAgua) {
        this.consumoAgua = consumoAgua;
    }

    public String getTemporalidad() {
        return temporalidad;
    }

    public void setTemporalidad(String temporalidad) {
        this.temporalidad = temporalidad;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteEntity)) {
            return false;
        }
        ReporteEntity other = (ReporteEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.ReporteEntity[ id=" + id + " ]";
    }
    
}
