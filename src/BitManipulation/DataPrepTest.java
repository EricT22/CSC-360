package BitManipulation;

public class DataPrepTest {

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

    public static void main (String[] args) {
        short[] data12;
        byte[] data8;
        
        data12 = BitOperations.preprocess("A");
        for (int i = 0; i < data12.length; ++i) {
            System.out.print(int2binary(data12[i], 12) + " ");
        }
        System.out.println();
        data8 = BitOperations.postprocess(data12);
        for (int i = 0; i < data8.length; ++i) {
        System.out.print(int2binary(data8[i], 8) + " ");
        }
        System.out.println();
        System.out.println();
        

        data12 = BitOperations.preprocess("AB");
        for (int i = 0; i < data12.length; ++i) {
        System.out.print(int2binary(data12[i], 12) + " ");
        }
        System.out.println();
        data8 = BitOperations.postprocess(data12);
        for (int i = 0; i < data8.length; ++i) {
        System.out.print(int2binary(data8[i], 8) + " ");
        }
        System.out.println();
        System.out.println();
        

        data12 = BitOperations.preprocess("ABC");
        for (int i = 0; i < data12.length; ++i) {
        System.out.print(int2binary(data12[i], 12) + " ");
        }
        System.out.println();
        data8 = BitOperations.postprocess(data12);
        for (int i = 0; i < data8.length; ++i) {
        System.out.print(int2binary(data8[i], 8) + " ");
        }
        System.out.println();
        System.out.println();
        

        data12 = BitOperations.preprocess("ABCD");
        for (int i = 0; i < data12.length; ++i) {
        System.out.print(int2binary(data12[i], 12) + " ");
        }
        System.out.println();
        data8 = BitOperations.postprocess(data12);
        for (int i = 0; i < data8.length; ++i) {
        System.out.print(int2binary(data8[i], 8) + " ");
        }
        System.out.println();
        System.out.println();


        data12 = BitOperations.preprocess("ABCDEF");
        for (int i = 0; i < data12.length; ++i) {
        System.out.print(int2binary(data12[i], 12) + " ");
        }
        System.out.println();
        data8 = BitOperations.postprocess(data12);
        for (int i = 0; i < data8.length; ++i) {
        System.out.print(int2binary(data8[i], 8) + " ");
        }
        System.out.println();
        System.out.println();
        }
}
