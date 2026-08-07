import java.util.*;
import java.util.stream.*;

public class streamanalytics{

    static class Sensor {
        String id;
        double temperature;

        Sensor(String id, double temperature) {
            this.id = id;
            this.temperature = temperature;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Sensor> sensors = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            double temperature = sc.nextDouble();

            sensors.add(new Sensor(id, temperature));
        }

        Map<String, Double> result = sensors.stream()

                .filter(s -> s.temperature > 50)

                .collect(Collectors.groupingBy(
                        s -> s.id,
                        Collectors.averagingDouble(s -> s.temperature)
                ));

        result.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())


                .forEach(entry ->
                        System.out.println(entry.getKey() + " " + entry.getValue())
                );

        sc.close();
    }
}