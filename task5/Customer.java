import java.io.*;
import java.util.Base64;
public class Customer implements Serializable {
    private String name;
    private transient String phone;
    private int score;
    private transient int cardNumber;
    
    public Customer(String name, String phone, int score, int cardNumber) {
        this.name = name;
        this.phone = phone;
        this.score = score;
        this.cardNumber = cardNumber;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public int getScore() {
        return this.score;
    }    
    
    public int getCardNumber() {
        return this.cardNumber;
    }    
    
    public void setcardNumber(int cn) {
        this.cardNumber = cn;
    }
    
    public String toString() {
        return this.getName() + " " + this.getPhone() + " " + this.getScore() + " " + this.getCardNumber();
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        System.out.println(Base64.getEncoder().encodeToString(String.valueOf(this.getCardNumber()).getBytes()));
        oos.writeObject(Base64.getEncoder().encodeToString(String.valueOf(this.getCardNumber()).getBytes()));
    }
    
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        String encodedString = (String) ois.readObject();
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        this.setcardNumber(Integer.parseInt(decodedString));
    }
}