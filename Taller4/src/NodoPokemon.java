public class NodoPokemon {
    private Pokemon pokemon;
    private NodoPokemon siguiente;
    private NodoPokemon anterior;

    public NodoPokemon(Pokemon pokemon, NodoPokemon siguiente, NodoPokemon anterior) {
        this.pokemon = pokemon;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public NodoPokemon getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPokemon siguiente) {
        this.siguiente = siguiente;
    }

    public NodoPokemon getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoPokemon anterior) {
        this.anterior = anterior;
    }
}
