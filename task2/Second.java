import java.io.*;
import java.util.*;
public class Second {
    public static void main(String[] args) {
        List<Customer> arr = new ArrayList<Customer>();
        BufferedWriter bw = null;
        try {
            File file = new File("C:\\Users\\Aramo\\OneDrive\\Desktop\\EPAM\\2- Java Core\\hw4\\task2\\Customers.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                String[] ar = st.split(",");
                Customer customer = new Customer(ar[0], ar[1], Integer.parseInt(ar[2]));
                arr.add(customer);
            }
            arr.sort(Comparator.comparing(Customer::getScore));
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for(Customer cust : arr) {
                bw.write(cust.getName() + ", " + cust.getPhone() + "," + cust.getScore());
                bw.write("\r\n");
            }
            
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } finally { 
            try{
                if(bw!=null)
                bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }
}