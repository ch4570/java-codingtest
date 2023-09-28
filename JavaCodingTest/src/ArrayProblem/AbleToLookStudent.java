package ArrayProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
*   보이는 학생 문제
*   -> 선생님이 N명의 학생을 일렬로 세우고, 일렬로 서 있는 학생들은
*   앞에 서 있는 사람들보다 키가 크면 보이고, 작거나 같으면 보이지 않는다.
* */
public class AbleToLookStudent {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        int[] numArr = new int[number];
        String[] studentsHeights = br.readLine().split(" ");

        for (int i=0; i<numArr.length; i++) {
            numArr[i] = Integer.parseInt(studentsHeights[i]);
        }

        System.out.println(solution(numArr));
    }

    // 내 풀이
    static int solution(int[] heightsArr) {
        int answer = 1;
        int maxHeight = heightsArr[0];

        for (int i=1; i<heightsArr.length; i++) {
            if (heightsArr[i] > maxHeight) {
                answer++;
                maxHeight = heightsArr[i];
            }
        }

        return answer;
    }

    // 강의 풀이
    static int solution2(int[] arr, int n) {
        int answer = 1;
        int max = arr[0];

        for (int i=1; i<n; i++) {
            if (arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }

        return answer;
    }
}


