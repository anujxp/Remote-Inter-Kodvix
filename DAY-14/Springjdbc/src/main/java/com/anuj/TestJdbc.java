package com.anuj;

import com.anuj.config.SpringConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

class TestJdbc {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        // 1. INSERT
        String insertSql = "INSERT INTO student VALUES(?,?,?)";
        jdbcTemplate.update(insertSql, 101, "Anuj", 95.5f);

        // 2. UPDATE
        String updateSql = "UPDATE student SET std_marks=? WHERE std_roll=?";
        jdbcTemplate.update(updateSql, 98.0f, 101);

        // 3. SELECT (Multiple)
        String selectSql = "SELECT * FROM student";
        List<Student> stdList = jdbcTemplate.query(selectSql, new StudentRowMapper());
        for (Student s : stdList) {
            System.out.println("Roll: " + s.getRollNumber() + ", Name: " + s.getName());
        }

        // 4. DELETE
        String deleteSql = "DELETE FROM student WHERE std_roll=?";
        jdbcTemplate.update(deleteSql, 101);
    }
}
