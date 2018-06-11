import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IterationHashMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("swz", 56);
        map.put("sjj", 56);
        map.put("spj", 30);
        map.put("sxj", 24);

        //iterate1(map);
        //iterate2(map);
        iterate3(map);
        System.out.println(map.size());
    }

    // iterate by Map.Entry
    /*
    * General idea: use entrySet()
    * PROs: efficient
    * CONs: cannot delete
    * */
    public static void iterate1(Map<String, Integer> map) {
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("name: %s - age: %d%n", entry.getKey(), entry.getValue());
        }
    }

    /*
    * General idea: use either keySet() or values()
    *
    * */
    public static void iterate2(Map<String, Integer> map) {
        for (String s : map.keySet()) {
            System.out.printf("name : %s%n", s);
        }

        for (int num : map.values()) {
            System.out.printf("age : %d%n", num);
        }
    }


    /*
    * General idea: use iterator(Generic)
    * PROs: delete safely and only way to iterate in old version of java.s
    * */
    public static void terate3 (Map<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
            iterator.remove();
        }
    }
}
