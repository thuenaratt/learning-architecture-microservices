package co.ecommerce.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayServiceApplication {
    public static void main(String[] args) {
        // Set client paths before Spring initializes Nacos and Sentinel.
        String runtimeDirectory = java.nio.file.Path.of("target", "runtime", "gateway-service")
                .toAbsolutePath().toString();
        System.getProperties().putIfAbsent("JM.SNAPSHOT.PATH", runtimeDirectory);
        System.getProperties().putIfAbsent("JM.LOG.PATH",
                java.nio.file.Path.of(runtimeDirectory, "logs").toString());
        System.getProperties().putIfAbsent("csp.sentinel.log.dir",
                java.nio.file.Path.of(runtimeDirectory, "sentinel-logs").toString());
        SpringApplication.run(GatewayServiceApplication.class, args);
    }
}
