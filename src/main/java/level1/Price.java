package level1;

public record Price(int value) {

    private static final int MINIMUM_PRICE = 1000;

    public Price {
        validate(value);
    }

    private void validate(int value) {
        if (value < MINIMUM_PRICE) {
            throw new IllegalArgumentException(MINIMUM_PRICE + "원 이상부터 구매가 가능합니다.");
        }
    }
}
