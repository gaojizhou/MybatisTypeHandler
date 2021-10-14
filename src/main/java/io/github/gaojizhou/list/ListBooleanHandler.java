package io.github.gaojizhou.list;

import org.apache.ibatis.executor.result.ResultMapException;

import static io.github.gaojizhou.constant.PostgreSqlDataType.BOOLEAN;
import static io.github.gaojizhou.constant.ErrorMessage.CHECK_HELP_MSG;
import static io.github.gaojizhou.constant.ErrorMessage.checkOtherHandel;

/**
 * @author gaojizhou
 */
public class ListBooleanHandler extends AbstractListHandler<Boolean> {

    @Override
    protected String getTypeName(Object o) {
        if (o instanceof Boolean) {
            return BOOLEAN;
        } else {
            throw new ResultMapException(
                    "ListBooleanHandler only fit to convert List<Boolean> to boolean[], "
                            + CHECK_HELP_MSG
                            + checkOtherHandel(o)
            );
        }
    }

}
