package edu.cnm.deepdive;

public class MergeSort {

  public static void sort(int[] data) {
    sort(data, 0, data.length);
  }

  public static void sort(int[] data, int start, int end) {
    if (end > start + 1) {
      //Divide
      int midpoint = (start + end) / 2;
      sort(data, start, midpoint);//Sort the left side
      sort(data, midpoint, end);//Sort the right side
      //Conquer Merge
      int[] merged = new int[end - start];
      int leftIndex = start;
      int rightIndex = midpoint;
      int mergedIndex = 0;
      while (leftIndex < midpoint && rightIndex < end) {
        int leftValue = data[leftIndex];
        int rightValue = data[rightIndex];
        if (leftIndex <= rightValue) {
          merged[mergedIndex] = leftIndex;
          leftIndex++;
        } else {
          merged[mergedIndex] = rightValue;
          rightIndex++;
        }
        mergedIndex++;
      }
      if (leftIndex < midpoint) {
        System.arraycopy(data, leftIndex, merged, mergedIndex, midpoint - leftIndex);
      } else { // We now know that items remain in the roght hand side: that is rightIndex <  end
        System.arraycopy(data, rightIndex, merged, mergedIndex, end - rightIndex);
      }
      System.arraycopy(merged, 0, data, start, merged.length);
    }
  }

}
