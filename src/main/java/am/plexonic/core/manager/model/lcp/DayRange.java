package am.plexonic.core.manager.model.lcp;

/**
 * Enum type of day range
 */
public enum DayRange {
    DAY1    (1),
    DAY7    (7),
    DAY40   (40);

    private int value;

    DayRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DayRange valueOf(final int value) {
        for (DayRange dayRange : DayRange.values()) {
            if (dayRange.value == value) {
                return dayRange;
            }
        }
        return null;
    }
}
