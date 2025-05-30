package RulesImpl;

import Rule.WordRule;

import java.util.Objects;

public class MoreThanFiveCharRule implements WordRule {

  public boolean rule(String word) {
    if(Objects.isNull(word) || word.isBlank()){
      return false;
    }
    return word.length() > 5;
  }
}
