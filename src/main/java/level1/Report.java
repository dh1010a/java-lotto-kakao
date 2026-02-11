package level1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Report {

    private final Price price;

    private final MatchCountMap matchCountMap;

    public Report(Price price, AnswerLottery answerLottery, List<Lottery> lotteries) {
        this.price = price;
        this.matchCountMap = new MatchCountMap(answerLottery, lotteries);
    }

    public int getMatchCount(Match match) {
        return matchCountMap.getMatchCount(match);
    }

    public String representReport() {
        StringBuilder sb = new StringBuilder("당첨 통계\n---------\n");

        appendMatchStatistics(sb);

        sb.append(String.format(
                "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)",
                calculateProfitRate()
        ));

        return sb.toString();
    }

    private void appendMatchStatistics(StringBuilder sb) {
        List<Match> winningMatches = List.of(
                Match.THREE, Match.FOUR, Match.FIVE, Match.FIVE_WITH_BONUS, Match.SIX
        );

        for (Match match : winningMatches) {
            sb.append(String.format(
                    "%s - %d개\n",
                    match.getDescription(), matchCountMap.getMatchCount(match)
            ));
        }
    }

    private double calculateProfitRate() {
        long totalPrize = Arrays.stream(Match.values())
                .mapToLong(match -> match.calculateTotalPrize(getMatchCount(match)))
                .sum();

        return (double) totalPrize / price.value();
    }

    private static class MatchCountMap {

        private final Map<Match, Integer> map;

        private MatchCountMap(AnswerLottery answerLottery, List<Lottery> givenLotteries) {
            this.map = givenLotteries.stream().collect(
                    Collectors.groupingBy(
                            answerLottery::judge,
                            Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                    )
            );
        }

        private int getMatchCount(Match match) {
            return map.getOrDefault(match, 0);
        }
    }
}
