import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Source extends Exception{
    ArrayList<User> user=new ArrayList<>();
    ArrayList<Admin> admins=new ArrayList<>();
    ArrayList<Product> products=new ArrayList<>();
    ArrayList<Bill> purchase=new ArrayList<>();
    Scanner p=new Scanner(System.in);
    int user_id=0;
    int admin_id=0;
    int prod_id=0;
    int purchase_id=0;
    public void Login(){
        try {
            System.out.println("Log-in Page: ");
            System.out.println("Enter your user ID(If you don't have one enter -1): ");
            int id = p.nextInt();
            p.nextLine();
            if (id == 1010) {
                admin_set();
                Login();
            }
            if (id == 1122) {
                admin_in();
                Login();
            } else {
                try {
                    if (id >= 0)
                        check_user(id);
                    else {
                        System.out.println("User ID noy found in database. Try with new login (1.yes/2.no) ?");
                        if(p.nextInt()==1) {
                            p.nextLine();
                            new_user();
                        }
                        else{
                            Login();
                        }
                    }
                } catch (IndexOutOfBoundsException E) {
                    System.out.println("Requested ID not found.");
                    new_user();
                }
            }
        }
        catch (InputMismatchException E){
            System.out.println("Try with number.");
            p.nextLine();
            Login();
        }
    }
    public void admin_set(){
        try {
            System.out.println("Enter the name of the admin to add (String): ");
            String name = p.nextLine();
            Admin ad = new Admin();
            ad.setName(name);
            System.out.println("Enter admin password for " + name + " (String) :");
            String pass = p.nextLine();
            ad.setPassword(pass);
            ad.setAdmin_id(admin_id);
            System.out.println("Your admin ID is " + admin_id);
            admins.add(admin_id, ad);
            System.out.println("Utilize secret ID 1122 for admin log-in page");
            admin_id++;
        }
        catch (InputMismatchException E){
            System.out.println("Use the data types given in brackets.");
            admin_set();
        }
    }
    public void admin_in() throws IndexOutOfBoundsException{
        try {
            System.out.println("Enter Admin ID (Integer): ");
            int n = p.nextInt();
            p.nextLine();
            if (n < admin_id) {
                System.out.println("Enter the Admin password (String): ");
                String pass = p.nextLine();
                Admin ad;
                ad = admins.get(n);
                if (ad.getPassword().equals(pass)) {
                    System.out.println("Welcome " + ad.getName());
                    admin_options(n);
                } else {
                    System.out.println("Wrong password..");
                }
            }
            else{
                System.out.println("Requested Admin ID not found. Try again");
            }
        }
        catch (InputMismatchException E){
            System.out.println("Use the data types given in brackets.");
            admin_in();
        }
    }
    public void new_user(){
            User user1 = new User();
            System.out.println("Welcome to Sign-Up page ");
            System.out.println("Enter your name (String): ");
            String name = p.nextLine();
            System.out.println("Enter your Phone number (Enter numbers only): ");
            String num=p.nextLine();
            for(User use: user ){
                if(use.getNumber().equals(num))
                {
                    System.out.println("User already exist. At user ID "+use.getUser_ID());
                    check_user(use.getUser_ID());
                }
            }
            System.out.println("Enter your mail id (String): ");
            String mail = p.nextLine();
            System.out.println("Enter your new password (Combination of words and numbers): ");
            String p1 = p.nextLine();
            System.out.println("Conform your password (Re-enter password): ");
            String p2 = p.nextLine();
            if (p1.equals(p2)) {
                user1.add(name, p1, mail, num,user_id);
                user.add(user_id, user1);
                System.out.println("Your user ID is : " + user_id);
                user_id++;
                Login();
            } else {
                System.out.println("Enter your new password (Combination of words and numbers): ");
                p1 = p.nextLine();
                System.out.println("Conform your password (Re-enter password): ");
                p2 = p.nextLine();
                if (p1.equals(p2)) {
                    user1.add(name, p1, mail, num,user_id);
                    user.add(user_id, user1);
                    System.out.println("Your user ID is : " + user_id);
                    user_id++;
                    Login();
                } else
                    new_user();
            }
    }
    public void check_user(int id) throws IndexOutOfBoundsException{
        User user2;
        user2=user.get(id);
        if(!user2.getName().equals("Not entered")){
            System.out.println("Enter your password: ");
            String password=p.nextLine();
            if(user2.getPassword().equals(password)) {
                System.out.println("User Options");
                user_options(id);
            }
            else
            {
                System.out.println("Incorrect password try again (yes/no).");
                String y=p.nextLine();
                if(y.equals("yes")||y.equals("Yes"))
                check_user(id);
                else
                    Login();
            }
        }
        else{
            System.out.println("Requested user Id not found.");
            new_user();
        }
    }
    public void user_options(int id){
        User use;
        use=user.get(id);
        System.out.println("Welcome "+use.getName());
        try {
            System.out.println("1. Search 2. View all Products 3.Buy 4.Categories 5.Checkout 6.Log-out 7.Purchase History 8.remove products from cart");
            int x = p.nextInt();
            switch (x) {
                case 1: {
                    Product_search();
                    user_options(id);
                }
                break;
                case 2: {
                    Product_view();
                    user_options(id);
                }
                break;
                case 3: {
                    prod_buy(id);
                    user_options(id);
                }
                break;
                case 4: {
                    product_category();
                    user_options(id);
                }
                break;
                case 5: {
                    user_checkout(id);
                }
                break;
                case 6: {
                    System.out.println("Thank you for shopping with us...");
                    Login();
                }
                break;
                case 7: {
                    user_purchase(id);
                    user_options(id);
                }
                break;
                case 8: {
                    remove_user(id);
                    user_options(id);
                }
                break;
                default: {
                    System.out.println("Incorrect Option, Try again..");
                    user_options(id);
                }
                break;
            }
        }
        catch (InputMismatchException E){
            System.out.println("Enter the option number in input field.");
            user_options(id);
        }
    }
    public void admin_options(int admin_num){
        System.out.println("Admin Options");
        try {
            System.out.println("1.View products 2.Add products 3.Modify products 4.Remove Products 5.View purchase history 6.Logout 7.Terminate");
            int x = p.nextInt();
            switch (x) {
                case 1: {
                    Admin_prod_view();
                    admin_options(admin_num);
                }
                break;
                case 2: {
                    add_products(admin_num);
                    admin_options(admin_num);
                }
                break;
                case 3: {
                    modify_products(admin_num);
                    admin_options(admin_num);
                }
                break;
                case 4: {
                    remove_products(admin_num);
                    admin_options(admin_num);
                }
                break;
                case 5: {
                    Bill_history();
                    admin_options(admin_num);
                }
                break;
                case 6: {
                    Admin ad;
                    ad = admins.get(admin_num);
                    System.out.println("Good Bye.. " + ad.getName());
                    Login();
                }
                break;
                case 7: {
                    System.out.println("End of the session...");
                    System.exit(0);
                }
                break;
                default: {
                    System.out.println("Wrong option, Try again.");
                    admin_options(admin_num);
                }
                break;
            }
        }
        catch (InputMismatchException E){
            System.out.println("Enter option number in the input field.");
            admin_options(admin_num);
        }
    }
    public void Admin_prod_view(){
        System.out.println("The products available are: ");
        for(Product p:products){
            p.admin_display();
        }
    }
    public void Bill_history(){
        for(Bill b:purchase){
            b.display_bill();
        }
    }
    public void add_products(int admin_num){
        p.nextLine();
        Product product=new Product();
        System.out.println("Enter the product name (String): ");
        String name=p.nextLine();
        System.out.println("Enter the product seller name (String): ");
        String seller=p.nextLine();
        System.out.println("Enter the product price (double): ");
        double d=p.nextDouble();
        p.nextLine();
        System.out.println("Enter the product category (1. Chocolate 2. Electronics 3.Household): ");
        int y=p.nextInt();
        String cat="null";
        switch (y){
            case 1:
                cat="Chocolate";
                break;
            case 2:
                cat="Electronics";
                break;
            case 3:
                cat="Household";
                break;
            default:{
                System.out.println("Worng option try again.");
                add_products(admin_num);
            }
            break;
        }
        System.out.println("Enter the available quantity: ");
        int q=p.nextInt();
        Admin ad=admins.get(admin_num);
        String admin_name=ad.getName();
        product.add(name,q,cat,d,seller,admin_name,prod_id);
        products.add(prod_id,product);
        prod_id++;
    }
    public void modify_products(int admin_num){
        Admin ad=admins.get(admin_num);
        System.out.println("Enter the product ID to modify: ");
        int id=p.nextInt();
        try {
            Product pd = products.get(id);
            System.out.println("Which parameter you need to change: ");
            System.out.println("1.Name 2.Quantity 3.Seller 4.Price 5.Category 6.Skip");
            int x = p.nextInt();
            switch (x) {
                case 1: {
                    p.nextLine();
                    System.out.println("Enter new name for product " + pd.getName());
                    pd.setName(p.nextLine());
                    pd.setAdmin_name(ad.getName());
                    System.out.println("Name changed successfully to" + pd.getName());
                    admin_options(admin_num);
                }
                break;
                case 2: {
                    System.out.println("Current quantity is: " + pd.getQuantity());
                    System.out.println("Enter the new available quantity of product " + pd.getName());
                    pd.setAdmin_name(ad.getName());
                    pd.setQuantity(p.nextInt());
                    admin_options(admin_num);
                }
                break;
                case 3: {
                    System.out.println("Previous Seller was: " + pd.getSeller());
                    System.out.println("Enter new seller name:  ");
                    pd.setAdmin_name(ad.getName());
                    pd.setSeller(p.nextLine());
                    admin_options(admin_num);
                }
                break;
                case 4: {
                    System.out.println("Previous price: " + pd.getPrice());
                    System.out.println("Enter the new price: ");
                    pd.setAdmin_name(ad.getName());
                    pd.setPrice(p.nextDouble());
                    admin_options(admin_num);
                }
                break;
                case 5: {
                    System.out.println("Previous category was: " + pd.getCategory());
                    System.out.println("Enter the new category: ");
                    pd.setAdmin_name(ad.getName());
                    pd.setCategory(p.nextLine());
                    admin_options(admin_num);
                }
                break;
                case 6: {
                    System.out.println("Redirecting to admin options.");
                    admin_options(admin_num);
                }
                break;
                default: {
                    System.out.println("Wrong option, Try again");
                    modify_products(admin_num);
                }
            }
        }
        catch (NullPointerException E){
            System.out.println("Product ID is not found in Database. Try again");
            Admin_prod_view();
            modify_products(admin_num);
        }
        catch (InputMismatchException E){
            System.out.println("Input data type mismatch, Try again.");
            modify_products(admin_num);
        }
    }
    public void remove_products(int admin_num){
        System.out.println("Enter the product ID to remove: ");
        int id=p.nextInt();
        p.nextLine();
        if(id<prod_id) {
            Product pd = products.get(id);
            System.out.println("The product to be removed is : " + pd.getName() + " are you sure (yes/no)");
            String s = p.nextLine();
            switch (s) {
                case "yes": {
                        products.remove(id);
                    System.out.println("Product removed successfully.");
                }
                break;
                case "no":{
                    System.out.println("Redirecting to admin options.");
                }
                break;
                default:{
                    System.out.println("Try typing yes or no.");
                    modify_products(admin_num);
                }
                break;
            }
        }
        else{
            System.out.println("Product not found.");
            admin_options(admin_num);
        }
    }
    public void Product_search(){
        int flag=0;
        p.nextLine();
        System.out.println("Enter the product name: ");
        String search=p.nextLine();
        for(Product pd: products){
            if(pd.getName().equals(search)) {
                pd.display_user();
                flag=1;
            }
        }
        if(flag==0)
         System.out.println("Product is not available right now.");
    }
    public void Product_view(){
        System.out.println("The available products are: ");
        for(Product pd: products){
            pd.display_user();
        }
    }
    public void prod_buy(int id){
        User user1=user.get(id);
        System.out.println("Enter the product ID to buy: ");
        int pd=p.nextInt();
        try {
            Product prod = products.get(pd);
                System.out.println("Enter the quantity to buy: ");
                int q = p.nextInt();
                if (q <= prod.getQuantity()) {
                    Bill b = new Bill();
                    b.add(user1.getName(), prod.getName(), q, (q * prod.getPrice()), purchase_id, pd);
                    purchase.add(purchase_id, b);
                    products.get(pd).setQuantity(products.get(pd).getQuantity() - q);
                    purchase_id++;
                }
                else{
                    System.out.println("Try quantity less than : "+prod.getQuantity());
                    prod_buy(id);
                }
        }
        catch (NullPointerException E){
            System.out.println("Product ID is not present. Try again");
            Product_view();
            prod_buy(id);
        }
    }
    public void product_category(){
        try {
            System.out.println("1. Cholcolate 2. Electronics 3. Household products");
            switch (p.nextInt()) {
                case 1:
                    display_category("Chocolate");
                    break;
                case 2:
                    display_category("Electronics");
                    break;
                case 3:
                    display_category("Household");
                    break;
                default:
                    System.out.println("Wrong option");
                    break;
            }
        }
        catch (InputMismatchException E){
            System.out.println("Enter the option number.");
            product_category();
        }
    }
    public void display_category(String cat){
        System.out.println("The available "+cat+" category products are: ");
        for(Product pd:products){
            if(cat.equals(pd.getCategory()))
                pd.display_user();
        }
    }
    public void user_checkout(int id){
        User use=user.get(id);
        double total=0;
        int flag=0;
        System.out.println("The current products in cart are: ");
        for(Bill b:purchase){
            if(use.getName().equals(b.getCustomer_name()))
             b.display_bill();
            total+=b.getPrice();
            flag=1;
        }
        if(flag==0)
            System.out.println("No products to view in cart. Thank you for Shopping with us...");
        if(flag!=0)
            System.out.println("Total amount to be paid is: "+total+" Thank you for shopping with us...");
        Login();
    }
    public void remove_user(int id){
        user_purchase(id);
        System.out.println("Enter the Bill ID to remove: ");
        int b_id=p.nextInt();
        try {
            purchase.get(b_id).setPrice(0);
            int q = purchase.get(b_id).getQuantity();
            purchase.get(b_id).setQuantity(0);
            int pid = purchase.get(b_id).getProd_id();
            products.get(pid).setQuantity(products.get(pid).getQuantity() + q);
            System.out.println("Item removed.");
        }
        catch (NullPointerException E){
            System.out.println("Incorrect Bill ID, try again.");
            remove_user(id);
        }
    }
    public void user_purchase(int id){
        double total=0;
        User use=user.get(id);
        System.out.println("The current products in cart are: ");
        for(Bill b:purchase){
            if(use.getName().equals(b.getCustomer_name())) {
                b.display_bill();
                total+=b.getPrice();
            }
        }
        System.out.println("Total Amount:  "+total);
    }
}
