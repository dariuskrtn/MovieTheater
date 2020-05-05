package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Movie;
import vu.lt.persistence.MoviesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Movies {
    @Inject
    private MoviesDAO moviesDAO;

    @Getter
    @Setter
    private Movie movieToCreate = new Movie();

    @Getter
    private List<Movie> allMovies;

    @PostConstruct
    public void init(){
        loadAllMovies();
    }

    @Transactional
    public String createMovie(){
        this.moviesDAO.persist(movieToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllMovies(){
        this.allMovies = moviesDAO.loadAll();
    }
}
