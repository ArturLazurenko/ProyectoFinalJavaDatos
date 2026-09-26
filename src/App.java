import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class App {

    static void mostrarMenu() {
        System.out.println("\nMENU:");
        // Listas
        System.out.println("=== Catalogo de juegos ===");
        System.out.println("1. Insertar juego en el catalogo");
        System.out.println("2. Mostrar catalogo");
        System.out.println("3. Buscar juego");
        System.out.println("4. Eliminar juego \n");
        // Pilas
        System.out.println("=== Registro de compras ===");
        System.out.println("5. Registrar compra");
        System.out.println("6. Deshacer ultima compra");
        System.out.println("7. Ver ultima compra");
        System.out.println("8. Mostrar historial de compras\n" );
        // Colas y colas de prioridad
        System.out.println("=== Descargas de juegos ===");
        System.out.println("9. Agregar descarga");
        System.out.println("10. Procesar siguiente descarga");
        System.out.println("11. Ver proxima descarga");
        System.out.println("12. Mostrar cola de descargas\n");

        System.out.println("=== Actualizaciones ===");
        System.out.println("13. Agregar actualizacion");
        System.out.println("14. Procesar actualizacion\n");

        System.out.println("=== Catalogo de categorias ===");
        System.out.println("15. Ver categorias");
        System.out.println("16. Buscar juego");
        System.out.println("17. Buscar juego por ID");
        System.out.println("18. Mostrar catalogo ordenado por nombre\n");

        System.out.println("=== Recomendaciones ===");
        System.out.println("19. Agregar recomendacion entre juegos");
        System.out.println("20. Ver recomendaciones de un juego\n");

        System.out.println("21. Salir\n");

        System.out.print("Selecciona una opcion: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<VideoGame> catalogo = new LinkedList<>();
        Queue<VideoGame> descargas = new Queue<>();
        Stack<String> compras = new Stack<>();

        PriorityQueue<DescargaPrioritaria> descargasPrioritarias = new PriorityQueue<>();
        ArrayList<VideoGame> catalogoOrdenado = new ArrayList<>();
        HashMap<String, VideoGame> juegosPorId = new HashMap<>();
        HashMap<String, ArrayList<String>> recomendaciones = new HashMap<>();
        NodoCategoria Categorias = null;
        int siguienteId = 1;
        int opcion = 0;

        // Juegos iniciales para probar el programa
        VideoGame juego1 = new VideoGame("Minecraft", "Sandbox");
        VideoGame juego2 = new VideoGame("Hollow Knight", "Indie");
        VideoGame juego3 = new VideoGame("Rocket League", "Deportes");
        VideoGame juego4 = new VideoGame("Elden Ring", "RPG");
        VideoGame juego5 = new VideoGame("Valorant", "Shooter");
        VideoGame juego6 = new VideoGame("Stardew Valley", "Simulacion");
        VideoGame juego7 = new VideoGame("The Witcher 3", "RPG");
        VideoGame juego8 = new VideoGame("Celeste", "Plataformas");
        VideoGame juego9 = new VideoGame("Dead by Daylight", "Terror");
        VideoGame juego10 = new VideoGame("Forza Horizon 5", "Carreras");
        VideoGame juego11 = new VideoGame("Terraria", "Aventura");

        catalogo.appendNode(juego1);
        catalogo.appendNode(juego2);
        catalogo.appendNode(juego3);
        catalogo.appendNode(juego4);
        catalogo.appendNode(juego5);
        catalogo.appendNode(juego6);
        catalogo.appendNode(juego7);
        catalogo.appendNode(juego8);
        catalogo.appendNode(juego9);
        catalogo.appendNode(juego10);
        catalogo.appendNode(juego11);

        catalogoOrdenado.add(juego1);
        catalogoOrdenado.add(juego2);
        catalogoOrdenado.add(juego3);
        catalogoOrdenado.add(juego4);
        catalogoOrdenado.add(juego5);
        catalogoOrdenado.add(juego6);
        catalogoOrdenado.add(juego7);
        catalogoOrdenado.add(juego8);
        catalogoOrdenado.add(juego9);
        catalogoOrdenado.add(juego10);
        catalogoOrdenado.add(juego11);

        juegosPorId.put("J1", juego1);
        juegosPorId.put("J2", juego2);
        juegosPorId.put("J3", juego3);
        juegosPorId.put("J4", juego4);
        juegosPorId.put("J5", juego5);
        juegosPorId.put("J6", juego6);
        juegosPorId.put("J7", juego7);
        juegosPorId.put("J8", juego8);
        juegosPorId.put("J9", juego9);
        juegosPorId.put("J10", juego10);
        juegosPorId.put("J11", juego11);

        recomendaciones.put("minecraft", new ArrayList<>());
        recomendaciones.put("hollow knight", new ArrayList<>());
        recomendaciones.put("rocket league", new ArrayList<>());
        recomendaciones.put("elden ring", new ArrayList<>());
        recomendaciones.put("valorant", new ArrayList<>());
        recomendaciones.put("stardew valley", new ArrayList<>());
        recomendaciones.put("the witcher 3", new ArrayList<>());
        recomendaciones.put("celeste", new ArrayList<>());
        recomendaciones.put("dead by daylight", new ArrayList<>());
        recomendaciones.put("forza horizon 5", new ArrayList<>());
        recomendaciones.put("terraria", new ArrayList<>());


        recomendaciones.get("minecraft").add("Hollow Knight");
        recomendaciones.get("hollow knight").add("Minecraft");

        recomendaciones.get("elden ring").add("The Witcher 3");
        recomendaciones.get("the witcher 3").add("Elden Ring");
        recomendaciones.get("minecraft").add("Terraria");
        recomendaciones.get("terraria").add("Minecraft");
        recomendaciones.get("valorant").add("Rocket League");
        recomendaciones.get("celeste").add("Hollow Knight");

        Categorias = Catalogo.insertarCategoria(Categorias, "Sandbox");
        Categorias = Catalogo.insertarCategoria(Categorias, "Metroidvania");
        Categorias = Catalogo.insertarCategoria(Categorias, "Deportes");
        Categorias = Catalogo.insertarCategoria(Categorias, "RPG");
        Categorias = Catalogo.insertarCategoria(Categorias, "Shooter");
        Categorias = Catalogo.insertarCategoria(Categorias, "Simulacion");
        Categorias = Catalogo.insertarCategoria(Categorias, "Plataformas");
        Categorias = Catalogo.insertarCategoria(Categorias, "Terror");
        Categorias = Catalogo.insertarCategoria(Categorias, "Carreras");
        Categorias = Catalogo.insertarCategoria(Categorias, "Aventura");

        siguienteId = 12;

        System.out.println("-------Steam 2 Version Alpha------");

        do {
            mostrarMenu();
            if (!sc.hasNextInt()) {
                System.out.println("Ingresa un numero de opcion valido.");
                sc.nextLine();
                continue;
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el titulo del juego: ");
                    String titulo = sc.nextLine();
                    System.out.print("Ingresa el genero: ");
                    String genero = sc.nextLine();

                    if (catalogo.search(new VideoGame(titulo, null))) {
                        System.out.println("Ese juego ya existe en el catalogo.");
                        break;
                    }

                    VideoGame juego = new VideoGame(titulo, genero);
                    String idJuego = "J" + siguienteId++;
                    catalogo.appendNode(juego);
                    catalogoOrdenado.add(juego);
                    juegosPorId.put(idJuego, juego);
                    recomendaciones.put(titulo.toLowerCase(), new ArrayList<>());
                    Categorias = Catalogo.insertarCategoria(Categorias, genero);
                    System.out.println("Juego insertado con ID: " + idJuego);
                    break;

                case 2:
                    catalogo.showList();
                    break;

                case 3:
                    System.out.print("Ingresa el titulo a buscar: ");
                    if (catalogo.search(new VideoGame(sc.nextLine(), null))) System.out.println("Juego encontrado.");
                    else System.out.println("Juego no encontrado.");
                    break;

                case 4:
                    System.out.print("Ingresa el titulo a eliminar: ");
                    String tituloEliminar = sc.nextLine();
                    VideoGame juegoEliminar = new VideoGame(tituloEliminar, null);
                    if (!catalogo.search(juegoEliminar)) {
                        System.out.println("Juego no encontrado.");
                        break;
                    }
                    catalogo.delete(juegoEliminar);
                    catalogoOrdenado.remove(juegoEliminar);
                    String idEliminar = null;
                    for (Map.Entry<String, VideoGame> entrada : juegosPorId.entrySet()) {
                        if (entrada.getValue().equals(juegoEliminar)) {
                            idEliminar = entrada.getKey();
                            break;
                        }
                    }
                    if (idEliminar != null) juegosPorId.remove(idEliminar);
                    recomendaciones.remove(tituloEliminar.toLowerCase());
                    for (ArrayList<String> lista : recomendaciones.values()) {
                        lista.removeIf(t -> t.equalsIgnoreCase(tituloEliminar));
                    }
                    break;

                case 5:
                    System.out.print("Que juego compraste? ");
                    compras.push("Compra: " + sc.nextLine());
                    System.out.println("Compra registrada.");
                    break;

                case 6:
                    String compraDeshecha = compras.pop();
                    if (compraDeshecha != null) System.out.println(compraDeshecha + " fue eliminada del historial.");
                    break;

                case 7:
                    String ultimaCompra = compras.peek();
                    if (ultimaCompra != null) System.out.println("Ultima compra: " + ultimaCompra);
                    break;

                case 8:
                    System.out.println("Historial de compras:");
                    compras.show();
                    break;

                case 9:
                    System.out.print("Titulo del juego a descargar: ");
                    String tituloDescarga = sc.nextLine();
                    System.out.print("Genero: ");
                    descargas.enqueue(new VideoGame(tituloDescarga, sc.nextLine()));
                    System.out.println("Descarga agregada a la cola.");
                    break;

                case 10:
                    VideoGame procesado = descargas.dequeue();
                    if (procesado != null) System.out.println("Descargando: " + procesado);
                    break;

                case 11:
                    VideoGame siguiente = descargas.peek();
                    if (siguiente != null) System.out.println("Proxima descarga: " + siguiente);
                    break;

                case 12:
                    System.out.println("Cola de descargas:");
                    descargas.showQueue();
                    break;

                case 13:
                    System.out.print("Titulo del juego: ");
                    String tituloPrioritario = sc.nextLine();
                    System.out.print("Genero: ");
                    String generoPrioritario = sc.nextLine();
                    System.out.print("Prioridad (1 = mas alta): ");
                    if (!sc.hasNextInt()) {
                        System.out.println("La prioridad debe ser un numero.");
                        sc.nextLine();
                        break;
                    }
                    int prioridad = sc.nextInt();
                    sc.nextLine();
                    if (prioridad < 1) System.out.println("La prioridad debe ser mayor o igual a 1.");
                    else {
                        descargasPrioritarias.add(new DescargaPrioritaria(new VideoGame(tituloPrioritario, generoPrioritario), prioridad));
                        System.out.println("Descarga prioritaria agregada.");
                    }
                    break;

                case 14:
                    DescargaPrioritaria prioritaria = descargasPrioritarias.poll();
                    if (prioritaria == null) System.out.println("No hay descargas prioritarias.");
                    else System.out.println("Procesando: " + prioritaria);
                    break;

                case 15:
                    if (Categorias == null) System.out.println("No hay categorias registradas.");
                    else {
                        System.out.println("Categorias ordenadas:");
                        Catalogo.mostrarCategoriasEnOrden(Categorias);
                    }
                    break;

                case 16:
                    if (catalogoOrdenado.isEmpty()) {
                        System.out.println("El catalogo esta vacio.");
                        break;
                    }
                    Catalogo.ordenarCatalogo(catalogoOrdenado);
                    System.out.print("Titulo a buscar: ");
                    int posicion = Catalogo.busquedaBinariaRecursiva(catalogoOrdenado, sc.nextLine(), 0, catalogoOrdenado.size() - 1);
                    if (posicion >= 0) System.out.println("Juego encontrado: " + catalogoOrdenado.get(posicion));
                    else System.out.println("Juego no encontrado.");
                    break;

                case 17:
                    System.out.print("Ingresa el ID (ejemplo J1): ");
                    VideoGame porId = juegosPorId.get(sc.nextLine().toUpperCase());
                    if (porId == null) System.out.println("No existe un juego con ese ID.");
                    else System.out.println("Juego encontrado: " + porId);
                    break;

                case 18:
                    if (catalogoOrdenado.isEmpty()) {
                        System.out.println("El catalogo esta vacio.");
                        break;
                    }
                    Catalogo.ordenarCatalogo(catalogoOrdenado);
                    System.out.println("Catalogo ordenado por nombre:");
                    for (VideoGame juegoOrdenado : catalogoOrdenado) {
                        System.out.println("- " + juegoOrdenado.getTitle() + " (" + juegoOrdenado.getGenre() + ")");
                    }
                    break;

                case 19:
                    System.out.print("Juego principal: ");
                    String origen = sc.nextLine();
                    System.out.print("Juego recomendado: ");
                    String destino = sc.nextLine();
                    if (!catalogo.search(new VideoGame(origen, null)) || !catalogo.search(new VideoGame(destino, null))) {
                        System.out.println("Ambos juegos deben existir en el catalogo.");
                        break;
                    }
                    recomendaciones.putIfAbsent(origen.toLowerCase(), new ArrayList<>());
                    ArrayList<String> sugerencias = recomendaciones.get(origen.toLowerCase());
                    if (sugerencias.contains(destino)) System.out.println("Esa recomendacion ya existe.");
                    else {
                        sugerencias.add(destino);
                        System.out.println("Recomendacion agregada al grafo.");
                    }
                    break;

                case 20:
                    System.out.print("Juego del que quieres ver recomendaciones: ");
                    String juegoConsultado = sc.nextLine();
                    ArrayList<String> relacionados = recomendaciones.get(juegoConsultado.toLowerCase());
                    if (relacionados == null || relacionados.isEmpty()) System.out.println("No hay recomendaciones para ese juego.");
                    else {
                        System.out.println("Juegos relacionados con " + juegoConsultado + ":");
                        for (String recomendado : relacionados) System.out.println("- " + recomendado);
                    }
                    break;

                case 21:
                    System.out.println("Cerrando Steam 2...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 21);

        sc.close();
    }
}
