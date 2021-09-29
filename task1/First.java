import java.net.*;
import java.io.*;
import java.lang.*;
import java.nio.*;
import java.nio.channels.*;
public class First {
    public static void main(String[] args) {
        String path = "https://www.facebook.com/";
        classDownloader(path);
        classDownloaderBuffered(path);
    }
    
    public static void classDownloader(String path) {
        try {
            URL url = new URL(path);
            InputStream inputStream = url.openStream(); 
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream); 
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Aramo\\OneDrive\\Desktop\\EPAM\\2- Java Core\\hw4\\task1\\downloaded.html");
            
            byte[] bucket = new byte[2048];
            int numBytesRead;
            
            while ((numBytesRead = bufferedInputStream.read(bucket, 0, bucket.length)) != -1) {
                fileOutputStream.write(bucket, 0, numBytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void classDownloaderBuffered(String path) {
        try {
            URL url = new URL(path);
            InputStream inputStream = url.openStream(); 
            
            URLConnection uc = url.openConnection();

            //Here I can't understand why the Url's content's length is returning -1, that's why I just assigned a big number.
            //System.out.println(uc.getContentLength());
            //ByteBuffer buf = ByteBuffer.allocateDirect(uc.getContentLength());
            ByteBuffer buf = ByteBuffer.allocateDirect(99999);
            int b;            
            while ((b=inputStream.read())!=-1) {
                buf.put((byte)b);
            }
            boolean append = false;
            FileChannel channel = new FileOutputStream("C:\\Users\\Aramo\\OneDrive\\Desktop\\EPAM\\2- Java Core\\hw4\\task1\\downloadedBuffered.html", append).getChannel();
            
            buf.flip();
            channel.write(buf);
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}