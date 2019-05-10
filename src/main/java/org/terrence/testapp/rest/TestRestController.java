package org.terrence.testapp.rest;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.terrence.testapp.jpa.Repository;

@RestController
public class TestRestController {

  @Autowired
  private Repository repo;

  StringWriter sw = new StringWriter();
  PrintWriter pw = new PrintWriter(sw);

  // run the test
  @RequestMapping(value = "/test", produces = "text/plain")
  public String runTest() {
    try {
      pw.println("Beginning test...");
      pw.println(repo.findAll());
    } catch (Exception e) {
      pw.println("FAIL: Unexpected error during test.");
      e.printStackTrace();
    }
    pw.flush();
    return sw.toString();
  }
}