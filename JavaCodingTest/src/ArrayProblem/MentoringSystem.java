package ArrayProblem;


import java.util.Scanner;

public class MentoringSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int studentCnt = sc.nextInt();
        int testCnt = sc.nextInt();

        int[][] mentorBoard = new int[testCnt][studentCnt];

        for (int i=0; i<testCnt; i++) {
            for (int j=0; j<studentCnt; j++) {
                mentorBoard[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(mentorBoard, studentCnt, testCnt));
    }

    static int solution(int[][] mentorBoard, int student, int test) {

        int answer = 0;

        // 바깥쪽 for문은 i,j의 순열 조합을 위한 for문 이므로 1부터 시작한다. -> 1,2중 for문
        for (int i=1; i<=student; i++) {
            for (int j=1; j<=student; j++) {
                int cnt = 0;
                for (int k=0; k<test; k++) {
                    int pi = 0;
                    int pj = 0;
                    for (int s=0; s<student; s++) {
                        if (mentorBoard[k][s] == i) {
                            pi = s;
                        }

                        if (mentorBoard[k][s] == j) {
                            pj = s;
                        }
                    }

                    if (pi < pj) {
                        cnt++;
                    }
                }

                if (cnt == test) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
