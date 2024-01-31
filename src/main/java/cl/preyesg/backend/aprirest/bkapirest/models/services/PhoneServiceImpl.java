package cl.preyesg.backend.aprirest.bkapirest.models.services;

import cl.preyesg.backend.aprirest.bkapirest.models.dao.IPhoneDao;
import cl.preyesg.backend.aprirest.bkapirest.models.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements IPhoneService{

    @Autowired
    IPhoneDao iPhoneDao;

    @Override
    public Phone save(Phone phone) {

        return iPhoneDao.save(phone);
    }
}
