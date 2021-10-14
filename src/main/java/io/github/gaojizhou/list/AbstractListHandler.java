package io.github.gaojizhou.list;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.gaojizhou.constant.PostgreSqlDataType.VARCHAR;

/**
 * @author gaozjizhou
 */
public abstract class AbstractListHandler<T> extends BaseTypeHandler<List<T>> {

    protected abstract String getTypeName(Object o);

    public static <T> List<T> objectToList(Object arrayObj) {
        try {
            T[] list = (T[]) arrayObj;
            return Arrays.asList(list);
        } catch (Exception e) {
            return new ArrayList<T>();
        }
    }

    public List<T> getDownCastingList(Array array) {
        if (array == null) {
            return null;
        }
        try {
            return objectToList(array.getArray());
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

    public String getType(List<T> parameter) {
        if (parameter == null || parameter.isEmpty()) {
            return VARCHAR;
        }
        Object o = parameter.get(0);
        return getTypeName(o);
    }



    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<T> parameter, JdbcType jdbcType) throws SQLException {
        String type = getType(parameter);
        Connection conn = ps.getConnection();
        Array array = conn.createArrayOf(type, parameter.toArray());
        ps.setArray(i, array);
    }

    @Override
    public List<T> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return getDownCastingList(resultSet.getArray(s));
    }

    @Override
    public List<T> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return getDownCastingList(resultSet.getArray(i));
    }

    @Override
    public List<T> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return getDownCastingList(callableStatement.getArray(i));
    }

}
