package com.example.msbanqueamine.web;

import com.example.msbanqueamine.entities.Compte;
import com.example.msbanqueamine.repositories.CompteRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@RestController//pour dire que c'est un web service rest
@RequestMapping("/banque")//pour dire que le web service est accessible par le chemin /banque
public class CompteRestControllerAPI {
    @Autowired//pour injecter le repository dans le web service
    private CompteRepository compteRepository;
    @GetMapping(path = "/comptes", produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})//pour dire que c'est une methode de type get cad une methode qui va etre executé lorsqu'on va faire une requete de type get   et pour dire que la methode va retourner un json cad un objet de type json
    public List<Compte> compteList(){//cette methode va retourner une liste de comptes
        return compteRepository.findAll();
    }
    @GetMapping(path = "/comptes/{id}", produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})//pour dire que c'est une methode de type get cad une methode qui va etre executé lorsqu'on va faire une requete de type get   et pour dire que la methode va retourner un json cad un objet de type json
public Compte getOne(@PathVariable Long id){//cette methode va retourner un compte dont l'id est passé en parametre
        return compteRepository.findById(id).get();
    }

@PostMapping(path="/comptes")//pour dire que c'est une methode de type post cad une methode qui va etre executé lorsqu'on va faire une requete de type post
    public Compte save(@RequestBody Compte compte){//cette method permet d'ajouter un compte dans la base de données et @requestbody permet de dire que le compte est passé en parametre

        return compteRepository.save(compte);
    }


    @PutMapping("/comptes/{id}")//pour dire que c'est une methode de type put cad une methode qui va etre executé lorsqu'on va faire une requete de type put
    public Compte update(@RequestBody Compte compte, @PathVariable Long id){//cette method permet de modifier un compte dans la base de données
        compte.setId(id);//pour dire que l'id du compte est celui passé en parametre
        return compteRepository.save(compte);
    }

@DeleteMapping("/comptes/{id}")//pour dire que c'est une methode de type delete cad une methode qui va etre executé lorsqu'on va faire une requete de type delete
    public void delete(@PathVariable("id") Long id){//cette methode va retourner une liste de comptes
        compteRepository.deleteById(id);
    }
}
