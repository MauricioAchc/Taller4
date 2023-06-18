public class NodoPokemon {

    /**
     * Corresponde al pokemon de tipo Pokemon.
     */
    private Pokemon pokemon;

    /**
     * Corresponde siguiente del NodoPokemon.
     */
    private NodoPokemon siguiente;

    /**
     * Corresponde al anterior del NodoPokemon.
     */
    private NodoPokemon anterior;


    /**
     * Constructor de la clase NodoPokemon.
     * @param pokemon Corresponde al pokemon..
     */
    public NodoPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.siguiente = null;
        this.anterior = null;
    }


    /**
     * Método de la clase que obtiene al pokemon.
     * @return pokemon solicitado.
     */
    public Pokemon getPokemon() {
        return pokemon;
    }


    /**
     * Método de la clase que inserta al pokemon.
     */
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }


    /**
     * Método de la clase que obtiene el pokemon siguiente..
     */
    public NodoPokemon getSiguiente() {
        return siguiente;
    }




    /**
     * Método de la clase que inserta al siguiente.
     */
    public void setSiguiente(NodoPokemon siguiente) {
        this.siguiente = siguiente;
    }


    /**
     * Método de la clase que obtiene al anterior.
     */
    public NodoPokemon getAnterior() {
        return anterior;
    }


    /**
     * Método de la clase que inserta al anterior.
     */
    public void setAnterior(NodoPokemon anterior) {
        this.anterior = anterior;
    }
}
