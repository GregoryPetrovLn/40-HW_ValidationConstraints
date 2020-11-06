package telran.dto;

import telran.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {
    public static final long serialVersionUID = 1L;
    private static final int MIN_SALARY = 5000;
    private static final int MAX_SALARY = 30000;

    private long id;

    @NotNull(message = "Name can't be null")
    @NotEmpty(message = "Name can't be empty")
    private String name;

    @NotNull(message = "Email can't be null")
    @Email()
    private final String email;

    @NotNull(message = "Birth date can't be null")
    @Past(message = "Birth date must be in past")
    private LocalDate birthDate;

    @NotNull(message = "Department can't be null")
    @NotEmpty(message = "Department can't be empty")
    private String department;

    @Min(value = MIN_SALARY, message = "Salary can't be less than " + MIN_SALARY)
    @Max(value = MAX_SALARY, message = "Salary can't be grater than " + MAX_SALARY)
    private int salary;

    @Valid(message = "There are no annotations in field address")
    private Address address;


    public Employee(long id, String name,Address address, String email, LocalDate birthday, String department, int salary) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.birthDate = birthday;
        this.department = department;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthDate;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public Long compareTo(Employee empl) {
        Long emplid = empl.getId();
        return this.id - emplid;
    }




}
