package com.cdolinta.roman.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageEncryptedDto {
    private Long id;
    private String messageEncrypted;
}
