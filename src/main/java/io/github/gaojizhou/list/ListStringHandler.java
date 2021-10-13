package io.github.gaojizhou.list;

import org.apache.ibatis.executor.result.ResultMapException;

import static io.github.gaojizhou.constant.PostgreSqlDataType.VARCHAR;

/**
 * @author gaojizhou
 */
public class ListStringHandler extends AbstractListHandler<String> {

    @Override
    public Class<String> getClassT() {
        return String.class;
    }

    @Override
    protected String getTypeName(Object o) {
        if (o instanceof String) {
            return VARCHAR;
        } else {
            throw new ResultMapException(
                    "ListStringHandler only fit to convert List<String> to varchar[], "
                            + "please check the incoming parameter. "
                            + "Other type handle or help: https://github.com/gaojizhou/MybatisTypeHandler"
            );
        }
    }

}
