package org.example.springcourse.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//    Иерархия:
//    WebApplicationInitializer
//        -AbstractContextLoaderInitializer
//               -AbstractDispatcherServletInitializer
//                     -AbstractAnnotationConfigDispatcherServletInitializer

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {



    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];                          //не будем использовать, поэтому возвращаем null
    }

    @Override                                         //указываем класс конфигурации
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};   //конфиг-й равноценен из web.xml тегу:
    }                     //<param-value>/WEB-INF/applicationContextMVC.xml</param-value> из эл-та <init-param> эл-та <servlet>

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};              // "/" - любой наш запрос должен перенаправляться на наш DispatcherServlet
    }                                           //равноценен из web.xml тегу: <url-pattern>/</url-pattern> из эл-та <servlet-mapping>
}
