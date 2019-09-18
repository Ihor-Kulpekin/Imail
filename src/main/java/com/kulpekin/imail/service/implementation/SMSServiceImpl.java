package com.kulpekin.imail.service.implementation;

import com.kulpekin.imail.dao.interfaces.SMSDaoInterface;
import com.kulpekin.imail.models.SMS;
import com.kulpekin.imail.service.interfaces.SMSServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SMSServiceImpl implements SMSServiceInterface {

    private final SMSDaoInterface smsDaoInterface;

    @Autowired
    public SMSServiceImpl(SMSDaoInterface smsDaoInterface) {
        this.smsDaoInterface = smsDaoInterface;
    }

    @Override
    public void sentAndSaveSMS(SMS sms) {
        smsDaoInterface.save(sms);
    }

    @Override
    public SMS getSMSById(int id) {

        return smsDaoInterface.getOne(id);
    }

    @Override
    public void removeSMS(int id) {
        smsDaoInterface.deleteById(id);
    }

    @Override
    public List<SMS> findSMSByTos(String emailUser) {
        return smsDaoInterface.findSMSByTos(emailUser);
    }
}
