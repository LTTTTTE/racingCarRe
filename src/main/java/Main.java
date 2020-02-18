import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame(InputView.inputAsCarNames());
		RoundNumber roundNumber = new RoundNumber(InputView.inputAsRoundNumber());

		IntStream.range(1, roundNumber.getRoundNumber())
			.forEach(x -> {
				racingGame.playRound();
				OutputView.showRoundsResult(racingGame);
			});

		OutputView.showWinners(racingGame.getWinners());
	}
}
