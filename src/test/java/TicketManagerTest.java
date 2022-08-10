import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    Ticket ticket1 = new Ticket(1, 40_000, "NSK", "MSK", 225);
    Ticket ticket2 = new Ticket(13, 35_000, "NSK", "MSK", 225);
    Ticket ticket3 = new Ticket(31, 40_000, "MSK", "NSK",  210);
    Ticket ticket4 = new Ticket(13, 37_000, "MSK",  "NSK", 210);
    Ticket ticket5 = new Ticket(124, 38_000, "Sochi", "NSK", 310);

    @BeforeEach
    public void setup(){
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    public void shouldFindByText(){
        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = manager.findAll("NSK", "MSK");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByWrongText(){
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.findAll("Sochi", "MSK");
        Assertions.assertArrayEquals(expected, actual);
    }
}
