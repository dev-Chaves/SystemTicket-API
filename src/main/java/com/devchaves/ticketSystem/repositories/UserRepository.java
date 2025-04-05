package com.devchaves.ticketSystem.repositories;

import com.devchaves.ticketSystem.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

    Optional<UserModel> findUserByUserName(String usersName);

}
