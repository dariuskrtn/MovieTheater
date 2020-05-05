package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "select u from User as u")
})
@Table(name = "USER")
@Getter @Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @Size(max = 50)
    @Column(name = "SURNAME")
    private String surname;

    @ManyToMany(mappedBy = "usersInSession")
    private List<Session> sessions;

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
