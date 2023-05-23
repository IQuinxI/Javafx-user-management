package ma.emsi.projet.misc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {

    private static final String DATE_PATTERN = "dd/MM/yyyy";


    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static String formatLY(LocalDate date) {
        return date == null ? null : DATE_TIME_FORMATTER.format(date);
    }

    public static LocalDate parseLY(String dateString) {
        try {
            return DATE_TIME_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {

            return null;
        }
    }

    public static boolean validDate(String dateString) {
        return DateUtil.parseLY(dateString) != null;
    }
}
