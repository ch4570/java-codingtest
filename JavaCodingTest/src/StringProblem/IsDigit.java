package StringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
*   문자와 숫자가 섞여있는 문자열 중 숫자만 추출해서 순서대로 자연수를 만들기
* */
public class IsDigit {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        System.out.println(solution(word));
    }

    // 내 풀이 -> parseInt를 이용
    static int solution(String word) {
        StringBuilder number = new StringBuilder();

        // 문자를 각 자리별로 쪼개서 숫자인지 확인한다.
        for (int i=0; i<word.length(); i++) {
            // 만약 숫자라면 StringBuilder에 append 해준다.
            if (Character.isDigit(word.charAt(i))) {
                number.append(word.charAt(i));
            }
        }
        // parseInt로 정수 변환 후 반환
        return Integer.parseInt(number.toString());


    }

    // ASCII 코드 값을 이용한 풀이
    static int solution2(String word) {
        int answer = 0;

        for (char x : word.toCharArray()) {
            // 48 = 0, 57 = 9 (ASCII Code 값 기준)
            if (x >= 48 && x <= 57) {
                answer = answer * 10 + (x - 48);
            }
        }

        return answer;
    }


}
