package com.zhanziwei.dao.impl;

import com.zhanziwei.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    public int update(String sql, Object ... args) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
    public<T> T queryForOne(Class<T> type, String sql, Object ... args) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JdbcUtils.close(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public<T> List<T> queryForList(Class<T> type, String sql, Object ... args) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Object queryForSingleValues(String sql, Object ... args) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtils.close(connection);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
