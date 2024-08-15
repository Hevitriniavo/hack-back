package com.fresh.coding.hackback.repositories;

import com.fresh.coding.hackback.entities.Role;
import com.fresh.coding.hackback.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
