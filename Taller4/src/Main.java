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

    public static void menuPrincipal(SistemaPokedex sistema) throws  IOException{
        int menu = 0;

        while(menu != 6){
            StdOut.println("------------------------>Bienvenido a la Pokedex<------------------------");
            StdOut.println("[1]  Desplegar Pokemon ordenados según id en orden decreciente");
            StdOut.println("[2]  Desplegar todos los pokémons del sistema ordenados alfabéticamente");
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

    public static  void desplegarPokemonOrdenadoSegunRango(SistemaPokedex sistema){

        StdOut.println("Ingrese el rango de inicio: ");
        int inicio = StdIn.readInt();

        StdOut.println("Ingrese el rango de fin: ");
        int fin = StdIn.readInt();

        for (int i = inicio; i <= fin; i++) {
            String[] pokemons = sistema.desplegarPokemonSegunRango();

            if(pokemons == null || pokemons.length == 0){
                StdOut.println("No hay pokémons en el sistema");
            }else{
                StdOut.println(pokemons[i]);
            }
        }
    }

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

    public static  void desplegarPokemonSegunDadoTipo(SistemaPokedex sistema){
        StdOut.println("Escriba el tipo del pokémon a buscar: ");
        String tipo = StdIn.readLine();

        String[] pokemons = sistema.desplegarPokemonDadoTipo(tipo);
        if(pokemons == null || pokemons.length == 0){
            StdOut.println("No hay pokémons en el sistema");
        }else{
            for (int i = 0; i < pokemons.length; i++) {
                StdOut.println(pokemons[i]);
            }
        }

    }

    public static  void desplegarPokemonPrimeraEvolucion(SistemaPokedex sistema){

        String[] pokemons = sistema.desplegarPokemonPrimeraEvolucion();
        if(pokemons == null || pokemons.length == 0){
            StdOut.println("No hay pokémons en el sistema");
        }else{
            for (int i = 0; i < pokemons.length; i++) {
                StdOut.println(pokemons[i]);
            }
        }
    }

    public static void subMenubusquedaPersonalizada(SistemaPokedex sistema){
        int opcionInt = 0;

        while(opcionInt != 2){
            StdOut.println("--------->Menu para búsquedas personalizadas<---------- ");
            StdOut.println("[1] Buscar Pokemon por nombre.");
            StdOut.println("[2] Buscar Pokemon por id.");
            StdOut.println("[3] Volver al menú anterior.");
            StdOut.print("Ingrese su opción: ");
            String opcionStr = StdIn.readLine();

            while (true){
                try{
                    opcionInt = Integer.parseInt(opcionStr);
                    if ( 1 <= opcionInt && opcionInt <= 2){
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

    public static void obtenerPokemonNombre(SistemaPokedex sistema){

        StdOut.println("Escriba el nombre del pokémon a buscar: ");
        String nombre = StdIn.readLine();

        String[] pokemons = sistema.obtenerPokemonNombre(nombre);
        if(pokemons == null || pokemons.length == 0){
            StdOut.println("No hay pokémons en el sistema");
        }else{
            for (int i = 0; i < pokemons.length; i++) {
                StdOut.println(pokemons[i]);
            }
        }
    }

    public static void obtenerPokemonId(SistemaPokedex sistema){

        StdOut.println("Escriba el id del pokémon a buscar: ");
        String id = StdIn.readLine();

        String[] pokemons = sistema.obtenerPokemonId(Integer.parseInt(id));
        if(pokemons == null || pokemons.length == 0){
            StdOut.println("No hay pokémons en el sistema");
        }else{
            for (int i = 0; i < pokemons.length; i++) {
                StdOut.println(pokemons[i]);
            }
        }
    }


    public static void busquedaPersonalizada(SistemaPokedex sistema){
    }

    public static void salir(SistemaPokedex sistema) throws  IOException{
    }
}