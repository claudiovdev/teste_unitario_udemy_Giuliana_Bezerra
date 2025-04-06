package br.com.exemplo.swplanetaapi.domain.service;

import br.com.exemplo.swplanetaapi.domain.Planet;
import br.com.exemplo.swplanetaapi.domain.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {
    private PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet create(Planet planet){
        return  planetRepository.save(planet);
    }

    public Optional<Planet> get(Long id) {
        return planetRepository.findById(id);
    }

    public Optional<Planet> getByName(String nome) {
        return planetRepository.findByName(nome);
    }

    public List<Planet> list(String terrain, String climate) {
        Example<Planet> query = QueryBuilder.makeQuery(new Planet(terrain,climate));
        return  planetRepository.findAll(query);
    }
}
