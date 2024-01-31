package cl.preyesg.backend.aprirest.bkapirest.models.entity;

import jakarta.persistence.*;

@Entity
public class Phone {

    public Phone(){

    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    private String number;
    private String citycode;
    private String countrycode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
