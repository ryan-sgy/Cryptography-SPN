
import java.util.HashMap;
import java.io.*;
public class WriteFile {
    public static void WriteFile(String path,int[] message, int[][] keyDict,HashMap<Integer,Integer> sBox, HashMap<Integer,Integer> pDict,int m, int a) throws IOException{
        try {
            PrintStream ps = new PrintStream(path);
            System.setOut(ps);
            if(a==0){
                System.out.println("Encrypt!");
                System.out.println("The input key K:");
                for (int g = 0; g < 9; g++) {
                    for (int h = 0; h < 32; h++) {
                        System.out.print(keyDict[g][h]);
                    }
                }
                System.out.println();

                System.out.println("The s-box function f:");
                for (int t = 0; t < 256; t++) {
                    System.out.print("f(" + t + ") = " + sBox.get(t) + ", ");
                }
                System.out.println();

                System.out.println("The permutation function σ:");
                for(int k = 0;k < 32;k++){
                    System.out.print("σ("+ k +")=" + pDict.get(k) +", ");
                }
                System.out.println();

                Functions fc = new Functions();
                System.out.println("The encrypted output E_k(x):");
                for (int i = 0; i < m / 32; i++) {
                    int[] text = new int[32];
                    for (int b = 0; b < 32; b++) {
                        text[b] = message[b + i * 32];
                    }
                    for (int j = 0; j < 8; j++) {
                        text = fc.xOR(text, keyDict, j);
                        text = fc.permutation(text, pDict);
                        text = fc.sBox(text, sBox);
                    }
                    text = fc.xOR(text, keyDict, 8);
                    for (int t = 0; t < 32; t++) {
                        System.out.print(text[t]);
                    }
                }
                System.out.println();

                System.out.println("m, the length of input in bits:" + m);

                System.out.println("_");
                System.out.println("a: " + (1-a));
            }
            else if(a == 1){
                System.out.println("Decrypt!");
                System.out.println("The input key K:");
                for (int g = 0; g < 9; g++) {
                    for (int h = 0; h < 32; h++) {
                        System.out.print(keyDict[g][h]);
                    }
                }
                System.out.println();
                System.out.println("The s-box function f:");
                for (int t = 0; t < 256; t++) {
                    System.out.print("f(" + t + ") = " + sBox.get(t) + ", ");
                }
                System.out.println();

                System.out.println("The permutation function σ:");
                for(int k = 0;k < 32;k++){
                    System.out.print("σ("+ k +")=" + pDict.get(k) +", ");
                }
                System.out.println();

                Functions fc = new Functions();
                System.out.println("The Decrypted output D_k(x):");
                for (int i = 0; i < m / 32; i++) {
                    int[] text = new int[32];
                    for (int b = 0; b < 32; b++) {
                        text[b] = message[b + i * 32];
                    }
                    text = fc.xOR(text,keyDict,8);
                    for (int j = 7; j >= 0; j--) {
                        text = fc.sBoxD(text,sBox);
                        text = fc.permutationD(text, pDict);
                        text = fc.xOR(text, keyDict,j);
                    }
                    for (int t = 0; t < 32; t++) {
                        System.out.print(text[t]);
                    }
                }
                System.out.println();

                System.out.println("m, the length of input in bits: " + m);

                System.out.println("_");
                System.out.println("a: " + (1-a));
            }
            else{
                System.out.println(("You input an invalid 'a'!"));
            }
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
