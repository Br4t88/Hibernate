package main;

import javax.persistence.*;

@Entity
@Table (name = "persons")
public class Person {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "age")
    private int age;
    @Column (name = "address")
    private String address;
    @Column (name = "amount")
    private int amount;

    public Person (){

    }

    public Person (int id, String name, int age, String address, int amount){
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.amount = amount;
    }

    public Person (String name, int age, String address, int amount){
        this.name = name;
        this.age = age;
        this.address = address;
        this.amount = amount;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                '}';
    }
}
