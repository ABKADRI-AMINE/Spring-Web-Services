package com.example.msbanqueamine.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @ManyToOne//pour dire que plusieurs comptes peuvent appartenir à un seul client
//    private Client client;
@OneToMany(mappedBy ="client")//un client peut avoir plusieurs comptes
private Collection<Compte> comptes;
}
