/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

public class SensorDTO{

    private Long id;

    private String tipo;
    
    private double estado;
    
    private double limiteNormal;

    
 
    public SensorDTO(){
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
 public double getEstado() {
        return estado;
    }

    public void setEstado(double estado) {
        this.estado = estado;
    }
    
    public double getLimiteNormal() {
        return limiteNormal;
    }

    public void setLimiteNormal(double limiteNormal) {
        this.limiteNormal = limiteNormal;
    }
}
