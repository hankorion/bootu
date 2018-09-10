package com.durain.bootu.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResultUtilTest {

	@Test(expected = InvocationTargetException.class)
	public void testConstructor() throws NoSuchMethodException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		final Constructor<?>[] resultUtilConstructors = ResultUtil.class.getDeclaredConstructors();
		for (Constructor<?> constructor : resultUtilConstructors) {
			Assert.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
			constructor.setAccessible(true);
			constructor.newInstance((Object[]) null);
		}
	}

	@Test
	public void testSuccessObject() {
		ResultUtil.success("{}");
	}

	@Test
	public void testSuccess() {
		ResultUtil.success();
	}

	@Test
	public void testError() {
		ResultUtil.error(403, "Not auth", "not auth");
	}

}
