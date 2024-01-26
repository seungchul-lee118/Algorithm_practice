import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNum = sc.nextInt();
        List<Integer> result = new ArrayList<>();
        String resultString = "";

        for (int i = firstNum / 2 + 1; i <= firstNum; i++) {
            List<Integer> tempList = longest(firstNum, i, new ArrayList<>());
            if (result.size() < tempList.size()) {
                result = tempList;
            }
        }
        System.out.println(result.size());
        for (Integer i : result) {
            resultString += i + " ";
        }
        System.out.println(resultString.trim());
        
    }

    public static List<Integer> longest(int firstNum, int secondNum, List<Integer> result) {
        if (firstNum < secondNum) {
            result.add(secondNum);
            return result;
        }
        if (result.isEmpty()) {
            result.add(firstNum);
        }
        result.add(secondNum);
        return longest(secondNum, firstNum - secondNum, result);
    }
}