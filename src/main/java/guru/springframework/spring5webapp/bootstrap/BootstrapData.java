package guru.springframework.spring5webapp.bootstrap;
import guru.springframework.spring5webapp.domain.Director;
import guru.springframework.spring5webapp.domain.Movie;
import guru.springframework.spring5webapp.domain.Studio;
import guru.springframework.spring5webapp.repositories.DirectorRepository;
import guru.springframework.spring5webapp.repositories.MovieRepository;
import guru.springframework.spring5webapp.repositories.StudioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner { //confused by syntax
    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;
    private final StudioRepository studioRepository;

    public BootstrapData(DirectorRepository directorRepository, MovieRepository movieRepository, StudioRepository studioRepository) {
        this.directorRepository = directorRepository;
        this.movieRepository = movieRepository;
        this.studioRepository = studioRepository;
    }

    @Override //confused by @Override need
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Studio cp = new Studio();
        cp.setName("Columbia Pictures");
        cp.setCity("Culver City");
        cp.setState("California");
        studioRepository.save(cp);

        Studio ap = new Studio();
        ap.setName("Annapurna Pictures");
        ap.setCity("Los Angeles");
        ap.setState("California");
        studioRepository.save(ap);

        Studio pp = new Studio();
        pp.setName("Paramount Pictures");
        pp.setCity("Hollywood");
        pp.setState("California");
        studioRepository.save(pp);

        Studio up = new Studio();
        up.setName("Universal Pictures");
        up.setCity("Universal City");
        up.setState("California");
        studioRepository.save(up);

        Studio wb = new Studio();
        wb.setName("Warner Bros");
        wb.setCity("Burbank");
        wb.setState("California");
        studioRepository.save(wb);

        Studio wds = new Studio();
        wds.setName("Walt Disney Studios");
        wds.setCity("Burbank");
        wds.setState("California");
        studioRepository.save(wds);

        Studio sp = new Studio();
        sp.setName("Sony Pictures");
        sp.setCity("Culver City");
        sp.setState("California");
        studioRepository.save(sp);

//Christopher Nolan Movies
        Director cNolan = new Director("Christopher","Nolan");
        directorRepository.save(cNolan);
        Movie inters = new Movie("Interstellar", 2014, 8.7);
        inters.setStudio(cp);
        inters.getDirectors().add(cNolan);
        cNolan.getMovies().add(inters);
        cp.getMovies().add(inters);
        movieRepository.save(inters);

        Movie incep = new Movie("Inception", 2010, 8.8);
        incep.setStudio(wb);
        incep.getDirectors().add(cNolan);
        cNolan.getMovies().add(incep);
        wb.getMovies().add(incep);
        movieRepository.save(incep);

        Movie oppen = new Movie("Oppenheimer", 2023, 8.3);
        oppen.setStudio(up);
        oppen.getDirectors().add(cNolan);
        cNolan.getMovies().add(oppen);
        up.getMovies().add(oppen);
        movieRepository.save(oppen);


        Movie darkk = new Movie("Dark Knight", 2008, 9.0);
        darkk.setStudio(wb);
        darkk.getDirectors().add(cNolan);
        cNolan.getMovies().add(darkk);
        wb.getMovies().add(darkk);
        movieRepository.save(darkk);

//Adam McKay Movies
        Director aMckay = new Director("Adam", "McKay");
        directorRepository.save(aMckay);
        Movie stepb = new Movie("Step Brothers", 2008, 6.9);
        stepb.setStudio(sp);
        stepb.getDirectors().add(aMckay);
        aMckay.getMovies().add(stepb);
        sp.getMovies().add(stepb);
        movieRepository.save(stepb);

        Movie talla = new Movie("Talladega Nights: The Ballad of Ricky Bobby", 2006, 6.6);
        talla.setStudio(cp);
        talla.getDirectors().add(aMckay);
        aMckay.getMovies().add(talla);
        cp.getMovies().add(talla);
        movieRepository.save(talla);

        Movie otherg = new Movie("The Other Guys", 2010, 6.6);
        otherg.setStudio(cp);
        otherg.getDirectors().add(aMckay);
        aMckay.getMovies().add(otherg);
        cp.getMovies().add(otherg);
        movieRepository.save(otherg);

        Movie vice = new Movie("Vice", 2018, 7.2);
        vice.setStudio(ap);
        vice.getDirectors().add(aMckay);
        aMckay.getMovies().add(vice);
        ap.getMovies().add(vice);
        movieRepository.save(vice);

        Movie ancho = new Movie("Anchorman: The Legend of Ron Burgundy", 2004, 7.1);
        ancho.setStudio(pp);
        ancho.getDirectors().add(aMckay);
        aMckay.getMovies().add(ancho);
        pp.getMovies().add(ancho);
        movieRepository.save(ancho);

//Martin Scorsese Movies
        Director mScorsese = new Director("Martin", "Scorsese");
        directorRepository.save(mScorsese);
        Movie depar = new Movie("The Departed", 2006, 8.5);
        depar.setStudio(wb);
        depar.getDirectors().add(mScorsese);
        mScorsese.getMovies().add(depar);
        wb.getMovies().add(depar);
        movieRepository.save(depar);

        Movie shutte = new Movie("Shutter Island", 2010, 8.2);
        shutte.setStudio(pp);
        shutte.getDirectors().add(mScorsese);
        mScorsese.getMovies().add(shutte);
        pp.getMovies().add(shutte);
        movieRepository.save(shutte);

        Movie casino = new Movie("Casino", 2002, 8.2);
        casino.setStudio(up);
        casino.getDirectors().add(mScorsese);
        mScorsese.getMovies().add(casino);
        up.getMovies().add(casino);
        movieRepository.save(casino);

        Movie goodf = new Movie("Goodfellas", 1990, 8.7);
        goodf.setStudio(wb);
        goodf.getDirectors().add(mScorsese);
        mScorsese.getMovies().add(goodf);
        wb.getMovies().add(goodf);
        movieRepository.save(goodf);

        Movie taxid = new Movie("Taxi Driver", 1976, 8.2);
        taxid.setStudio(cp);
        taxid.getDirectors().add(mScorsese);
        mScorsese.getMovies().add(taxid);
        cp.getMovies().add(taxid);
        movieRepository.save(taxid);

//Print test statements
        System.out.println("Number of Movies: " + movieRepository.count());
        System.out.println("Number of Studios: " + studioRepository.count());
        System.out.println("Number of Directors: " + directorRepository.count());
        System.out.println("Warner Bros number of Movies: " + wb.getMovies().size());
        System.out.println("Columbia Pictures number of Movies: " + cp.getMovies().size());
        System.out.println("Paramount Pictures number of Movies: " + pp.getMovies().size());
        System.out.println("Walt Disney Studio number of Movies: " + wds.getMovies().size());
        System.out.println("Annapurna Pictures number of Movies: " + ap.getMovies().size());
        System.out.println("Sony Pictures number of Movies: " + sp.getMovies().size());
        System.out.println("Universal Pictures number of Movies: " + up.getMovies().size());





    }
}
