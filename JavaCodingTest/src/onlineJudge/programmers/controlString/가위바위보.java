package onlineJudge.programmers.controlString;

public class 가위바위보 {
    public static void main(String[] args) {
        System.out.println(solution("205"));
    }

    static String solution(String rsp) {

        String answer = "";

        for (int i=0; i<rsp.length(); i++) {

            if (rsp.charAt(i) == '2') {
                answer += '0';
            } else if (rsp.charAt(i) == '0') {
                answer += '5';
            } else {
                answer += '2';
            }
        }

        return answer;
    }
}
