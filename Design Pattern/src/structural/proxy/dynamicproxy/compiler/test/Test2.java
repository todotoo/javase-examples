package structural.proxy.dynamicproxy.compiler.test;

import java.lang.reflect.Method;

import proxy.dynamicproxy.Moveable;

public class Test2 {
	public static void main(String[] args) {
		Method[] methods = Moveable.class.getMethods();
		for(Method m : methods) {
			System.out.println(m.getName());
		}
	}
}
