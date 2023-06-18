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

        this.listaPokemon.ordenarPokemonsIdCreciente();
        String[] listaPokemon = new String[this.listaPokemon.getCantPokemons()];
        for (int i = 0; i < this.listaPokemon.getCantPokemons(); i++) {
            listaPokemon[i] = String.valueOf(this.listaPokemon.obtenerPokemon(i).getNombre());
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
    public String[] desplegarPokemonDadoTipo(String tipo){

        this.listaPokemon.ordenarPokemons();
        String[] listaPokemon = new String[this.listaPokemon.getCantPokemons()];
        for (int i = 0; i < this.listaPokemon.getCantPokemons(); i++) {
            Pokemon pokemon = this.listaPokemon.obtenerPokemon(i);
            if (pokemon != null && pokemon.getTipo1().equalsIgnoreCase(tipo) || pokemon != null && pokemon.getTipo2().equalsIgnoreCase(tipo)){
                listaPokemon[i] = this.listaPokemon.obtenerPokemon(i).getNombre();
            }
        }
        return listaPokemon;
    }

    public String[] desplegarPokemonPrimeraEvolucion(){

        this.listaPokemon.ordenarPokemonsIdDecreciente();
        String[] listaPokemon = new String[this.listaPokemon.getCantPokemons()];
        for (int i = 0; i < this.listaPokemon.getCantPokemons(); i++) {
            if (this.listaPokemon.obtenerPokemon(i).getEtapa().equalsIgnoreCase("Primera Evolucion")){
                listaPokemon[i] = this.listaPokemon.obtenerPokemon(i).getNombre();
            }
        }
        return listaPokemon;
    }

    @Override
    public String[] obtenerPokemonNombre(String nombre) {

        String[] listaPokemon = new String[this.listaPokemon.getCantPokemons()];
        for (int i = 0; i < this.listaPokemon.getCantPokemons(); i++) {
            try{
                Pokemon pokemoni = this.listaPokemon.obtenerPokemon(i);
                if (pokemoni != null && pokemoni.getNombre().equalsIgnoreCase(nombre)){
                    listaPokemon[i] = pokemoni.toString();
                }
            }catch (Exception E){
                continue;
            }
        }
        return listaPokemon;
    }

    @Override
    public String[] obtenerPokemonId(int id) {
        String[] listaPokemon = new String[this.listaPokemon.getCantPokemons()];
        for (int i = 0; i < this.listaPokemon.getCantPokemons(); i++) {
            try{
                Pokemon pokemoni = this.listaPokemon.obtenerPokemon(i);
                if (pokemoni != null && pokemoni.getId() == id){
                    listaPokemon[i] = pokemoni.toString();
                }
            }catch (Exception E){
                continue;
            }
        }
        return listaPokemon;
    }

    public Pokemon busquedaPersonalizada(){
        return null;
    }

    public void salirMenuPrincipal(){
    }

    public void salir(){
    }
}
