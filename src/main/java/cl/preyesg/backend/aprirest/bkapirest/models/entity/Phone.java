package cl.preyesg.backend.aprirest.bkapirest.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Phone {

    public Phone(){

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    private String number;
    private String citycode;


    public String getContrycode() {
        return contrycode;
    }

    public void setContrycode(String contrycode) {
        this.contrycode = contrycode;
    }

    private String contrycode;

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    @ManyToOne(cascade= { CascadeType.ALL})
    @JsonBackReference
    @JoinColumns(value = { @JoinColumn(referencedColumnName = "id")}, foreignKey = @ForeignKey(name = "usuario_id"))
    private Usuario usuario;


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
