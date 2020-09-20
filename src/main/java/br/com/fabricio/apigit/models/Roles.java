package br.com.fabricio.apigit.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles extends EntityBase {

    @Column(unique = true, length = 100)
    private String nome;
}
