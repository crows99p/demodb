package jp.co.demo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.demo.entities.My2Data;

@Service
@Transactional
public class My2Service {

    @Autowired
    NamedParameterJdbcTemplate jdbc;

// ID指定検索（1件検索）
    public List<Map<String, Object>> findUser(Long id){
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        String sql = "SELECT * FROM my2data WHERE id = :id";
        System.out.println("SQL:" + sql);
        return jdbc.queryForList(sql, param);

    }

// 全件検索
    public List<My2Data> findUsers(){
        String sql = "SELECT * FROM my2data ORDER BY id";
        System.out.println("SQL:" + sql);
        return jdbc.query(sql, new BeanPropertyRowMapper<My2Data>(My2Data.class));
    }

// 登録（更新）
    public My2Data save(My2Data user) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(user);

        String sql_u = "UPDATE my2data "
        		+ "SET name = :name, email = :email "
        		+ "WHERE id = :id";

        String sql_i = "INSERT INTO my2data(name, email) "
        		+ "VALUES (:name, :email)";

        if (user.getId() == null) {
            System.out.println("SQL:" + sql_i);
            jdbc.update(sql_i, param);

        } else {
            System.out.println("SQL:" + sql_u);
            jdbc.update(sql_u, param);
        }

        return user;
    }

 // ID指定削除（1件削除）
    public void deleteUser(Long id) {
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        String sql = "DELETE FROM my2data WHERE id = :id";
        System.out.println("SQL:" + sql);
        jdbc.update(sql, param);
    }

// 全件削除
    public void deleteUsers() {
        String sql = "DELETE FROM my2data";
        System.out.println("SQL:" + sql);
        jdbc.update(sql, new HashMap<>());
    }
}
