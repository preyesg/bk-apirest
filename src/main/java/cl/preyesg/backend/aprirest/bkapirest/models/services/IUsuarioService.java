package cl.preyesg.backend.aprirest.bkapirest.models.services;

import cl.preyesg.backend.aprirest.bkapirest.models.entity.Usuario;

import java.util.List;


public interface IUsuarioService {

    public List<Usuario> findAll();

    public Usuario save(Usuario usuario);

}
