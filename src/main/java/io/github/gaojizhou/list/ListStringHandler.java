package io.github.gaojizhou.list;

import org.apache.ibatis.executor.result.ResultMapException;

import static io.github.gaojizhou.constant.PostgreSqlDataType.VARCHAR;
import static io.github.gaojizhou.constant.ErrorMessage.CHECK_HELP_MSG;
import static io.github.gaojizhou.constant.ErrorMessage.checkOtherHandel;
/**
 * @author gaojizhou
 */
public class ListStringHandler extends AbstractListHandler<String> {

    @Override
    protected String getTypeName(Object o) {
        if (o instanceof String) {
            return VARCHAR;
        } else {
            throw new ResultMapException(
                    "ListStringHandler only fit to convert List<String> to varchar[], "
                            + CHECK_HELP_MSG
                            + checkOtherHandel(o)
            );
        }
    }

}
