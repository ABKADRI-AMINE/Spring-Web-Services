//package com.example.msbanqueamine.web;
//
//import com.example.msbanqueamine.entities.Compte;
//import com.example.msbanqueamine.repositories.CompteRepository;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//@Component//pour dire que c'est un composant spring
//@WebService(serviceName = "BanqueWS")//pour dire que c'est un web service
//public class CompteSoapService {
//    @Autowired//pour injecter le repository dans le web service
//    private CompteRepository compteRepository;
//
//    @WebMethod//pour changer le nom de la methode
//    public List<Compte> compteList() {//cette methode va retourner une liste de comptes
//        return compteRepository.findAll();
//    }
//
//    @WebMethod//pour changer le nom de la methode
//
//    public Compte getOne(@WebParam(name = "id") Long id) {//cette methode va retourner un compte dont l'id est passé en parametre
//        return compteRepository.findById(id).get();
//    }
//}
