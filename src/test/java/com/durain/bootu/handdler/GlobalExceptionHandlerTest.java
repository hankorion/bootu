package com.durain.bootu.handdler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindException;

import com.durain.bootu.model.Game;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GlobalExceptionHandlerTest {

	@Autowired
	GlobalExceptionHandler globalExceptionHandler;

	@Test
	public void testHandleBindExceptionNull() {
		Game game = new Game();
		BindException ex = new BindException(game, "name");
		ex.rejectValue("name", "0", null);
		globalExceptionHandler.handleBindException(ex);
	}

	@Test
	public void testHandleBindExceptionEmpty() {
		Game game = new Game();
		BindException ex = new BindException(game, "name");
		ex.rejectValue("name", "0", "");
		globalExceptionHandler.handleBindException(ex);
	}
	
	@Test
	public void testHandleBindExceptionNotFieldError() {
		Game game = new Game();
		BindException ex = new BindException(game, "name");
		ex.reject("testHandleBindExceptionNotFieldError");
		globalExceptionHandler.handleBindException(ex);
	}
}
