package ArrayProblem;

import java.util.Scanner;

public class WhoIsPrincipal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 반의 학생수를 입력받는다.
        int studentCount = sc.nextInt();

        // 반 배정 테이블을 생성하고 초기화한다.
        int[][] table = new int[studentCount][5];

        for (int i=0; i<studentCount; i++) {
            for (int j=0; j<table[i].length; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(table, studentCount));
    }

    static int solution(int[][] table, int num) {
        int max = Integer.MIN_VALUE;
        int answer = 0;

        for (int i=0; i<num; i++) {
            int cnt = 0;
            for (int j=0; j<num; j++) {

                for (int k=0; k<5; k++) {
                    if (table[i][k] == table[j][k]) {
                        cnt++;
                        break;
                    }
                }

            }

            if (cnt > max) {
                max = cnt;
                answer = i + 1;
            }
        }

        return answer;
    }
}
