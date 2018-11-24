package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.Test;

public class Lecture9 {

  @Test
  public void reduce() {
    Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

    Integer sum1 = Arrays.stream(integers).reduce(0, (a, b) -> a + b);
    Integer sum2 = Arrays.stream(integers).reduce(0, Integer::sum);

    assertThat(sum1).isEqualTo(sum2).isEqualTo(1831);
  }
}
