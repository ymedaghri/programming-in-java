package interview;

import java.util.*;


/**
 * Created by ymedaghri on 29/06/2017.
 */
public class AndTheWinnerIs
{

  private Map<String, Integer> map = new HashMap<>();
  private int maxNum = 0;
  private List<String> name = new ArrayList<>();


  public static void main(String[] args)
  {
    System.out.println(
        new AndTheWinnerIs()
            .TellMeWhoIsTheWinner(
                Arrays.asList("alice", "octave", "eugene", "bob", "julie", "zak", "bob", "alice", "donovan")));
  }


  private String TellMeWhoIsTheWinner(List<String> input)
  {
    input.stream().forEach(value -> {
      Integer occurences = map.getOrDefault(value, 0) + 1;
      if (occurences == maxNum) {
        name.add(value);
      }
      else if (occurences > maxNum) {
        name = new ArrayList<>();
        maxNum = occurences;
        name.add(value);
      }
      map.put(value, occurences);
    });

    return name.stream().reduce((a, b) -> a.concat(", ").concat(b)).orElse("");
  }


}
