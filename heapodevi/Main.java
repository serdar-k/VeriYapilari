package heapodevi;

import java.awt.BorderLayout;
import static java.lang.Integer.parseInt;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Serdar
 */
public class Main {


  public static void main(String[] args) {
      
      String string;
      
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("Eklemek Istediginiz Sayilari Aralarinda Bosluk Olmadan Sadece Virgul Olacak Sekilde Girin ");
      
      string = scanner.nextLine();
      
      // Kullanicidan alinan sayilar ',' ile ayrilarak bir dizi icine atilir
      String[] stringArray = string.split(",");
      
      // Girilen sayi uzunlugunda yeni bir dizi olusturulur
      int size = stringArray.length;
      
      int[] array = new int[size];
      
      // Olusturulan yeni diziye, kullanicidan alinan degerler int tipine donusturulerek sira ile eklenir
      for(int i = 0; i < stringArray.length; i++){
          array[i] = parseInt(stringArray[i]);
      }
      
      // Kullanicinin girdigi degerler bir min heap olusturuyorsa herhangi bir islem yapilmaz
      if(HeapKontrol.isMinHeap(array)){
          System.out.println("Girilen Sayilarla Olusan Dizi MinHeap Ozelligindedir");
      }
      
      // Kullanicinin girdigi degerler bir min heap olusturmuyorsa, girilen degerlerle yeni bir min heap olusturulur
      if(!HeapKontrol.isMinHeap(array)){
          System.out.println("Girilen Sayilarla Olusan Dizi Min Heap Ozelliginde Degildir");
          System.out.println("Girilen Sayilarin Yeniden Duzenlenmesiyle Olusturulan Min Heap: ");
          MinHeap.buildMinHeap(array);
          System.out.println(Arrays.toString(array));
      }
      

//    int[] array1 = {10,15,20,25,30,35,40}; True
//    int[] array2 = {40,35,30,25,20,15,10}; False
//    int[] array3 = {10,20,70,100,50,60,70}; False

  }    
}
