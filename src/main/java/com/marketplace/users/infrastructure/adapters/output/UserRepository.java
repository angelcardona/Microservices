package com.marketplace.users.infrastructure.adapters.output;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketplace.users.infrastructure.adapters.output.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{

    
}
