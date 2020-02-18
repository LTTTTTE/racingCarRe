import java.util.Objects;
import java.util.Optional;

public class Name {
	private static final int MAX_NAME_LENGTH = 5;
	private static final int MIN_NAME_LENGTH = 1;

	private String name;

	public Name(String name) {
		this.name = Optional.ofNullable(name)
			.filter(this::isNotEmpty)
			.filter(this::isRightLengthName)
			.orElseThrow(() -> new IllegalArgumentException("잘못된 이름입니다."));
	}

	private boolean isRightLengthName(String name) {
		return name.length() <= MAX_NAME_LENGTH && name.length() >= MIN_NAME_LENGTH;
	}

	private boolean isNotEmpty(String name) {
		return name != null && !name.isEmpty();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Name name1 = (Name)o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	public String getName() {
		return name;
	}
}
