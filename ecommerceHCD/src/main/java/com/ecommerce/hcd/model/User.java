package com.ecommerce.hcd.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ecommerce.hcd.model.enumerated.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
   
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", length = 55, nullable = false)
    private String username;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 255 ,nullable = false)
    private String password;

    @Column(name = "profile_img_url", length = 255)
    private String profileImgUrl;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "surnames", length = 150)
    private String surnames;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;
    
    @Column(name = "create_at")
    private LocalDateTime create_at = LocalDateTime.now();

    @OneToOne(mappedBy = "user", orphanRemoval = true)
    private Cart cart;


    public User(){
    }

    public User(String username, String email, String password, String profileImgUrl) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profileImgUrl = profileImgUrl;
    }

    public User(String username, String email, String password, String profileImgUrl, String name, String surnames, LocalDate birthday) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profileImgUrl = profileImgUrl;
        this.name = name;
        this.surnames = surnames;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setProfileImgUrl(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
            + ", profileImgUrl=" + profileImgUrl + ", name=" + name + ", surnames=" + surnames + ", birthday=" + birthday + ", role=" + role + ", create_at=" + create_at + ", cart=" + cart
            + "]";
    }

}
