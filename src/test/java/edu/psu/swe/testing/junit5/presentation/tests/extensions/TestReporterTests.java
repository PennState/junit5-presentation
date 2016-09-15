package edu.psu.swe.testing.junit5.presentation.tests.extensions;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

public class TestReporterTests {

  @Test
  public void testTestReporter(TestReporter testReporter) {
    Map<String, String> entries = new HashMap<>();
    entries.put("Entry key 1", "Entry value 1");
    entries.put("Entry key 2", "Entry value 2");
    testReporter.publishEntry(entries);
    testReporter.publishEntry("Entry key 3", "Entry value 3");
  }

}
