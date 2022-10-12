package com.cdolinta.roman.model.mapper;

import com.cdolinta.roman.model.MessageEncrypted;
import com.cdolinta.roman.model.dto.MessageEncryptedDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MessageEncryptedDtoMapper {
    MessageEncryptedDto map(MessageEncrypted product);

    MessageEncrypted map(MessageEncryptedDto dto);
}
