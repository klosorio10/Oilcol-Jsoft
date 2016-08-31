/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dto.CampoDTO;
import dto.PozoDTO;
import main.PersistenceManager;
import models.Competitor;
import models.CompetitorDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.CampoEntity;
import models.PozoEntity;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Mauricio
 */
@Path("/oilcol")
@Produces(MediaType.APPLICATION_JSON)
public class OilcolService {

    @PersistenceContext(unitName = "Oilcol")
    EntityManager entityManager; 
    

     @PostConstruct
    public void init() {
        try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
   @GET
    @Path("/getCampos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Query q = entityManager.createQuery("select u from CampoEntity u order by u.id" );
        List<CampoEntity> campos = q.getResultList();
         for (int i=0;i<campos.size();i++){
             List<PozoEntity> lista=(List<PozoEntity>) campos.get(i).getPozos();
            for(int j=0;j<lista.size();j++){
                lista.get(j).setCampo(null);
            }
            campos.get(i).setPozos(lista);
         }
         return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(campos).build();
    } 
    
    @GET
    @Path("/getPozos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPozos() {
        Query q = entityManager.createQuery("select u from PozoEntity u order by u.id");
        List<PozoEntity> pozos = q.getResultList();
        for (int i=0;i<pozos.size();i++){
        CampoEntity campo= pozos.get(i).getCampo();
        campo.setPozos(null);
              
         }
           
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(pozos).build();
    } 
    
    @GET
    @Path("/getPozo/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPozo(@PathParam("id") Long id) {
        System.out.println("entro");
        PozoEntity pozo =entityManager.find(PozoEntity.class, id);
        PozoDTO encontrado=new PozoDTO();
        if(pozo!=null){
            encontrado.setId(pozo.getId());
            encontrado.setNombre(pozo.getNombre());
            encontrado.setConsumoEnergetico(pozo.getConsumoEnergetico());
            encontrado.setEmergencia(pozo.isEmergencia());
            encontrado.setEstado(pozo.getEstado());
            encontrado.setNumeroBarriles(pozo.getNumeroBarriles());
            encontrado.setTemperatura(pozo.getTemperatura());
        }
     return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(encontrado).build();
     } 
    
    

    @POST
    @Path("/agregarCampo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCampo(CampoDTO campo) {
        JSONObject rta = new JSONObject();
        CampoEntity campoTmp = new CampoEntity();
        campoTmp.setCiudad(campo.getCiudad());
        campoTmp.setNombre(campo.getNombre());
        
 
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(campoTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(campoTmp);
            rta.put("campo_id", campoTmp.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            campoTmp = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    } 
    
    
    @POST
    @Path("/agregarCampo2")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCampo2(CampoDTO campo) {
        JSONObject rta = new JSONObject();
        CampoEntity campoTmp = new CampoEntity();
        campoTmp.setCiudad(campo.getCiudad());
        campoTmp.setNombre(campo.getNombre());
        
        ArrayList<PozoEntity> lista=new ArrayList<PozoEntity>();
        //campoTmp.s
        for(int i=0;i<campo.getPozos().size();i++){
            PozoDTO pozo=campo.getPozos().get(i);
            PozoEntity nuevo=new PozoEntity();
            nuevo.setNombre(pozo.getNombre());
            nuevo.setCampo(campoTmp);
            lista.add(nuevo);
           try {
            entityManager.getTransaction().begin();
            entityManager.persist(nuevo);
            entityManager.getTransaction().commit();
            entityManager.refresh(nuevo);
           
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            campoTmp = null;
        } 
        }
        campoTmp.setPozos(lista);
         System.out.println("nuevo: "+campoTmp.getPozos().size());
        //
 
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(campoTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(campoTmp);
            rta.put("campo_id", campoTmp.getId());
            rta.put("pozos_id", campo.getPozos().size());
            rta.put("pozos_nuevos", campoTmp.getPozos().size());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            campoTmp = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    } 
    
    
    @POST
    @Path("/agregarPozo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPozo(PozoDTO campo) {
        JSONObject rta = new JSONObject();
        PozoEntity campoTmp = new PozoEntity();
        
        campoTmp.setNombre(campo.getNombre());
        //campoTmp.setNombre(campo.getNombre());
       // campoTmp.setPozos(campo.getPozos());        
 
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(campoTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(campoTmp);
            rta.put("pozo_id", campoTmp.getId());
           // rta.put("pozo_id", ((CampoDTO)campoTmp.getPozos().get(0)).getNombre());
            
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            campoTmp = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    } 
    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCompetitor(CompetitorDTO competitor) {
        JSONObject rta = new JSONObject();
        Competitor competitorTmp = new Competitor();
        competitorTmp.setAddress(competitor.getAddress());
        competitorTmp.setAge(competitor.getAge());
        competitorTmp.setCellphone(competitor.getCellphone());
        competitorTmp.setCity(competitor.getCity());
        competitorTmp.setCountry(competitor.getCountry());
        competitorTmp.setName(competitor.getName());
        competitorTmp.setSurname(competitor.getSurname());
        competitorTmp.setTelephone(competitor.getTelephone());
 
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(competitorTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(competitorTmp);
            rta.put("competitor_id", competitorTmp.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            competitorTmp = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    } 
    
    
       @POST
    @Path("/log")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginCompetitor(CompetitorDTO competitor) {
        JSONObject rta = new JSONObject();
        Competitor competitorTmp = new Competitor();
        competitorTmp.setUsername(competitor.getUsername());
        competitorTmp.setPassword(competitor.getPassword());

            Query q = entityManager.createQuery("select u from Competitor u where u.username='"+competitor.getUsername()+"' and u.password='"+competitor.getPassword()+"'");
             List<Competitor> competitors = q.getResultList();
             if(competitors.isEmpty())
             {
                 return Response.status(401).header("NotAuthorizedException", "*").build();
             }else
             {
                return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(competitors).build();
             }

    } 


}
