
public class Customer {

    private String name;
    private String license;
    private String phone;

    public Customer(String name, String license, String phone) {
        this.name = name;
        this.license = license;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense() {
        this.license = license;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone() {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer name: " + name + ", Licnse: " + license + "Phone: " + phone;
    }
}
