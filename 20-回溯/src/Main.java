import com.embedded.Queen;

/**
 * @author rnang0
 * @date 2020/8/23
 **/
public class Main {
    public static void main(String[] args) {
        Queen queen = new Queen(4);
        queen.placeQueens();

        //Queen queen = new Queen(8);
        //queen.placeQueens();
    }
}
