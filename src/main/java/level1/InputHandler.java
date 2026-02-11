package level1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = scanner.nextLine();

        int price = parseToInt(input);
        validatePriceUnit(price);

        return price;
    }

    public AnswerLottery inputAnswerLottery() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<String> numbers = Arrays.asList(scanner.nextLine().split(",\\s*"));

        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusBall = scanner.nextLine();

        return new AnswerLottery(numbers, bonusBall);
    }

    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private void validatePriceUnit(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("1,000원 이상부터 구매가 가능합니다.");
        }
    }
}
