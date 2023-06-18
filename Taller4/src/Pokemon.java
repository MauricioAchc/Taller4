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
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.evolucionSiguiente = evolucionSiguiente;
        this.evolucionPrevia = evolucionPrevia;
        this.tipo1 = tipo1;
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

    public void setId(int id) {
        this.id = id;
    }


    /**
     * Método de la clase que obtiene el nombre del pokemon.
     *
     * @return nombre del pokemon solicitado.
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * Método de la clase que obtiene la etapa del pokemon.
     *
     * @return etapa del pokemon solicitado.
     */
    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }



    /**
     * Método de la clase que obtiene la evolución siguiente del pokemon.
     * @return evolución siguiente del pokemon solicitado.
     */
    public String getEvolucionSiguiente() {
        return evolucionSiguiente;
    }

    public void setEvolucionSiguiente(String evolucionSiguiente) {
        this.evolucionSiguiente = evolucionSiguiente;
    }


    /**
     * Método de la clase que obtiene la evolución previa del pokemon.
     * @return evolución previa del pokemon solicitado.
     */
    public String getEvolucionPrevia() {
        return evolucionPrevia;
    }

    public void setEvolucionPrevia(String evolucionPrevia) {
        this.evolucionPrevia = evolucionPrevia;
    }


    /**
     * Método de la clase que obtiene el primer tipo del pokemon.
     * @return primer tipo del pokemon solicitado.
     */
    public String getTipo1() {
        return tipo1;
    }


    /**
     * Método que permite insertar un tipo1 dentro del sistema.
     */
    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }


    /**
     * Método de la clase que obtiene el segundo tipo del pokemon.
     * @return segundo tipo del pokemon solicitado.
     */
    public String getTipo2() {
        return tipo2;
    }



    /**
     * Método que permite insertar un tipo2 dentro del sistema.
     */
    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
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
