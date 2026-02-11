package BitManipulation;

public class BitOperationsTestIIITest {

    public static String int2binary(long b, int bits)
	{
		long r = 0;
		String result = "";
		for (int i = 0; i < bits; ++i) {
			r = b & 0x01; // -- isolate least significant bit
			result = r + result; // -- string concatenation
			b = b >>> 1;  // -- shift for next least significant bit
		}
		return result;
	}


    public static void main(String[] args) {
        System.out.println("S1\t\tS2");
        
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 8; ++j) {
                System.out.println(
                int2binary((byte)(((i << 3) | j) & 0x0F), 4) + ": " +
                int2binary(BitOperations.S1((byte)(((i << 3) | j) & 0x0F)), 3) + "\t" +
                int2binary(BitOperations.S2((byte)(((i << 3) | j) & 0x0F)), 3));
            }
        }
    }
}
