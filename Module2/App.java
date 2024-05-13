package Module2;
public class App {
    public static void main(String[] args) throws Exception {
        SinglyLinkedList<Integer> testList = new SinglyLinkedList<>();
        testList.addToFront(6);
        System.out.println(testList.size());
    }
}