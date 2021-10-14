package io.github.gaojizhou.list;

import org.apache.ibatis.executor.result.ResultMapException;

import static io.github.gaojizhou.constant.PostgreSqlDataType.INTEGER;
import static io.github.gaojizhou.constant.ErrorMessage.CHECK_HELP_MSG;
import static io.github.gaojizhou.constant.ErrorMessage.checkOtherHandel;

/**
 * @author gaojizhou
 */
public class ListIntegerHandler extends AbstractListHandler<Integer> {

    @Override
    protected String getTypeName(Object o) {
        if (o instanceof Integer) {
            return INTEGER;
        } else {
            throw new ResultMapException(
                    "ListIntegerHandler only fit to convert List<Integer> to integer[], "
                            + CHECK_HELP_MSG
                            + checkOtherHandel(o)
            );
        }
    }

}
