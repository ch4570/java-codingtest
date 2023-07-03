package MapAndSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 모든_아나그램_찾기_해설 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        System.out.println(solution(a, b));
    }

    static int solution(String a, String b) {
        int answer = 0;
        Map<Character, Integer> am = new HashMap<>();
        Map<Character, Integer> bm = new HashMap<>();

        for (char x : b.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0) + 1);
        }
        int L = b.length() - 1;

        for (int i=0; i<L; i++) {
            am.put(b.charAt(i), am.getOrDefault(b.charAt(i), 0) + 1);
        }
        int lt = 0;

        for (int rt=L; rt<a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);

            if (am.equals(bm)) {
                answer++;
            }

            bm.put(a.charAt(lt), a.charAt(lt) - 1);
            if (bm.get(a.charAt(lt)) == 0) {
                bm.remove(a.charAt(lt));
            }

            lt++;
        }




        return answer;
    }
}
