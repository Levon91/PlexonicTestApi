package am.plexonic.common.utils.dateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * The thread-safe date format.
 */
public final class ThreadLocalDateFormat {
    private final ThreadLocal<DateFormat> target = new ThreadLocal<DateFormat> () {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(pattern);
        }
    };

    /**
     * The pattern describing the date and time format.
     */
    private final String pattern;

    /**
     * The regular constructor.
     *
     * @param pattern the pattern describing the date and time format.
     */
    public ThreadLocalDateFormat(String pattern) {
        this.pattern = pattern;
    }

    /**
     * Gets the current thread date formatter.
     *
     * @return the current thread date formatter.
     */
    public DateFormat get() {
        return target.get();
    }
}
