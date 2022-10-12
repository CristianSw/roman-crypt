package com.cdolinta.roman.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String messagge;

    @OneToOne(mappedBy = "message",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private MessageEncrypted messageCrypted;
}
