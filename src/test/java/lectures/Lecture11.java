package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    StringBuilder result = new StringBuilder();
    int lastNameIndex = names.size() - 1;
    for (int i = 0; i < names.size(); i++) {
      result.append(names.get(i))
          .append(i < lastNameIndex ? ", " : "");
    }

    System.out.println(result);
  }

  @Test
  public void joiningStringsWithStream() {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

    String result = names.stream()
        .map(String::toUpperCase)
        .collect(Collectors.joining("|"));

    System.out.println(result);
  }
}
