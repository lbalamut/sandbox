import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.concurrent.TimeUnit;

/**
 */
public class JMXTest {

    static void jmxQuery(String host, String port, String names) throws Exception {

        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + host + ":" + port + "/jmxrmi");
        final JMXConnector connector = JMXConnectorFactory.connect(url);
        final MBeanServerConnection connection = connector.getMBeanServerConnection();
        for (String beanNameWithFieldNames : names.split(";")) {

            String[] beanNameWithFieldNamesArray = beanNameWithFieldNames.split("\\|");
            if (beanNameWithFieldNamesArray.length != 2) {
                throw new IllegalArgumentException("invalid format: " + beanNameWithFieldNames);
            }

            String beanName = beanNameWithFieldNamesArray[0];
            String fields = beanNameWithFieldNamesArray[1];
            ObjectName objectName = new ObjectName(beanName);
            for (String field : fields.split(",")) {
                final String[] fieldPath = field.split("\\.");
                Object value = connection.getAttribute(objectName, fieldPath[0]);
                if (fieldPath.length == 1) {
                    result(beanName, field, value);
                } else if (value instanceof CompositeData && fieldPath.length == 2) {
                    CompositeData data = (CompositeData) value;
                    result(beanName, field, data.get(fieldPath[1]));
                } else {
                    throw new IllegalStateException("Unsupported bean type: " + value);
                }
            }
        }
        connector.close();
    }

    private static void result(String beanName, String field, Object value) {
        System.out.println((beanName + "_" + field).replaceAll("[=:\\.]", "_") + "= " + value);
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            jmxQuery("ciperf05.places.devbln", "5300",
                            "java.lang:type=OperatingSystem|OpenFileDescriptorCount,MaxFileDescriptorCount;" +

                            "java.lang:type=Memory|HeapMemoryUsage.used;" +
                            "java.lang:name=PS Perm Gen,type=MemoryPool|Usage.used;" +

                            "java.lang:type=Threading|ThreadCount;" +
                            "Catalina:name=http-8080,type=ThreadPool|keepAliveCount"

            );
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
