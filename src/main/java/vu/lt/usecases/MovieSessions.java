package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Movie;
import vu.lt.entities.Session;
import vu.lt.persistence.MoviesDAO;
import vu.lt.persistence.SessionsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class MovieSessions {
    @Inject
    private MoviesDAO moviesDAO;

    @Inject
    private SessionsDAO sessionsDAO;

    @Getter
    @Setter
    private Session sessionToCreate = new Session();

    @Getter @Setter
    private Movie movie;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer movieId = Integer.parseInt(requestParameters.get("movieId"));
        this.movie = moviesDAO.findOne(movieId);
    }

    @Transactional
    public String createSession(){
        sessionToCreate.setMovie(this.movie);
        sessionsDAO.persist(sessionToCreate);
        return "movieSessions?faces-redirect=true&movieId=" + movie.getId();
    }
}
