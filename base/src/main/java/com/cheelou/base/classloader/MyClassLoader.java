package com.cheelou.base.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author louzf
 * @decription 自定义类加载器 加载LoadDemo类
 * //使用javac命令将LoadDemo.java编译成LoadDemo.class文件
 *
 * @createTime 2019/12/30 14:15
 */
public class MyClassLoader extends ClassLoader{

    //使用绝对路径加载class文件
    String PATH = "E:\\APPLICATIONS\\OWN\\自用\\springboot-demo\\base\\src\\main\\java\\com\\cheelou\\base\\classloader\\LoadDemo.class";

    public static void main(String[] args) {
        MyClassLoader mcl = new MyClassLoader();
        Object obj = null;
        try {
            Class<?> clazz = Class.forName("LoadDemo", true, mcl);
            obj = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());//打印出我们的自定义类加载器
        /*
        控制台Console打印：
        This is a classloader Demo class��LoadDemo{name='null'}
        sun.misc.Launcher$AppClassLoader@18b4aac2
        */
    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    public MyClassLoader() {
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File(PATH);
        try{
            byte[] bytes = getClassBytes(file);
            //defineClass方法可以把二进制流字节组成的文件转换为一个java.lang.Class
            Class<?> c = this.defineClass(name, bytes, 0, bytes.length);
            return c;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return super.findClass(name);
    }


    private byte[] getClassBytes(File file) throws Exception
    {
        // 这里要读入.class的字节，因此要使用字节流
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true){
            int i = fc.read(by);
            if (i == 0 || i == -1)
                break;
            by.flip();
            wbc.write(by);
            by.clear();
        }
        fis.close();
        return baos.toByteArray();
    }
}
