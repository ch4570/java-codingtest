package SortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 좌표_정렬 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> arr = new ArrayList<>();


        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr.add(new Point(x, y));
        }

        for (Point p : solution(arr)) {
            System.out.println(p.toString());
        }
    }

    static List<Point> solution(List<Point> arr) {
        Collections.sort(arr);

        return arr;
    }
}


class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;


    }

    @Override
    public int compareTo(Point o) {

        if (x > o.x) {
            return 1;
        } else {
            if (x == o.x && y > o.y) {
                return 1;
            }
        }


        return -1;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
