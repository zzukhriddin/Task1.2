package com.epam.esm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GiftCertificate {
    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int duration;
    private Timestamp create_date;
    private Timestamp last_update_date;

    @ManyToMany
    List<Tag> tags;
}
