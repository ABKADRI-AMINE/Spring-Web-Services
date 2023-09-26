package com.example.msbanqueamine.entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@XmlRootElement//pour dire que c'est un objet xml qui va etre retourné par le web service
@Entity//pour dire que c'est une entité JPA cad une classe qui va etre mappé avec une table dans la base de données
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Compte {
    @Id//pour dire que c'est la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)//pour dire que c'est une clé primaire auto incrémenté dans la base de données
    private Long id;
    private double solde;
    @Temporal(TemporalType.DATE)//@Temporal pour dire que c'est une date et @TemporalType pour dire que c'est une date sans heure
    private Date dateCreation;
//    @Enumerated(EnumType.ORDINAL)//pour dire que c'est un enum et EnumType.ORDINAL pour dire que c'est un enum de type entier au niveau de la bd l'attribut type sera d type numerique par ex comte cournat sera 0 et compte epargne sera 1 il va utiliser des nombres pour stocker les valeurs de l'enum
    @Enumerated(EnumType.STRING)//pour dire que c'est un enum et EnumType.STRING pour dire que c'est un enum de type chaine de caractere au niveau de la bd l'attribut type sera d type chaine de caractere par ex comte cournat sera COURANT et compte epargne sera EPARGNE il va utiliser des chaines de caractere pour stocker les valeurs de l'enum
    @Column(length = 10)//pour dire que la longueur de l'attribut type sera de 10 caractere
    private TypeCompte type;
    @ManyToOne//pour dire que plusieurs comptes peuvent appartenir à un seul client
    private Client client;
}
