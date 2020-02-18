import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PositionTest {
	@Test
	public void initTest() {
		Position oneArgumentConstruction = new Position(0);
		Position noArgumentConstruction = new Position();

		assertThat(oneArgumentConstruction).isNotNull();
		assertThat(noArgumentConstruction).isNotNull();
	}

	@Test
	public void wrongInitTest() {
		assertThatThrownBy(() -> {
			Position position = new Position(-1);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("잘못된");
	}

	@Test
	public void equalsAndHashCodeTest() {
		Position position = new Position(0);
		Position position1 = new Position(1);
		Position position2 = new Position(0);

		assertThat(position).isNotEqualTo(position1);
		assertThat(position).isEqualTo(position2);
	}
}