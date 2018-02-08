import java.util.Arrays;

public class GenericMethods {


  public static <E> void printArray(E[] inputArray) {
    Arrays.stream(inputArray).forEach(
        element -> System.out.printf("%s ", element)
    );
    System.out.println();
  }

  public static void main(String[] args) {

    Integer[] intArray = {1, 2, 3, 4, 5};
    Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
    Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

    printArray(intArray);
    printArray(doubleArray);
    printArray(charArray);
  }

}
