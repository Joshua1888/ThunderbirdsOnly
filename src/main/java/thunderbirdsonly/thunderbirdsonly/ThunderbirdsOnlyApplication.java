package thunderbirdsonly.thunderbirdsonly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("thunderbirdsonly.thunderbirdsonly")
public class ThunderbirdsOnlyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThunderbirdsOnlyApplication.class, args);
    }

}
