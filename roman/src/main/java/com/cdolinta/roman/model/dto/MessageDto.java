package com.cdolinta.roman.model.dto;

import com.cdolinta.roman.model.MessageEncrypted;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private Long id;

    private String message;
    private MessageEncrypted messageCrypted;
}
