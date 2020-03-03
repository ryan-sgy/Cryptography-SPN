
import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException{
        //read data from input_spn.txt
        String path1 = "src/resources/input_spn.txt";
        ReadFile file = new ReadFile();
        int m = file.readM(path1);
        int[] message = file.readX(path1,m);
        int[][] keyDict = file.readKey(path1);
        HashMap<Integer,Integer> sBox = file.readSbox(path1);
        HashMap<Integer,Integer> pDict = file.readP(path1);
        int a = file.readA(path1);

        //write into output_spn.txt
        String path2 = "src/resources/output_spn.txt";
        WriteFile outputFile = new WriteFile();
        outputFile.WriteFile(path2,message,keyDict,sBox,pDict,m,a);
    }

}