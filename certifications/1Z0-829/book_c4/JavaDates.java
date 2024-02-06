import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JavaDates {

  public static void main(String[] args) {
    LocalDateTime localDate = LocalDateTime.now(); //all objets al inmutual
    LocalDateTime r = localDate.plusDays(23);
    DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("MM dd YYYY");
    System.err.println(dateformatter.format(localDate));
    System.err.println(dateformatter.format(r));
  }
}
