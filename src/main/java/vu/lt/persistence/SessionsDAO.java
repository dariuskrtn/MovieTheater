package vu.lt.persistence;

import vu.lt.entities.Movie;
import vu.lt.entities.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class SessionsDAO {
    @Inject
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Session> loadAll() {
        return em.createNamedQuery("Session.findAll", Session.class).getResultList();
    }

    public void persist(Session session){
        this.em.persist(session);
    }
}
