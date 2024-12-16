package pro.sky.skyspringhw5;

import java.util.Objects;

public class Employee {
    private static int count;
    private int iD;
    private String fullName;
    private Integer department;
    private double salary;


    // Constructor
    public Employee(String fullName, int department, double salary) {
        this.iD = ++count;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }


    // Get && Set
    public String getFullName() {
        return fullName;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return iD;
    }

    // toString
    @Override
    public String toString() {
        return "Сотрудник {" +
                "iD = " + iD +
                ", Ф.И.О. = " + fullName +
                ", Отдел = " + department +
                ", ЗП = " + salary +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Employee other = (Employee) o;
        if (fullName == null) {
            if (other.fullName != null)
                return false;
        } else if (!fullName.equals(other.fullName))
            return false;
        if (fullName == null) {
            return other.fullName == null;
        } else return fullName.equals(other.fullName);
    }

    @Override
    public int hashCode() {
        final int prime = 1;
        int result = 1;
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        return result;
    }
}
