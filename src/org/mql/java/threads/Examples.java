package org.mql.java.threads;

import org.mql.java.annotations.GenerateModels;
import org.mql.java.models.Point;
import org.mql.java.models.Produits;

public class Examples {
	public Examples() {
		exp01();
	}

	private void exp01() {

		Class<?> cls;
		try {
			cls = Class.forName("org.mql.java.threads.ModelGenerator");
			int count = cls.getDeclaredAnnotation(GenerateModels.class).count();
			Buffer<Point> buffer = new Buffer<Point>(count);
			new ModelGenerator<Point>(buffer, Point.class).start();
			new PrintConsole<Point>(buffer, Point.class).start();
			new FilePrinter<Point>(buffer).start();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void exp02() {

		Class<?> cls;
		try {
			cls = Class.forName("org.mql.java.threads.ModelGenerator");
			int count = cls.getDeclaredAnnotation(GenerateModels.class).count();
			Buffer buffer = new Buffer(count);
			new ModelGenerator<Produits>(buffer, Produits.class).start();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void exp03() {
		Class<?> cls;
		try{

			cls = Class.forName("org.mql.java.threads.ModelGenerator");
			cls = Class.forName("org.mql.java.threads.ModelGenerator");
			int count = cls.getDeclaredAnnotation(GenerateModels.class).count();
			Buffer<Point> buffer = new Buffer<Point>(count);
			new ModelGenerator<Point>(buffer, Point.class).start();
			new PrintConsole<Point>(buffer, Point.class).start();

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		new Examples();
	}

}
