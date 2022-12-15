import java.util.Scanner;

public class Main {
    public static int inputMonth() {
        Scanner scan = new Scanner(System.in);
        System.out.print("introduisez le mois : ");
        int month = scan.nextInt();
        if (month > 12 || month < 1) {
            throw new RuntimeException("mois inexistant");
        }
        else return month;
    }

    public static int inputYear() {
        Scanner scan = new Scanner(System.in);
        System.out.print("introduisez l'année : ");
        return scan.nextInt();
    }

    public static String stringMonth(int intMonth) {
        String[] month = {"janvier","fervrier","mars","avril","mai","juin","juillet","aout","septembre","octobre","novembre","decembre"};
        return month[intMonth-1];
    }

    public static void line() {System.out.println("===========================");}

    public static void printDays() {
        System.out.println("Lun Mar Mer Jeu Ven Sam Dim");
    }

    public static int firstDay(int month,int year) {
        int yr = year;
        if (month == 1 || month == 2) yr = year-1;
        int q = 1;
        int j = yr/100;
        int k = yr%100;
        int m;
        if (month == 1) m = 13;
            else if (month == 2) m = 14;
                else m = month;
        return (q + ( ((m+1)*13) / 5) + k + (k/4) + (j/4) + (5*j) ) % 7;
    }


    public static void emptySlot(int firstDay) {
        int[] spaceArray = {5,6,0,1,2,3,4};
        String space = "   ";
        String betweenSpace = " ";
        for (int i = 0; i < spaceArray[firstDay];++i){
            System.out.print(space);
            System.out.print(betweenSpace);
        }
    }
    public static int monthSize(int month,boolean bissextiles) {
        int res = 0;
        int[] monthtrenteun = {1,3,5,7,8,10,12};
        int[] monthtrente = {4,6,9,11};
        for (int i = 0; i <= 6 ; ++i){
            if (month == monthtrenteun[i]) {
                res = 31;
                break;
            }
        }
        for (int i = 0; i <= 3 ; ++i){
            if (month == monthtrente[i]) {
                res = 30;
                break;
            }
        }
        if (month == 2 && bissextiles) res = 29;
        else if (month == 2) res = 28;
        return res;
    }

    public static void printDates(int firstDay,int monthSize) {
        int j = firstDay;
        for (int i = 1; i <= monthSize;++i){
            if(j == 2) {
                System.out.println();
            }
            if(i<10){
                System.out.print("0"+ i + "  ");
            }
            else System.out.print(i + "  ");
            ++j;
            if (j == 7){
                j = 0;
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int intMonth = inputMonth();
        int year = inputYear();
        int firstday = firstDay(intMonth,year);
        boolean bissextiles = ( ( (year % 4 == 0) && (year % 100 != 0) ) ^ (year % 400 == 0) ) ;
        System.out.println();
        int monthsize = monthSize(intMonth,bissextiles);
        String stringMonth = stringMonth(intMonth);
    //entête
        line();
        System.out.printf(stringMonth +" "+ year);
        System.out.println();
        line();
    //jr de la semaine
        printDays();
    //dates
        emptySlot(firstday);
        printDates(firstday,monthsize);
        line();
    }
}