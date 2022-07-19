package ca.jrvs.practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LifeCycleTest {


  @Before
    public void setUp() throws Exception{
    System.out.println("before jumping the method");
  }
  @After
  public void tearDown() throws Exception {
    System.out.println("after the method that");
  }

  @Test
  public void testHelloWorld() throws Exception{

    System.out.println("Tets Helloworld");
  }
  @Test
  public void testHelloWorld2() throws Exception{

    System.out.println("Tets Helloworld2");
  }

}
