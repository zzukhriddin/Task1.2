package com.epam.esm.repository;

import com.epam.esm.entity.Tag;
import com.epam.esm.payload.TagDto;

import java.util.List;

public interface TagDAO {
    List<Tag> getAll();

    Tag getById(Long id);

    long save(TagDto tagDto);


    long deleteById(Long id);
}
