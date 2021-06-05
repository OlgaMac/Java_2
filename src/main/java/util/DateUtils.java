package util;

import java.sql.Date;
import java.time.LocalDate;

public final class DateUtils {

    private DateUtils() {}

    public static Date ofLocalDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }

        return Date.valueOf(localDate);
    }

    public static LocalDate ofDate(Date date) {
        if (date == null) {
            return null;
        }

        return date.toLocalDate();
    }
}

