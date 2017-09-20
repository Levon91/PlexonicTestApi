package am.plexonic.common.utils.validator;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * The common validator
 */
public final class CommonValidator {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    private static final DateFormat DATE_TIME_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    private CommonValidator() {
    }

    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    public static boolean isEmpty(String[] array) {
        return ArrayUtils.isEmpty(array);
    }

    public static boolean isValidDate(String strDate) {
        try {
            DATE_FORMAT.parse(strDate);
            return true;
        } catch (Exception e) {
            System.out.println("Exception was thrown when validating the date string (" + strDate + ")");
            return false;
        }
    }

    /**
     * Checks if the given date is before now
     *
     * @param strDate date in string format
     * @return true if given date is after now, false otherwise
     */
    public static boolean isDateBeforeNow(String strDate) {
        try {
            Date date = DATE_TIME_FORMAT.parse(strDate);
            return date.before(new Date());
        } catch (Exception e) {
            System.err.println("Exception was thrown when validating the date string (" + strDate + ")");
            return false;
        }
    }

    public static boolean isDateBeforeNow(long dateTime) {
        return dateTime < System.currentTimeMillis();
    }

    public static boolean isValidBankCode(String code) {
        return true;
    }

}
