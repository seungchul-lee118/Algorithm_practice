package bootcamp.example.lv3;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    // 프로그래머스 Lv.3 베스트앨범

    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList<>();
        Map<String, ArrayList<Integer>> genreMap = new HashMap<>();
        Map<String, Integer> genrePlays = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreMap.putIfAbsent(genres[i], new ArrayList<>());
            genreMap.get(genres[i]).add(plays[i]);

            Integer beforePlay = genrePlays.getOrDefault(genres[i], 0);
            genrePlays.put(genres[i], beforePlay + plays[i]);
        }

        while (!genreMap.isEmpty()) {
            int maxPlays = 0;
            String maxGenre = "";
            for (String key : genrePlays.keySet()) {
                if (genrePlays.get(key) > maxPlays) {
                    maxPlays = genrePlays.get(key);
                    maxGenre = key;
                }
            }
            genrePlays.remove(maxGenre);
            ArrayList<Integer> maxGenrePlays = genreMap.remove(maxGenre);
            maxGenrePlays.sort(Comparator.reverseOrder());

            int cnt = 0;
            for (int i = 0; i < Math.min(maxGenrePlays.size(), 2); i++) {
                if (cnt == 2) break;
                Integer maxPlayOfGenre = maxGenrePlays.get(i);
                for (int j = 0; j < plays.length; j++) {
                    if (plays[j] == maxPlayOfGenre) {
                        result.add(j);
                        cnt++;
                    }
                }
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}