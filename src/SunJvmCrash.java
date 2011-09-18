import sun.dc.pr.PathDasher;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 */
public class SunJvmCrash {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        final Thread thread = Thread.currentThread();

        final Field field = Thread.class.getDeclaredField("eetop");
        field.setAccessible(true);
        field.setLong(thread, 0l);
        PathDasher dasher = new PathDasher(null);
    }

}
