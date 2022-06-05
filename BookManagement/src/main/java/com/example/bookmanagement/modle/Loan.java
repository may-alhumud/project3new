package com.example.bookmanagement.modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Loan {
    @Id
    @NotNull
    private Integer id;
    @NotNull
    private Integer userid;
    @NotNull
    private Integer  bookid;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Books> books;

}
