/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;


/**
 *
 * @author kl.osorio10
 */
public class ReporteDTO {
 
 //   private date date;
    
    private String zonaGeo;
    
    private String estado;

    private String region;
    
    private CampoDTO[] campos;
    
    private String emergencia;
    
    private double consumoCrudo;
    
    private double consumoAgua;
    
    private String temporalidad;
    
    public ReporteDTO(){
        
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

    public CampoDTO[] getCampos() {
        return campos;
    }

    public void setCampos(CampoDTO[] campos) {
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
       
   
}
