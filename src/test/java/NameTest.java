import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NameTest {
	@Test
	public void initTest() {
		Name name = new Name("이름1");
		assertThat(name).isNotNull();
	}

	@ParameterizedTest
	@MethodSource("generateNullableNames")
	public void nullTest(String value) {
		assertThatThrownBy(() -> {
			Name name = new Name(value);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("잘못된");
	}

	static Stream<Arguments> generateNullableNames() {
		return Stream.of(
			Arguments.of((Object)null),
			Arguments.of("")
		);
	}

	@Test
	public void equalAndHashCodeTest() {
		Name name = new Name("이름1");
		Name name2 = new Name("이름2");
		Name name3 = new Name("이름1");

		assertThat(name).isNotEqualTo(name2);
		assertThat(name).isEqualTo(name3);
	}

	@ParameterizedTest
	@MethodSource("generateNames")
	public void isRightNameLengthTest(String value) {
		assertThatThrownBy(() -> {
			Name name = new Name(value);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("잘못된");
	}

	static Stream<Arguments> generateNames() {
		return Stream.of(
			Arguments.of("가나다라마바"),
			Arguments.of("가나다라마바사아자차카타파하"),
			Arguments.of("abcdef"),
			Arguments.of("1234567")
		);
	}
}