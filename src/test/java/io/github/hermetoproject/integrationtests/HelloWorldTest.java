package io.github.hermetoproject.integrationtests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the HelloWorld class.
 */
class HelloWorldTest {

  @Test
  void testGetGreeting() {
    HelloWorld helloWorld = new HelloWorld();
    String greeting = helloWorld.getGreeting();
    assertNotNull(greeting);
    assertEquals("Hello, World!", greeting);
  }

  @Test
  void testMainMethod() {
    // Verify main method exists and can be called
    HelloWorld.main(new String[] {});
    // If we get here without exception, the test passes
  }
}
