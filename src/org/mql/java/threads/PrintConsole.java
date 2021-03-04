package org.mql.java.threads;

import java.util.concurrent.TimeUnit;

public class PrintConsole<T> extends Thread {

	private Buffer buffer;
	private Class<T> cls;

	public PrintConsole(Buffer buffer, Class<T> cls) {
		this.buffer = buffer;
		this.cls = cls;
	}

	@Override
	public void run() {
		for (int i = 0; i < buffer.getSize(); i++) {
			buffer.read(i);
			try {

				TimeUnit.MILLISECONDS.sleep(500);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
