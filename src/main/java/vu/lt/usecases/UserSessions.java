package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Session;
import vu.lt.entities.User;
import vu.lt.persistence.SessionsDAO;
import vu.lt.persistence.UsersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class UserSessions {
    @Inject
    private UsersDAO usersDAO;

    @Inject
    private SessionsDAO sessionsDAO;

    @Getter @Setter
    private User user;

    @Getter @Setter
    private List<Session> allSessions;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer userId = Integer.parseInt(requestParameters.get("userId"));
        user = usersDAO.findOne(userId);

        loadAllSessions();
    }

    @Transactional
    public String buyTicket(Session session){
        List<User> newUsersInSession = session.getUsersInSession();
        newUsersInSession.add(user);
        session.setUsersInSession(newUsersInSession);
        sessionsDAO.persist(session);
        return "userSessions?faces-redirect=true&userId="+user.getId();
    }

    private void loadAllSessions() {
        this.allSessions = sessionsDAO.loadAll();
    }
}
