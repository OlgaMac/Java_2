package reflexion.annatation;

public class RandomApp {
    public static void main(String[] args) {
        RandomIntAnnotationProcessor processor = new RandomIntAnnotationProcessor();
        RandomStringAnnotationProcessor processorString = new RandomStringAnnotationProcessor();
        User user = new User();
        String[] names = {"reflexion.annatation.User"};
        user = (User) processor.createObjectByClassName(User.class.getName());
        Object[] objects = processorString.createObjectByClassName(names);
        for (Object o : objects) {
            System.out.println(o);
        }


        //System.out.println(user);
    }
}
