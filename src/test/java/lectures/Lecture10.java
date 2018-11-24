package lectures;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class Lecture10 {

  private static final List<ArrayList<String>> arrayListOfNames = Lists.newArrayList(
      Lists.newArrayList("Mariam", "Alex", "Ismail"),
      Lists.newArrayList("John", "Alesha", "Andre"),
      Lists.newArrayList("Susy", "Ali")
  );

  @Before
  public void setUp() {
    System.out.println(arrayListOfNames);
  }

  @Test
  public void withoutFlatMap() {
    List<String> names = new ArrayList<>();
    arrayListOfNames.forEach(names::addAll);

    // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
    System.out.println(names);
  }

  @Test
  public void withFlatMap() {
    List<String> names = arrayListOfNames.stream()
        .flatMap(List::stream)
        .collect(Collectors.toList());

    // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
    System.out.println(names);
  }
}
