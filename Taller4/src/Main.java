import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdIn;
import ucn.StdOut;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SistemaPokedex sistema = new SistemaPokedexImpl();

        menuPrincipal(sistema);

    }

    public static void cargarArchivo(SistemaPokedex sistema) throws IOException{
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




        }
    }


    public static void menuPrincipal(SistemaPokedex sistema) throws  IOException{
        int menu = 0;

        while(menu != 6){
            StdOut.println("------------------------>Bienvenido a la Pokedex<------------------------");
            StdOut.println("[1]  Desplegar Pokemon ordenados según id");
            StdOut.println("[2]  Desplegar todos los pokémons del sistema");
            StdOut.println("[3]  Desplegar pokémon según tipo");
            StdOut.println("[4]  Desplegar los pokémons en su primera evolución");
            StdOut.println("[5]  Busqueda personalizada");
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
                case 1 -> desplegarPokemonOrdenado(sistema);
                case 2 -> desplegarPokemonDelSistema(sistema);
                case 3 -> desplegarPokemonSegunTipo(sistema);
                case 4 -> desplegarPokemonPrimeraEvolucion(sistema);
                case 5 -> subMenubusquedaPersonalizada(sistema);
                case 6 -> salir(sistema);
            }




        }
    }

    public static  void desplegarPokemonOrdenado(SistemaPokedex sistema){
        String pokemons = sistema.desplegarPokemonSegunRango();
        StdOut.println("-------------> Despliegue de los pokémons ordenado según su id");

    }

    public static  void desplegarPokemonDelSistema(SistemaPokedex sistema){
        String pokemons = sistema.desplegarPokemonAlfabetico();
        StdOut.println("-------------> Despliegue de los pokémons almacenados en el sistema, ordenados\n" +
                "alfabéticamente");


    }


    public static  void desplegarPokemonSegunTipo(SistemaPokedex sistema){
        String pokemons = sistema.desplegarPokemonDadoTipo();
        StdOut.println("-------------> Despliegue de los pokémons dado un tipo en particular");


    }


    public static  void desplegarPokemonPrimeraEvolucion(SistemaPokedex sistema){
        String pokemons = sistema.desplegarPokemonPrimeraEvolucion();
        StdOut.println("-------------> Despliegue de los pokémonsprimera evolución, ordenados según su id en orden\n" +
                "decreciente");



    }



    public static void subMenubusquedaPersonalizada(SistemaPokedex sistema){
        int opcionInt = 0;

        while(opcionInt != 2){
            StdOut.println("--------->Menu para búsquedas personalizadas<---------- ");
            StdOut.println("[1] Buscar Pokemon por nombre o id.");
            StdOut.println("[2] Volver al menú anterior.");
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
                case 1 -> busquedaPersonalizada(sistema);
                case 2 -> StdOut.println("\nVolviendo al menú anterior...\n");
            }

        }
    }


    public static void busquedaPersonalizada(SistemaPokedex sistema){

    }


    public static void salir(SistemaPokedex sistema) throws  IOException{

    }















}