public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public Ticket[] getTickets() {
        return tickets;
    }

    public void save(Ticket t) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = t;
        tickets = tmp;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id) {
        Ticket foundTicket = findById(id);
        if (foundTicket == null) {
            throw new NotFoundExeption("Element with id: " + id + " not found");
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket Ticket : tickets) {
            if (Ticket.getId() != id) {
                tmp[copyToIndex] = Ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }
}
