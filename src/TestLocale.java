import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 */
public class TestLocale {

    public static void main(String[] args) {
        Locale locale = new Locale("pl");

        String s = DateFormat.getDateInstance(DateFormat.FULL, locale).format(new Date());
        System.out.println(s);
        
    }
}
