import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber {
	private static final int MIN_RANDOM_NUMBER = 0;
	private static final int MAX_RANDOM_NUMBER = 9;

	private int randomNumber;

	private RandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}

	public static RandomNumber generate() {
		return new RandomNumber(ThreadLocalRandom.current()
			.ints(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
			.limit(1)
			.findAny()
			.orElse(0));
	}

	public boolean isBiggerThen(int number) {
		return randomNumber >= number;
	}
}
