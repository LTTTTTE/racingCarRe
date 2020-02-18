import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
	private static final String COMMA = ",";

	private List<Car> cars;

	public RacingGame(String carNames) {
		if (carNames == null) {
			throw new IllegalArgumentException("뭔가 아주 큰 문제가 있는디");
		}

		this.cars = Stream.of(splitAsComma(carNames))
			.map(Name::new)
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public void playRound() {
		cars.forEach(Car::move);
	}

	private String[] splitAsComma(String names) {
		return names.split(COMMA);
	}

	private Position findMaxPosition() {
		return cars.stream()
			.map(Car::getPosition)
			.reduce(Position::findBiggerPosition)
			.orElseThrow(() -> new IllegalArgumentException("이 경기에 우승자는 없습니다."));
	}

	public List<Car> getWinners() {
		Position maxPosition = findMaxPosition();

		return cars.stream()
			.filter(car -> car.isSamePosition(maxPosition))
			.collect(Collectors.toList());
	}

	public List<Car> getCars() {
		return cars;
	}
}
