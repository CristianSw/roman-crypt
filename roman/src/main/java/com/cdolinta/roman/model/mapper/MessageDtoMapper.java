package com.cdolinta.roman.model.mapper;

import com.cdolinta.roman.model.Message;
import com.cdolinta.roman.model.dto.MessageDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MessageDtoMapper {
    MessageDto map(Message product);

    Message map(MessageDto dto);
}
