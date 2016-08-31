
package dto;

import java.util.List;

/**
 *
 * @author Johan
 */
public class CampoDTO {
 
    private Long id;

    private String nombre;
    
    private String ciudad;
        

    
    private List<PozoDTO>pozos;

    
    
    public CampoDTO(){
        
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

      

    public List<PozoDTO> getPozos() {
        return pozos;
    }

    public void setPozos(List<PozoDTO> pozos) {
        this.pozos = pozos;
    }
   
}
