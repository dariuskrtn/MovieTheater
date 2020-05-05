package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@Entity
@NamedQueries({
        @NamedQuery(name = "Movie.findAll", query = "select m from Movie as m")
})
@Table(name = "MOVIE")
@Getter @Setter
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 100)
    @Column(name = "NAME")
    private String name;

    @Size(max = 1000)
    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "movie")
    private List<Session> sessions;
}