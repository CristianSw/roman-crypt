package com.cdolinta.roman.repository;

import com.cdolinta.roman.model.MessageEncrypted;
import com.cdolinta.roman.model.dto.MessageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageEncryptedRepository extends JpaRepository<MessageEncrypted, Long> {
void encryptMessage(MessageDto messageDto, Integer n);
}
