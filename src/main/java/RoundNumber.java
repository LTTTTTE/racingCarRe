public class RoundNumber {
	private static final int MIN_ROUND_NUMBER = 1;

	private int roundNumber;

	public RoundNumber(int roundNumber) {
		if (isNotRightRoundNumber(roundNumber)) {
			throw new IllegalArgumentException("잘못된 라운드 넘버 입니다.");
		}

		this.roundNumber = roundNumber;
	}

	private boolean isNotRightRoundNumber(int roundNumber) {
		return roundNumber < MIN_ROUND_NUMBER;
	}

	public int getRoundNumber() {
		return roundNumber;
	}
}
