import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Tickets ticket = new ObjectMapper().
                readerFor(Tickets.class).
                readValue(new File("tickets.json"));

        System.out.println(ticket);

    }
}
