package cl.preyesg.backend.aprirest.bkapirest.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
public class Usuario implements Serializable {
    public Usuario(){

    }


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;
    @NotEmpty(message="no puede ser vacio")
    private String name;
    @NotEmpty(message="no puede ser vacio")
    @Column(nullable=false, unique=true)
    @Email
    private String email;
    @Column(name = "status")
    private String status;
    @NotEmpty(message="no puede ser vacio")
    @Pattern(regexp = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$")
    @Column(nullable=false)
    private String password;
    @Column(name="create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @PrePersist
    public void prePersist() {
        createAt = new Date();
        status = "Activo";
    }
   //@OneToMany(fetch = FetchType.LAZY, mappedBy = "idUsuario", cascade = CascadeType.ALL)
    //@JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario",
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REMOVE
            })
    List<Phone> phones;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public Date getCreateAt() {
        return createAt;
    }
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}

