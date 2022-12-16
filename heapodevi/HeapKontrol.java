package heapodevi;

/**
 *
 * @author Serdar
 */
public class HeapKontrol {
    public static boolean isMinHeap(int[] array) {
    // Yaprak yapisinda olmayan son node'dan (ornegin son yapragin ebeveyni) baslayarak kok node'a kadar gezinti
    for (int i = (array.length - 2) / 2; i >= 0; i--) {
      // Eger o anki eleman kendi cocugundan buyukse dizi min heap yapisinda degildir ve false doner
      if (array[i] > array[2 * i + 1] || (2 * i + 2 < array.length && array[i] > array[2 * i + 2])) {
        return false;
      }
    }
    // Ustteki if yapisi gecerli degilse dizi min heap yapisindadir ve true doner
    return true;
  }
}
