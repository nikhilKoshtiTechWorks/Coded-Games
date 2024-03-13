import java.util.Scanner;

public class ticTacToe {
    public static boolean isWinner(int x, int y, String[][] array, String mySign){
        int count = 0;
        // for horizontal line
        for(int i = 0; i<array.length; i++){
            if(array[x][i]==mySign){
                count++;
            }
        } if(count==3){return true;}

        // for vertical line
        count = 0;
        for(int i = 0; i<array.length; i++){
            if(array[i][y]==mySign){
                count++;
            }
        } if(count==3){return true;}

        // for left to right diagonal
        // upper left (row and col both decreases)
        count = 0;
        int r = x;
        for(int c = y; r>=0 && c>=0; c--, r--){       // here && is added to avoid the condition (0,-1) as -1 < 0 result of true && false = false : it will check the next condition for upper right
            if(array[r][c] == mySign){
                count++;
            }
        }
        // lower right (row and col both increases)
        r = x+1;
        for(int c = y+1; c<array.length && r<array.length; c++, r++){
            if(array[r][c] == mySign){
                count++;
            }
        } if(count==3){return true;}

        // for right to left daigonal
        // upper right (row decrease & col increase)
        count = 0;
        r = x;
        for(int c = y; c<array.length && r>=0; c++, r--){
            if(array[r][c] == mySign){
                count++;
            }
        }
        // lower left (row increase & col decrease)
        r = x+1;
        for(int c = y-1; c>=0 && r<array.length; c--, r++){
            if(array[r][c] == mySign){
                count++;
            }
        } if(count==3){return true;}

        return false; 
    }

    public static void printArray(String[][] array){
        for(int i = 0; i<array.length; i++){
            for(int j = 0; j<array.length; j++){
                System.out.print(array[i][j] + " ");
            }System.out.println();
        }
    }

    public static void fillArray(String[][] array){
        for(int i = 0; i<array.length; i++){
            for(int j = 0; j<array.length; j++){
                array[i][j] = ".";
            }
        }
    }

    public static void main(String[] args) {
        String array[][] = new String[3][3];
        fillArray(array);

        Scanner scan = new Scanner(System.in);
        int x,y;
        for(int i = 0; i<array.length; i++){
            for(int j = 0; j<array.length; j++){
                if((i+j)%2==0){
                    printArray(array);
                    System.out.print("Give co-ordiantes of 'X':");
                    x = scan.nextInt();
                    y = scan.nextInt();
                    array[x][y] = "X";
                    boolean result = isWinner(x, y, array, "X");
                    if(result==true) {
                        System.out.println("X is a WINNER!!!");
                        i = array.length+1;
                        j = array.length+1;
                    }
                    
                } else {
                    printArray(array);
                    System.out.print("Give co-ordiantes of 'O':");
                    x = scan.nextInt();
                    y = scan.nextInt();
                    array[x][y] = "O";
                    boolean result = isWinner(x, y, array, "O");
                    if(result==true) {
                        System.out.println("O is a WINNER!!!");
                        i = array.length+1;
                        j = array.length+1;
                    }
                }
                
            }
        }

        printArray(array);

        scan.close();
    }
}
