package level1;

import java.util.List;

public class AnswerLottery extends Lottery {

    private final int bonusLotteryNumber;

    public AnswerLottery(List<String> lottery, String bonusLottery) {
        super(lottery);

        this.bonusLotteryNumber = super.parseNumber(bonusLottery);

        if (this.lottery.contains(bonusLotteryNumber)) {
            throw new RuntimeException("보너스 볼은 기존 로또 번호와 중복되지 않아야 합니다.");
        }
    }

    public int getBonusLotteryNumber() {
        return bonusLotteryNumber;
    }
}
