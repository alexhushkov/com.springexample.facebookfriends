package dao;

import facebook.FbFriend;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Implemention of {@code ContactDAO} provides access
 * to dataBase through jdbc
 */
@Component
public class JdbcContactDAO implements ContactDAO {

    private JdbcTemplate jdbcTemplate;

    /**
     * Constructs and initialises jdbcTemplate
     * @param dataSource - includes database configuration
     */
    public JdbcContactDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Inserts {@code list<FbFriends>} into facebookFriends db
     * @param friends {@code List<FbFriends>}
     */
    public void insertAllFriends(List<FbFriend> friends) {

        String queryInsert = "INSERT INTO facebookFriends (name) VALUES (?)";

        for (FbFriend friend : friends) {
            jdbcTemplate.update(queryInsert, friend.getName());
        }
    }

    /**
     * Selects all data from facebookFriends
     * @return {@code List<FbFriends>}
     */
    public List<FbFriend> getFriends() {

        String querySelect = "SELECT * FROM facebookFriends";
        List<FbFriend> friends = new ArrayList<FbFriend>();
        List<Map<String,Object>> rows = jdbcTemplate.queryForList(querySelect);

        for (Map<String, Object> row : rows) {

            FbFriend friend = new FbFriend();
            friend.setId((Integer)row.get("id"));
            friend.setName((String)row.get("name"));

            friends.add(friend);
        }

        return friends;
    }
}
