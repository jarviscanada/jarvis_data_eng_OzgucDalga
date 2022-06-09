package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.util.List;
public interface JavaGrep {
  /**
   * Top level search workflow
   * @throws IOException
   */
  void process() throws IOException;

  /**
   * Traverse a given directory and return all files
   * @param rootDir
   * @return
   */
  List<File> ListFiles(String rootDir);

  /**
   * Read a file and retirn all the Lines
   *
   * Explain FileReader, BufferRader, and charaacter encoding
   *
   * @param inputFile
   * @return
   */
  List<String> readLines(File inputFile);

  /**
   * check if a line contains the regex pattern (passed by user)
   * @param Line
   * @return
   */
  boolean containsPattern(String Line);

  /**
   * Write lines to a file
   *
   * Explore: FileOutStream, OutStreamWriter, and BufferedWritter
   *
   * @param lines
   * @throws IOException
   */
  void writeToFile(List<String> lines) throws IOException;

  String getRootPath();

  void setRoothPath;

  String getRegex();

  void setRegex(String regex);

  String getOutFile();

  void setOutFile(String outFile);
}