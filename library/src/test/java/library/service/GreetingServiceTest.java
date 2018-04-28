package library.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest("service.getMessage=Hello")
public class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @Test
    public void contextLoads() {
        assertThat(greetingService.getMessage()).isNotNull();
        assertThat(greetingService.getMessage()).isEqualTo("Hello");
    }

    @SpringBootApplication
    static class TestConfiguration {
    }

}