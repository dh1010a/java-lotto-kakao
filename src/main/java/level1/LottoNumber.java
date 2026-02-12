package level1;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int value;

    public LottoNumber(String stringNumber) {
        this(parse(stringNumber));
    }

    public LottoNumber(int value) {
        validateRange(value);
        this.value = value;
    }

    private static int parse(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값은 허용되지 않습니다.");
        }
    }

    private void validateRange(int value) {
        if (value < Constant.LOTTERY_MIN_VALUE || value > Constant.LOTTERY_MAX_VALUE) {
            throw new IllegalArgumentException("로또 번호는 1 - 45 범위 숫자만 가능합니다.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber that)) return false;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}