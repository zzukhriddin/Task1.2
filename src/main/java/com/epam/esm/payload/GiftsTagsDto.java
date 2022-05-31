package com.epam.esm.payload;

import java.sql.Timestamp;

public interface GiftsTagsDto {
    Long getId();
    String getName();
    String getDescription();
    Double getPrice();
    Integer getDuration();
    Timestamp getCreate_date();
    Timestamp getLast_update_date();

}
