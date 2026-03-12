package BitManipulation;

public class EncodeDecodeTest {
        // Testing encode/decode
    public static void main(String[] args) {
        short key = 0b100100110;
        short plain = (short)0b111111111111;

        System.out.println(plain + "\n");

        for (int round = 0; round < 9; round++){
            short c = BitOperations.encode12(plain, round, key);
            short d = BitOperations.decode12(c, round, key);

            System.out.println("(" + round + "): " + c + "\t" + d);
        }
    }
}
