package MapAndSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 학급_회장 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        String votePaper = br.readLine();

        System.out.println(solution(number, votePaper));
    }

    static char solution(int number, String votePaper) {
        Map<Character, Integer> resultMap = new HashMap<>();
        char answer = ' ';
        int count = 0;

        // 각 학생의 득표 횟수를 Map에 저장
        for (int i=0; i<number; i++) {
            resultMap.put(votePaper.charAt(i), resultMap.getOrDefault(votePaper.charAt(i), 0) + 1);
        }

        Iterator<Character> iterator = resultMap.keySet().iterator();

        // Map의 Key를 Iterator로 받아 순회하면서 가장 득표가 높은 학생을 찾는다.
        while (iterator.hasNext()) {
            char key = iterator.next();
            int value = resultMap.get(key);

            if (count < value) {
                count = value;
                answer = key;
            }
        }

        return answer;
    }
}
