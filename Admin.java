public class Admin {
    private String name;
    private int admin_id;
    private String password;
    public void setName(String name){
        this.name=name;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
