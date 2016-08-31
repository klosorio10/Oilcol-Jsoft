
package dto;

import java.util.List;

/**
 *
 * @author Johan
 */
public class PozoDTO {
 
    private Long id;

    private String nombre;
    
    private String estado;
    
    private double temperatura;

    private double consumoEnergetico;
    
    private double numeroBarriles;
    
    private boolean emergencia; 
 
    public PozoDTO(){
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
   
}
