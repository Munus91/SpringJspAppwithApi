package com.nmironov.internetshop.repository.admin;


import com.nmironov.internetshop.model.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;


@Component
public class GoodRepositoryImpl implements GoodRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL = "SELECT * FROM goods ORDER BY created_at";
    private static final String SQL_GET_ALL_ACTIVE =
            "SELECT g.good_id, g.name, g.category, g.sub_category, g.trade_mark, c.name as country_name, g.price, g.amount, g.good_description, g.created_at, g.updated_at  FROM goods g JOIN countries c ON g.country_id = c.country_id  WHERE g.archived = FALSE ORDER BY g.created_at";



    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    public List<Good> getAllGoods() {

        List<Good> allGoods = jdbcTemplate.query(SQL_GET_ALL_ACTIVE, new GoodRowMapper());
        return allGoods;
    }

    public Good getGoodById(Long goodId) {

        String query =
                "SELECT g.good_id, g.name, g.category, g.sub_category, g.trade_mark, c.name as country_name, g.price, g.amount, g.good_description, g.created_at, g.updated_at  FROM goods g JOIN countries c ON g.country_id = c.country_id  WHERE g.archived = FALSE AND g.good_id = :good_id ORDER BY g.created_at";

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("good_id", goodId);
        Good good = jdbcTemplate.queryForObject(query, namedParameters, new GoodRowMapper());

        return good;
    }


    public void addGood(Good good) {

        String query =
                "INSERT INTO goods (name,category,sub_category,trade_mark,country_id,price,amount,good_description,created_at,updated_at) "
                        +
                        "VALUES (:name,:category,:sub_category,:trade_mark,:country_id,:price,:amount,:good_description,:created_at,:updated_at);";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("name", good.getName())
                .addValue("category", good.getCategory())
                .addValue("sub_category", good.getSubcategory())
                .addValue("trade_mark", good.getTrademark())
                .addValue("country_id", good.getCountryId())
                .addValue("price", good.getPrice())
                .addValue("amount", good.getAmount())
                .addValue("good_description", good.getGoodDescription())
                .addValue("created_at", Timestamp.from(
                        Instant.now()))
                .addValue("updated_at", Timestamp.from(Instant.now()));
        this.jdbcTemplate.update(query, namedParameters);

    }


    public void deleteGood(Long goodId) {

        String query = "UPDATE goods SET archived = TRUE WHERE good_id = :good_id;";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("good_id", goodId);
        this.jdbcTemplate.update(query, namedParameters);

    }

    public void updateGood(Good good) {

        String query =
                "UPDATE goods SET "
                        + "name = :name , "
                        + "category = :category, "
                        + "sub_category = :sub_category, "
                        + "trade_mark = :trade_mark,"
                        + "country_id = :country_id,"

                        // + "country_id = :country_id,"// select уже с хидден полями
                        + "price = :price,"
                        + "amount = :amount,"
                        + "good_description = :good_description,"
                        + "updated_at = :updated_at"
                        + "  WHERE good_id = :good_id";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("good_id", good.getGoodId())
                .addValue("name", good.getName())
                .addValue("category", good.getCategory())
                .addValue("sub_category", good.getSubcategory())
                .addValue("trade_mark", good.getTrademark())
                .addValue("country_id", good.getCountryId())//evaluate country id by name
                .addValue("price", good.getPrice())
                .addValue("amount", good.getAmount())
                .addValue("good_description", good.getGoodDescription())
                .addValue("updated_at", Timestamp.from(Instant.now()));
        this.jdbcTemplate.update(query, namedParameters);

    }
}

