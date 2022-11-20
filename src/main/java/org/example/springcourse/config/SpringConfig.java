package org.example.springcourse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

// WebMvcConfigurer реализуется, если под себя хотим настроить Спринг MVC. Нам нужен не стандартный шаблонизатор, а Thymeleaf
@Configuration
@ComponentScan("org.example.springcourse")
@EnableWebMvc                        //равноценна <mvc:annotation-driven/> из xml конфигурации (applicationContextMVC.xml)
public class SpringConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;
    @Autowired                            //Внедрение зависимости... Спорно, по идее для конструктора не нужен @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");        //указываем где лажат наши views - представления
        templateResolver.setSuffix(".html");                  //указываем расширение файлов .html
        return templateResolver;                              //указание prefix и suffix позволит обращаться из контроллера
    }                                                         //к views только по названию и не указывать полный путь и расширение
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }
    @Override                                         //передаем Спрингу, что хотим использовать шаблонизатор Thymeleaf
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }
}
