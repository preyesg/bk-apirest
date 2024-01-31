package cl.preyesg.backend.aprirest.bkapirest.models.dao;

import cl.preyesg.backend.aprirest.bkapirest.models.entity.Phone;
import org.springframework.data.repository.CrudRepository;

public interface IPhoneDao extends CrudRepository<Phone, Long> {
}
