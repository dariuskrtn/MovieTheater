package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Session.findAll", query = "select s from Session as s")
})
@Table(name = "SESSION")
@Getter @Setter
public class Session implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @Column(name = "SESSION_TIME")
    private Date sessionTime;

    @Column(name = "TICKET_PRICE")
    private Double ticketPrice;

    @Column(name = "TICKETS_TOTAL")
    private Integer ticketsTotal;

    @ManyToMany
    @JoinTable(
            name = "SESSION_USER",
            joinColumns = @JoinColumn(name = "SESSION_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private List<User> usersInSession;
}
