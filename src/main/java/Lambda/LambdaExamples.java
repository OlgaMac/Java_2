package Lambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaExamples {
    public static void main(String[] args) {

        Comparator<Phone> weightComparator = new Comparator<Phone>() {
            @Override
            public int compare(Phone o1, Phone o2) {
                return Double.compare(o1.getWeight(),o2.getWeight());
            }
        };

        int maxLength = 5;
        Predicate<Phone> maxLengthPredicate = new Predicate<Phone>() {
            @Override
            public boolean test(Phone phone) {
                return phone.getBrand().length() <= maxLength;
            }
        };
// 3 parts of lambda
        // - arguments
        // - delimeter{->}
        // - method body
        Predicate<Phone> maxLengthLambdaPredicate = phone -> phone.getBrand().length() <= maxLength;
        Predicate<Phone> maxLengthLambdaPredicate2 = (p) -> {
            return p.getBrand().length() <= maxLength;
        };

        Comparator<Phone> weightComparator2 = (p1, p2) -> Double.compare(p1.getWeight(),p2.getWeight());

        List<Phone>list = new ArrayList<>();
        list.add(new Phone("Xiomi", "Redmi Note 7", 134));
        list.add(new Phone("Xiomi", "Redmi Note 8 Pro", 164));
        list.add(new Phone("Samsung", "S20", 210));
        list.add(new Phone("Sumsung", "Note 20", 250));
        list.add(new Phone("IPhone", "12 Pro Max", 189));

        List<Phone> filteredList = list.stream()
                .filter(phone -> phone.getBrand().length() <= maxLength)
                .collect(Collectors.toList());

        List<Phone> filteredWithoutStream = new ArrayList<>();
        for(Phone phone: list){
            if(phone.getBrand().length() <= maxLength){
                filteredWithoutStream.add(phone);
            }
        }

        List<Double> weights = list.stream()
                .map(phone -> phone.getWeight())
                .filter(weight -> weight > 200)
                .collect(Collectors.toList());

        double maxWeight = list.stream()
                .mapToDouble(p -> p.getWeight())
                .max()
                .getAsDouble();

        OptionalDouble optinal = list.stream()
                //.mapToDouble(p -> p.getWeight())
                .mapToDouble(Phone::getWeight)
                .max();

        double maxWeight1 = optinal.orElse(0);

        List<Phone> sortedList = list.stream()
                .sorted((p1,p2)->p1.getBrand().compareTo(p2.getBrand()))
                .collect(Collectors.toList());

        list.forEach(phone -> System.out.println(phone));
        list.forEach(System.out::println); //method reference


    }
}
