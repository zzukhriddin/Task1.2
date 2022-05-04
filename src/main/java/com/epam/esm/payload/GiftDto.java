package com.epam.esm.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiftDto {
    private String name;
    private String description;
    private Double price;
    private Timestamp duration;
    private Timestamp create_date;
    private Timestamp last_update_date;
}
