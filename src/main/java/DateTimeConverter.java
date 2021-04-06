import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTimeConverter {

    static DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yy HH:mm");

    public static LocalDateTime format(String date, String time) {
        String dateTime = date + " " + time;
        return formatter.parseLocalDateTime(dateTime);
    }


}
