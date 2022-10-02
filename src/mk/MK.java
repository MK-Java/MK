
package mk;

public class MK {
    public static void main(String[] args) {
//        System.out.println("PI : "+Math.PI);
//        for (int i = 2000000; i < 10000000; i++) {
//            double temp = calculatePI(i);
//            if (i%2==0 && temp > Math.PI) {
//                System.out.println("At Term :" + i + " Approximate PI value is : " + temp);
//                break;
//            }
//             if(i!=2 && i%2==1 && temp> Math.PI) {
//                System.out.println("At Term :" + i + " Approximate PI value is : " + temp);
//                break;
//            }
            
//        }
//        double PI = Math.PI, temp, approxPI = 0;
//        int startTerm = 500;
//        do {
//            temp = approxPI;
//            approxPI = calculatePI(startTerm);
//            startTerm++;
//        } while (approxPI <= PI);
//        System.out.println("At Term :" + (startTerm - 1) + " Approximate PI value is : " + (temp <= 0 ? approxPI : approxPI));
        
    System.out.println("\nEX-4");        

        System.out.println("Pi in Netbeans Java is - " + Math.PI);
//
//        double PI = Math.PI, temp, approxPI = 0;
//        int startTerm = 500;
//        do {
//            temp = approxPI;
//            approxPI = calculatePI(startTerm);
//            startTerm++;
//        } while (approxPI <= PI);
//        System.out.println("At Term :" + (startTerm - 1) + " Approximate PI value is : " + (temp <= 0 ? approxPI : approxPI));
//   
        long oddValue=1, temp=0,k=1;
        double pi = 0.0;
        do{
            double currentPI =0.0 ;
            if(k%2 != 0){
                currentPI = (double)4/oddValue;
            }
            else{
                currentPI = (double)-1*4/oddValue;
            }
            oddValue = oddValue+2;
            pi = pi+currentPI;
            temp= k;
            k++;
            if(pi >= Math.PI )
            break;            
            
        }while(true);
        System.out.println("Term : "+temp +" is the nearest value to PI ("+Math.PI +") => "+ pi);
//        int odd=1;
//        double pi = 0.0;
//        for(int i=1; i<=1000000;i++){
//            double currentValue = 0.0;
//            if(i%2 == 0){
//                currentValue = (double)-4/odd;
//            }
//            else{
//                currentValue = (double)4/odd;
//            }
//            odd = odd+2;
//            pi = pi+currentValue;
//        }
//        System.out.println(pi);        
    }
//        public static double calculatePI(int n) {
//        double pi = 0;
//        for (int i = 1; i < n; i++) {
//            pi = pi + (Math.pow(-1, i + 1) / (2 * i - 1));
//        }        
//        return 4 * pi;
//    }
}
