import java.io.*;
import java.nio.*;
import java.nio.file.*;
public class Third {
    public static void main(String[] args) {
        String path = "C:\\Users\\Aramo\\OneDrive\\Desktop\\EPAM\\2- Java Core\\hw4\\task3\\";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        
        for (File file : listOfFiles) {
            if (file.isFile()) {
                if(extension(file.getName()).equals("tmp")) {
                    File f = new File(path+file.getName());
                    if(f.delete()) {
                        System.out.println("File deleted successfully");
                    } else {
                        System.out.println("Failed to delete the file");
                    }
                }
            }
        }
    }
    
    public static String extension(String fileName) {
        int index = fileName.lastIndexOf('.');
        return fileName.substring(index + 1);
    }
}