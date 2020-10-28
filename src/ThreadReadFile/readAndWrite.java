package ThreadReadFile;

import java.io.*;

public class readAndWrite implements Runnable {
    private volatile int len = 0;
    private byte[] bytes;
    private static volatile InputStream is;
    static {
        try {
            is = new FileInputStream("C:\\Users\\user\\IdeaProjects\\ReviewTest\\src\\ThreadReadFile\\Poems1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static volatile OutputStream os;
    static {
        try {
            os = new FileOutputStream("C:\\Users\\user\\IdeaProjects\\ReviewTest\\src\\ThreadReadFile\\Poems2.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public  void run() {
        while (len != -1) {
            try {
                bytes = new byte[1024];
                len = is.read(bytes);
                if (len != -1) {
                    os.write(bytes, 0, len);
                }
                System.out.println(Thread.currentThread().getName() + "读取并且写入文件");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
