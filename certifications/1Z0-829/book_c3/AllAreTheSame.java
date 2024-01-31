public class AllAreTheSame {

  public static void main(String[] args) {
    int count = 0;
    BUNNY: for (int row = 1; row <= 3; row++)
      RABBIT: for (int col = 0; col < 3; col++) {
        if ((col + row) % 2 == 0) {
          // break RABBIT; jump the 2 cicle and the last one, don't jumb
          // continue BUNNY; each complete cicle of RABBIT sum 1 in count, with a continue
          // i garantee 2 iterations for bunny
          break; // this break and the firts onw is the same case and behavior
        }
        count++;
      }
    System.out.println(count);// print 2
  }
}
