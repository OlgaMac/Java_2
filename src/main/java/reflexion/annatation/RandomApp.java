package reflexion.annatation;

import java.util.List;

public class RandomApp {
    public static void main(String[] args) {
        RandomIntAnnatationProcessor processor = new RandomIntAnnatationProcessor();
        RandomStringAnnotationProcessor processorString = new RandomStringAnnotationProcessor();
        User user = new User();
        String[] names = {"reflexion.annatation.User"};
        user = (User) processor.createObjectByClassName(User.class.getName());
        Object[] objects = processorString.createObjectByClassName(names);
        for(Object o: objects)
          System.out.println(o);


        //System.out.println(user);
    }
}
