package test0105;

public class BreakEx {

	public static void main(String[] args) {
		aaa :for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 3 && j == 3) {

					break aaa;
				}
				System.out.printf("(%d, %d)\n", i, j);

			}

		}

	}

}
