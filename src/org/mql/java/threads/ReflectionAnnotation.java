package org.mql.java.threads;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionAnnotation<T> {

	private String outputValue = "";

	public ReflectionAnnotation(T object) {
		Field[] fields = object.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getAnnotations().length > 0) {
				fields[i].setAccessible(true);
				try {
					outputValue += fields[i].get(object);
					fields[i].setAccessible(false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			outputValue += " ";
		}
		try {

			Method setOutputValue = object.getClass().getDeclaredMethod("setOutputValue", String.class);
			setOutputValue.invoke(object, outputValue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
