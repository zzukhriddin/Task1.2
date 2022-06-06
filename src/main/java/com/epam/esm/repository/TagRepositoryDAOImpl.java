package com.epam.esm.repository;

import com.epam.esm.entity.Tag;
import com.epam.esm.payload.TagDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TagRepositoryDAOImpl implements TagDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Tag> getAll() {
        return jdbcTemplate.query("SELECT * FROM tag", new BeanPropertyRowMapper<>(Tag.class));
    }

    @Override
    public Tag getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM tag WHERE id=?", new BeanPropertyRowMapper<>(Tag.class), id);
    }


    @Override
    public long save(TagDto tagDto) {
        return jdbcTemplate.update("INSERT INTO tag(name) VALUES(?, ?, ?)", new Object[] {tagDto.getName()});
    }

    @Override
    public long deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM tag WHERE id=?", id);
    }
}
