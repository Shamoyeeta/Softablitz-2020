class User {
    private String name,username,email;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {  //HASHING FUNCTION
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    void addItem(String pname, String category, String ID, double price, double quantity, double threshold) {
        Product product=new Product(pname,category,ID,price,quantity,threshold);
        updateLog(ID,"Added new product");
    }

    void updateLog(String productID, String change)  {
        //insert into log values username,product Id, change
    }
}


