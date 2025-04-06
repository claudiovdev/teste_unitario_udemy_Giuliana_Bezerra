package br.com.exemplo.swplanetaapi.domain.service;

import br.com.exemplo.swplanetaapi.domain.Planet;
import br.com.exemplo.swplanetaapi.domain.repository.PlanetRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static br.com.exemplo.swplanetaapi.common.PlanetConstants.INVALIDPLANET;
import static br.com.exemplo.swplanetaapi.common.PlanetConstants.NAME;
import static br.com.exemplo.swplanetaapi.common.PlanetConstants.PLANET;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;


import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest(classes = PlanetService.class)
class PlanetServiceTest {

    @InjectMocks
    private PlanetService planetService;

    @Mock
    private PlanetRepository planetRepository;


    @Test
    public void createPlanet_WithValidate_ReturnPlanet(){

        when(planetRepository.save(PLANET)).thenReturn(PLANET);

        Planet sut = planetService.create(PLANET);

        Assertions.assertThat(sut).isEqualTo(PLANET);
    }

    @Test
    public void createPlanet_WithInvalidData_ThrowsException(){

        when(planetRepository.save(INVALIDPLANET)).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> planetService.create(INVALIDPLANET));
    }

    @Test
    public void getPlanet_ByExistingId_ReturnPlanet(){
        when(planetRepository.findById(1L)).thenReturn(Optional.of(PLANET));

        Optional<Planet> planeta = planetService.get(1L);

        assertThat(planeta).isNotEmpty();
        assertThat(planeta.get()).isEqualTo(PLANET);
    }
    @Test
    public void getPlanet_byUnexistingId_ReturnEmpty(){
        when(planetRepository.findById(anyLong())).thenReturn(Optional.empty());

        Optional<Planet> planet = planetService.get(1L);

        assertThat(planet).isEmpty();

    }
    @Test
    public void getPlanet_ByExistingName_returnsPlanet(){
        when(planetRepository.findByName(NAME)).thenReturn(Optional.of(PLANET));

        Optional<Planet> planet = planetService.getByName(NAME);

        assertThat(planet).isNotEmpty();
        assertThat(planet.get()).isEqualTo(PLANET);
    }

    @Test
    public void getPlanet_byUnexistingName_ReturnsEmpty(){
        when(planetRepository.findByName(NAME)).thenReturn(Optional.empty());

        Optional<Planet> planet = planetService.getByName(NAME);

        assertThat(planet).isEmpty();
    }

    @Test
    public void listPlanest_ReturnAllPlanets(){
        List<Planet> planets = new ArrayList<>();
        planets.add(PLANET);

        Example<Planet> query = QueryBuilder.makeQuery(new Planet(PLANET.getTerrain(),PLANET.getClimate()));

        when(planetRepository.findAll(query)).thenReturn(planets);

        List<Planet> result = planetService.list(PLANET.getTerrain(),PLANET.getClimate());

        assertThat(result).isNotNull();
    }

    @Test
    public void listPlanets_returnsNoPlanets(){
        when(planetRepository.findAll((Example<Planet>) any())).thenReturn(Collections.emptyList());

        List<Planet> result = planetService.list(PLANET.getTerrain(),PLANET.getClimate());
        assertThat(result).isEmpty();

    }

}