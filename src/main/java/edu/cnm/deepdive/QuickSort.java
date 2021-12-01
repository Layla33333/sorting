package edu.cnm.deepdive;

public class QuickSort {

  public static void sort(int[] data) {
    sort(data, 0, data.length);
  }

  public static void sort(int[] data, int start, int end) {
    if (end > start + 1) {
      // Divide
      // Naive approach ; Pick first element as pivot value
      int pivotValue = data[start];
      int dividerIndex = start;
      for (int currentIndex = start + 1; currentIndex < end; currentIndex++) {
        int currentValue = data[currentIndex];
        if (currentValue <= pivotValue) {
         // dividerIndex++;
          if (++dividerIndex < currentIndex) {
            data[currentIndex] = data[dividerIndex];
            data[dividerIndex] = currentValue;
          }
        }
      }
      data[start] = data[dividerIndex];
      data[dividerIndex] = pivotValue;
      sort(data,start, dividerIndex);
      sort(data,dividerIndex + 1, end);
      // Conquer:  DO Nothing
    }
  }
}
