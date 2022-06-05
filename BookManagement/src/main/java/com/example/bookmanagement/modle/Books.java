package com.example.bookmanagement.modle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Books {
    @Id
    @NotNull
    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String genre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Loan> loans;

}
