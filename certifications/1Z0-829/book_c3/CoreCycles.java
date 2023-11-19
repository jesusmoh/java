import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class CoreCycles {
    public static void main(String[] args) {

        int[][] myComplexArray = { { 5, 2, 1, 3 }, { 3, 9, 8, 9 }, { 5, 7, 12, 7 } };
        OUTER: for (int[] mySimpleArray : myComplexArray) {
            INNER: for (int i = 0; i < mySimpleArray.length; i++) {
                System.out.print(mySimpleArray[i] + "\t");
                continue OUTER;// 5 3 5
            }
            System.out.println();
        }

        int[] mySimplex3Arrayy = { 1, 2, 3, 4, 5, 6, 7 , 8, 9, 10 };
        OUTER2: for (int v: mySimplex3Arrayy) {
            System.out.println(v);
            INNER2: for (int i = 0; i < mySimplex3Arrayy.length; i++) {
                System.out.print(mySimplex3Arrayy[i] + "\t");
                break OUTER2;// break the father
            }
            
        }

        int count = 0;
        BUNNY: for (int row = 1; row <= 3; row++) {
           System.out.println(".."+row);
            RABBIT: for (int col = 0; col < 3; col++) {
                if ((col + row) % 2 == 0)
                    break;
                count++;
            }
           
        }
        System.out.println(count);

        int[] mySimplex2Array = { 1, 2, 3, 4, 5, 6, 7 , 8, 9, 10 };
        List<Integer> numList = Arrays.asList(10, 21, 60);
        OUTER: numList.forEach(x -> {
            System.out.println(" "+x.intValue()+" ");
            if (true) {
                INNER: for (int i = 0; i < mySimplex2Array.length; i++) {
                    System.out.print(" "+mySimplex2Array[i]+" ");
                    if (i == 3) {
                        System.out.println("    ");
                        continue; // Skips the iteration when i is 3
                      }
                       System.out.println(" OK ");
                }
            }
        });
    }
}
