package br.com.exemplo.swplanetaapi.domain.repository;

import br.com.exemplo.swplanetaapi.domain.Planet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.assertj.core.api.Assertions;


import static br.com.exemplo.swplanetaapi.common.PlanetConstants.PLANET;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class PlanetRepositoryTest {

    @Autowired
    private PlanetRepository repository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void createPlanet_WithValidate_ReturnPlanet(){
        Planet planet = repository.save(PLANET);

        Planet result = testEntityManager.find(Planet.class, planet.getId());

        assertThat(result).isNotNull();

        assertThat(result.getNome()).isEqualTo(PLANET.getNome());
    }

}