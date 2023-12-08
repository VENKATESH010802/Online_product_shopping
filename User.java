import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private String mail;
    private String number;
    private int user_ID;
  //  private ArrayList<Integer> History=new ArrayList<>();
    public User(){
        name="Not entered";
        password="Not Set password";
        mail="Not mentioned";
        number="No data";
    }
    public void add(String n,String p,String m,String num,int id){
        name=n;
        password=p;
        mail=m;
        number=num;
        user_ID=id;
    }
    public int getUser_ID(){
        return user_ID;
    }
//    public void user_bought(int n){
//        History.add(n);
//    }
//    public void user_delete(int n){
//        if(History.contains(n)) {
//            History.remove(n);
//            System.out.println("Product removed from cart");
//        }
//        else
//            System.out.println("Product not found in cart");
//    }
    public String getName(){
        return name;
    }
    public String getMail(){
        return mail;
    }
    public String getPassword(){
        return password;
    }
    public String getNumber(){
        return number;
    }
}
