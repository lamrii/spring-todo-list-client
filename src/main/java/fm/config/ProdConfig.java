package fm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppConfig.class, WebConfig.class})
public class ProdConfig {
}
