package com.kulpekin.imail.dao.interfaces;

import com.kulpekin.imail.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDaoInterface extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
