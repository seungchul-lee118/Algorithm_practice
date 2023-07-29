package bootcamp.example.lv2;

import java.util.*;

public class OpenChat {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi",
            "Enter uid4567 Prodo", "Leave uid1234",
            "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        System.out.println(Arrays.toString(solution(record)));
    }

    // 프로그래머스 lv.2 오픈채팅방

    public static String[] solution(String[] record) {
        List<String> message = new ArrayList<>();
        Map<String, String> userNickname = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String[] data = record[i].split(" ");
            String action = data[0];
            String user = data[1];

            if (action.equals("Enter")) {
                userNickname.put(user, data[2]);
            } else if (action.equals("Change")) {
                userNickname.put(user, data[2]);
            }
        }

        for (int i = 0; i < record.length; i++) {
            String[] data = record[i].split(" ");
            String action = data[0];
            String user = data[1];
            String nickname = userNickname.get(user);

            if (action.equals("Enter")) {
                message.add(nickname + "님이 들어왔습니다.");
            } else if (action.equals("Leave")) {
                message.add(nickname + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[message.size()];
        for (int i = 0; i < message.size(); i++) {
            answer[i] = message.get(i);
        }
        return answer;
    }
}
