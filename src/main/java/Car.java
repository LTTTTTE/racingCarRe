import java.util.Optional;

public class Car {
	private static final int MOVE_AMOUNT = 1;
	private static final int MOVE_PIVOT = 4;

	private Name name;
	private Position position;

	public Car(Name name) {
		this.name = Optional.ofNullable(name)
			.orElseThrow(() -> new IllegalArgumentException("뭔가문제가있는디"));
		this.position = new Position();
	}

	public void move() {
		if (RandomNumber.generate().isBiggerThen(MOVE_PIVOT)) {
			position.addPosition(MOVE_AMOUNT);
		}
	}

	public boolean isSamePosition(Position position) {
		return this.position.equals(position);
	}

	public Position getPosition() {
		return position;
	}

	public Name getName() {
		return name;
	}
}


