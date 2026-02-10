package level1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserLotteryTest {

    private static final List<String> answerLotteryNumbers = List.of("1", "2", "3", "4", "5", "6");
    private static final String bonusLotteryNumber = "10";

    private static Stream<Arguments> judgeLotteryArgs() {
        return Stream.of(
                Arguments.of(List.of("11", "12", "13", "14", "15", "16"), Match.NONE),
                Arguments.of(List.of("1", "12", "13", "14", "15", "16"), Match.NONE),
                Arguments.of(List.of("1", "2", "13", "14", "15", "16"), Match.NONE),
                Arguments.of(List.of("1", "2", "3", "14", "15", "16"), Match.THREE),
                Arguments.of(List.of("1", "2", "3", "4", "15", "16"), Match.FOUR),
                Arguments.of(List.of("1", "2", "3", "4", "5", "16"), Match.FIVE),
                Arguments.of(List.of("1", "2", "3", "4", "5", "10"), Match.FIVE_WITH_BONUS),
                Arguments.of(List.of("1", "2", "3", "4", "5", "6"), Match.SIX)
        );
    }

    @ParameterizedTest
    @MethodSource("judgeLotteryArgs")
    @DisplayName("정답 로또 번호를 정확히 판단한다.")
    void testJudgeLottery(List<String> userLotteryNumbers, Match expectedMatch) {
        AnswerLottery answerLottery = new AnswerLottery(answerLotteryNumbers, bonusLotteryNumber);
        UserLottery userLottery = new UserLottery(userLotteryNumbers);

        assertThat(userLottery.judge(answerLottery)).isEqualTo(expectedMatch);
    }
}
