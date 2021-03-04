package org.mql.java.threads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;

public class FilePrinter<T> extends Thread {

    private Buffer buffer;
    private Class<T> cls;
    private ObjectOutputStream objectOutputStream;
    private FileOutputStream fileOutputStream;

    public FilePrinter(Buffer buffer) {
        this.buffer = buffer;
        try{
            fileOutputStream = new FileOutputStream("test.txt",true);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
            try{
                for (int i = 0; i < buffer.getSize(); i++) {

                    System.out.println("######## file printer attempting to read ###########");
                    Object object = buffer.read(i);
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("######## end print file read ###########");
                    serializeAndRegisterObject(object);

                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
    }

    public void serializeAndRegisterObject(Object object) throws IOException {
            objectOutputStream.writeObject(object);

    }

}
