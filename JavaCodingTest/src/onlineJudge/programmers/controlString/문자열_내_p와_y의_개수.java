package onlineJudge.programmers.controlString;

public class 문자열_내_p와_y의_개수 {

    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }

    static boolean solution(String s) {
        boolean answer = false;

        int countS = 0, countP = 0;

        String lowerCase = s.toLowerCase();

        for (int i=0; i<lowerCase.length(); i++) {
            if (lowerCase.charAt(i) == 'p') {
                countP++;
            }

            if (lowerCase.charAt(i) == 'y') {
                countS++;
            }
        }

        if ((countS == countP) || (countP == 0 && countS == 0)) {
            answer = true;
        }

        return answer;
    }
}
