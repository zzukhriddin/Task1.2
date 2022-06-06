package com.epam.esm.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiftDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int duration;
    private LocalDateTime create_date;
    private LocalDateTime last_update_date;

    private List<TagDto> tags;
}
