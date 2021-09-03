package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StateServiceTest {
    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StateService statefulService1 = ac.getBean(StateService.class);
        StateService statefulService2 = ac.getBean(StateService.class);

        statefulService1.orderStateful("userA", 10000);
        statefulService2.orderStateful("userB", 20000);

        int price = statefulService1.getPrice();

        System.out.println("price = " + price);

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    @Test
    void statelessServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StateService statefulService1 = ac.getBean(StateService.class);
        StateService statefulService2 = ac.getBean(StateService.class);

        int userA = statefulService1.orderStateless("userA", 10000);
        int userB = statefulService2.orderStateless("userB", 20000);

        System.out.println("userA = " + userA + ", userB = " + userB);
        Assertions.assertThat(userA).isNotEqualTo(userB);
    }

    static class TestConfig {
        @Bean
        public StateService statefulService() {
            return new StateService();
        }
    }
}