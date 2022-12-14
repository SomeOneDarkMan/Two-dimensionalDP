import java.util.*;

public class StepTurtle {

    public static HashMap logicCouth(int[][] mass){
        //int[][] sumMass;


        for(int i=mass.length-2; i>=0;i--){
          mass[i][0]=mass[i][0]+mass[i+1][0];
        }

        for(int i=1;i<=mass[mass.length-1].length-1;i++){
            mass[mass.length-1][i]=mass[mass.length-1][i-1]+mass[mass.length-1][i];
        } // заполняем пограничные значения (нижнию строку и крайний левый столбец )

      /* стоблец  */ for (int j=mass.length-2;j>=0;j--){
      /*  строка  */  for(int i=1;i<= mass[j].length-1;i++){ //0 is changed on j ; arr might be non-square


                if(mass[j+1][i]<=mass[j][i-1]){
            mass[j][i]=mass[j][i-1]+mass[j][i];



                }

                else {    mass[j][i]=mass[j+1][i]+mass[j][i];

                }

       }


        }
        HashMap d=new HashMap<String,Object>();
      d.put("MaxSum", mass[0][mass[0].length-1]);
      d.put("StepWay",stepWay(mass));
return d;
    }

    private static Object stepWay(int[][] mass) {
        StringBuilder stringBuilder=new StringBuilder();
        int i=mass[0].length-1;
          for(int j= 0;j<=mass.length-1;j++){
              if(i==0){
                  stringBuilder.append("U"); j++;
              }
              else if(j==mass.length-1& i!=0){
                  for(int h=i;h>0;h--)
                  stringBuilder.append("R");
              }
              else if(mass[j+1][i]>=mass[j][i-1]){
                  stringBuilder.append("U");

              }
              else { stringBuilder.append("R"); i--; j--;}

          }


        return stringBuilder;
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
        //int[][] mass={{6,0,8},{5,4,0},{3,5,1},{7,6,7},{2,3,8}};
          HashMap d=logicCouth(massFineshed);
        StringBuilder stringBuilder=(StringBuilder) d.get("StepWay");

        System.out.println((int)d.get("MaxSum")+" Путь: "+stringBuilder.reverse().toString());

        // int[][] mass={{1,2,6,3},{7,2,4,8},{5,0,9,6,},{4,7,1,2},{10,3,0,2}};//Можно запихнуть в двемерный массив массивы
        // разной длинны пример выше


    }
}
