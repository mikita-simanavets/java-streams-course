package lectures;

import beans.Person;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mockdata.MockData;
import org.junit.Test;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();

    // 1. Find people aged less or equal 18
    List<Person> youngPeople = new ArrayList<>();
    for (Person person : people) {
      if (person.getAge() <= 18) {
        youngPeople.add(person);
      }
    }

    for (Person young : youngPeople) {
      System.out.println(young.getAge());
    }

    System.out.println("=====");

    // 2. Then change implementation to find first 10 people
    final int limit = 10;
    int counter = 0;

    List<Person> first10Below18 = new ArrayList<>();
    for (Person person : people) {
      if (person.getAge() <= 18) {
        first10Below18.add(person);
        counter++;
        if (counter == limit) {
          break;
        }
      }
    }

    for (Person young : first10Below18) {
      System.out.println(young.getAge());
    }
  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();

  }
}
