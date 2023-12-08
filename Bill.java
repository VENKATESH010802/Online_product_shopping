import java.util.ArrayList;

public class Bill {
    private String customer_name;
    private String Product_name;
    private int quantity;
    private double price;
    private int bill_num;
    private int prod_id;
    public void add(String name,String product,int q,double pri,int bill_no,int prod_id){
        customer_name=name;
        Product_name=product;
        quantity=q;
        price=pri;
        bill_num=bill_no;
        this.prod_id=prod_id;
        System.out.println("added to bill.");
    }
    public void display_bill(){
        System.out.println("Bill number: "+bill_num+"Product name: "+Product_name+" Quantity :"+quantity+" Price: "+price);
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getProduct_name() {
        return Product_name;
    }

    public int getQuantity() {
        return quantity;
    }
    public int getProd_id(){
        return prod_id;
    }
    public double getPrice() {
        return price;
    }
}
