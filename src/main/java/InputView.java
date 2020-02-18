import java.util.Scanner;

public class InputView {
	private static final String NUMBER_INPUT_EXCEPTION_MESSAGE = "숫자만 입력 가능합니다.";
	private static final String CAR_NAME_INPUT_MESSAGE = "자동차이름입력하라능";
	private static final String ROUND_NUMBER_INPUT_MESSAGE = "몇라운드진행할지입력하라능";

	private static Scanner input = new Scanner(System.in);

	public static String inputAsCarNames() {
		System.out.println(CAR_NAME_INPUT_MESSAGE);
		return input.nextLine();
	}

	public static int inputAsRoundNumber() {
		System.out.println(ROUND_NUMBER_INPUT_MESSAGE);

		try {
			return input.nextInt();
		} catch (NumberFormatException e) {
			throw new NumberFormatException(NUMBER_INPUT_EXCEPTION_MESSAGE);
		}
	}
}
