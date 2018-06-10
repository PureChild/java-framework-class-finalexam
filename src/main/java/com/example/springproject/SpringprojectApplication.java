package com.example.springproject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.nio.charset.Charset;

@SpringBootApplication
@MapperScan(value = {"com.example.springproject.member.mapper","com.example.springproject.board.mapper"}) // Mapper 인터페이스 인식
public class SpringprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringprojectApplication.class, args);
	}

	/* DataSource 객체를 주입해서 결과를 만들고 해당 결과를 빈으로 사용 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{

		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}

	@Bean
	public HttpMessageConverter<String> responseBodyConverter() {
		return new StringHttpMessageConverter(Charset.forName("UTF-8"));
	}

	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}
}
