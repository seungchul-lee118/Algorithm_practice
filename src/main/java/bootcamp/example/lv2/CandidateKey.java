package bootcamp.example.lv2;

import java.util.*;

public class CandidateKey {
    public static void main(String[] args) {
        String[][] relation1 = {{"100","ryan","music","2"},
            {"200","apeach","math","2"},
            {"300","tube","computer","3"},
            {"400","con","computer","4"},
            {"500","muzi","music","3"},
            {"600","apeach","music","2"}};
        String[][] relation2 = { {"a","1","aaa","c","ng"},
            {"a","1","bbb","e","g"},
            {"c","1","aaa","d","ng"},
            {"d","2","bbb","d","ng"}};
        String[][] relation3 = {{"a","1","aaa","c","ng"},
            {"b","1","bbb","c","g"},
            {"c","1","aaa","d","ng"},
            {"d","2","bbb","d","ng"}};

        System.out.println(solution(relation1));
//        System.out.println(solution(relation2));
//        System.out.println(solution(relation3));
    }

    // 프로그래머스 lv.2 후보키

    public static int solution(String[][] relation) {
        List<Set<Character>> keys = new ArrayList<>();

        StringBuilder columns = new StringBuilder();
        for (int i = 0; i < relation[0].length; i++) {
            columns.append(i);
        }

        for (int i = 1; i <= relation[0].length; i++) {
            comb(columns.toString(), new HashSet<>(), i, relation, keys);
        }

        return keys.size();
    }

    static void comb(String columns, Set<Character> set, int r, String[][] relation, List<Set<Character>> keys) {
        if (r == 0) {
            if (isUnique(set, relation) && isMinimal(set, keys)) {
                keys.add(set);
            }
            System.out.println("set = " + set);
            return;
        }

        for (int i = 0; i < columns.length(); i++) {
            Set<Character> newSet = new HashSet<>(set);
            newSet.add(columns.charAt(i));
            comb(columns.substring(i + 1), newSet, r - 1, relation, keys);
        }
    }

    static boolean isUnique(Set<Character> key, String[][] relation) {
        Set<String> set = new HashSet<>();
        for (String[] row : relation) {
            StringBuilder builder = new StringBuilder();
            for (Character col : key) {
                builder.append(row[col - '0']);
            }
            if (set.contains(builder.toString())) return false;
            else set.add(builder.toString());
        }
        return true;
    }

    static boolean isMinimal(Set<Character> targetKey, List<Set<Character>> keys) {
        for (Set<Character> key : keys) {
            if (targetKey.containsAll(key)) return false;
        }
        return true;
    }
}
