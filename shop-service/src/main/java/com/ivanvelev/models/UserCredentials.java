package com.ivanvelev.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity(name = "user_credentials")
@Table(name = "user_credentials", schema = "shop")
public class UserCredentials {

    @Id
    @Column(name = "username")
    @NotNull
    private String username;

    @Column(name = "password")
    @NotNull
    @JsonIgnore
    private String password;

    @Column(name = "email")
    @NotNull
    @JsonIgnore
    private String email;

    public UserCredentials() {
    }

    public UserCredentials(@NotNull String username, @NotNull String password, @NotNull String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "users_roles",
//            joinColumns = @JoinColumn(name = "credentials_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles;

}
