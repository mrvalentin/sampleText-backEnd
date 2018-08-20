package com.example.demo.database;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "text")
public class DAO extends AuditModel{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "text_id")
    @SequenceGenerator(
            name = "text_id",
            sequenceName = "text_sequence",
            initialValue = 1000
    )
    private Long id;

    @Size(max = 50)
    @Column(columnDefinition = "text")
    private String text;

    public DAO(String text) {
        this.text = text;
    }

    public DAO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
