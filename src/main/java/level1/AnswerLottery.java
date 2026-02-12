package level1;

import java.util.List;

public class AnswerLottery extends Lottery {

    private final LottoNumber bonusLotteryNumber;

    public AnswerLottery(List<String> lottery, String bonusLottery) {
        super(lottery);
        this.bonusLotteryNumber = new LottoNumber(bonusLottery);
        validateBonusNumber();
    }

    private void validateBonusNumber() {
        // 부모(Lottery)가 가진 contains 메서드를 활용하여 중복 체크
        if (super.contains(bonusLotteryNumber)) {
            throw new IllegalArgumentException("보너스 볼은 기존 로또 번호와 중복되지 않아야 합니다.");
        }
    }

    public Match judge(Lottery givenLottery) {
        // 1. 당첨 번호(this.lottery) 중 사용자 로또(givenLottery)에 포함된 개수 확인
        long matchCount = this.lottery.stream()
                .filter(givenLottery::contains)
                .count();

        // 2. 보너스 번호가 사용자 로또에 포함되어 있는지 확인
        boolean bonusBallMatch = givenLottery.contains(this.bonusLotteryNumber);

        return Match.matchOf(matchCount, bonusBallMatch);
    }
}