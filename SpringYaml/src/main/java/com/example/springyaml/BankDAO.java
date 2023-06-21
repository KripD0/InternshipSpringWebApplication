package com.example.springyaml;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class BankDAO {

    private JdbcTemplate jdbcTemplate;

    public BankDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //TODO Идея постоянно просит выбрать schemas, как это убрать или исправить, просто постоянно выбирать надоедает.

    public List<Bank> selectAllBank(){
        return jdbcTemplate.query("SELECt * FROM bank", new BeanPropertyRowMapper<>(Bank.class));
    }

//    @PostConstruct
//    public void updateAllBanks(){
//        List<Bank> list = selectAllBank();
//        jdbcTemplate.batchUpdate("UPDATE bank SET name = ? WHERE  id = ?", new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps, int i) throws SQLException {
//                ps.setString(1, "Альфа");
//                ps.setInt(2, list.get(i).getId());
//            }
//
//            @Override
//            public int getBatchSize() {
//                return list.size();
//            }
//        });
//    }
}
