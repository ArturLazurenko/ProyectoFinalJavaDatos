import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        LinkedList<VideoGame> catalogo = new LinkedList<>();
        Queue<VideoGame> descargas = new Queue<>();
        Stack<String> compras = new Stack<>();

        int opcion = 0;

        System.out.println("-------Steam 2 Version Alpha------");

        do {
            System.out.println("\nMENU:");
            System.out.println("=== Catalogo de juegos ===");
            System.out.println("1. Insertar juego en el catalogo");
            System.out.println("2. Mostrar catalogo");
            System.out.println("3. Buscar juego");
            System.out.println("4. Eliminar juego");
            System.out.println("=== Registro de compras ===");
            System.out.println("5. Registrar compra ");
            System.out.println("6. Deshacer ultima compra");
            System.out.println("7. Ver ultima compra");
            System.out.println("8. Mostrar historial de compras");
            System.out.println("=== Descargas ===");
            System.out.println("9. Agregar descarga");
            System.out.println("10. Procesar siguiente descarga");
            System.out.println("11. Ver proxima descarga");
            System.out.println("12. Mostrar cola de descargas");
            System.out.println("13. Salir");
            System.out.print("Selecciona una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el titulo del juego: ");
                    String title = sc.nextLine();
                    System.out.print("Ingresa el genero: ");
                    String genre = sc.nextLine();
                    VideoGame game = new VideoGame(title, genre);
                    catalogo.appendNode(game);
                    System.out.println("Juego insertado.");
                    break;

                case 2:
                    catalogo.showList();
                    break;

                case 3:
                    System.out.print("Ingresa el titulo a buscar: ");
                    String titleToFind = sc.nextLine();
                    boolean found = catalogo.search(new VideoGame(titleToFind, null));

                    if (found) {
                        System.out.println("Juego encontrado!!!");
                    } else {
                        System.out.println("Juego no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingresa el titulo a eliminar: ");
                    String titleToDelete = sc.nextLine();
                    catalogo.delete(new VideoGame(titleToDelete, null));
                    break;

                case 5:
                    System.out.print("Que juego compraste? ");
                    String purchasedGame = sc.nextLine();
                    compras.push("Compra: " + purchasedGame);
                    System.out.println("Compra registrada.");
                    break;

                case 6:
                    System.out.println("Deshaciendo ultima compra...");
                    String undonePurchase = compras.pop();

                    if (undonePurchase != null) {
                        System.out.println(undonePurchase + " fue eliminada del historial.");
                    }
                    break;

                case 7:
                    String lastPurchase = compras.peek();

                    if (lastPurchase != null) {
                        System.out.println("Ultima compra: " + lastPurchase);
                    }
                    break;

                case 8:
                    System.out.println("Historial de compras:");
                    compras.show();
                    break;

                case 9:
                    System.out.print("Ingresa el titulo del juego a descargar: ");
                    String downloadTitle = sc.nextLine();
                    System.out.print("Ingresa el genero: ");
                    String downloadGenre = sc.nextLine();

                    VideoGame gameToDownload = new VideoGame(downloadTitle, downloadGenre);
                    descargas.enqueue(gameToDownload);

                    System.out.println("Descarga agregada a la cola.");
                    break;

                case 10:
                    System.out.println("Procesando...");
                    VideoGame processedGame = descargas.dequeue();

                    if (processedGame != null) {
                        System.out.println("Descargando: " + processedGame);
                    } else {
                        System.out.println("No hay descargas en la cola.");
                    }
                    break;

                case 11:
                    VideoGame nextDownload = descargas.peek();

                    if (nextDownload != null) {
                        System.out.println("Proxima descarga: " + nextDownload);
                    } else {
                        System.out.println("No hay descargas en la cola.");
                    }
                    break;

                case 12:
                    System.out.println("Cola de descargas:");
                    descargas.showQueue();
                    break;

                case 13:
                    System.out.println("Cerrando Steam 2...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        } while (opcion != 13);

        sc.close();
    }
}