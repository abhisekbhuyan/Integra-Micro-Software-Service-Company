package com.integra.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.integra.entity.UserMasterEntity;

public interface UserMasterRepository extends JpaRepository<UserMasterEntity, Integer> {
    UserMasterEntity findByempid(int emp_id);
}