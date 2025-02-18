package com.example.demo.Player;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Aplica a todas las rutas de la aplicación
                .allowedOrigins("http://localhost:5174")  // Origen permitido (ajusta según tu frontend)
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos permitidos
                .allowedHeaders("*")  // Permite todos los encabezados
                .allowCredentials(true);  // Permite credenciales (cookies, autenticación)
    }
}
