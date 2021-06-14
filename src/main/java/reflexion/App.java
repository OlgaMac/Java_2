package reflexion;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class App {
    @SneakyThrows
    public static void main(String[] args) {
        Phone phone = new Phone(8, "Sony Ex");
        Class<?> phoneClass = phone.getClass();

        Class<?> classOfPhone = Phone.class;

        String className = classOfPhone.getName();
        System.out.println("Class name: " + className);

        Field[] publicField = classOfPhone.getFields();
        System.out.println("List of public field");
        for (Field pf : publicField) {
            System.out.println(pf.getType().getName() + " " + pf.getName());
        }

        System.out.println();
        System.out.println("List of fields");

        Field[] fields = classOfPhone.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getType().getName() + " " + f.getName());
        }
        Field ramField = classOfPhone.getDeclaredField("ram");
        ramField.setAccessible(true);
        ramField.set(phone, 16);
        int ram = (int) ramField.get(phone);
        System.out.println("Ram: " + ram);

        Method method = classOfPhone.getDeclaredMethod("printPhone");
        method.setAccessible(true);
        method.invoke(phone);

        Constructor<?> allSrgsConstructor = classOfPhone.
                getDeclaredConstructor(String.class, String.class, int.class);
        allSrgsConstructor.setAccessible(true);
        Phone samsung = (Phone) allSrgsConstructor.newInstance("Samsung", "Gelaxy S21", 16);
        method.invoke(samsung);
    }
}

