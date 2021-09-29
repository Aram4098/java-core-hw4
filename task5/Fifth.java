import java.io.*;
public class Fifth {
    public static void main(String[] args) {
        Customer c = new Customer("Artashes", "+ 374 041000001", 7, 1454254674);
        serializeCustomer(c);
        Customer deSerializedC = deSerializeCustomer();
        System.out.println(deSerializedC.toString());
    }

    
    protected static void serializeCustomer(Customer c) {
        try {
            FileOutputStream fileOut = new FileOutputStream("cust.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(c);
            out.flush();
            out.close();
            fileOut.close();
            System.out.println("The Serialized data is saved in cust.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    protected static Customer deSerializeCustomer() {
        Customer c = null;
        try {
            FileInputStream fileIn = new FileInputStream("cust.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            c = (Customer) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            System.out.println("User class not found");
            e.printStackTrace();
        }
        return c;
    }
}