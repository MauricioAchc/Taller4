public class SistemaPokedexImpl implements  SistemaPokedex{
    private  ListaPokemon listaPokemon;

    public SistemaPokedexImpl() {
        this.listaPokemon = new ListaPokemon();
    }

    @Override
    public boolean regitrarPokemons(int id, String nombre, String etapa, String evolucionSiguiente, String evolucionPrevia, String tipo1, String tipo2) {

        Pokemon nuevoPokemon = new Pokemon(id, nombre, etapa, evolucionSiguiente, evolucionPrevia, tipo1, tipo2);
        return this.listaPokemon.agregarPokemon(nuevoPokemon);
    }

    public String[] desplegarPokemonSegunRango(){

        this.listaPokemon.ordenarPokemonsId();
        String[] listaPokemon = new String[this.listaPokemon.getCantPokemons()];
        for (int i = 0; i < this.listaPokemon.getCantPokemons(); i++) {
            listaPokemon[i] = String.valueOf(this.listaPokemon.obtenerPokemon(i).getId());
        }
        return listaPokemon;
    }

    public String[] desplegarPokemonAlfabetico(){

        this.listaPokemon.ordenarPokemons();
        String[] listaPokemon = new String[this.listaPokemon.getCantPokemons()];
        for (int i = 0; i < this.listaPokemon.getCantPokemons(); i++) {
            listaPokemon[i] = this.listaPokemon.obtenerPokemon(i).getNombre();
        }
        return listaPokemon;
    }
    public String desplegarPokemonDadoTipo(){
        return null;
    }

    public String desplegarPokemonPrimeraEvolucion(){
        return null;
    }

    public Pokemon busquedaPersonalizada(){
        return null;
    }

    public void salirMenuPrincipal(){
    }

    public void salir(){



    }
}
