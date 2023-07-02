package ArrayProblem;

import java.util.Scanner;

public class FindPeak {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 격자의 행과 열의 개수를 입력받는다
        int number = sc.nextInt();

        // 격자를 담을 이차원 배열 선언
        int[][] boardMap = new int[number][number];

        // 이중 포문을 돌면서 값을 넣어준다.
        for (int i=0; i<number; i++) {
            for (int j=0; j<boardMap[i].length; j++) {
                boardMap[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(boardMap, number));
    }

    static int solution(int[][] boardMap, int number) {

        /*
        *   12시 방향으로 움직일때 : 행 1감소, 열 변동없음(0)
        *   3시 방향으로 움직일때 : 열 1증가, 행 변동없음(0)
        *   6시 방향으로 움직일때 : 행 1증가, 열 변동없음(0)
        *   9시 방향으로 움직일때 : 열 1감소, 행 변동없음(0)
        * */
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // 봉우리의 개수를 셀 카운팅 변수
        int answer = 0;

        /*
        *   이중 포문을 돌면서 지도를 탐색한다.
        *   이중 포문안에 포문 하나를 더 두고 3중으로 탐색한다
        *   -> 12시, 3시, 6시, 9시 방향으로 돌아야 하기 때문에 (총 4회)
        * */
        for (int i=0; i<number; i++) {
            for (int j=0; j<boardMap[i].length; j++) {
                boolean isPeak = true;
                for (int k=0; k<4; k++) {
                    // x와 y는 현재 살펴보고자 하는 위치의 행과 열의 인덱스 번호
                    int x = i + dx[k];
                    int y = j + dy[k];

                    /*
                    *   봉우리의 경계에 있는 위치의 경우 인덱스가 number와 같거나 -1 인덱스를 가지므로,
                    *   IndexOutOfBoundsException이 발생할 수 있다.
                    *   따라서 조건을 걸어서 이 부분은 필터링 해주고 진행해야한다.
                    * */
                    if (x>=0 && y >=0 && x<number && y<number && boardMap[i][j] <= boardMap[x][y]) {
                        isPeak = false;
                        break;
                    }
                }
                if (isPeak) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
