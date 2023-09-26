package com.example.msbanqueamine.web;

import com.example.msbanqueamine.entities.Compte;
import com.example.msbanqueamine.repositories.CompteRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component//pour dire que c'est un composant spring
@Path("/banque")//path utilise pour consulter le web service
public class CompteRestJaxRSAPI {
    @Autowired//pour injecter le repository dans le web service
    private CompteRepository compteRepository;
    @Path("/comptes")//path utilise pour consulter le web service
    @GET//pour dire que c'est une methode de type get cad une methode qui va etre executé lorsqu'on va faire une requete de type get
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})//pour dire que la methode va retourner un json cad un objet de type json
    public List<Compte> compteList(){//cette methode va retourner une liste de comptes
        return compteRepository.findAll();
    }
    @Path("/comptes/{id}")//path utilise pour consulter le web service
    @GET//pour dire que c'est une methode de type get cad une methode qui va etre executé lorsqu'on va faire une requete de type get
    @Produces({MediaType.APPLICATION_JSON})//pour dire que la methode va retourner un json cad un objet de type json
    public Compte getOne(@PathParam(value = "id") Long id){//cette methode va retourner un compte dont l'id est passé en parametre
        return compteRepository.findById(id).get();
    }


    @Path("/comptes")//path utilise pour consulter le web service
    @POST//pour dire que c'est une methode de type post cad une methode qui va etre executé lorsqu'on va faire une requete de type post
    @Produces({MediaType.APPLICATION_JSON})//pour dire que la methode va retourner un json cad un objet de type json
    public Compte save(Compte compte){//cette method permet d'ajouter un compte dans la base de données
        return compteRepository.save(compte);
    }


    @Path("/comptes/{id}")//path utilise pour consulter le web service
    @PUT//pour dire que c'est une methode de type put cad une methode qui va etre executé lorsqu'on va faire une requete de type put
    @Produces({MediaType.APPLICATION_JSON})//pour dire que la methode va retourner un json cad un objet de type json
    public Compte update(Compte compte, @PathParam("id") Long id){//cette method permet de modifier un compte dans la base de données
        compte.setId(id);//pour dire que l'id du compte est celui passé en parametre
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")//path utilise pour consulter le web service
    @DELETE//pour dire que c'est une methode de type delete cad une methode qui va etre executé lorsqu'on va faire une requete de type delete
    @Produces({MediaType.APPLICATION_JSON})//pour dire que la methode va retourner un json cad un objet de type json
    public void delete(@PathParam("id") Long id){//cette methode va retourner une liste de comptes
        compteRepository.deleteById(id);
    }
}
