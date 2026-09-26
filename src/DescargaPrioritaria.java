public class DescargaPrioritaria implements Comparable<DescargaPrioritaria> {
    VideoGame juego;
    int prioridad;

    public DescargaPrioritaria(VideoGame juego, int prioridad) {
        this.juego = juego;
        this.prioridad = prioridad;
    }

    @Override
    public int compareTo(DescargaPrioritaria otra) {
        return Integer.compare(this.prioridad, otra.prioridad);
    }

    @Override
    public String toString() {
        return juego.getTitle() + " | Prioridad: " + prioridad;
    }
}
