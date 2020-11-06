import telran.dto.Address;
import telran.dto.Employee;
import telran.validation.Validator;

import java.time.LocalDate;

public class ConstraintsTestAppl {

    public static void main(String[] args) {
        Employee employee = new Employee(
                123,
                "Gregory",
               new Address("Tel-aviv", "Dizengof", 25, 12),
                "grishap96123@gmail.com",
                LocalDate.of(1996, 06, 20),
                "Java developer",
                6000);

        Employee employee2 = new Employee(
                123,
                null,
                new Address("", "", 0, 12),
                "grishap96123@g@mail.com",
                LocalDate.of(2040, 06, 20),
                "",
                1236000);


        System.out.println("=========== telran.dto.Employee 1 ===========");
        Validator.validate(employee).stream().filter(e ->  e != null).forEach(System.out::println);

        System.out.println("=========== telran.dto.Employee 2 ===========");
        Validator.validate(employee2).stream().filter(e ->  e != null).forEach(System.out::println);

    }
}
