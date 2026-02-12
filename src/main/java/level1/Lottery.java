package level1;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lottery {

    protected final Set<LottoNumber> lottery;

    public Lottery(List<String> numbers) {
        Set<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        validateSize(lottoNumbers);
        this.lottery = lottoNumbers;
    }

    private void validateSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != Constant.LOTTERY_SIZE) {
            throw new IllegalArgumentException("중복되지 않은 숫자는 6개여야 합니다.");
        }
    }

    public boolean contains(LottoNumber given) {
        return this.lottery.contains(given);
    }

    public String represent() {
        return lottery.stream()
                .sorted()
                .toList()
                .toString();
    }
}