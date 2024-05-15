package Module1;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println();

        ArrayList <String> listOne = new ArrayList<>();

        listOne.addToFront("9a");
        listOne.addToFront("8a");
        listOne.addToFront("7a");
        listOne.addToFront("6a");
        listOne.addToFront("5a");
        listOne.addToFront("4a");
        listOne.addToFront("3a");
        listOne.addToFront("2a");
        listOne.addToFront("1a");

        listOne.removeFromFront();

        
        listOne.printOut();
        System.out.println();
        System.out.println(listOne.size());

    }
}
