package SortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 좌표_정렬_해설 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point2> arr = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr.add(new Point2(x, y));
        }

        Collections.sort(arr);

        for (Point2 p : arr) {
            System.out.println(p.x + " " + p.y);
        }
    }

}

class Point2 implements Comparable<Point2> {
    public int x, y;

    Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point2 o) {

        if (this.x == o.x) {
            return this.y - o.y;
        }


        return this.x - o.x;
    }
}
