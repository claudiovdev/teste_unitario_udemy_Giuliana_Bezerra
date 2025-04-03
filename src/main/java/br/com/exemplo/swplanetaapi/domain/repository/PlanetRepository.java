package br.com.exemplo.swplanetaapi.domain.repository;

import br.com.exemplo.swplanetaapi.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
