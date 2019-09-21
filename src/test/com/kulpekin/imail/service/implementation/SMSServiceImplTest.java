package com.kulpekin.imail.service.implementation;

import com.kulpekin.imail.models.SMS;
import com.kulpekin.imail.service.interfaces.SMSServiceInterface;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@Transactional
@Rollback
@RunWith(SpringRunner.class)
public class SMSServiceImplTest {

    @Autowired
    private SMSServiceInterface smsServiceInterface;


    private SMS expectedSMS;

    @Before
    public void setUp() {
        expectedSMS = new SMS();
        expectedSMS.setTos("tos");
        expectedSMS.setFroms("froms");
        expectedSMS.setContents("contents");
        expectedSMS.setSubjects("subjects");
        smsServiceInterface.sentAndSaveSMS(expectedSMS);
    }

    @Test
    public void sentAndSaveSMSTest() {
        SMS sms = smsServiceInterface.getSMSById(expectedSMS.getId());
        assertEquals(expectedSMS,sms);
    }

    @Test
    public void getSMSByIdTest() {
        List<SMS> smsList = smsServiceInterface.findSMSByTos(expectedSMS.getTos());
        SMS smsFromList = smsList.get(0);
        SMS smsGotById = smsServiceInterface.getSMSById(smsFromList.getId());
        assertNotNull(smsGotById);
    }

    @Test
    public void removeSMSTest() {
        assertEquals(1L,smsServiceInterface.findSMSByTos(expectedSMS.getTos()).size());
        smsServiceInterface.removeSMS(expectedSMS.getId());
        assertEquals(0L,smsServiceInterface.findSMSByTos(expectedSMS.getTos()).size());
    }

    @Test
    public void findSMSByTosTest() {
        smsServiceInterface.sentAndSaveSMS(expectedSMS);
        int sizeList = smsServiceInterface.findSMSByTos(expectedSMS.getTos()).size();
        assertEquals(sizeList,smsServiceInterface.findSMSByTos(expectedSMS.getTos()).size());
    }

}