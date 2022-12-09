import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class MissedDateTime implements Comparable<MissedDateTime> {
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private LocalDateTime missedDateTime;

    public MissedDateTime() {
        this.missedDateTime = LocalDateTime.now();
    }

    public MissedDateTime(LocalDateTime localDateTime) {
        this.missedDateTime = localDateTime;
    }

    public LocalDateTime getMissedDateTime() {
        return missedDateTime;
    }

    @Override
    public int compareTo(MissedDateTime o) {
        return this.getMissedDateTime().compareTo(o.getMissedDateTime());
    }

    @Override
    public String toString() {
        return dtf.format(missedDateTime);
    }
}
