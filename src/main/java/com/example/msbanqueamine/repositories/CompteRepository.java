package com.example.msbanqueamine.repositories;

import com.example.msbanqueamine.entities.Compte;
import com.example.msbanqueamine.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {//la classe qu on veut gerer est de type compte ainsi que l'id est de type Long
@RestResource(path = "/byType")//pour changer le nom de la methode findByType en byType
    public List<Compte> findByType(@Param("t")TypeCompte type);//pour chercher les comptes par type
}
