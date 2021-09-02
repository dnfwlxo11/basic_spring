package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {
    // 형식을 ApplicationContext로 안한 이유는 getBeanDefinition을 못씀
    AnnotationConfigApplicationContext acJava = new AnnotationConfigApplicationContext(AppConfig.class);
    GenericXmlApplicationContext acXml = new GenericXmlApplicationContext("appConfig.xml");

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBeanToJava() {
        String[] beanDefinitionNames = acJava.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) { 
            BeanDefinition beanDefinition = acJava.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName + ", beanDefinitin = " + beanDefinition);
            }
        }
    }

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBeanToXml() {
        String[] beanDefinitionNames = acXml.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = acXml.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName + ", beanDefinitin = " + beanDefinition);
            }
        }
    }
}
