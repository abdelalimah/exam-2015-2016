package org.mql.java.threads;

public class Buffer<T> {

	private Object data[];
	private int size;
	private int i = 0;

	public Buffer(int size) {
		this.size = size;
		data = new Object[size];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setData(Object[] data) {
		this.data = data;
	}

	public Object[] getData() {
		return data;
	}

	synchronized public void write(Object object) throws InterruptedException {
		System.out.println("start writing");
		System.out.println("writing in : " + i);
		data[i] = object;
		new ReflectionAnnotation(data[i]);
		System.out.println("writer value :" + data[i].toString());
		i++;

		notify();
	}

	synchronized public Object read(int i) {

			System.out.println("start reading");
			try {
				if (data[i] == null) {
					System.out.println("i stopped");
					wait();
				}
				new ReflectionAnnotation(data[i]);
				System.out.println("reading from : " + i);
				System.out.println("reader value :" + data[i]);
				return data[i];
			}

			catch (Exception e) {
				e.printStackTrace();
				return null;
			}

	}

//	public void pause(int time) {
//
//		try {
//			Thread.sleep(time);
//		} catch (Exception e) {
//			System.out.println("  Erreur :" + e.getMessage());
//		}
//
//	}

}
