package reflexion.annatation;

import lombok.ToString;

@ToString

public class User {
    @RandomString(length = 16)
    private  String name;
    @RandomString(length = 16)
    private String lastName;

    @RandomInt(min = 0, max = 100)
    private int age;
    @RandomInt(min = 0)
    private int identifier;

    public User() {
    }
}
