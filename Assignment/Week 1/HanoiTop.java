public class HanoiTop {
    public static void move(char from, char to, int n) {
        System.out.println("원반 " + n + "을 " + from + "에서 " + to + "로 이동");
    }

    public static void hanoi(char from, char to, char via, int n) {
        if (n == 1) {
            move(from, to, n);
            return;
        }

        hanoi(from, via, to, n - 1);
        move(from, to, n);
        hanoi(via, to, from, n - 1);
    }

    public static void main(String[] args) {
        System.out.println("원반이 3개인 경우");
        System.out.println("(원반 이름: 크기가 작은-큰 순서 1-2-3)\n");
        hanoi('A', 'C', 'B', 3);

        System.out.println("\n원반이 4개인 경우");
        System.out.println("(원반 이름: 크기가 작은-큰 순서 1-2-3-4)\n");
        hanoi('A', 'C', 'B', 4);
    }
}
