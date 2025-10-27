package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    public void playRound() {
        cars.forEach(Car::moveIfPossible);
    }

    public List<String> status() {
        return cars.stream()
                .map(Car::status)
                .toList();
    }

    public List<String> winners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.hasSamePosition(maxPosition))
                .map(Car::name)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::position))
                .map(Car::position)
                .orElse(0);
    }

    private List<Car> createCars(List<String> names) {
        List<Car> list = new ArrayList<>();
        for (String name : names) {
            list.add(new Car(name));
        }
        return list;
    }
}
