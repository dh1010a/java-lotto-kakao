package level1;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLotteryGeneratorTest {

    @Test
    @DisplayName("랜덤한 로또를 생성할 수 있다.")
    void testGeneration() {
        RandomLotteryGenerator generator = new RandomLotteryGenerator();

        int num = 10;
        assertThatCode(() -> generator.generate(num))
                .doesNotThrowAnyException();
    }
}
