public class Main {
    public static void main(String[] args) {
        MyDynamicArray array = new MyDynamicArray(2);
        array.add(0);
        array.add(1);
        array.travesal();
        System.out.println(array.size);

        array.add(2);
        System.out.println(array.data.length);
    }
}
