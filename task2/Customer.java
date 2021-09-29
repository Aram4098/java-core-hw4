public class Customer {
    private String name;
    private String phone;
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

}