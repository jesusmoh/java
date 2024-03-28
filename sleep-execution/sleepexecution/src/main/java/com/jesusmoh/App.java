package com.jesusmoh;

//FINOBAHCI PARA LA POSTION  20

// (0 + 1) =1  
// (1 + 1) =2
// (2 + 3) =5
// (3 + 5) =8
// (4 + 8)

public class App {
    public static void main(String[] args) {
        int pNumber = 0;
        int nextNumber = 1;
        int positionMax = 100;
        for (int i = 1; i <= positionMax; i++) {
            System.out.print(" p"+i );
            int sum = pNumber + nextNumber;
            pNumber = nextNumber;
            nextNumber = sum;
            if (i == 19) {
                System.out.print(" Value for position 20 "+pNumber + " ");
                break;
            }

        }
    }

}
