package com.enigma.jpa_wmbrod.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "m_user_credential")
public class UserCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_credential_seq")
    @SequenceGenerator(name = "user_credential_seq", sequenceName = "m_user_credential_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public UserCredential() {
    }

    public UserCredential(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
