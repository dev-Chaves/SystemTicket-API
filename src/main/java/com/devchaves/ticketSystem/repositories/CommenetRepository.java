package com.devchaves.ticketSystem.repositories;

import com.devchaves.ticketSystem.models.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommenetRepository extends JpaRepository<CommentModel, UUID> {
}
