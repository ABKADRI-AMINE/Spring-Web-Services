package com.example.msbanqueamine;

import com.example.msbanqueamine.entities.Client;
import com.example.msbanqueamine.entities.Compte;
import com.example.msbanqueamine.entities.TypeCompte;
import com.example.msbanqueamine.repositories.ClientRepository;
import com.example.msbanqueamine.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class MsBanqueAmineApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBanqueAmineApplication.class, args);
    }
@Bean
//pour tester notre application on va utiliser la methode start qui va etre executé au demarrage de l'application
    CommandLineRunner start(CompteRepository compteRepository, RepositoryRestConfiguration restConfiguration, ClientRepository clientRepository){
        return args -> {
            restConfiguration.exposeIdsFor(Compte.class);//pour dire que l'id de la classe compte est exposé cad on peut l'afficher dans le navigateur
            Client c1 = clientRepository.save(new Client(null, "amine", null));
            Client c2 = clientRepository.save(new Client(null, "mohamed", null));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT, c1));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE, c1));
            compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT, c2));
            //afficher les comptes  dans la console
            compteRepository.findAll().forEach(c->{
                System.out.println(c.getSolde());
            });
        };
    }
}
