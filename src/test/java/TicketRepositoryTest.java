import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {
    TicketRepository repo = new TicketRepository();
    Ticket ticket1 = new Ticket(1, 40_000, "MSK", "NSK", 225);
    Ticket ticket2 = new Ticket(13, 35_000, "MSK", "NSK", 225);
    Ticket ticket3 = new Ticket(31, 40_000, "NSK", "MSK", 210);
    Ticket ticket4 = new Ticket(14, 37_000, "NSK", "MSK", 210);
    Ticket ticket5 = new Ticket(124, 38_000, "NSK", "Sochi", 310);

    @BeforeEach
    public void saveTickets(){
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
    }
    @Test
    public void shouldGetTicket(){
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSaveTicket(){
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindById(){
        Ticket expected = ticket2;
        Ticket actual =  repo.findById(13);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByNotExistId(){
        Ticket actual =  repo.findById(2);
        Assertions.assertThrows(NotFoundExeption.class, () -> {
            repo.removeById(2);
        });
    }

    @Test
    public void shouldRemoveByExistId() {
        repo.removeById(13);

        Ticket[] expected = {ticket1, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotRemoveByNotExistId(){

        Assertions.assertThrows(NotFoundExeption.class, () -> {
            repo.removeById(2);
        });
    }
}

