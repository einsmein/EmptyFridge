package library.service;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(GreetingServiceProperties.class)
public class GreetingService {

    private final GreetingServiceProperties greetingServiceProperties;

    public GreetingService(GreetingServiceProperties greetingServiceProperties) {
        this.greetingServiceProperties = greetingServiceProperties;
    }

    public String getMessage() {
        return this.greetingServiceProperties.getMessage();
    }

    public void setMessage(String message) {
        this.greetingServiceProperties.setMessage("Message is " + message);
    }
}
