package br.com.exemplo.swplanetaapi.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planets")
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String climate;
    private String terrain;

    public Planet( String nome, String climate, String terrain) {

        this.nome = nome;
        this.climate = climate;
        this.terrain = terrain;
    }

    public Planet() {
    }

    public Planet(String terrain, String climate) {
        this.terrain = terrain;
        this.climate = climate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(obj, this);
    }
}
