

public class AppScope {

    int aa;//auto initilizated with 0
   
    public final static void main(String[] args) {

        AppScope f= new AppScope();

        int bb; // No initializated

        {var x=1;System.out.println("Hello World!"+x);}
        {var x=2;System.out.println("Hello World!"+x);}
        {var x=3;System.out.println("Hello World!"+x);}


         String one,two;
         one=new String("a");
         two=new String("b");
         /*
          one-----|A
          two-----|B
         */
         one=two;
         /*
             -----|A|
          one-----|B|-----two
         */
         String three=one;
          /*
              ****** |A|
          one *****  |B| ***** two
                      *
                      *
                    three
         */
         one=null;
         

        System.out.println(three);
         
    }
}
