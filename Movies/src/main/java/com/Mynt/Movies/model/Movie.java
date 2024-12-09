package com.Mynt.Movies.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "movie") // Explicitly specifying the table name
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name") // Specify name in the column
    private String name;

    @Column(name = "year_released")
    private Integer yearReleased;

    @Column(name = "is_sequel")
    private Boolean isSequel;

    // Mapping the genre as an element collection
    @ElementCollection(targetClass = com.mynt.Movies.model.Genre.class)
    @CollectionTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movie_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private List<com.mynt.Movies.model.Genre> genre;

    // Mapping the cast list as an element collection
    @ElementCollection
    @CollectionTable(name = "movie_cast", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "actor_name")
    private List<String> castList;

}
