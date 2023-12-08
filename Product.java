public class Product {
     private String name;
     private String category;
     private double price;
     private int quantity;
     private String seller;
     private int prod_id;
     private String admin_name;
    public void add(String n,int q,String cat,double p,String sell,String admin_name,int prod_id){
        name=n;
        quantity=q;
        category=cat;
        price=p;
        seller=sell;
        this.admin_name=admin_name;
        this.prod_id=prod_id;
        System.out.println("Successfully added to product");
    }
    public String getName(){
        return name;
    }
    public String getCategory(){
        return category;
    }
    public String getSeller(){
        return seller;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getPrice(){
        return price;
    }
    public int getProd_id(){
        return prod_id;
    }
    public String getAdmin_name(){
        return admin_name;
    }
    public void setAdmin_name(String name){
        admin_name=name;
    }
    public void setProd_id(int p){
        prod_id=p;
    }
     public void setName(String n){
         name=n;
     }
     public void setQuantity(int q){
         quantity=q;
     }
     public void setCategory(String cat){
         category=cat;
     }
     public void setPrice(double p){
         price =p;
     }
     public  void setSeller(String sell){
         seller=sell;
     }
     public void display_user() {
         System.out.println("Product ID: " + prod_id + " Product name: " + name + " Price: " + price + " Quantity: " + quantity + " Seller: " + seller + " Category: " + category);
     }
     public void admin_display(){
         System.out.println("Product ID: " + prod_id + " Product name: " + name + " Price: " + price + " Quantity: " + quantity + " Seller: " + seller + " Category: " + category+" Last edited admin: "+admin_name);
     }
}
