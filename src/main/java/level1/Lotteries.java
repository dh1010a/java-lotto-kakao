package level1;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {

    private final List<Lottery> lotteries;

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = new ArrayList<>(lotteries);
    }
}
