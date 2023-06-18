public class Pokemon {

    /**
     * Corresponde al Id del pokemon.
     */
    private int id;

    /**
     * Corresponde al nombre del pokemon.
     */
    private String nombre;

    /**
     * Corresponde a la etapa del pokemon.
     */
    private String etapa;

    /**
     * Corresponde a la evolución siguiente o segunda del pokemon.
     */
    private String evolucionSiguiente;

    /**
     * Corresponde a la evolución anterior o primera del pokemon.
     */
    private String evolucionPrevia;

    /**
     * Corresponde al tipo número uno del pokemon.
     */
    private String tipo1;

    /**
     * Corresponde al tipo número dos del pokemon.
     */
    private String tipo2;

    /**
     * Constructor de la clase pokemons.
     *
     * @param id                 Corresponde al identificador del pokemon.
     * @param nombre             Corresponde al nombre del pokemon.
     * @param etapa              Corresponde a la etapa del pokemon.
     * @param evolucionPrevia    Corresponde a la evolución previa del pokemon.
     * @param evolucionSiguiente Corresponde a la evolución siguiente del pokemon.
     * @param tipo1              Corresponde al primer tipo del pokemon.
     * @param tipo2              Corresponde al segundo tipo del pokemon.
     */
    public Pokemon(int id, String nombre, String etapa, String evolucionSiguiente, String evolucionPrevia, String tipo1, String tipo2) {

        // método  para validación de id.
        if (id != 0 && id > 30) {
            throw new IllegalArgumentException("Número de id no valido!");
        }
        this.id = id;

        // método  para validación de nombre.
        if (nombre == null || nombre.length() == 0) {
            throw new IllegalArgumentException("Nombre no valido!");
        }
        this.nombre = nombre;

        // método  para validación de etapa.
        if (etapa == null || etapa.length() == 0) {
            throw new IllegalArgumentException("Etapa no valida!");
        }
        this.etapa = etapa;

        // método  para validación de evolucionSiguiente.
        if (evolucionSiguiente == null || evolucionSiguiente.length() == 0) {
            throw new IllegalArgumentException("Evolución siguiente no valida!");
        }
        this.evolucionSiguiente = evolucionSiguiente;

        // método  para validación de evolucionPrevia.
        if (evolucionPrevia == null || evolucionPrevia.length() == 0) {
            throw new IllegalArgumentException("Evolución previa no valida!");
        }
        this.evolucionPrevia = evolucionPrevia;

        // método  para validación de tipo1.
        if (tipo1 == null || tipo1.length() == 0) {
            throw new IllegalArgumentException("Tipo 1 no valid0!");
        }
        this.tipo1 = tipo1;

        // método  para validación de tipo2.
        if (tipo2 == null || tipo2.length() == 0) {
            throw new IllegalArgumentException("Tipo 2 no valido!");
        }
        this.tipo2 = tipo2;
    }

    /**
     * Método de la clase que obtiene el id del pokemon.
     *
     * @return id del pokemon solicitado.
     */
    public int getId() {
        return id;
    }

    /**
     * Método de la clase que obtiene el nombre del pokemon.
     *
     * @return nombre del pokemon solicitado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método de la clase que obtiene la etapa del pokemon.
     *
     * @return etapa del pokemon solicitado.
     */
    public String getEtapa() {
        return etapa;
    }

    /**
     * Método de la clase que obtiene la evolución siguiente del pokemon.
     * @return evolución siguiente del pokemon solicitado.
     */
    public String getEvolucionSiguiente() {
        return evolucionSiguiente;
    }

    /**
     * Método de la clase que obtiene el primer tipo del pokemon.
     * @return primer tipo del pokemon solicitado.
     */
    public String getTipo1() {
        return tipo1;
    }

    /**
     * Método de la clase que obtiene el segundo tipo del pokemon.
     * @return segundo tipo del pokemon solicitado.
     */
    public String getTipo2() {
        return tipo2;
    }

    /**
     * Método que transforma la información de cada pokemons en un dato de tipo String.
     * @return Información del pokemons.
     */
    public String toString(){
        return "Id:"+this.id+"\nNombre: "+this.nombre+"\nEtapa: "+this.etapa+ "\nEvolución siguiente: "+
                this.evolucionSiguiente+"\nEvolución previa: "+this.evolucionPrevia+"\nTipo1: "+
                this.tipo1+"\nTipo2: "+this.tipo2;

    }
}