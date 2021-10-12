package io.github.gaojizhou;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author gaojizhou
 */
public class ListObjectHandler extends BaseTypeHandler<List<String>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        String type = getType(parameter);
        Connection conn = ps.getConnection();
        Array array = conn.createArrayOf(type, parameter.toArray());
        ps.setArray(i, array);
    }

    @Override
    public List<String> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return getList(resultSet.getArray(s));
    }

    @Override
    public List<String> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return getList(resultSet.getArray(i));
    }

    @Override
    public List<String> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return getList(callableStatement.getArray(i));
    }

    private List<String> getList(Array array) {

        if (array == null) {
            return null;
        }

        try {
            return Arrays.asList((String[]) array.getArray());
        } catch (Exception e) {
            return null;
        }

    }

    private String getType(List<String> parameter) {

        if (parameter == null || parameter.isEmpty()) {
            return "varchar";
        }
        Object o = parameter.get(0);
        String typeName = null;
        if (o instanceof String) {
            typeName = "varchar";
        }
        return typeName;
    }
}
