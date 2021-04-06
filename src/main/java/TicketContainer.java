import java.util.List;

public class TicketContainer {

    private List<Ticket> tickets;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "TicketContainer{" +
                "tickets=" + tickets +
                '}';
    }

}
