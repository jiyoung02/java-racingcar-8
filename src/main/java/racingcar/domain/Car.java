package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exception.InvalidCarNameException;

public class Car {

    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveIfPossible() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public boolean hasSamePosition(int maxPosition) {
        return position == maxPosition;
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    public String status() {
        return String.format("%s : %s", name, "-".repeat(position));
    }

}
