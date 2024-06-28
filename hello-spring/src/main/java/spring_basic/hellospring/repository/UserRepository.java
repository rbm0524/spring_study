package spring_basic.hellospring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import spring_basic.hellospring.domain.User;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean login(String id, String password) {
        try {
            String sql = "SELECT * FROM Users WHERE u_id = ? AND u_pw = ?";
            List<User> users = jdbcTemplate.query(sql, new Object[] {id, password}, new BeanPropertyRowMapper<User>() {});

            if(users.isEmpty()) {
                return false;
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public boolean addUser(String id, String password) {
        try {
            String sql = "INSERT INTO Users (u_id, u_pw) VALUES (?, ?)";
            jdbcTemplate.update(sql, id, password);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
