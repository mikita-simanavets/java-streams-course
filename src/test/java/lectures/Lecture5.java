package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    Predicate<Car> carPredicate = car -> car.getPrice() < 20000;

    List<Car> carFiltered = cars.stream()
        .filter(carPredicate)
        .collect(Collectors.toList());

    carFiltered.forEach(System.out::println);
    System.out.println(carFiltered.size());
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

    List<PersonDTO> dto = people.stream()
        .map(PersonDTO::map)
        .collect(Collectors.toList());

    assertThat(dto).hasSize(1000);
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    ImmutableList<Car> cars = MockData.getCars();

    double average = cars.stream()
        .mapToDouble(Car::getPrice)
        .average()
        .orElse(0);

    System.out.println(average);
  }

  @Test
  public void test() throws Exception {
    MockData.getCars().forEach(System.out::println);
  }
}
