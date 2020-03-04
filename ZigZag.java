//Cole Constantino | return given string given amount of rows in zig zag conversion
import java.util.*;
public class ZigZag{
  public static String convert(String s, int rows){
    List<Integer> list = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    boolean inc = true;
    int count = 0;
    
    //sort list of string index levels 
    for(int i = 0; i<s.length(); i++){
      list.add(i,count);
      list2.add(i,i);
      if(inc == true) {
        count++;
      }
      else{
        count--;
      }
      
      if(count == rows-1) {
        inc = false;
      }
      else if(count == 0){
        inc  = true;
      }
    }
    //sort list of string index levels  
    
    StringBuilder sb = new StringBuilder();
    int newCount = 0;
    int newIndex = 0;
    String temp = "";
    count = 0;
    
    for(int j = 0; j < s.length(); j++){
      newIndex = list.indexOf(count);
      temp = Character.toString(s.charAt(list2.get(newIndex)));
      sb.append(temp);
      list.remove(newIndex);
      list2.remove(newIndex);
      if(!list.contains(count)){
        count++;
      }
    }
    String ans = sb.toString();
    return ans; 
  }
  
  public static void main(String[] args){
    String s = "paypalishiring";
    System.out.println(convert(s,3));
  }
}