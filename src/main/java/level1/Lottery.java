package level1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lottery {

    private static final int LOTTERY_SIZE = 6;

    private static final int
            LOTTERY_MIN_VALUE = 1,
            LOTTERY_MAX_VALUE = 45;

    protected final Set<Integer> lottery;

    public Lottery(List<String> numbers) {
        Set<String> numberSet = new HashSet<>(numbers);

        this.lottery = numberSet.stream()
                .map(this::parseNumber)
                .collect(Collectors.toSet());

        if (this.lottery.size() != LOTTERY_SIZE) {
            throw new RuntimeException("숫자는 6 개여야 합니다.");
        }
    }

    protected int parseNumber(String number) {
        int num;
        try {
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값은 허용되지 않습니다.");
        }

        if (
                num < LOTTERY_MIN_VALUE ||
                num > LOTTERY_MAX_VALUE
        ) {
            throw new RuntimeException("로또 번호는 1 - 45 범위 숫자만 가능합니다.");
        }

        return num;
    }
}
