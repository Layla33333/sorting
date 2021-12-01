package edu.cnm.deepdive;

public class BinarySearch {

  public static int search(int[] haystack, int needle) {
    return search(haystack, needle, 0, haystack.length);
  }

  public static int search(int[] haystack, int needle, int start, int end) {
    int position;
    if (end > start)  {
      int midpoint = (start + end) / 2;
      int midpointValue = haystack[midpoint];
      if (midpointValue < needle) {
      position = search(haystack, needle, midpoint + 1, end);
      } else if (midpointValue > needle) {
        position = search(haystack, needle, start, midpoint);
      } else {
        position = midpoint;
      }
    } else {
      position = ~(start + 1);
    }
    return position;
  }
}
