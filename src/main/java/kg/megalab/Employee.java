package kg.megalab;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    private  String ID;
    private  String Firstname;
    private String lastname;
    private int age;
    private double salary;
    private Position position;
   // private int exp;

}
