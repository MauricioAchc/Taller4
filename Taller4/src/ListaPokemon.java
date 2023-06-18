public class ListaPokemon {


    /**
     * Entidad que representa al nodo del sistema.
     */
    private NodoPokemon cabeza;

    /**
     * Corresponde a la cantidad de pokemons del sistema.
     */
    private int cantPokemons;


    /**
     * Constructor de la clase ListaPokemon.
     */
    public ListaPokemon() {
        this.cabeza = null;
        this.cantPokemons = 0;
    }




    /**
     * Método que agrega un pokemon al sistema.
     * @param pokemon Corresponde al pokemons que se va ingresar.
     * @return "true" si se agregó correctamente al sistema, o "false" si no se pudo arreglar.
     */
    public boolean agregarPokemon(Pokemon pokemon){

        NodoPokemon nuevoPokemon = new NodoPokemon(pokemon);
        if (this.cabeza == null){
            this.cabeza = nuevoPokemon;
            this.cantPokemons++;
            return true;
        }

        NodoPokemon aux = this.cabeza;
        for (int i = 0; i < this.cantPokemons; i++) {
            if (aux.getPokemon().getId() == pokemon.getId()){
                return false;
            }
            aux = aux.getSiguiente();
        }
        aux = this.cabeza;
        while (aux.getSiguiente() != null){
            aux = aux.getSiguiente();
        }

        aux.setSiguiente(nuevoPokemon);
        nuevoPokemon.setAnterior(aux);
        this.cantPokemons++;
        return true;
    }



    /**
     * Método que obtiene el pokemon según su posición.
     * @param  posicion Corresponde a la posición en la que encuentra el pokemons.
     */
    public Pokemon obtenerPokemon(int posicion){

        if (posicion < 0 || posicion >= this.cantPokemons){
            return null;
        }
        NodoPokemon aux = this.cabeza;
        for (int i = 0; i < posicion; i++) {
            aux = aux.getSiguiente();
        }
        return aux.getPokemon();
    }



    /**
     * Método que ordena los pokemons en el sistema.
     * @param pokemon Corresponde al pokemons que se va ingresar.
     * @return "true" si se agregó correctamente al sistema, o "false" si no se pudo arreglar.
     */
    public void ordenarPokemons(){

        NodoPokemon aux1 = this.cabeza;

        for (int i = 0; i < this.cantPokemons-1; i++) {
            NodoPokemon aux2 = aux1.getSiguiente();
            for (int j = i+1; j < this.cantPokemons; j++) {
                Pokemon pokemon1 = aux1.getPokemon();
                Pokemon pokemon2 = aux2.getPokemon();
                if (pokemon1.getNombre().compareTo(pokemon2.getNombre()) > 0){
                    aux1.setPokemon(pokemon2);
                    aux2.setPokemon(pokemon1);
                }
                aux2 = aux2.getSiguiente();
            }
            aux1 = aux1.getSiguiente();
        }
    }



    /**
     * Método que ordena los pokemons según la id en orden creciente dentro del sistema.
     */
    public void ordenarPokemonsIdCreciente(){

        NodoPokemon aux1 = this.cabeza;

        for (int i = 0; i < this.cantPokemons-1; i++) {
            NodoPokemon aux2 = aux1.getSiguiente();
            for (int j = i+1; j < this.cantPokemons; j++) {
                Pokemon pokemon1 = aux1.getPokemon();
                Pokemon pokemon2 = aux2.getPokemon();
                if (pokemon1.getId() > pokemon2.getId()){
                    aux1.setPokemon(pokemon2);
                    aux2.setPokemon(pokemon1);
                }
                aux2 = aux2.getSiguiente();
            }
            aux1 = aux1.getSiguiente();
        }
    }



    /**
     * Método que ordena los pokemons según la id en orden decreciente dentro del sistema.
     */
    public void ordenarPokemonsIdDecreciente(){

        NodoPokemon aux1 = this.cabeza;

        for (int i = 0; i < this.cantPokemons-1; i++) {
            NodoPokemon aux2 = aux1.getSiguiente();
            for (int j = i+1; j < this.cantPokemons; j++) {
                Pokemon pokemon1 = aux1.getPokemon();
                Pokemon pokemon2 = aux2.getPokemon();
                if (pokemon1.getId() < pokemon2.getId()){
                    aux1.setPokemon(pokemon2);
                    aux2.setPokemon(pokemon1);
                }
                aux2 = aux2.getSiguiente();
            }
            aux1 = aux1.getSiguiente();
        }
    }


    /**
     * Método que busca los pokemons según el tipo dentro del sistema.
     */
    public boolean buscarPokemonTipo(String tipo){

        if (this.cabeza == null){
            return false;
        }
        NodoPokemon actual = this.cabeza;
        while (actual != null){
            if (actual.getPokemon().getTipo1().equals(tipo) || actual.getPokemon().getTipo2().equals(tipo)){
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }





    /**
     * Este método obtiene la cabeza del nodo dentro de la lista.
     */
    public NodoPokemon getCabeza() {
        return cabeza;
    }


    /**
     * Este método inserta la cabeza del nodo dentro de la lista.
     */
    public void setCabeza(NodoPokemon cabeza) {
        this.cabeza = cabeza;
    }



    /**
     * Este método obtiene la cantidad de pokemons de la lista.
     * @return un entero con la cantidad de pokemons. Si no hay clientes retorna 0.
     */
    public int getCantPokemons() {
        return cantPokemons;
    }




    /**
     * Este método inserta la cantidad de los pokemons dentro de la lista.
     */
    public void setCantPokemons(int cantPokemons) {
        this.cantPokemons = cantPokemons;
    }
}
