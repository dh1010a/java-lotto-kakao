package level1;

public enum Match {
    NONE(0),
    THREE(3),
    FOUR(4),
    FIVE(5),
    FIVE_WITH_BONUS(5),
    SIX(6);

    private final int matchCount;

    Match(int matchCount) {
        this.matchCount = matchCount;
    }

    public static Match matchOf(long matchCount, boolean bonusBallMatch) {
        if (matchCount < THREE.matchCount) {
            return NONE;
        }

        if (matchCount == THREE.matchCount) {
            return THREE;
        }

        if (matchCount == FOUR.matchCount) {
            return FOUR;
        }

        if (matchCount == FIVE.matchCount && !bonusBallMatch) {
            return FIVE;
        }

        if (matchCount == FIVE.matchCount) {
            return FIVE_WITH_BONUS;
        }

        return SIX;
    }
}
