package org.wg.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MethodDemo {

	@Test
	public void getMethodDemo_3() throws Exception {

		Class clazz = Class.forName("org.wg.reflect.Person");

		Method method = clazz.getMethod("paramMethod", String.class, int.class);

		Object obj = clazz.newInstance();
		// 返回方法的返回结果
		Object o = method.invoke(obj, "小强", 89);
	}

	@Test
	public void getMethodDemo_2() throws Exception {

		Class clazz = Class.forName("org.wg.reflect.Person");

		Method method = clazz.getMethod("show", null);//获取空参数一般方法。

//		Object obj = clazz.newInstance();
		Constructor constructor = clazz.getConstructor(String.class, int.class);

		Object obj = constructor.newInstance("小明", 37);

		method.invoke(obj, null);
	}

	/*
	 * 获取指定Class中的所有公共函数。
	 */
	@Test
	public void getMethodDemo() throws Exception {

		Class clazz = Class.forName("org.wg.reflect.Person");

		Method[] methods = clazz.getMethods();//获取的都是公有的方法。

		methods = clazz.getDeclaredMethods();//只获取本类中所有方法，包含私有。

		for (Method method : methods) {
			System.out.println(method);
		}
	}

}
