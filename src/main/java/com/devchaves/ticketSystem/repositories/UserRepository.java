package com.devchaves.ticketSystem.repositories;

import com.devchaves.ticketSystem.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    Optional<UserModel> findUserByUsersName(String usersName);

}
