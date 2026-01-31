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
    
}
