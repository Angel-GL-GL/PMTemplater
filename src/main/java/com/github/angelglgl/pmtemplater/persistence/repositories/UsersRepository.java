package com.github.angelglgl.pmtemplater.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.angelglgl.pmtemplater.persistence.entities.UsersEntity;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    @Query("SELECT u FROM UsersEntity u WHERE u.userEmail = :userEmail")
    Optional<UsersEntity> findByUserEmail(@Param("userEmail") String userEmail);
}