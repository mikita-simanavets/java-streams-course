package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
    long femaleCount = MockData.getPeople()
        .stream()
        .filter(person -> person.getGender().equalsIgnoreCase("female"))
        .count();

    assertThat(femaleCount).isEqualTo(467);
  }

  @Test
  public void min() throws Exception {
    double minPrice = MockData.getCars()
        .stream()
        .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
        .mapToDouble(Car::getPrice)
        .min()
        .orElse(0);

    assertThat(minPrice).isEqualTo(6600.59);
  }

  @Test
  public void max() throws Exception {
    double maxPrice = MockData.getCars()
        .stream()
        .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
        .mapToDouble(Car::getPrice)
        .max()
        .orElse(0);

    assertThat(maxPrice).isEqualTo(99677.14);
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
    double averageCarPrice = cars.stream()
        .mapToDouble(Car::getPrice)
        .average()
        .orElse(0);

    assertThat(averageCarPrice).isEqualTo(52693.19979);
  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
        .mapToDouble(Car::getPrice)
        .sum();

    assertThat(sum).isEqualTo(5.269319979E7);

    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
    System.out.println(sum);
    System.out.println(bigDecimalSum);
  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics = cars.stream()
        .mapToDouble(Car::getPrice)
        .summaryStatistics();
    System.out.println(statistics);

    assertThat(statistics.getAverage()).isEqualTo(52693.19979);
    assertThat(statistics.getCount()).isEqualTo(1000);
    assertThat(statistics.getMax()).isEqualTo(99932.82);
    assertThat(statistics.getMin()).isEqualTo(5005.16);
    assertThat(statistics.getSum()).isEqualTo(5.269319979E7);
  }
}
