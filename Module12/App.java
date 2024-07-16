package Module12;
public class App {
    public static void main(String[] args) {
        CharSequence text = "BABABABA";
        CharSequence pattern = "ABAB";
        CharacterComparator comp = new CharacterComparator();
        System.out.println();
        System.out.println(PatternMatching.boyerMoore(pattern, text, comp));
    }
}