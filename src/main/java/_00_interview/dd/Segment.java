package _00_interview.dd;

/**
 * 滴滴mq三面，n米线段分成m段，有几种分法
 * @author Kyrie
 * @date 2023/10/9 12:00
 */
public class Segment {
    private int segmentNOfM (int n, int m) {
        int[][] record = new int[n + 1][m + 1];
        // init
        for (int i = 1; i <= n; i++) {
            record[i][1] = 1;
        }
        for (int i = 1; i <= m; i++) {
            if (i == 1) continue;
            record[1][i] = 0;
        }
        for (int i = 2; i <= n; i++) {
            int k = 1;
            for (int j = 2; i <= m; j++){
                while (k <= m){
                    record[i][j] += (i - k) * record[i - k][j - 1];
                    k++;
                }
            }
        }
        return record[n][m];
    }
}
