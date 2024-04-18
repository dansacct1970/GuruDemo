package guru.springframework.spring5webapp.domain;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int year;
    private double imdbRating;
    @ManyToOne
    private Studio studio;
    @ManyToMany //mapping many-to-many relationships like @JoinTable does below is somewhat complex compared to other database relationship types
    @JoinTable(name = "director_movie", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "director_id"))
    private Set<Director> directors = new HashSet<>();

    public Movie() {
    }

    public Movie(String title, int year, double imdbRating){
        this.title = title;
        this.year = year;
        this.imdbRating = imdbRating;
    }

    public Studio getStudio() {
        return studio;
    }
    public void setStudio(Studio studio) {
        this.studio = studio;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public double getImdbRating() {
        return imdbRating;
    }
    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
    public Set<Director> getDirectors() {
        return directors;
    }
    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    @Override //confused about purpose
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", directors=" + directors +
                ", studio=" + studio +
                '}';
    }

    @Override //confused about purpose of override and equals() method
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o; //how does this syntax even make sense?

        return Objects.equals(id, movie.id);
    }

    @Override //confused about purpose of override and hashCode() method
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
