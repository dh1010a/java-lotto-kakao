package level1;

public record Price(int value) {

    public Price {
        validate(value);
    }

    private void validate(int value) {
        if (value < Constant.LOTTERY_PRICE) {
            throw new IllegalArgumentException(Constant.LOTTERY_PRICE + "원 이상부터 구매가 가능합니다.");
        }
    }
}
