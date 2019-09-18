package com.kulpekin.imail.service.interfaces;

import com.kulpekin.imail.models.SMS;

import java.util.List;

public interface SMSServiceInterface {

    void sentAndSaveSMS(SMS sms);
    SMS getSMSById(int id);
    void removeSMS(int id);
    List<SMS> findSMSByTos(String emailUser);

}
