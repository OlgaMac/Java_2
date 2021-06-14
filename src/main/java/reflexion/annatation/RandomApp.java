package reflexion.annatation;

public class RandomApp {
    public static void main(String[] args) {
        RandomIntAnnatationProcessor processor = new RandomIntAnnatationProcessor();
        User user = (User) processor.createObjectByClassName(User.class.getName());
        System.out.println(user);
    }
}
