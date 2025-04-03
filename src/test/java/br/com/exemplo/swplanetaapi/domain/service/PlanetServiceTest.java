package br.com.exemplo.swplanetaapi.domain.service;

import br.com.exemplo.swplanetaapi.domain.Planet;
import br.com.exemplo.swplanetaapi.domain.repository.PlanetRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static br.com.exemplo.swplanetaapi.common.PlanetConstants.INVALIDPLANET;
import static br.com.exemplo.swplanetaapi.common.PlanetConstants.PLANET;
@ExtendWith(MockitoExtension.class)
//@SpringBootTest(classes = PlanetService.class)
class PlanetServiceTest {

    @InjectMocks
    private PlanetService planetService;

    @Mock
    private PlanetRepository planetRepository;


    @Test
    public void createPlanet_WithValidate_ReturnPlanet(){

        Mockito.when(planetRepository.save(PLANET)).thenReturn(PLANET);

        Planet sut = planetService.create(PLANET);

        Assertions.assertThat(sut).isEqualTo(PLANET);
    }

    @Test
    public void createPlanet_WithInvalidData_ThrowsException(){
        planetService.create(INVALIDPLANET);
    }
}