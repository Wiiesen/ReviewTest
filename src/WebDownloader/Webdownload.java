package WebDownloader;

import  org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Webdownload implements Runnable{
    private String url;//地址
    private String name;//文件名
    public Webdownload(String url,String name){
        this.url = url;
        this.name = name;
    }
    @Override
    public void run(){
        Webdownloader webdownloader = new Webdownloader();
        webdownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        Webdownload test1 = new Webdownload("https://vip2.loli.net/2020/10/24/VMvKarTkQDXoLHR.jpg","1.jpg");
        Webdownload test2 = new Webdownload("https://vip2.loli.net/2020/10/18/gBFk6Q9jncdTNAC.jpg","2.jpg");
        Webdownload test3 = new Webdownload("https://vip2.loli.net/2020/10/25/D93mKZjPW14awhx.jpg","3.jpg");

        new Thread(test2).start();
        new Thread(test1).start();
        new Thread(test3).start();

    }
}
//下载器
class Webdownloader{
    public void downloader(String url,String name){
        try{
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }  catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题！");
        }
    }
}
