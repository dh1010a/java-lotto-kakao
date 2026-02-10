package level1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner;
    private static final RandomLotteryGenerator randomLotteryGenerator;

    static {
        scanner = new Scanner(System.in);
        randomLotteryGenerator = new RandomLotteryGenerator();
    }

    public static void main(String[] args) {
        int price = inputPrice();
        Lotteries userLotteries = purchaseLotteries(price);
        printLotteries(userLotteries);

        AnswerLottery answerLottery = inputAnswerLottery();
        printResult(price, userLotteries, answerLottery);
    }

    private static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    private static Lotteries purchaseLotteries(int price) {
        int count = price / Constant.LOTTERY_PRICE;
        System.out.println(count + "개를 구매했습니다.");
        return randomLotteryGenerator.generate(count);
    }

    private static void printLotteries(Lotteries lotteries) {
        System.out.println(lotteries.representLotteries());
        System.out.println();
    }

    private static AnswerLottery inputAnswerLottery() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<String> numbers = Arrays.asList(scanner.nextLine().split(",\\s*"));

        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusBall = scanner.nextLine();

        return new AnswerLottery(numbers, bonusBall);
    }

    private static void printResult(int price, Lotteries userLotteries, AnswerLottery answer) {
        Report report = new Report(price, answer, userLotteries.getLotteries());
        System.out.println();
        System.out.println(report.representReport());
    }
}