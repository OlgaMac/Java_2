package reflexion.annatation;

import lombok.ToString;

@ToString

public class User {
    private  String name;
    private String lastName;

    @RandomInt(min = 0, max = 100)
    private int age;
    @RandomInt(min = 0)
    private int identifier;
}
