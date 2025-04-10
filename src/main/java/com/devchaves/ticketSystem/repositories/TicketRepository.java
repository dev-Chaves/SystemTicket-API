package com.devchaves.ticketSystem.repositories;

import com.devchaves.ticketSystem.models.TicketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<TicketModel, UUID> {

}
