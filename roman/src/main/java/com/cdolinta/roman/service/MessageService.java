package com.cdolinta.roman.service;

import com.cdolinta.roman.model.Message;
import com.cdolinta.roman.model.dto.MessageDto;
import com.cdolinta.roman.model.mapper.MessageDtoMapper;
import com.cdolinta.roman.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository repository;
    private final MessageDtoMapper mapper;

    public Optional<MessageDto> findMessageById(Long id){
    return repository.findById(id).map(mapper::map);
    }

    public void saveMessage(MessageDto dto){
        repository.save(mapper.map(dto));
    }
    public void deleteMessage(MessageDto dto){
        repository.delete(mapper.map(dto));
    }
}
