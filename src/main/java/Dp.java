import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Kyrie
 * @date 2021/12/27 5:45 PM
 */
public class Dp {
    public static void main(String[] args) {
        List<Integer> longList = Arrays.asList(1,2,3);
        System.out.println(String.format("ids: %s", longList));
        BigDecimal a = BigDecimal.ZERO;
        boolean b = a.equals(BigDecimal.ZERO);
        Date date = new Date(System.currentTimeMillis());
        String dataStr = date.toString();
        System.out.println(dataStr);
//        System.out.println(climbStairs(3));
        Node n1 = new Node(1,"name1");
        Node n2 = new Node(2, "name2");
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(n1);
        nodeList.add(n2);
        boolean contains = nodeList.contains(1);
        System.out.println(minPath(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
    public static int climbStairs (int n){
        int res[] = new int[n+1];
        Arrays.fill(res, -1);
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i < res.length; i++) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }

    public static int minPath (int[][] grid){
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[][] mem = new int[grid.length][grid[0].length];
        for (int i = 0; i < mem.length; i++) {
            Arrays.fill(mem[i], -1);
        }
        mem[0][0] = grid[0][0];
        for(int j = 1 ; j < mem[0].length; j++){
            mem[0][j] = mem[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < mem.length; i++) {
            mem[i][0] = mem[i -1][0] + grid[i][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                mem[i][j] = Math.min(mem[i-1][j], mem[i][j-1]) + grid[i][j];
            }
        }
        return mem[grid.length-1][grid[0].length-1];
    }

    static class Node {
        int id;
        String name;
        public Node(int id, String name){
            this.id  = id;
            this.name = name;
        }
    }
}
