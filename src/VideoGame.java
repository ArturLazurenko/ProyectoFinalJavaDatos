public class VideoGame {
    public String title;
    public String genre;
 
    public VideoGame(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }
 
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoGame)) return false;
        VideoGame other = (VideoGame) o;
        return title != null && title.equalsIgnoreCase(other.title);
    }
 
    @Override
    public int hashCode() {
        return title != null ? title.toLowerCase().hashCode() : 0;
    }
 
    @Override
    public String toString() {
        return "Juego: " + title + "\nGenero: " + genre;
    }
}