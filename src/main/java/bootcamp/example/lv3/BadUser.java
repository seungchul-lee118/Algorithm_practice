package bootcamp.example.lv3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BadUser {
    public static void main(String[] args) {
        String[] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id1 = {"fr*d*", "abc1**"};

        String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id2 = {"*rodo", "*rodo", "******"};

        String[] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id3 = {"fr*d*", "*rodo", "******", "******"};

        System.out.println(solution(user_id1, banned_id1));
        System.out.println(solution(user_id2, banned_id2));
        System.out.println(solution(user_id3, banned_id3));
    }

    // 프로그래머스 Lv.3 불량 사용자

    public static int solution(String[] user_id, String[] banned_id) {
        List<String>[] matchedIds = new ArrayList[banned_id.length];
        HashSet<HashSet<String>> idSets = new HashSet<>();

        for (int i = 0; i < banned_id.length; i++) {
            matchedIds[i] = new ArrayList<>();
            for (int j = 0; j < user_id.length; j++) {
                String replaced = banned_id[i].replace("*", ".");
                if (user_id[j].matches(replaced)) matchedIds[i].add(user_id[j]);
            }
        }
        findSet(idSets, new HashSet<>(), matchedIds, 0);
        return idSets.size();
    }

    static void findSet(HashSet<HashSet<String>> idSets, HashSet<String> set, List<String>[] matchedIds, int idx) {
        if (idx == matchedIds.length) {
            HashSet<String> clone = (HashSet<String>) set.clone();
            idSets.add(clone);
            return;
        }
        for (int i = 0; i < matchedIds[idx].size(); i++) {
            String matchedId = matchedIds[idx].get(i);
            if (set.contains(matchedId)) continue;
            set.add(matchedId);
            findSet(idSets, set, matchedIds, idx + 1);
            set.remove(matchedId);
        }
    }
}