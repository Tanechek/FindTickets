import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketTest {
    Ticket ticket = new Ticket(1, 40_000, "MSK", "NSK", 390);

    @Test
    public void shouldGetId(){
        int expected = 1;
        int actual = ticket.getId();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldGetPrice(){
        int expected = 40_000;
        int actual = ticket.getPrice();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldGetToAirport(){
        String expected = "NSK";
        String actual = ticket.getToAirport();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldGetFromAirport(){
        String expected = "MSK";
        String actual = ticket.getFromAirport();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldGetFlyTime(){
        int expected = 390;
        int actual = ticket.getFlyTime();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldSetId(){
        ticket.setId(11);
        int expected = 11;
        int actual = ticket.getId();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldSetPrice(){
        ticket.setPrice(35_000);
        int expected = 35_000;
        int actual = ticket.getPrice();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldSetToAirport(){
        ticket.setToAirport("NSK");
        String expected = "NSK";
        String actual = ticket.getToAirport();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldSetFromAirport(){
        ticket.setFromAirport("MSK");
        String expected = "MSK";
        String actual = ticket.getFromAirport();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldSetFlyTime(){
        ticket.setFlyTime(380);
        int expected = 380;
        int actual = ticket.getFlyTime();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void compareWithLowerPrice(){
        Ticket ticketWithLowerPrice = new Ticket(2, 30_000, "MSK", "NSK", 390);
        Assertions.assertEquals(1, ticket.compareTo(ticketWithLowerPrice));
    }
    @Test
    public void compareWithEqualPrice(){
        Ticket ticketWithLowerPrice = new Ticket(3, 40_000, "MSK", "NSK", 390);
        Assertions.assertEquals(0, ticket.compareTo(ticketWithLowerPrice));
    }
    @Test
    public void compareWithHigherPrice(){
        Ticket ticketWithLowerPrice = new Ticket(3, 50_000, "MSK", "NSK", 390);
        Assertions.assertEquals(-1, ticket.compareTo(ticketWithLowerPrice));
    }
}
