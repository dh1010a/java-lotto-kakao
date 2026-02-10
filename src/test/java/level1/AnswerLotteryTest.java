package level1;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerLotteryTest {

    @Test
    @DisplayName("보너스 볼은 기존 로또 번호와 중복되지 않는다.")
    void testDuplicateBonusLottery() {

        List<String> lottery = List.of(
                "1", "2", "3", "4", "5", "6"
        );
        String bonusLottery = "1";

        assertThatThrownBy(() -> new AnswerLottery(lottery, bonusLottery))
                .isInstanceOf(RuntimeException.class);
    }
}
