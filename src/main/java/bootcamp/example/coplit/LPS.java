package bootcamp.example.coplit;

public class LPS {
    public static void main(String[] args) {

    }

    public static int LPS(String str) {

        if (str.length() <=1) return 0;
        int preIdx = 0;
        int sufIdx = str.length()/2 + str.length() % 2;
        int count = 0;

        for (int i = sufIdx; i < str.length(); i++) {
            if (str.charAt(preIdx) == str.charAt(i)) {
                count++;
                preIdx++;
            } else if (str.charAt(i) == str.charAt(0)) {
                preIdx = 1;
                count = 1;
            } else {
                count = 0;
                preIdx = 0;
            }
        }

        return count;
    }
}
