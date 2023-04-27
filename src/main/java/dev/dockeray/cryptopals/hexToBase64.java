package dev.dockeray.cryptopals;

import java.util.Arrays;
import java.util.Base64;
import java.util.stream.IntStream;

class Hex {
    public byte[] getCombinations() {
        return combinations;
    }

    byte[] combinations = new byte[255];
    public Hex() {
        var it = IntStream.range(-128, 127).boxed().iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            var idx = Byte.toUnsignedInt((byte) i.intValue());
            if(idx != 0){
                combinations[idx-1] = Byte.parseByte(i.toString());
            }
        }
    }
}

public class hexToBase64 {
    public static void printHex(byte[] bites) {
       StringBuilder str = new StringBuilder("");
        for (byte bite : bites) {
            str.append(String.format("%02x", bite));
        }
        System.out.println(str);
    }

    public static void printBytes(byte[] bites) {
        StringBuilder str = new StringBuilder("");
        for (byte bite : bites) {
            str.append((char) bite);
        }
        System.out.println(str);
    }
    public static String getBytesStr(byte[] bites) {
        StringBuilder str = new StringBuilder("");
        for (byte bite : bites) {
            str.append((char) bite);
        }
        return str.toString();
    }

    public static byte[] parseHex(String str) {
        byte[] bites = new byte[str.length()/2];
        var idx = 0;
        for(int i = 0; i < str.length(); i+=2){
            var c = str.substring(i, i+2);
            bites[idx] = Byte.parseByte(c, 16);
            idx++;
        }
        return bites;
    }

    public static String singleByteCypher(byte[] b) {
        var score = 0;
        var str = "";
        Hex h = new Hex();
        for(byte bite: h.getCombinations()){
            byte[] cypher = new byte[b.length];
            Arrays.fill(cypher, bite);
            var decode = fixedBitwise(cypher, b);
            var decodedStr = getBytesStr(decode);
            var maybeScore = getScore(decodedStr);
            if(maybeScore > score){
                str = decodedStr;
                score = maybeScore;
            }
        };
        return str;
    }

    public static int getScore(String str) {
        var score = 0;
        for(int i = 0; i < str.length(); i++){
            var s = str.substring(i, i+1);
            if(s.equals("e") || s.equals("a") || s.equals("i") || s.equals("o") || s.equals("u")){
                score++;
            }
        }
        return score;
    }

    public static byte[] fixedBitwise(byte[] b1, byte[] b2) {
        var len = b1.length;
        byte[] orByte = new byte[len];

        for(int i = 0; i < b1.length; i++){
            var val = b1[i] ^ b2[i];
            orByte[i] = (byte) (val);
        }
        return orByte;
    }

    public static void main(String[] args) {
        var s = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
        // challenge 1
        System.out.println("==== 1 ===");
        System.out.println("");

        var sixtyFour = Base64.getEncoder().encode(parseHex(s));
        printBytes(sixtyFour);
        System.out.println("");

        // challenge 2
        System.out.println("==== 2 ===");
        System.out.println("");

        var b1 = parseHex("1c0111001f010100061a024b53535009181c");
        var b2 = parseHex("686974207468652062756c6c277320657965");
        var bitwise = fixedBitwise(b1, b2);
        printHex(bitwise);
        printBytes(bitwise);
        System.out.println("");
        // challenge 3
        System.out.println("==== 3 ===");
        var encoded = parseHex("1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736");

        System.out.println(singleByteCypher(encoded));

    }
}
