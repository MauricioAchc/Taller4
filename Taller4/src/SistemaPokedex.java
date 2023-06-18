public interface SistemaPokedex {



    /**
     * Método que registra pokemons en el sistema.
     * @param id Corresponde al identificador del pokemon.
     * @param nombre Corresponde al nombre del pokemon.
     * @param etapa Corresponde a la etapa del pokemon.
     * @param evolucionPrevia Corresponde a la evolución previa del pokemon.
     * @param evolucionSiguiente Corresponde a la evolución siguiente del pokemon.
     * @param tipo1 Corresponde al primer tipo del pokemon.
     * @param tipo2 Corresponde al segundo tipo del pokemon.
     * @return "this.listaPokemon.agregarPokemon(nuevoPokemon)".
     */
    public boolean regitrarPokemons(int id, String nombre, String etapa, String evolucionSiguiente, String evolucionPrevia, String tipo1, String tipo2);


    /**
     * Método que despliega los pokemons según el rango.
     * @return "listaPokemon".
     */
    public String[] desplegarPokemonSegunRango();


    /**
     * Método que despliega los pokemons del sistema en un orden alfabetico.
     * @return "listaPokemon".
     */
    public String[] desplegarPokemonAlfabetico();


    /**
     * Método que despliega los pokemons del sistema dado un tipo en particular.
     * @param tipo Corresponde al tipo del pokemon.
     * @return "listaPokemon".
     */
    public String[] desplegarPokemonDadoTipo(String tipo);


    /**
     * Método que despliega los pokemons del sistema en su primera evolución.
     * @return "listaPokemon".
     */
    public String[] desplegarPokemonPrimeraEvolucion();

    /**
     * Método que despliega los pokemons del sistema en su segunda evolución.
     * @return "listaPokemon".
     */
    public String[] desplegarSegundaEvolucion();


    /**
     * Método que obtiene los nombres de los pokemons del sistema.
     * @param nombre Corresponde al nombre de los pokemons.
     * @return "listaPokemon".
     */
    public String[] obtenerPokemonNombre(String nombre);


    /**
     * Método que obtiene los id de los pokemons del sistema.
     * @param id Corresponde a la id de los pokemons dentro del sistema.
     * @return "listaPokemon".
     */
    public String[] obtenerPokemonId(int id);



    /**
     * Método que busca de forma personalizada los pokemons dentro del sistema.
     */
    public Pokemon busquedaPersonalizada();



    /**
     * Método que permite salir del menu principal dentro del sistema.
     */
    public void salirMenuPrincipal();
}
