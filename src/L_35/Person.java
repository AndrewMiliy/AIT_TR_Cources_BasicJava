package L_35;

public class Person {
private String name;
private String address;
private String phone;
private String email;

    private int age;

    public Person(String name, int age) {
        this.name = name; this.age = age;
    }

    public String toString() {
        return name + " (" + age + ")";
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
