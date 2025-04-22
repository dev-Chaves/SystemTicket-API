package com.devchaves.ticketSystem.util.converters;

import com.devchaves.ticketSystem.DTOS.CommentDTO.CommentRequestDTO;
import com.devchaves.ticketSystem.models.CommentModel;
import com.devchaves.ticketSystem.util.converterDTOLogic.DTOConverter;

import java.time.LocalDateTime;

public class CommentRequestToModelConverter implements DTOConverter<CommentModel, CommentRequestDTO> {
    @Override
    public CommentRequestDTO convert(CommentModel source) {

        CommentModel comment = new CommentModel();

        comment.setComment_id(source.getComment_id());
        comment.setUser(source.getUser());
        comment.setComment_text(source.getComment_text());
        comment.setCreated_at(LocalDateTime.now());

        return null;
    }
}
