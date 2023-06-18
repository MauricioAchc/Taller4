public class SistemaPokedexImpl implements  SistemaPokedex{


    /**
     * Corresponde a la lista de los pokemons del sistema.
     */
    private  ListaPokemon listaPokemon;


    /**
     * Corresponde al constructor de la clase SistemaPokedexImpl.
     */
    public SistemaPokedexImpl() {
        this.listaPokemon = new ListaPokemon();
    }



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
    @Override
    public boolean regitrarPokemons(int id, String nombre, String etapa, String evolucionSiguiente, String evolucionPrevia, String tipo1, String tipo2) {

        Pokemon nuevoPokemon = new Pokemon(id, nombre, etapa, evolucionSiguiente, evolucionPrevia, tipo1, tipo2);
        return this.listaPokemon.agregarPokemon(nuevoPokemon);
    }



    /**
     * Método que despliega los pokemons según el rango.
     * @return "listaPokemon".
     */

    public String[] desplegarPokemonSegunRango(){

        this.listaPokemon.ordenarPokemonsIdCreciente();
        String[] listaPokemon = new String[this.listaPokemon.getCantPokemons()];
        for (int i = 0; i < this.listaPokemon.getCantPokemons(); i++) {
            listaPokemon[i] = String.valueOf(this.listaPokemon.obtenerPokemon(i).getNombre());
        }
        return listaPokemon;
    }




    /**
     * Método que despliega los pokemons del sistema en un orden alfabetico.
     * @return "listaPokemon".
     */
    public String[] desplegarPokemonAlfabetico(){

        this.listaPokemon.ordenarPokemons();
        String[] listaPokemon = new String[this.listaPokemon.getCantPokemons()];
        for (int i = 0; i < this.listaPokemon.getCantPokemons(); i++) {
            listaPokemon[i] = this.listaPokemon.obtenerPokemon(i).getNombre();
        }
        return listaPokemon;
    }



    /**
     * Método que despliega los pokemons del sistema dado un tipo en particular.
     * @param tipo Corresponde al tipo del pokemon.
     * @return "listaPokemon".
     */
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



    /**
     * Método que despliega los pokemons del sistema en su primera evolución.
     * @return "listaPokemon".
     */
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



    /**
     * Método que despliega los pokemons del sistema en su segunda evolución.
     * @return "listaPokemon".
     */
    public String[] desplegarSegundaEvolucion(){
        this.listaPokemon.ordenarPokemons();
        String[] listaPokemon = new String[this.listaPokemon.getCantPokemons()];
        for (int i = 0; i < this.listaPokemon.getCantPokemons(); i++) {
            if (this.listaPokemon.obtenerPokemon(i).getEvolucionSiguiente().equalsIgnoreCase("Segunda Evolucion")){
                listaPokemon[i] = this.listaPokemon.obtenerPokemon(i).getNombre();
            }
        }
        return listaPokemon;


    }



    /**
     * Método que obtiene los nombres de los pokemons del sistema.
     * @param nombre Corresponde al nombre de los pokemons.
     * @return "listaPokemon".
     */
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



    /**
     * Método que obtiene los id de los pokemons del sistema.
     * @param id Corresponde a la id de los pokemons dentro del sistema.
     * @return "listaPokemon".
     */
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



    /**
     * Método busca de forma personalizada los pokemons .
     * @return null.
     */
    public Pokemon busquedaPersonalizada(){
        return null;
    }


    /**
     * Método permite salir del menu principal.
     */
    public void salirMenuPrincipal(){
    }


    /**
     * Método permite salir del sistema.
     */
    public void salir(){
    }
}
