import java.util.*;
import java.util.function.Function;

public class HelloJVM {
    public static void main(String[] args) {
        System.out.println("hello JVM");

        Map<String,Object> data = new HashMap<>();
//        data.put("name",null);
        data.put("age",21);
        data.computeIfAbsent("name", new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                return new String("jack");
            }
        });

        data.put(null,"testNull");
        System.out.println(data.get(null));
        testSet();
    }


    public static void testSet(){
        List<Object> data = new ArrayList<>();
        data.add(null);
        data.add(null);
        System.out.println(data.size());
    }

}
