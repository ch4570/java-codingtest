package StringProblem;

import java.util.Scanner;

/*
 *   한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 구하기
 *   -> 해설 코드
 * */
public class WordDistanceLecture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.next();
        char word = sc.next().charAt(0);

        int[] answer = solution(sentence, word);

        for (int count : answer) {
            System.out.print(count + " ");
        }

    }

    /*
    *  1. 문자열을 앞에서 뒤로 탐색하면서 왼쪽 단어와의 거리를 기준으로 정답 배열을 채워준다.
    *  2. 문자열을 뒤에서 앞으로 탐색하면서 오른쪽 단어와의 거리값을 구하고, 기존에 채워진 값보다 작은 경우 교체한다.
    *
    *  문제해결 Point
    *  처음 초기 거리의 변수를 100을 넘는 수로 둔다(문자의 길이가 100을 넘지 않기 때문)
    * */
    static int[] solution(String sentence, char word) {
        int[] answer = new int[sentence.length()];

        int distance = 1000;

        for (int i=0; i< sentence.length(); i++) {
            if (sentence.charAt(i)== word) {
                // 문자를 찾으면 거리를 0으로 바꿔준다.
                distance = 0;
                // 정답 배열에 값을 넣어준다.
                answer[i] = distance;
            } else {
                // 문자를 찾지 못했을때는, 거리를 1 증가시킨다.
                distance++;
                // 거리를 증가시키고 다시 정답 배열에 넣어준다.
                answer[i] = distance;
            }
        }

        // 뒤에서 앞으로 문자열을 순회하기 위해서 거리 변수를 초기화한다.
        distance = 1000;

        for (int i=sentence.length() - 1; i>=0; i--) {
            if (sentence.charAt(i)== word) {
                // 앞에서 뒤로 순회할때 이미 0으로 채워진값은, 탐색을 위해 거리 변수의 값만 0으로 하고 배열의 값을 교체하지 않는다.
                distance = 0;
            } else {
                // 문자를 찾지 못했을떄는, 거리를 1 증가시키고 정답 배열에 넣어준다.
                distance++;
                answer[i] = Math.min(answer[i], distance);
            }
        }

        return answer;
    }
}
