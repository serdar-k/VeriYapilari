package heapodevi;

/**
 *
 * @author Serdar
 */
public class MinHeap {
    public static void heapify(int[] array, int i) {
    int sol = 2 * i + 1;
    int sag = 2 * i + 2;
    int en_kucuk = i;
    if (sol < array.length && array[sol] < array[i]) {
      en_kucuk = sol;
    }
    if (sag < array.length && array[sag] < array[en_kucuk]) {
      en_kucuk = sag;
    }
    if (en_kucuk != i) {
      int temp = array[i];
      array[i] = array[en_kucuk];
      array[en_kucuk] = temp;
      heapify(array, en_kucuk);
    }
  }

  public static void buildMinHeap(int[] array) {
    for (int i = (array.length - 2) / 2; i >= 0; i--) {
      heapify(array, i);
    }
  }
}
