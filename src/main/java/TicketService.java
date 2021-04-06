import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Minutes;

import java.util.ArrayList;
import java.util.Collections;

public class TicketService {

    private final TicketContainer ticketContainer;

    public TicketService(TicketContainer ticketContainer) {
        this.ticketContainer = ticketContainer;

        for (Ticket ticket : ticketContainer.getTickets()) {
            ticket.setDepartureDateTime();
            ticket.setArrivalDateTime();
        }

    }

    public Duration getAvgTime(String originCity, String destinationCity) {
        double summaryTime = 0;
        int count = 0;
        for (Ticket ticket : ticketContainer.getTickets()) {
            Duration duration = new Duration(ticket.getDepartureDateTime().toDateTime(), ticket.getArrivalDateTime().toDateTime());
            summaryTime += duration.getStandardMinutes();
            count++;

        }
        int result = (int) (summaryTime / count);

        return new Duration(result * 60000L);
    }


    public Duration getPercentile(String originName, String destinationName) {
        ArrayList<Minutes> minutes = new ArrayList<>();
        for (Ticket ticket : ticketContainer.getTickets()) {
            Duration duration = new Duration(ticket.getDepartureDateTime().toDateTime(DateTimeZone.UTC), ticket.getArrivalDateTime().toDateTime(DateTimeZone.UTC));

            minutes.add(duration.toStandardMinutes());
        }
        Collections.sort(minutes);

        double percentile = 0.90 * minutes.size();

        int index = (int) Math.ceil(percentile) - 1;

        return new Duration(minutes.get(index).toStandardDuration());
    }


}
