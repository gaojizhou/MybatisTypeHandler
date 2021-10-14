package io.github.gaojizhou.constant;

import java.util.Date;
import java.math.BigDecimal;

/**
 * @author gaojizhou
 */
public class ErrorMessage {

    public static final String CHECK_HELP_MSG = "please check the incoming parameter. "
            + "Other type handle or help: https://github.com/gaojizhou/MybatisTypeHandler. ";

    public static final String SEEN_LIKE_MSG = "it seems to fit this handel: io.github.gaojizhou.list.";

    public static String checkOtherHandel(Object o) {
        if (o instanceof String) {
            return SEEN_LIKE_MSG + "ListStringHandler";
        } else if (o instanceof BigDecimal) {
            return SEEN_LIKE_MSG + "ListBigDecimalHandler";
        } else if (o instanceof Boolean) {
            return SEEN_LIKE_MSG + "ListBooleanHandler";
        } else if (o instanceof Date) {
            return SEEN_LIKE_MSG + "ListDateHandler";
        } else if (o instanceof Integer) {
            return SEEN_LIKE_MSG + "ListIntegerHandler";
        } else {
            return "";
        }
    }
}
