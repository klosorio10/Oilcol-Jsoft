/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author kl.osorio10
 */
@Entity
public class PozoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    private String nombre;

    private String estado;
    
    private double temperatura;

    private double consumoEnergetico;
    
    private double numeroBarriles;
    
    private boolean emergencia; 
    
    @ManyToOne(cascade=ALL)
    private CampoEntity campo;

   
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    @Override
    public String toString() {
        return "models.PozoEntity[ id=" + id + " ]";
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(double consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public double getNumeroBarriles() {
        return numeroBarriles;
    }

    public void setNumeroBarriles(double numeroBarriles) {
        this.numeroBarriles = numeroBarriles;
    }

    public boolean isEmergencia() {
        return emergencia;
    }

    public void setEmergencia(boolean emergencia) {
        this.emergencia = emergencia;
    }
    
     public CampoEntity getCampo() {
        return campo;
    }

    public void setCampo(CampoEntity campo) {
        this.campo = campo;
    }
    
}
