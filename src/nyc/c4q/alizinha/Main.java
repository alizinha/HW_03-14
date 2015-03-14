
package nyc.c4q.alizinha;

import sun.plugin.cache.CacheUpdateHelper;

import java.util.Scanner;

/**
 * Created by c4q-Allison on 3/13/15.
 */
public class Main {

    public static boolean drawMap(int xCoord, int yCoord, String direction) {
        final int WIDTH = 14;
        final int HEIGHT = 8;


        String aptArray[][] = {{ "  *  ", "  *  ", "  *  ", "  *  ", "  *  ", "  *  ", "  *  ", "  *  ", "  *  ", "  *  ", "  *  ", "  *  ", "  *  ", "  *  " },
                { "  *  ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", "  *  ", "     ", "tabl ", "  *  " },
                { "  *  ", "  *  ", "     ", "  *  ", "  *  ", "  *  ", "     ", "  *  ", "  *  ", "     ", "  *  ", "     ", "     ", "  *  " },
                { "  *  ", "clos ", "     ", "bath ", "  *  ", "comp ", "     ", "cat  ", "  *  ", "     ", "  *  ", "     ", "  *  ", "  *  " },
                { "  *  ", "     ", "     ", "     ", "  *  ", "     ", "     ", "     ", "  *  ", "     ", "  *  ", "     ", "stov ", "  *  " },
                { "  *  ", "     ", "     ", "hamp ", "  *  ", "book ", "  *  ", "couc ", "  *  ", "     ", "     ", "     ", "     ", "  *  " },
                { "  *  ", "bed  ", "nigh ", "dres ", "  *  ", "TV   ", "     ", "chai ", "  *  ", "     ", "  *  ", "frid ", "coun ", "  *  " },
                { "  *  ", "  *  ", "  *  ", "  *  ", "  *  ", "  *  ", "  *  ", "  *  ", "  *  ", "door ", "  *  ", "  *  ", "  *  ", "  *  " }};


        if (xCoord > WIDTH-1 || yCoord > HEIGHT-1){
            return false;
        }

        if (aptArray[yCoord][xCoord].equals("  *  ")){
            return false;
        }

        String specialChar = "";
        if (direction.equals("up") ){
            specialChar = "^";
        }
        else if (direction.equals("down") ){
            specialChar = "v";
        }
        else if (direction.equals("left") ){
            specialChar = "<";
        }
        else if (direction.equals("right") ){
            specialChar = ">";
        }
        else {
            return false;
        }
        aptArray[yCoord][xCoord] = aptArray[yCoord][xCoord].substring(0, 2) + specialChar + aptArray[yCoord][xCoord].substring(3, 5);

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++){
                System.out.print(aptArray[i][j]);
            }
            System.out.println();

        }

        return true;


    }



    public static void main(String[] args) {


        int currentXposition=1;
        int currentYposition=6;
        String currentDirection = "up";
        String convertedCommand = "";

        String command = "";


        drawMap(1, 6, currentDirection);

        while (!command.equals("quit")){
            System.out.println("Where do you want to go? (Type the 'e' key to go up, the 'x' key to go down, the 'd' key to go right, the 's' key to go left.)");
            Scanner input = new Scanner(System.in);
            command = input.next();

            if (!command.equals("e") && !command.equals("x") && !command.equals("d") && !command.equals("s")){
                System.out.println("invalid command");
                continue;

            }

            System.out.println("Command is good.");

            if(command.equals("e")) {
                convertedCommand = "up";
            }else if (command.equals("x")){
                convertedCommand = "down";
            }else if (command.equals("d")){
                convertedCommand = "right";
            } else if (command.equals("s")){
                convertedCommand = "left";
            }

            if (!convertedCommand.equals(currentDirection)){
                currentDirection=convertedCommand;
                System.out.println("Changing orientation to:" + currentDirection);
                drawMap(currentXposition,currentYposition,currentDirection);
                continue;
            }

            if (currentDirection.equals("up")) {

                if(drawMap(currentXposition,currentYposition-1,currentDirection)){
                    currentYposition--;
                }else{
                    System.out.println("Invalid Move In +Y direction");
                }
            }
            else if (currentDirection.equals("down")) {

                if(drawMap(currentXposition,currentYposition+1,currentDirection)){
                    currentYposition++;
                }else{
                    System.out.println("Invalid Move In -Y direction");
                }
            }
            else if (currentDirection.equals("left")) {

                if(drawMap(currentXposition-1,currentYposition,currentDirection)){
                    currentXposition--;
                }else{
                    System.out.println("Invalid Move In -X direction");
                }
            }
            else if (currentDirection.equals("right")) {

                if(drawMap(currentXposition+1,currentYposition,currentDirection)){
                    currentXposition++;
                }else{
                    System.out.println("Invalid Move In +X direction");
                }
            }


        }




    }



}




