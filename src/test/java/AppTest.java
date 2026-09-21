import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
  @Test
  void simpleTest() {
    assertTrue(true);
  }

  @Test
  void mySimpleTest() {
    assertEquals(1, Integer.parseInt("1"));
  }
}