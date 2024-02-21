class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Product[] products;
    private int productCount;
    private static final int MAX_PRODUCTS = 150;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.products = new Product[MAX_PRODUCTS];
        this.productCount = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }


    public void addProduct(Product product) {
        if (productCount < MAX_PRODUCTS) {
            products[productCount++] = product;
        } else {
            System.out.println("Cannot add more products. Storage is full.");
        }
    }

    public Product[] getAllProducts() {
        return products;
    }

    public Book[] getAllBooks() {
        Book[] books = new Book[MAX_PRODUCTS];
        int bookCount = 0;
        for (Product product : products) {
            if (product instanceof Book) {
                books[bookCount++] = (Book) product;
            }
        }
        return books;
    }

    public Electronics[] getAllElectronics() {
        Electronics[] electronics = new Electronics[MAX_PRODUCTS];
        int electronicCount = 0;
        for (Product product : products) {
            if (product instanceof Electronics) {
                electronics[electronicCount++] = (Electronics) product;
            }
        }
        return electronics;
    }
}

