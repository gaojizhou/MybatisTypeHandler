package io.github.gaojizhou.list;

import org.apache.ibatis.executor.result.ResultMapException;

import java.math.BigDecimal;

import static io.github.gaojizhou.constant.PostgreSqlDataType.NUMERIC;
import static io.github.gaojizhou.constant.ErrorMessage.CHECK_HELP_MSG;
import static io.github.gaojizhou.constant.ErrorMessage.checkOtherHandel;

/**
 * @author gaojizhou
 */
public class ListBigDecimalHandler extends AbstractListHandler<BigDecimal> {

    @Override
    public String getTypeName(Object o) {
        if (o instanceof BigDecimal) {
            return NUMERIC;
        } else {
            throw new ResultMapException(
                    "ListBigDecimalHandler only fit to convert List<BigDecimal> to numeric[], "
                            + CHECK_HELP_MSG
                            + checkOtherHandel(o)
            );
        }
    }

}
