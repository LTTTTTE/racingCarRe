import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RoundNumberTest {
	@Test
	public void initTest() {
		RoundNumber roundNumber = new RoundNumber(5);
		assertThat(roundNumber).isNotNull();
	}

	@Test
	public void wrongInitTest() {
		assertThatThrownBy(() -> {
			RoundNumber roundNumber = new RoundNumber(0);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("잘못된");
	}
}