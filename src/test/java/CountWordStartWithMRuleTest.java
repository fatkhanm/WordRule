import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import RulesImpl.CountWordStartWithUppercase;
import org.junit.Test;

public class CountWordStartWithMRuleTest {
  CountWordStartWithUppercase countWordStartWithMRule = new CountWordStartWithUppercase();

  @Test
  public void checkRuleIfWordIsNull(){
    assertFalse(countWordStartWithMRule.rule(null));
  }

  @Test
  public void checkRuleIfWordIsBlank(){
    assertFalse(countWordStartWithMRule.rule(""));
  }

  @Test
  public void checkRuleIfWordNotMatch(){
    assertFalse(countWordStartWithMRule.rule("kamu"));
  }

  @Test
  public void checkRuleIfWordMatch(){
    assertTrue(countWordStartWithMRule.rule("Muka"));
  }
}
