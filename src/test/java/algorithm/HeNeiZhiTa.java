package algorithm;

public class HeNeiZhiTa {

	private static volatile int count = 0;

	public static void main(String[] args) {

		int n = 3;

		hanoi(n, 'A', 'B', 'C');

		System.out.println("COUNT:" + count + "条");

	}

	public static void hanoi(int n, char A, char B, char C) {

		count++;

		if (n == 1) {

			System.out.println("Move sheet " + n + " from " + A + " to " + C + "");

		}

		else {

			hanoi(n - 1, A, C, B);  //把A柱子上第N-1个盘子通过C放到B柱子上

			System.out.println("Move sheet " + n + " from " + A + " to " + C + "");

			hanoi(n - 1, B, A, C); //把B上所有盘子通过A放到C上

		}

	}
}