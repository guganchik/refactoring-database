package com.example.coursework.database.repositories;

import lombok.RequiredArgsConstructor;
import com.example.coursework.database.Result;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ResultRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Result> allResult(int price) {
        String sql = "SELECT computercasesid, computercases, datastorageid, datastorage," +
                " motherboardsid, motherboards, powersupplyid, powersupply, processorsid," +
                " processors, ram_memoryid, ram_memory, graphicscardsid," +
                " graphicscards, price FROM getcomputerforprice(?)";
        return jdbcTemplate.query(sql, new Object[]{price}, new ResultRowMapper());
    }

    private static class ResultRowMapper implements RowMapper<Result> {

        @Override
        public Result mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Result(
                    rs.getInt("computercasesid"),
                    rs.getString("computercases"),
                    rs.getInt("datastorageid"),
                    rs.getString("datastorage"),
                    rs.getInt("motherboardsid"),
                    rs.getString("motherboards"),
                    rs.getInt("powersupplyid"),
                    rs.getString("powersupply"),
                    rs.getInt("processorsid"),
                    rs.getString("processors"),
                    rs.getInt("ram_memoryid"),
                    rs.getString("ram_memory"),
                    rs.getInt("graphicscardsid"),
                    rs.getString("graphicscards"),
                    rs.getInt("price")
            );
        }
    }
}
