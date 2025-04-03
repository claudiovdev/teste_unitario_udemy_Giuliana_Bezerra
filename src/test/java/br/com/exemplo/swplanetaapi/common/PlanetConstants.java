package br.com.exemplo.swplanetaapi.common;

import br.com.exemplo.swplanetaapi.domain.Planet;

public class PlanetConstants {
    public static final Planet PLANET = new Planet("name", "climate", "terreno");
    public static final Planet INVALIDPLANET = new Planet("", "", "");
    public static final String NAME = "SATURNO";


}
