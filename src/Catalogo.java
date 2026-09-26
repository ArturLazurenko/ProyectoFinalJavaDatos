import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Catalogo {
    private Catalogo() {
    }

    public static NodoCategoria insertarCategoria(NodoCategoria raiz, String categoria) {
        if (raiz == null) return new NodoCategoria(categoria);

        int comparacion = categoria.compareToIgnoreCase(raiz.categoria);
        if (comparacion < 0) raiz.izquierda = insertarCategoria(raiz.izquierda, categoria);
        else if (comparacion > 0) raiz.derecha = insertarCategoria(raiz.derecha, categoria);
        return raiz;
    }

    public static void mostrarCategoriasEnOrden(NodoCategoria raiz) {
        if (raiz == null) return;
        mostrarCategoriasEnOrden(raiz.izquierda);
        System.out.println("- " + raiz.categoria);
        mostrarCategoriasEnOrden(raiz.derecha);
    }

    // Divide y venceras: busca recursivamente en una lista ordenada.
    public static int busquedaBinariaRecursiva(ArrayList<VideoGame> juegos, String titulo, int inicio, int fin) {
        if (inicio > fin) return -1;

        int medio = (inicio + fin) / 2;
        int comparacion = titulo.compareToIgnoreCase(juegos.get(medio).getTitle());
        if (comparacion == 0) return medio;
        if (comparacion < 0) return busquedaBinariaRecursiva(juegos, titulo, inicio, medio - 1);
        return busquedaBinariaRecursiva(juegos, titulo, medio + 1, fin);
    }

    public static void ordenarCatalogo(ArrayList<VideoGame> juegos) {
        Collections.sort(juegos, Comparator.comparing(VideoGame::getTitle, String.CASE_INSENSITIVE_ORDER));
    }
}
