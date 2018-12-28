package cm.bdqn.packet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PacketApplication {

    public static void main(String[] args) {
        SpringApplication.run(PacketApplication.class, args);
    }

}

