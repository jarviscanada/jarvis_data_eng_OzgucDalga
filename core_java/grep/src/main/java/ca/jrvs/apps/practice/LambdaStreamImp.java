package ca.jrvs.apps.practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaStreamImp implements LambdaStreamExc{
    /**
     * Create a String stream from array
     * <p>
     * note: arbitrary number of value will be stored in an array
     *
     * @param strings
     * @return
     */
    @Override
    public Stream<String> createStrStream(String... strings) {
        return Arrays.stream(strings);
    }

    /**
     * Convert all strings to uppercase
     * please use createStrStream
     *
     * @param strings
     * @return
     */
    @Override
    public Stream<String> toUpperCase(String... strings) {
        Stream<String> stringStream = createStrStream(strings);
        return stringStream.map(String::toUpperCase);
    }

    /**
     * filter strings that contains the pattern
     * e.g.
     * filter(stringStream, "a") will return another stream which no element contains a
     *
     * @param stringStream
     * @param pattern
     * @return
     */
    @Override
    public Stream<String> filter(Stream<String> stringStream, String pattern) {
        return stringStream.filter(s -> !s.contains(pattern));
    }

    /**
     * Create a intStream from a arr[]
     *
     * @param arr
     * @return
     */
    @Override
    public IntStream createIntStream(int[] arr) {
        return IntStream.of(arr);
    }

    /**
     * Convert a stream to list
     *
     * @param stream
     * @return
     */
    @Override
    public <E> List<E> toList(Stream<E> stream) {
        return stream.collect(Collectors.toList());
    }

    /**
     * Convert a intStream to list
     *
     * @param intStream
     * @return
     */
    @Override
    public List<Integer> toList(IntStream intStream) {
        Stream<Integer> integerStream = intStream.boxed();
        return toList(integerStream);
    }

    /**
     * Create a IntStream range from start to end inclusive
     *
     * @param start
     * @param end
     * @return
     */
    @Override
    public IntStream createIntStream(int start, int end) {
        return IntStream.range(start, end+1);
    }

    /**
     * Convert a intStream to a doubleStream
     * and compute square root of each element
     *
     * @param intStream
     * @return
     */
    @Override
    public DoubleStream squareRootIntStream(IntStream intStream) {
        return intStream.mapToDouble(Math::sqrt);
    }

    /**
     * filter all even number and return odd numbers from a intStream
     *
     * @param intStream
     * @return
     */
    @Override
    public IntStream getOdd(IntStream intStream) {
        return intStream.filter(x -> x % 2 == 1);
    }

    /**
     * Return a lambda function that print a message with a prefix and suffix
     * This lambda can be useful to format logs
     * <p>
     * You will learn:
     * - functional interface http://bit.ly/2pTXRwM & http://bit.ly/33onFig
     * - lambda syntax
     * <p>
     * e.g.
     * LambdaStreamExc lse = new LambdaStreamImp();
     * Consumer<String> printer = lse.getLambdaPrinter("start>", "<end");
     * printer.accept("Message body");
     * <p>
     * sout:
     * start>Message body<end
     *
     * @param prefix prefix str
     * @param suffix suffix str
     * @return
     */
    @Override
    public Consumer<String> getLambdaPrinter(String prefix, String suffix) {
        return x-> System.out.println(prefix + x + suffix);
    }

    /**
     * Print each message with a given printer
     * Please use `getLambdaPrinter` method
     * <p>
     * e.g.
     * String[] messages = {"a","b", "c"};
     * lse.printMessages(messages, lse.getLambdaPrinter("msg:", "!") );
     * <p>
     * sout:
     * msg:a!
     * msg:b!
     * msg:c!
     *
     * @param messages
     * @param printer
     */
    @Override
    public void printMessages(String[] messages, Consumer<String> printer) {
        createStrStream(messages).forEach(printer);
    }

    /**
     * Print all odd number from a intStream.
     * Please use `createIntStream` and `getLambdaPrinter` methods
     * <p>
     * e.g.
     * lse.printOdd(lse.createIntStream(0, 5), lse.getLambdaPrinter("odd number:", "!"));
     * <p>
     * sout:
     * odd number:1!
     * odd number:3!
     * odd number:5!
     *
     * @param intStream
     * @param printer
     */
    @Override
    public void printOdd(IntStream intStream, Consumer<String> printer) {
        String[] strings = intStream.filter(x -> x%2==1).mapToObj(Integer::toString).toArray(String[]::new);
        printMessages(strings, printer);
    }

    /**
     * Square each number from the input.
     * Please write two solutions and compare difference
     * - using flatMap
     *
     * @param ints
     * @return
     */
    @Override
    public Stream<Integer> flatNestedInt(Stream<List<Integer>> ints) {
        return ints.flatMap(Collection::stream);
    }

    public static void main(String[] args) {
        LambdaStreamExc lse = new LambdaStreamImp();
        lse.printOdd(lse.createIntStream(0, 5), lse.getLambdaPrinter("odd number:", "!"));
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2));
        System.out.println(list);
        System.out.println(lse.toList(lse.flatNestedInt(list.stream())));
    }
}package ca.jrvs.apps.practice;

    import java.util.Arrays;
    import java.util.Collection;
    import java.util.List;
    import java.util.function.Consumer;
    import java.util.stream.Collectors;
    import java.util.stream.DoubleStream;
    import java.util.stream.IntStream;
    import java.util.stream.Stream;

public class LambdaStreamImp implements LambdaStreamExc{
  /**
   * Create a String stream from array
   * <p>
   * note: arbitrary number of value will be stored in an array
   *
   * @param strings
   * @return
   */
  @Override
  public Stream<String> createStrStream(String... strings) {
    return Arrays.stream(strings);
  }

  /**
   * Convert all strings to uppercase
   * please use createStrStream
   *
   * @param strings
   * @return
   */
  @Override
  public Stream<String> toUpperCase(String... strings) {
    Stream<String> stringStream = createStrStream(strings);
    return stringStream.map(String::toUpperCase);
  }

  /**
   * filter strings that contains the pattern
   * e.g.
   * filter(stringStream, "a") will return another stream which no element contains a
   *
   * @param stringStream
   * @param pattern
   * @return
   */
  @Override
  public Stream<String> filter(Stream<String> stringStream, String pattern) {
    return stringStream.filter(s -> !s.contains(pattern));
  }

  /**
   * Create a intStream from a arr[]
   *
   * @param arr
   * @return
   */
  @Override
  public IntStream createIntStream(int[] arr) {
    return IntStream.of(arr);
  }

  /**
   * Convert a stream to list
   *
   * @param stream
   * @return
   */
  @Override
  public <E> List<E> toList(Stream<E> stream) {
    return stream.collect(Collectors.toList());
  }

  /**
   * Convert a intStream to list
   *
   * @param intStream
   * @return
   */
  @Override
  public List<Integer> toList(IntStream intStream) {
    Stream<Integer> integerStream = intStream.boxed();
    return toList(integerStream);
  }

  /**
   * Create a IntStream range from start to end inclusive
   *
   * @param start
   * @param end
   * @return
   */
  @Override
  public IntStream createIntStream(int start, int end) {
    return IntStream.range(start, end+1);
  }

  /**
   * Convert a intStream to a doubleStream
   * and compute square root of each element
   *
   * @param intStream
   * @return
   */
  @Override
  public DoubleStream squareRootIntStream(IntStream intStream) {
    return intStream.mapToDouble(Math::sqrt);
  }

  /**
   * filter all even number and return odd numbers from a intStream
   *
   * @param intStream
   * @return
   */
  @Override
  public IntStream getOdd(IntStream intStream) {
    return intStream.filter(x -> x % 2 == 1);
  }

  /**
   * Return a lambda function that print a message with a prefix and suffix
   * This lambda can be useful to format logs
   * <p>
   * You will learn:
   * - functional interface http://bit.ly/2pTXRwM & http://bit.ly/33onFig
   * - lambda syntax
   * <p>
   * e.g.
   * LambdaStreamExc lse = new LambdaStreamImp();
   * Consumer<String> printer = lse.getLambdaPrinter("start>", "<end");
   * printer.accept("Message body");
   * <p>
   * sout:
   * start>Message body<end
   *
   * @param prefix prefix str
   * @param suffix suffix str
   * @return
   */
  @Override
  public Consumer<String> getLambdaPrinter(String prefix, String suffix) {
    return x-> System.out.println(prefix + x + suffix);
  }

  /**
   * Print each message with a given printer
   * Please use `getLambdaPrinter` method
   * <p>
   * e.g.
   * String[] messages = {"a","b", "c"};
   * lse.printMessages(messages, lse.getLambdaPrinter("msg:", "!") );
   * <p>
   * sout:
   * msg:a!
   * msg:b!
   * msg:c!
   *
   * @param messages
   * @param printer
   */
  @Override
  public void printMessages(String[] messages, Consumer<String> printer) {
    createStrStream(messages).forEach(printer);
  }

  /**
   * Print all odd number from a intStream.
   * Please use `createIntStream` and `getLambdaPrinter` methods
   * <p>
   * e.g.
   * lse.printOdd(lse.createIntStream(0, 5), lse.getLambdaPrinter("odd number:", "!"));
   * <p>
   * sout:
   * odd number:1!
   * odd number:3!
   * odd number:5!
   *
   * @param intStream
   * @param printer
   */
  @Override
  public void printOdd(IntStream intStream, Consumer<String> printer) {
    String[] strings = intStream.filter(x -> x%2==1).mapToObj(Integer::toString).toArray(String[]::new);
    printMessages(strings, printer);
  }

  /**
   * Square each number from the input.
   * Please write two solutions and compare difference
   * - using flatMap
   *
   * @param ints
   * @return
   */
  @Override
  public Stream<Integer> flatNestedInt(Stream<List<Integer>> ints) {
    return ints.flatMap(Collection::stream);
  }

  public static void main(String[] args) {
    LambdaStreamExc lse = new LambdaStreamImp();
    lse.printOdd(lse.createIntStream(0, 5), lse.getLambdaPrinter("odd number:", "!"));
    List<List<Integer>> list = Arrays.asList(
        Arrays.asList(1),
        Arrays.asList(2));
    System.out.println(list);
    System.out.println(lse.toList(lse.flatNestedInt(list.stream())));
  }
}