package cl.preyesg.backend.aprirest.bkapirest.models.services;

import java.util.List;

import cl.preyesg.backend.aprirest.bkapirest.models.dao.IPhoneDao;
import cl.preyesg.backend.aprirest.bkapirest.models.dao.IUsuarioDao;
import cl.preyesg.backend.aprirest.bkapirest.models.entity.Phone;
import cl.preyesg.backend.aprirest.bkapirest.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    IUsuarioDao dao;

    @Autowired
    IPhoneDao iPhoneDao;

    @Override
    public List<Usuario> findAll() {
        // TODO Auto-generated method stub
        return (List<Usuario>) dao.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
        String uuid = java.util.UUID.randomUUID().toString();
        usuario.setId(uuid);
        for (Phone phone : usuario.getPhones()) {
            phone.setUsuario(usuario);
        }
        return  dao.save(usuario);
    }



}
