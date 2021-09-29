import java.io.Serializable;
public class Customer implements Serializable {
    private String name;
    private transient String phone;
    private int score;
    
    public Customer(String name, String phone, int score) {
        this.name = name;
        this.phone = phone;
        this.score = score;
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

    public String toString() {
        return this.getName() + " " + this.getPhone() + " " + this.getScore();
    }
}