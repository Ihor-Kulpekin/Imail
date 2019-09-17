package com.kulpekin.imail.dao.interfaces;

import com.kulpekin.imail.models.Message;

public interface MessageDaoInterface {

    void sentAndSaveMessage(Message message);

    void deleteMessage(int id);
}
