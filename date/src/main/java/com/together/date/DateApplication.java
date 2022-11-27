package com.together.date;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.together.date.Dao")
public class DateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DateApplication.class, args);
	}

}
