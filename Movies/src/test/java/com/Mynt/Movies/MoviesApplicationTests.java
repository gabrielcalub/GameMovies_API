package com.mynt.Movies;

import com.mynt.Movies.service.MovieService;
import com.mynt.Movies.service.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MoviesApplicationTests {
	MovieService service = new MovieServiceImpl();

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetSecurity(){
		System.out.println(service.getSecurity());
	}

}