class Book extends Product {
    private String authorFullName;

    public Book(String name, String description, double price, String authorFullName) {
        super(name, description, price);
        this.authorFullName = authorFullName;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }
}

