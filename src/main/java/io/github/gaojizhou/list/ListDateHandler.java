package io.github.gaojizhou.list;

import org.apache.ibatis.executor.result.ResultMapException;

import java.util.Date;

import static io.github.gaojizhou.constant.PostgreSqlDataType.DATE;
import static io.github.gaojizhou.constant.ErrorMessage.CHECK_HELP_MSG;
import static io.github.gaojizhou.constant.ErrorMessage.checkOtherHandel;

/**
 * @author gaojizhou
 */
public class ListDateHandler extends AbstractListHandler<Date> {

    @Override
    protected String getTypeName(Object o) {
        if (o instanceof Date) {
            return DATE;
        } else {
            throw new ResultMapException(
                    "ListDateHandler only fit to convert List<Date> to date[], "
                            + CHECK_HELP_MSG
                            + checkOtherHandel(o)
            );
        }
    }

}
