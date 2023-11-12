package _04_Maze_Maker;
import java.util.Random;

public class BotCode {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private static final int[][] MAZE = new int[WIDTH][HEIGHT];
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        generateMaze();
        printMaze();
    }

    private static void generateMaze() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                MAZE[i][j] = 1;
            }
        }

        int startX = RANDOM.nextInt(WIDTH);
        int startY = RANDOM.nextInt(HEIGHT);
        MAZE[startX][startY] = 0;
        dfs(startX, startY);
    }

    private static void dfs(int x, int y) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int[] order = {0, 1, 2, 3};
        shuffle(order);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[order[i]];
            int ny = y + dy[order[i]];

            if (nx >= 0 && nx < WIDTH && ny >= 0 && ny < HEIGHT && MAZE[nx][ny] == 1) {
                MAZE[nx][ny] = 0;
                MAZE[x + dx[order[i]] / 2][y + dy[order[i]] / 2] = 0;
                dfs(nx, ny);
            }
        }
    }

    private static void shuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = RANDOM.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private static void printMaze() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (MAZE[i][j] == 1) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}