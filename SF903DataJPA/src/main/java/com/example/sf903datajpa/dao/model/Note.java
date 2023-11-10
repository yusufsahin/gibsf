package com.example.sf903datajpa.dao.model;

import jakarta.persistence.*;
import lombok.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "Notes")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id",nullable = false)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;


}