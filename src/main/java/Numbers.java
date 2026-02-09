import java.util.Arrays;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(Number... numbers) {
        this.numbers = Arrays.asList(numbers);
    }

    public Number getSum() {
        int result = 0;
        for (Number number : numbers) {
            result += number.getValue();
        }
        return new Number(result);
    }
}
