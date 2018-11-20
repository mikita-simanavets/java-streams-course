package lectures;

import java.util.Arrays;
import java.util.function.Predicate;
import org.junit.Test;

public class Lecture6 {

  private final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;

  @Test
  public void findAny() {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    int any = Arrays.stream(numbers)
        .filter(numbersLessThan10)
        .findAny()
        .get();
    System.out.println(any);
  }

  @Test
  public void findFirst() {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    int first = Arrays.stream(numbers)
        .filter(numbersLessThan10)
        .findFirst()
        .get();
    System.out.println(first);
  }
}
