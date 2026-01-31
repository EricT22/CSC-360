package BitManipulation;

public class BitOperations {

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
    
}
