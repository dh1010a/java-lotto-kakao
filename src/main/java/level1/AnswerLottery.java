package level1;

import java.util.List;

public class AnswerLottery {

    private final Lottery winningLottery;
    private final LottoNumber bonusLotteryNumber;

    public AnswerLottery(Lottery winningLottery, LottoNumber bonusLotteryNumber) {
        validateBonusNumber(winningLottery, bonusLotteryNumber);
        this.winningLottery = winningLottery;
        this.bonusLotteryNumber = bonusLotteryNumber;
    }

    public AnswerLottery(List<String> lottery, String bonusLottery) {
        this(new Lottery(lottery), LottoNumber.valueOf(bonusLottery));
    }

    private void validateBonusNumber(Lottery winningLottery, LottoNumber bonusNumber) {
        if (winningLottery.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    public Match judge(Lottery userLottery) {
        int matchCount = winningLottery.countMatchingNumbers(userLottery);
        boolean bonusBallMatch = userLottery.contains(this.bonusLotteryNumber);

        return Match.matchOf(matchCount, bonusBallMatch);
    }
}