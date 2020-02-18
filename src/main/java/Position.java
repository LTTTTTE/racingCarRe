import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Position {
	private static final int DEFAULT_POSITION = 0;

	private int position;

	public Position() {
		this.position = DEFAULT_POSITION;
	}

	public Position(int position) {
		if (isNotRightPosition(position)) {
			throw new IllegalArgumentException("잘못된 포지션 입니다.");
		}

		this.position = position;
	}

	public void addPosition(int number) {
		this.position += number;
	}

	public Position findBiggerPosition(Position position) {
		if (this.position >= position.getPosition()) {
			return this;
		}

		return position;
	}

	private boolean isNotRightPosition(int position) {
		return position < DEFAULT_POSITION;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Position position1 = (Position)o;
		return position == position1.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}

	@Override
	public String toString() {
		return IntStream.range(0, position)
			.mapToObj(x -> "-")
			.collect(Collectors.joining());
	}

	public int getPosition() {
		return position;
	}
}
