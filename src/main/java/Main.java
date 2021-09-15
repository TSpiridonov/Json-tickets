import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.Duration;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Duration avgTime;
        Duration timePercentile;

        String originCity = "Владивосток";
        String destinationCity = "Тель-Авив";
        String destinationCitys = "Тель-Авив";

        TicketContainer container = mapper.readValue(new File("tickets.json"), TicketContainer.class);

        TicketService ticketService = new TicketService(container);

        avgTime = ticketService.getAvgTime(originCity, destinationCity);
        timePercentile = ticketService.getPercentile(originCity, destinationCity);

        System.out.printf("Среднее время полета между городами %s и %s составляет %d ч. и %d м.\n", originCity, destinationCity, avgTime.getStandardHours(), avgTime.getStandardMinutes() % 60);
        System.out.printf("90-й перцентиль времени полета между городами %s и %s составляет %d ч. и %d м.\n", originCity, destinationCity, timePercentile.getStandardHours(), timePercentile.getStandardMinutes() % 60);
    }
}
