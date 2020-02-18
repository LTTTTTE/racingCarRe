import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
	private static final String NEW_LINE = "\n";

	public static void showWinners(List<Car> winners) {
		String result = winners.stream()
			.map(car -> car.getName().getName())
			.collect(Collectors.joining(","));
		System.out.println(result + "가 우승하였습니다.");
	}

	public static void showRoundsResult(RacingGame racingGame) {
		String result = racingGame.getCars()
			.stream()
			.map(car -> car.getName().getName() + " : " + car.getPosition().toString())
			.collect(Collectors.joining(NEW_LINE));
		System.out.println(result + NEW_LINE);
	}
}
