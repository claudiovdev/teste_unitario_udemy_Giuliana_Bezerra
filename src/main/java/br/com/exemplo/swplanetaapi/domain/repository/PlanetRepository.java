package br.com.exemplo.swplanetaapi.domain.repository;

import br.com.exemplo.swplanetaapi.domain.Planet;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> , QueryByExampleExecutor<Planet> {
    Optional<Planet> findByNome(String nome);

    @Override
    <S extends Planet> List<S> findAll(Example<S> exemple);
}
