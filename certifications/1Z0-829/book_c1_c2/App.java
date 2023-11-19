
public class App {

    public final static void main(String[] args) {

        final int score1=8,score2=3;
        char myScore=7;
        var goal = switch(myScore){
            default -> "unknow";
            case score1 -> "great";
            case 2,4,6 ->   "good";
            case score2, 0 -> "bad";
        };



        System.out.println("Hello World!" +"*"+ args[0]);
    }
}
