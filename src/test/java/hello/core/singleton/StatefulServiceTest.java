package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // 쓰레드 A 에서 사용자가 10000원 주문
        int moon = statefulService1.order("moon", 10000);

        // 쓰레드 B 에서 사용자가 20000원 주문
        int lee = statefulService1.order("lee", 20000);

        // 쓰레드 A 에서 사용자 A 가 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println(moon);

//        assertThat(statefulService1.getPrice()).isNotEqualTo(10000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}