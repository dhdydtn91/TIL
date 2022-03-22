package hash;

import java.util.HashMap;
import java.util.TreeMap;

public class IntToRoman {
  public String intToRoman(int num) {

      // store fix roman numbers in Map along with pattern
      TreeMap<Integer,String> map = new TreeMap();

      map.put(1,"I");
      map.put(4,"IV");
      map.put(5,"V");
      map.put(9,"IX");
      map.put(10,"X");
      map.put(40,"XL");
      map.put(50,"L");
      map.put(90,"XC");
      map.put(100,"C");
      map.put(400,"CD");
      map.put(500,"D");
      map.put(900,"CM");
      map.put(1000,"M");

      String str = new String();
      // store numbers from map in array so as to traverse as per num
      int[] arr = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
      int i = arr.length-1;

      while(num>0)
      {

        /** iteration 1
         if num >= value in array
         *  e.g. num = 14 > arr[i]  i.e. 10
         *   num = 14-10=4
         str = X
         again check num with same element in array
         else (if num<arr)
         go to next element

         iteration 2
         num = 4 == arr[i]
         str = X + IV
         **/
        if(num>=arr[i])
        {
          num -= arr[i];
          str += map.get(arr[i]);
        }
        else
          i--;
      }

      return str;

  }
  public static void main(String[] args) {
    IntToRoman i = new IntToRoman();
    int num  = 58;
    i.intToRoman(num);
  }

}
