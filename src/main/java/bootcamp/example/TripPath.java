package bootcamp.example;

import java.util.*;

public class TripPath {
    public static void main(String[] args) {
        String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},
            {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(solution(tickets1)));
        System.out.println(Arrays.toString(solution(tickets2)));
    }
    // 프로그래머스 Lv.3 여행경로
    public static String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            PriorityQueue<String> queue = map.getOrDefault(ticket[0], new PriorityQueue<>());
            queue.add(ticket[1]);
            map.put(ticket[0], queue);
        }

        System.out.println(map);
        return dfs("ICN", map).toArray(new String[0]);
    }

    public static Deque<String> dfs(String key, Map<String, PriorityQueue<String>> map) {
        if (!map.containsKey(key) || map.get(key).isEmpty()) {
            return new LinkedList<>(List.of(key));
        }

        Deque<String> toPort = dfs(map.get(key).poll(), map);
        if(!map.get(key).isEmpty()){
            Deque<String> fromPort = dfs(map.get(key).poll(), map);
            if(fromPort.size() > toPort.size()){
                while(!toPort.isEmpty()){
                    fromPort.addLast(toPort.pollFirst());
                }
                toPort = fromPort;
            } else {
                while(!fromPort.isEmpty()){
                    toPort.addFirst(fromPort.pollLast());
                }
            }
        }
        toPort.addFirst(key);
        return toPort;
    }
}