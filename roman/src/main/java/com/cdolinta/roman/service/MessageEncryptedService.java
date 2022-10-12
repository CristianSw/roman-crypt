package com.cdolinta.roman.service;

import com.cdolinta.roman.model.Alphabet;
import com.cdolinta.roman.model.Message;
import com.cdolinta.roman.model.dto.MessageDto;
import com.cdolinta.roman.model.dto.MessageEncryptedDto;
import com.cdolinta.roman.model.mapper.MessageDtoMapper;
import com.cdolinta.roman.model.mapper.MessageEncryptedDtoMapper;
import com.cdolinta.roman.repository.AlphabetRepository;
import com.cdolinta.roman.repository.MessageEncryptedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageEncryptedService {
    private final MessageEncryptedRepository repository;
    private final AlphabetRepository alphabetRepository;
    private final MessageEncryptedDtoMapper mapperEncrypted;
    private final MessageDtoMapper mapperMessage;


    public Optional<MessageEncryptedDto> findMessageEncryptedById(Long id){
        return repository.findById(id).map(mapperEncrypted::map);
    }

    public void saveMessageEncrypted(MessageEncryptedDto dto){
        repository.save(mapperEncrypted.map(dto));
    }
    public void deleteMessageEncrypted(MessageEncryptedDto dto){
        repository.delete(mapperEncrypted.map(dto));
    }

    void encryptMessage(MessageDto messageDto, Integer n){
        List<Alphabet> alphabet = alphabetRepository.findAll();
        Message messageFromDto = mapperMessage.map(messageDto);
        String message = messageFromDto.getMessagge();
        List<Character> messageLetters = new ArrayList<>();
        List<Character> encryptedLetters = new ArrayList<>();

        for (int i = 0; i < message.length(); i++) {
            messageLetters.add(message.charAt(i));
        }
        for (int i = 0; i < messageLetters.size(); i++) {
            int finalI = i;
            Optional<Alphabet> first = alphabet.stream()
                    .filter(x -> x.getLetter().equals(messageLetters.get(finalI)))
                    .findFirst();
            Long id = first.get().getId();
            Alphabet encryptedLetterByN = alphabet.get((int) (id + n));
            encryptedLetters.add(encryptedLetterByN.getLetter());
        }
        String encryptedString = encryptedLetters.toString();
        MessageEncryptedDto messageToReturn = new MessageEncryptedDto();
        messageToReturn.setMessageEncrypted(encryptedString);
        repository.save(mapperEncrypted.map(messageToReturn));
    }
}
