package reflexion.annatation;

import lombok.SneakyThrows;
import util.StringUtils;

import javax.crypto.ExemptionMechanismException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class RandomStringAnnotationProcessor {
    @SneakyThrows
    public Object[] createObjectByClassName(String[] className) {
        Collection<Object> objects = new ArrayList<>();
        for (int i = 0; i < className.length; i++) {
            Object instance = Class.forName(className[i]).getDeclaredConstructor().newInstance();

            Field[] fields = Class.forName(className[i]).getDeclaredFields();
            for (Field field : fields) {
                RandomString annotation = field.getAnnotation(RandomString.class);
                if (annotation != null) {
                    if(!field.getType().equals(String.class)){
                        throw new ExemptionMechanismException("Not String Field");
                    }
                    int length = annotation.length();
                    String RandomString = methodRandomString(length);
                    field.setAccessible(true);
                    field.set(instance, RandomString);
                }
            }
            objects.add(instance);
        }
        return objects.toArray();
    }


    private String methodRandomString(int length){
        Random random = new Random();
        String s = " ";
        for (int j = 0; j < length; j++) {
            if(j == 0){
                s += Character.toString((char) random.nextInt(90 - 65) + 65);
            }else {
                s += Character.toString((char) random.nextInt(122 - 97) + 97);
            }
        }
        return s;
    }
}
