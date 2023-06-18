import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdIn;
import ucn.StdOut;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SistemaPokedex sistema = new SistemaPokedexImpl();

        cargarPokemons(sistema);
        menuPrincipal(sistema);
    }

    //region LECTURA DE ARCHIVOS.

    /**
     * Subprograma para cargar y leer el archivo para guardarlo en la ListaInstrumento.
     * @param sistema Corresponde al llamamiento al SistemaPokedexImpl.
     * @throws IOException Detiene la carga/escritura  del archivo si ocurre algun error.
     */
    public static void cargarPokemons(SistemaPokedex sistema) throws IOException{
        ArchivoEntrada archivoEntrada = new ArchivoEntrada("kanto.txt");
        while(!archivoEntrada.isEndFile()){
            Registro registroEntrada = archivoEntrada.getRegistro();
            int id = registroEntrada.getInt();
            String nombre = registroEntrada.getString();
            String etapa = registroEntrada.getString();
            String evolucionSiguiente = registroEntrada.getString();
            String evolucionPrevia = registroEntrada.getString();
            String tipo1 = registroEntrada.getString();
            String tipo2 = registroEntrada.getString();
            sistema.regitrarPokemons(id,nombre,etapa,evolucionSiguiente,evolucionPrevia,tipo1,tipo2);
        }
        archivoEntrada.close();
    }

    /**
     * Subprograma que lleva al menu principal al usuario.
     * @param sistema Corresponde al llamamiento al SistemaPokedexImpl.
     * @throws IOException Detiene la carga/escritura  del archivo si ocurre algun error.
     */
    public static void menuPrincipal(SistemaPokedex sistema) throws  IOException{
        int menu = 0;

        while(menu != 6){
            StdOut.println("------------------------>Bienvenido a la Pokedex<------------------------\n");
            StdOut.println("[1]  Desplegar Pokemon según rango");
            StdOut.println("[2]  Desplegar todos los pokémons del sistema");
            StdOut.println("[3]  Desplegar pokémon según tipo en particular");
            StdOut.println("[4]  Desplegar los pokémons en su primera evolución");
            StdOut.println("[5]  Búsqueda personalizada");
            StdOut.println("[6]  salir del sistema");
            StdOut.println("Ingrese una opción por favor:");
            String menuStr = StdIn.readLine().strip();
            int menuInt;

            while(true){
                try{
                    menuInt = Integer.parseInt(menuStr);
                    if(1 <= menuInt && menuInt <=6){
                        break;
                    }else{
                        StdOut.println("error la opcion ingresada no existe");
                        StdOut.println("Ingrese una opción valida por favor");
                        menuStr = StdIn.readString();
                    }

                }catch(Exception e){
                    StdOut.println("error la opcion ingresada no existe");
                    StdOut.println("Ingrese una opción valida por favor");
                    menuStr = StdIn.readString();
                }
            }
            menu = menuInt;

            switch (menu){
                case 1 -> desplegarPokemonOrdenadoSegunRango(sistema);
                case 2 -> desplegarPokemonDelSistemaAlfabeticamente(sistema);
                case 3 -> desplegarPokemonSegunDadoTipo(sistema);
                case 4 -> desplegarPokemonPrimeraEvolucion(sistema);
                case 5 -> subMenubusquedaPersonalizada(sistema);
                case 6 ->salir(sistema);
            }
        }
    }

    /**
     * Subprograma que permite el despliegue de los pokemons ordenados según el rango.
     * @param sistema Corresponde al llamamiento al SistemaPokedexImpl.
     */
    public static  void desplegarPokemonOrdenadoSegunRango(SistemaPokedex sistema){

        StdOut.println("------------------------>Rango (1-30)<------------------------");
        StdOut.println("Ingrese el rango de inicio: ");
        int inicio = StdIn.readInt() -1;

        StdOut.println("Ingrese el rango de fin: ");
        int fin = StdIn.readInt() - 1;

        if (inicio >= 0 && fin <= 29 ){
            for (int i = inicio; i <= fin; i++) {
                String[] pokemons = sistema.desplegarPokemonSegunRango();

                if(pokemons == null || pokemons.length == 0){
                    StdOut.println("No hay pokémons en el sistema");
                }else{
                    StdOut.println(pokemons[i]);
                }
            }
        }else {
            StdOut.println("Rango ingresado invalido!...Volviendo al menú anterior\n");
        }
    }

    /**
     * Subprograma que permite el despliegue de los pokemons ordenados alfabeticamente.
     * @param sistema Corresponde al llamamiento al SistemaPokedexImpl.
     */
    public static  void desplegarPokemonDelSistemaAlfabeticamente(SistemaPokedex sistema){

        String[] pokemons = sistema.desplegarPokemonAlfabetico();
        if(pokemons == null || pokemons.length == 0){
            StdOut.println("No hay pokémons en el sistema");
        }else{
            for (int i = 0; i < pokemons.length; i++) {
                StdOut.println(pokemons[i]);
            }
        }
    }

    /**
     * Subprograma que permite el despliegue de los pokemons segun el tipo de este.
     * @param sistema Corresponde al llamamiento al SistemaPokedexImpl.
     */
    public static  void desplegarPokemonSegunDadoTipo(SistemaPokedex sistema){
        StdOut.println("Escriba el tipo del pokémon a buscar: ");
        String tipo = StdIn.readLine();

        if (sistema.existepokemonTipo(tipo)){

            String[] pokemons = sistema.desplegarPokemonDadoTipo(tipo);

            for (String pokemon : pokemons){
                if (pokemon!= null){
                    StdOut.println(pokemon);
                }
            }
        }else{
            StdOut.println("Tipo del pokémon no encontrado!...Volviendo al menú anterior"+"\n");
        }
    }

    /**
     * Subprograma que permite el despliegue de los pokemons en su primera evolución.
     * @param sistema Corresponde al llamamiento al SistemaPokedexImpl.
     */
    public static  void desplegarPokemonPrimeraEvolucion(SistemaPokedex sistema){

        String[] pokemons = sistema.desplegarPokemonPrimeraEvolucion();

        for (String pokemon : pokemons){
            if (pokemon != null){
                StdOut.println(pokemon);
            }
        }
    }

    /**
     * Subprograma que lleva al submenu de busqueda personalizada lo que permite el despliegue de los pokemons según el nombre o id.
     * @param sistema Corresponde al llamamiento al SistemaPokedexImpl.
     */
    public static void subMenubusquedaPersonalizada(SistemaPokedex sistema){
        int opcionInt = 0;

        while(opcionInt != 3){
            StdOut.println("--------->Menu para búsquedas personalizadas<---------- ");
            StdOut.println("[1] Buscar Pokemon por nombre.");
            StdOut.println("[2] Buscar Pokemon por id.");
            StdOut.println("[3] Volver al menú anterior.");
            StdOut.print("Ingrese su opción: ");
            String opcionStr = StdIn.readLine();

            while (true){
                try{
                    opcionInt = Integer.parseInt(opcionStr);
                    if ( 1 <= opcionInt && opcionInt <= 3){
                        break;
                    }else{
                        StdOut.println("Error, la opción ingresada no existe");
                        StdOut.print("Ingrese su opción nuevamente: ");
                        opcionStr = StdIn.readString();
                    }
                }catch(Exception e){
                    StdOut.println("Error, la opción ingresada no existe");
                    StdOut.print("Ingrese su opción nuevamente: ");
                    opcionStr = StdIn.readString();
                }
            }

            switch (opcionInt) {
                case 1 -> obtenerPokemonNombre(sistema);
                case 2 -> obtenerPokemonId(sistema);
                case 3 -> StdOut.println("\nVolviendo al menú anterior...\n");
            }
        }
    }

    /**
     * Subprograma que permite obtener los nombres de los pokemons.
     * @param sistema Corresponde al llamamiento al SistemaPokedexImpl.
     */
    public static void obtenerPokemonNombre(SistemaPokedex sistema){

        StdOut.println("Escriba el nombre del pokémon a buscar: ");
        String nombre = StdIn.readLine();

        if (sistema.existepokemonNombre(nombre)){

            String[] pokemons = sistema.obtenerPokemonNombre(nombre);

            for (String pokemon : pokemons){
                if (pokemon!= null){
                    StdOut.println(pokemon + "\n");
                }
            }
        }else{
            StdOut.println("Nombre el pokémon no encontrado!"+"\n");
        }
    }

    /**
     * Subprograma que permite obtener los id de los pokemons y lleva a un submenu para desplegar las evoluciones de estos.
     * @param sistema Corresponde al llamamiento al SistemaPokedexImpl.
     */
    public static void obtenerPokemonId(SistemaPokedex sistema){

        StdOut.println("Escriba el id del pokémon a buscar: ");
        int id = StdIn.readInt();

        if (sistema.existepokemonId(id)){

            String[] pokemons = sistema.obtenerPokemonId(id);

            for (String pokemon : pokemons){
                if (pokemon!= null){
                    StdOut.println(pokemon + "\n");
                }
            }
        }else{
            StdOut.println("Id el pokémon no encontrado!"+"\n");
        }
    }

    /**
     * Subprograma que salir del sistema.
     */
    public static void salir(SistemaPokedex sistema){
        sistema.salir();
    }
}