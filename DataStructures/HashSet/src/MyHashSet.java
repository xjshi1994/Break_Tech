import java.util.HashMap;

public class MyHashSet {

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        System.out.println(hashSet.contains(1));
        hashSet.add(1);
        System.out.println(hashSet.contains(1));
    }
    /*
    * General Idea: hashset implemented based on the hashmap
    * 1. boolean add
    * 2. boolean contains
    * 3. boolean remove
    *
    * IMPORTANT: map.put() remove() -> return value is previous value
    * */
    private HashMap<Integer, Object> map;
    private Object PRESENT = new Object();

    public MyHashSet() {
        map = new HashMap<>();
    }

    public MyHashSet(int capacity) {
        map = new HashMap<>(capacity);
    }

    public MyHashSet(int capacity, float loadFactor) {
        map = new HashMap<>(capacity, loadFactor);
    }

    public boolean add(int e) {
        return map.put(e, PRESENT) == null;
    }

    public boolean contains(int e) {
        return map.containsKey(e);
    }

    public boolean remove(int e) {
        return map.remove(e) == PRESENT;
    }


}
