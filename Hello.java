public class Hello{
    public static void main(String a[]){
        int num = 3;
        System.out.println("Hello World");
        System.out.println(num+5);
        int nums[] = {3,7,2,4};
        int snums[][] = new int[3][4];
        System.out.println(snums[0][0]);
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                snums[i][j] = (int)(Math.random()*100);
                System.out.println();
            }
        }
    }
}