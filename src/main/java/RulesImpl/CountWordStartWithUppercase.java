package RulesImpl;

import Rule.WordRule;

import java.util.Objects;

public class CountWordStartWithUppercase implements WordRule {

  public boolean rule(String word) {
    if (Objects.isNull(word) || word.isBlank()){
      return false;
    }
    return Character.isUpperCase(word.charAt(0));
  }
}
