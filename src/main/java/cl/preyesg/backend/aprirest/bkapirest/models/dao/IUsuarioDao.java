package cl.preyesg.backend.aprirest.bkapirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import cl.preyesg.backend.aprirest.bkapirest.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}