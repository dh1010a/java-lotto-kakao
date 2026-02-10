package level1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Report {

    private final int price;

    private final MatchCountMap matchCountMap;

    public Report(int price, AnswerLottery answerLottery, List<Lottery> lotteries) {
        this.price = price;
        this.matchCountMap = new MatchCountMap(answerLottery, lotteries);
    }

    public int getMatchCount(Match match) {
        return matchCountMap.getMatchCount(match);
    }

    public int getPrice() {
        return price;
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
