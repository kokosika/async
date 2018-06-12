package com.gp;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.gp.mapper")
@EntityScan(basePackageClasses = {
		GestionproyectosApplication.class,
		Jsr310JpaConverters.class
})
@EnableAsync
public class GestionproyectosApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(GestionproyectosApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GestionproyectosApplication.class, args);
        LOGGER.info("******************* Inicio de la Aplicación *******************");
    }
}
