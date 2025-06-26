package gestionale;

import java.sql.Date;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private String email;
    private Date hireDate;
    private double salary;

    public Employee() { }

    public Employee(String name, String surname, String email, Date hireDate, double salary) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.hireDate = hireDate;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return String.format("ID: %d | %s %s | %s | %s | €%.2f",
                id, name, surname, email, hireDate.toString(), salary);
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}