package com.example.bookmanagement.modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class User1 {
    @Id
    @NotNull
    private Integer id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String  password;

}
