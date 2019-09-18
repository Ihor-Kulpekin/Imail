package com.kulpekin.imail.dao.interfaces;

import com.kulpekin.imail.models.SMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SMSDaoInterface extends JpaRepository<SMS,Integer> {

    List<SMS> findSMSByTos(String emailUser);

}
