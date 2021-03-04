package org.mql.java.threads;

import java.util.concurrent.TimeUnit;

import org.mql.java.annotations.GenerateModels;

@GenerateModels()
public class ModelGenerator<T> extends Thread {

	private Buffer buffer;
	private Class<T> cls;

	public ModelGenerator() {
	}

	public ModelGenerator(Buffer buffer, Class<T> cls) {
		this.buffer = buffer;
		this.cls = cls;
	}

	@Override
	public void run() {

		int count = buffer.getSize();
		do {
			T object;
			try {
				object = cls.getConstructor().newInstance();
				buffer.write(object);
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count--;
		} while (count != 0);

	}

}
