package com.latino.modele.service;

import com.latino.dao.PosteDAO;
import com.latino.modele.Poste;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/postes")
public class PosteRESTService {
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Poste poste) {
        System.out.println("create(Poste poste) : "+poste.toString());
        PosteDAO.add(poste);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") int id, Poste poste) {
        System.out.println("edit(@PathParam("+id+") int id, Poste poste) : "+poste.toString());
        PosteDAO.update(id, poste);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) {
        System.out.println("remove(@PathParam("+id+") int id)");
        PosteDAO.delete(id);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Poste find(@PathParam("id") int id) {
        System.out.println("find(@PathParam("+id+") int id) : ");
        return PosteDAO.getById(id);        
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Poste> findAll() {
        System.out.println("findAll() : ");
        return PosteDAO.getAll();        
    }

    @GET
    @Path("/nbMatch/{nbMatch}/langages/{langages}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Poste> findByLangages(@PathParam("nbMatch")int nb, @PathParam("langages") String lPostulants) {
        System.out.println("findByLangages(int "+nb+", String lPostulants) : "+lPostulants);
        return PosteDAO.getByLangages(nb, lPostulants);
    }
    
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        System.out.println("countREST() : "+ PosteDAO.getAll().size());
        return String.valueOf(PosteDAO.getAll().size());
    }
}
