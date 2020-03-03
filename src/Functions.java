import java.util.HashMap;

public class Functions {
    public static int[] xOR(int[] plain,int[][] key,int count){
        int [] message = new int[32];
        for (int i = 0;i<32;i++){
            message[i] = key[count][i]^plain[i];
        }
        return message;
    }

    public static int[] sBox(int[] message, HashMap<Integer,Integer> sDict){
        int [] mCode = new int[32];
        for(int i = 0; i<4;i++) {
            int[] split = new int[8];
            int arr[] = new int[8];
            int t = 7;
            int sum =0;
            for(int n =0;n<8;n++){
                split[n] = message[n+i*8];
            }
            for (int j = 7; j >= 0 ; j--) {
                int base = (int) Math.pow(2, j);
                sum += split[7-j]*base;
            }
            int temp =sDict.get(sum);
            String str = Integer.toBinaryString(temp);
            for (int m = str.length()-1; m >=0; m--) {
                arr[t] = Integer.parseInt(str.substring(m,m+1));
                t--;
            }
            for(int c =0;c<8;c++){
                mCode[c+i*8] = arr[c];
            }
        }
        return mCode;
    }

    public static int[] permutation(int[] message,HashMap<Integer,Integer> pDict){
        int[] mesg = new int[32];
        for(int i =0; i<32;i++){
            mesg[pDict.get(i)] = message[i];
        }
        return mesg;
    }

    public static int[] sBoxD(int[] message,HashMap<Integer,Integer> sDict){
        int[] mCode = new int[32];
        for(int i = 0; i<4;i++) {
            int[] split = new int[8];
            int arr[] = new int[8];
            int t = 7;
            int sum =0;
            for(int n =0;n<8;n++){
                split[n] = message[n+i*8];
            }
            for (int j = 7; j >= 0 ; j--) {
                int base = (int) Math.pow(2, j);
                sum += split[7-j]*base;
            }
            int temp = getKey(sDict,sum);
            String str = Integer.toBinaryString(temp);
            for (int m = str.length()-1; m >=0; m--) {
                arr[t] = Integer.parseInt(str.substring(m,m+1));
                t--;
            }
            for(int c =0;c<8;c++){
                mCode[c+i*8] = arr[c];
            }
        }
        return mCode;
    }

    public static int[] permutationD(int[] message,HashMap<Integer,Integer> pDict){
        int[] mesg = new int[32];
        for(int i =0;i<32;i++){
            int temp = getKey(pDict, i);
            mesg[temp] = message[i];
        }
        return mesg;
    }

    public static int getKey(HashMap<Integer,Integer> dict,int value){
        for(int key:dict.keySet()) {
            if (dict.get(key) == value) {
                return key;
            }
        }
        return -1;
    }
}
