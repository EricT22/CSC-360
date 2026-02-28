package BitManipulation;


public class BitOperations {

    private static int[][] s1 = {
            {0b101, 0b010, 0b001, 0b110, 0b011, 0b100, 0b111, 0b000},
            {0b001, 0b100, 0b110, 0b010, 0b000, 0b111, 0b101, 0b011}
        };

    private static int[][] s2 = {
            {0b100, 0b000, 0b110, 0b101, 0b111, 0b001, 0b011, 0b010},
            {0b101, 0b011, 0b000, 0b111, 0b110, 0b010, 0b001, 0b100}
        };

    public static int left(byte _byte) {
        int b = (int)_byte;
        int mask = 0x000000FF;

        b &= mask;

        b >>= 4;


        return (byte)b;
    }

    public static int right(byte _byte) {
        int b = (int)_byte;

        int mask = 0x0000000F;

        b &= mask;

        return (byte)b;
    }

    public static int sixbits(byte _byte) {
        int b = (int)_byte;
        int mask = 0x000000FC;

        b &= mask;

        b >>= 2;


        return (byte)b;
    }

    public static int lrswap(short _in) {
        int mask = 0x0000FFFF;

        int l = (int)_in;

        l &= mask;
        l >>= 8;
        
        int r = (int)_in;
        
        r <<= 8;
        r &= mask;

        return (short)(l | r);
    }

    public static int expander(byte b) {
        int e = (int)b;
        e &= 0x0000FFFF;

        int b7 = (e & 0b00100000) << 2;
        int b6 = (e & 0b00010000) << 2;
        int b5 = (e & 0b00000100) << 3;
        int b4 = (e & 0b00001000) << 1;
        int b3 = (e & 0b00000100) << 1;
        int b2 = (e & 0b00001000) >> 1;
        int b1 = (e & 0b00000010);
        int b0 = (e & 0b00000001);
        

        return b7 | b6 | b5 | b4 | b3 | b2 | b1 | b0;
    }

    public static int keyextractor(short key, int pos) {
        int k = (int)key;
        int mask = 0x0000FFFF;

        k &= mask;

        for (int i = 0; i < pos; i ++){
            // wrap
            k = ((k << 1) & mask) | (k >> 15);
        }

        k = lrswap((short)k);

        return (byte)k;
    }

    
    public static byte S1(byte _byte){
        int left = left(_byte);
        int right = right(_byte);

        int row = right >> 3;

        int col = right & 0x7;

        return (byte)((left << 4) + s1[row][col]);
    }

    public static byte S2(byte _byte){
        int left = left(_byte);
        int right = right(_byte);

        int row = right >> 3;

        int col = right & 0x7;

        return (byte)((left << 4) + s2[row][col]);
    }


    public static byte feistel(byte r, byte k) {
        // expander
        int e = expander(r);

        // xor
        e ^= k;

        // Split
        int left = left((byte) e);
        int right = right((byte) e);

        // S1 & S2
        left = S1((byte) left);
        right = S2((byte) right);

        // Concat
        int ls1 = (left & 0x07) << 3;
        int rs2 = right & 0x07;

        return (byte)(ls1 + rs2);
    }

    public static short[] preprocess(String s){
        byte[] bytes = s.getBytes();

        // Multiple of 3
        while (bytes.length % 3 != 0){
            byte[] temp = bytes.clone();
            bytes = new byte[temp.length + 1];

            for (int i = 0; i < temp.length; i++){
                bytes[i] = temp[i];
            }
        }

        // combining into short array
        short[] arr = new short[bytes.length / 3 * 2];
        int arrInd = 0;

        for (int i = 0; i < bytes.length; i += 3){
            byte b0 = bytes[i];
            byte b1 = bytes[i + 1];
            byte b2 = bytes[i + 2];

            int x = (int)b0;
            x <<= 4;

            int yLeft = left(b1);
            
            int yRight = right(b1);
            yRight <<= 8;

            int z = (int)b2;

            arr[arrInd] = (short)(x + yLeft);
            arrInd++;
            arr[arrInd] = (short)(yRight + z);
            arrInd++;
        }

        return arr;
    }

    public static byte[] postprocess(short[] s){
        byte[] b = new byte[s.length * 3 / 2];
        int bInd = 0;

        for (int i = 0; i < s.length; i += 2){
            short s0 = s[i];
            short s1 = s[i + 1];

            byte x = (byte)(((int)s0) >> 4);

            int yLeft = ((int)s0) & 0xF;
            yLeft <<= 4;

            int yRight = ((int)s1) >> 8;
            yRight &= 0xF;

            byte y = (byte)(yLeft + yRight);

            byte z = (byte)(((int)s1) & 0xFF);


            b[bInd] = x;
            bInd++;
            b[bInd] = y;
            bInd++;
            b[bInd] = z;
            bInd++;
        }


        return b;
    }
}
