package com.nmironov.internetshop.repository.admin;


import com.nmironov.internetshop.model.User;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {


    private static final String SQL_GET_ALL_ACTIVE =
            "SELECT * FROM users WHERE archived = FALSE ORDER BY created_at";
    NamedParameterJdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User getUserById(Long user_Id) {


        String query =
                "SELECT * FROM users WHERE archived = FALSE AND user_id = :user_id ORDER BY created_at";

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("user_id", user_Id);
        User user = jdbcTemplate.queryForObject(query, namedParameters, new UserRowMapper());
        return user;
    }

    public User getAdminById(Long user_Id) {
        String query =
                "SELECT * FROM users WHERE archived = FALSE AND user_id = :user_id AND role='ADMIN' ORDER BY created_at";

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("user_id", user_Id);
        User user = jdbcTemplate.queryForObject(query, namedParameters, new UserRowMapper());
        return user;
    }


    public User getUserByUsername(String username) {

        String query =
                "SELECT *  FROM users  WHERE archived = FALSE AND username = :username ORDER BY created_at";

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("username", username);
        User user = jdbcTemplate.queryForObject(query, namedParameters, new UserRowMapper());
        return user;
    }



    public List<User> getAllUsers() {
        List<User> allUsers = jdbcTemplate.query(SQL_GET_ALL_ACTIVE, new UserRowMapper());
        return allUsers;
    }

    public void deleteUser(Long userId) {
        String query = "UPDATE users SET archived = TRUE WHERE user_id = :user_id;";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("user_id", userId);
        this.jdbcTemplate.update(query, namedParameters);
    }

    public void updateUser(User user) {

        String query =
                "UPDATE users SET "
                        + "username = :username , "
                        + "name = :name, "
                        + "surname = :surname, "
                        + "city = :city,"
                        + "addressline1 = :addressline1,"
                        + "addressline2 = :addressline2,"
                        + "updated_at = :updated_at"
                        + "  WHERE user_id = :user_id";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("user_id", user.getUserId())
                .addValue("username", user.getUsername())
                .addValue("name", user.getName())
                .addValue("surname", user.getSurname())
                .addValue("city", user.getCity())
                .addValue("addressline1", user.getAddressLine1())//evaluate country id by name
                .addValue("addressline2", user.getAddressLine2())
                .addValue("updated_at", Timestamp.from(Instant.now()));
        this.jdbcTemplate.update(query, namedParameters);
    }

}

