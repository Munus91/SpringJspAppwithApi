package com.nmironov.internetshop.repository.admin;



import com.nmironov.internetshop.model.Good;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodRowMapper implements RowMapper<Good> {

    @Override
    public Good mapRow(ResultSet rs, int rowNum) throws SQLException {
        Good good = new Good();

        good.setGoodId(rs.getLong("good_id"));
        good.setName(rs.getString("name"));
        good.setCategory(rs.getString("category"));
        good.setSubcategory(rs.getString("sub_category"));
        good.setTrademark(rs.getString("trade_mark"));
        good.setCountryName(rs.getString("country_name"));
        //good.setCountryId(rs.getLong("country_id"));
        good.setPrice(rs.getBigDecimal("price"));
        good.setAmount(rs.getInt("amount"));
        good.setGoodDescription(rs.getString("good_description"));
        good.setCreatedAt(rs.getTimestamp("created_at"));
        good.setUpdatedAt(rs.getTimestamp("updated_at"));
        return good;
    }


}
