package com.zhanziwei.test;

import com.zhanziwei.utils.JdbcUtils;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class JdbcUtilsTest {

    @Test
    public void getConnection() throws SQLException {
        for (int i = 0; i < 100; i++) {
            System.out.println(JdbcUtils.getConnection());
        }
    }

}