public interface SistemaPokedex {

    public boolean regitrarPokemons(int id, String nombre, String etapa, String evolucionSiguiente, String evolucionPrevia, String tipo1, String tipo2);
    public String[] desplegarPokemonSegunRango();
    public String[] desplegarPokemonAlfabetico();
    public String[] desplegarPokemonDadoTipo(String tipo);
    public String[] desplegarPokemonPrimeraEvolucion();
    public String[] desplegarSegundaEvolucion();
    public String[] obtenerPokemonNombre(String nombre);
    public String[] obtenerPokemonId(int id);
    public Pokemon busquedaPersonalizada();
    public void salirMenuPrincipal();
}
