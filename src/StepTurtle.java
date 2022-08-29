import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StepTurtle {

    public static int logicCouth(int[][] mass){
        int[][] sumMass=mass;

        for(int i=mass.length-2; i>=0;i--){
          mass[i][0]=mass[i][0]+mass[i+1][0];
        }

        for(int i=1;i<=mass[mass.length-1].length-1;i++){
            mass[mass.length-1][i]=mass[mass.length-1][i-1]+mass[mass.length-1][i];
        }
        for (int j=mass.length-2;j>=0;j--){

            for(int i=1;i<= mass[0].length-1;i++){
               

                if(mass[j+1][i]<=mass[j][i-1]){
            mass[j][i]=mass[j][i-1]+mass[j][i];
                }

                else {  mass[j][i]=mass[j+1][i]+mass[j][i]; }

       }

        }
return mass[0][mass[0].length-1];
    }


    public static void main(String[] args) {

         int[][] startMassWithVaule;
        Scanner scanner=new Scanner(System.in);
        String stringOfNxM=scanner.nextLine();
        //
        String[] mass=stringOfNxM.split(" ");
        int[][] massFineshed=new int[Integer.parseInt(mass[0])][Integer.parseInt(mass[1])];

        //Arrays.fill(massFineshed,1); многомерные массивы нельзя так заполнить

        boolean chek=true;
        while (chek){
            System.out.println("заполните поля цветочками");

            String s=scanner.nextLine();
            // условия выхода и заполнения полей в массиве цветочками
            if(s.equalsIgnoreCase("выход")){
             chek=false;
            }

            if (!s.matches("\\d{3}")==true){
              System.out.println("Вы ввели некоректное значение,поробуйте еще раз");
            continue;
            }

            if (s.matches("\\d{3}")){
                String d0=String.valueOf(s.charAt(0));
                String d1=String.valueOf(s.charAt(1));
                String d2=String.valueOf(s.charAt(2));
                int c0=Integer.parseInt(d0);
                int c1=Integer.parseInt(d1);
                int c2=Integer.parseInt(d2);
                //делал в 21:53 хотел спать с байтами не стал разбирать. почему то используя charAr или другое связанное
                // с char возращает цифру в байтах
             massFineshed[c0][c1]=c2;// хочешь обработай ошибку

            }
        }

        System.out.println(logicCouth(massFineshed));

        // int[][] mass={{1,2,6,3},{7,2,4,8},{5,0,9,6,},{4,7,1,2},{10,3,0,2}};//Можно запихнуть в двемерный массив массивы
        // разной длинны пример выше


    }
}
