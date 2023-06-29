package ArrayProblem;


import java.util.Scanner;

/*
*   가위바위보 문제
*   -> A와 B의 가위바위보 게임의 결과를 출력하는 예제
* */
public class RockScissorsPaper {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int gameTime = sc.nextInt();

        int[] playerA = new int[gameTime];
        int[] playerB = new int[gameTime];

        for (int i=0; i<playerA.length; i++) {
            playerA[i] = sc.nextInt();
        }

        for (int i=0; i< playerB.length; i++) {
            playerB[i] = sc.nextInt();
        }


        System.out.println(solution(playerA, playerB, gameTime));
    }

    // 내 풀이
    static String solution(int[] playerA, int[] playerB, int gameTime) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < gameTime; i++) {
            if (playerA[i] == playerB[i]) {
                sb.append("D\n");
            } else if (playerA[i] - playerB[i] == 1) {
                sb.append("A\n");
            } else if (playerA[i] - playerB[i] == -1 || playerA[i] - playerB[i] == 2) {
                sb.append("B\n");
            } else {
                sb.append("A\n");
            }
        }

        return sb.toString();
    }

    // 강의 풀의
    public String solution2(int n, int[] a, int[] b) {
        String answer = "";
        for (int i=0; i<n; i++) {
            if (a[i] == b[i]) {
                answer += "D";
            } else if(a[i] == 1 && b[i] == 3) {
                answer += "A";
            } else if(a[i] == 2 && b[i] == 1) {
                answer += "A";
            } else if(a[i] == 3 && b[i] == 2) {
                answer += "A";
            } else {
                answer += "B";
            }
        }

        return answer;
    }
}
