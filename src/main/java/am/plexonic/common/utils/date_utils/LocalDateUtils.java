package am.plexonic.common.utils.date_utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateUtils {

    private static final ThreadLocalDateFormat DATE_FORMAT = new ThreadLocalDateFormat("dd-MM-yyyy");

    /**
     * Plus the given days to the current date.
     *
     * @param days the days
     * @return the date = the current date + the days
     */
    public static Date plusDays(long days) {
        return localDateTimeToDate(LocalDateTime.now().plusDays(days));
    }

    /**
     * Plus the given days to the given date.
     *
     * @param date the date
     * @param days the days
     * @return the date = the given date + the days
     */
    public static Date plusDays(Date date, long days) {
        return localDateTimeToDate(dateToLocalDateTime(date).plusDays(days));
    }

    private static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    private static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
