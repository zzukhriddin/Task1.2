package com.epam.esm.repository;

import com.epam.esm.entity.Gift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GiftRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Gift> getAll() {
        return jdbcTemplate.query("SELECT * FROM product", new BeanPropertyRowMapper<>(Gift.class));
    }


    public Gift getById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM gift WHERE id=?", new BeanPropertyRowMapper<>(Gift.class), id);
    }


    public int save(Gift gift) {
        return jdbcTemplate.update("INSERT INTO gift(id, name, description, price) VALUES(?, ?, ?)", new Object[] {gift.getId(),gift.getName(),gift.getDescription(),gift.getPrice()});
    }


    public int update(Gift gift, Long id) {
        return jdbcTemplate.update("UPDATE gift SET id=?, name=?, description=?, price=? WHERE id=?", new Object[] {gift.getId(),gift.getName(),gift.getDescription(),gift.getPrice(), id});
    }


    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM gift WHERE id=?", id);
    }
}