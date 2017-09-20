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

    public static boolean isValidDate(String strDate) {
        try {
            DATE_FORMAT.parse(strDate);
            return true;
        } catch (Exception e) {
            System.out.println("Exception was thrown when validating the date string (" + strDate + ")");
            return false;
        }
    }
}
