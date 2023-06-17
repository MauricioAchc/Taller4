public class ListaPokemon {
    private NodoPokemon cabeza;
    private int cantPokemons;

    public ListaPokemon() {
        this.cabeza = null;
        this.cantPokemons = 0;
    }

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

    public NodoPokemon getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoPokemon cabeza) {
        this.cabeza = cabeza;
    }

    public int getCantPokemons() {
        return cantPokemons;
    }

    public void setCantPokemons(int cantPokemons) {
        this.cantPokemons = cantPokemons;
    }
}
