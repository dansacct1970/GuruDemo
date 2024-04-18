package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String addressLine;
    private String city;
    private String state;
    private String zip;

    @OneToMany
    @JoinColumn(name = "studio_id")
    private Set<Movie> movies = new HashSet<>();
    public Studio() {
    }
    public Set<Movie> getMovies() {
        return movies;
    }
    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddressLine() {
        return addressLine;
    }
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Studio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) { //huh?
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studio studio = (Studio) o;

        return Objects.equals(id, studio.id);
    }
    @Override
    public int hashCode() { //huh?
        return id != null ? id.hashCode() : 0;
    }
}
