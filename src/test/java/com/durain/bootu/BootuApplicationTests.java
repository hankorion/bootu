package com.durain.bootu;

import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootuApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void applicationStarts() {
		BootuApplication.main(new String[] {});
	}

	@Test
	public void applicationStartsWeb() {
		BootuApplication bootuApp = new BootuApplication();
		Class<BootuApplication> cBoot = BootuApplication.class;
		try {
			Method method = cBoot.getDeclaredMethod("configure", new Class[] {SpringApplicationBuilder.class});
			method.setAccessible(true);
			method.invoke(bootuApp, new Object[] { new SpringApplicationBuilder() });
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
