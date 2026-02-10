package level1;

import java.util.List;

public class UserLottery extends Lottery {

    public UserLottery(List<String> userLotteryNumbers) {
        super(userLotteryNumbers);
    }

    public Match judge(AnswerLottery answerLottery) {

        long matchCount = answerLottery.lottery.stream()
                .filter(this.lottery::contains)
                .count();

        boolean bonusBallMatch = this.lottery.contains(
                answerLottery.getBonusLotteryNumber()
        );

        return Match.matchOf(matchCount, bonusBallMatch);
    }
}
