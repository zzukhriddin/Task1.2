package com.epam.esm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiftCertificate {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer duration;
    private Timestamp create_date;
    private Timestamp last_update_date;

}
