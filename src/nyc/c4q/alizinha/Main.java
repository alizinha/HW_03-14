
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


        System.out.println("You've awoken in bed in an apartment that you don't quite recognize.\n " +
                "In fact, you're kind of unsure of what day it is and even who you are. Go ahead\n" +
                " and explore to see what you can discover.");


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

    public static void sayTheWords(int xCoord, int yCoord){

        if (xCoord == 7 && yCoord == 3){
            System.out.println("You stepped on the cat!");
        } else if(xCoord == 2 && yCoord == 6 ){
            System.out.println("On the nightstand there's a copy of The Bible.");
        } else if(xCoord == 3 && yCoord == 3 ){
            System.out.println("You're in the bathroom. Take your time.");
        } else if(xCoord == 1 && yCoord == 3 ){
            System.out.println("You've opened the closet. It's full of suits.");
        } else if(xCoord == 3 && yCoord == 5 ){
            System.out.println("You've opened the hamper. It contains a sundress.");
        } else if(xCoord == 5 && yCoord == 5 ){
            System.out.println("You're at the bookshelf. None of the books are in English.");
        } else if(xCoord == 5 && yCoord == 3 ){
            System.out.println("You're at the computer. It's a Mac but no internet. :( ");
        } else if(xCoord == 5 && yCoord == 6 ){
            System.out.println("You're at the TV. It only has Netflix.");
        } else if(xCoord == 7 && yCoord == 6 ){
            System.out.println("You're at the chair. It's made of fine Corinthian leather.");
        } else if(xCoord == 11 && yCoord == 6 ){
            System.out.println("You're in the fridge. There's only Diet Coke & mustard.");
        } else if(xCoord == 12 && yCoord == 4 ){
            System.out.println("You're at the stove. It's got a pot of spaghetti on it.");
        } else if(xCoord == 12 && yCoord == 1 ){
            System.out.println("You're at the dining room table. Buried under lots of paper are the house keys.");
        } else if(xCoord == 12 && yCoord == 6 ){
            System.out.println("You're at the kitchen counter. There's a stack of mail on it.");
        } else if(xCoord == 1 && yCoord == 6 ){
            System.out.println("You're back in bed. You could just take another nap.");
        } else if(xCoord == 3 && yCoord == 6 ){
            System.out.println("You're in the dresser: lacy underthings and boxers, mostly.");
        } else if(xCoord == 7 && yCoord == 5 ){
            System.out.println("You're on the couch. Check the cushions for loose change.");
        } else if(xCoord == 9 && yCoord == 7 ){
            System.out.println("You're at the door but you can't leave yet because you haven't found the key!");

        }




    }

    public static boolean searchForKey(int xCoord,int yCoord){
        if (xCoord == 12 && yCoord == 1){
            System.out.println("You found the key! You can now leave the apartment!!");
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {


        int currentXposition=1;
        int currentYposition=6;
        String currentDirection = "up";
        String convertedCommand = "";
        boolean isKeyFound = false;
        String command = "";


        drawMap(1, 6, currentDirection);

        while (!command.equals("quit")){
            System.out.println("Where do you want to go? (Type the 'e' key to go up, the 'x' key to go down the 'd' key to go right, the 's' key to go left.)");
            Scanner input = new Scanner(System.in);
            command = input.next();

            if (!command.equals("e") && !command.equals("x") && !command.equals("d") && !command.equals("s")){
                System.out.println("invalid command");
                continue;

            }


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

                if(drawMap(currentXposition, currentYposition - 1, currentDirection)){
                    currentYposition--;
                    if(currentXposition == 9 && currentYposition == 7 && isKeyFound){
                        System.out.println("goodbye");
                        break;
                    }
                    sayTheWords(currentXposition,currentYposition);
                    if (!isKeyFound) {
                        isKeyFound = searchForKey(currentXposition, currentYposition);
                    }                }else{
                    System.out.println("Invalid Move In +Y direction");
                }
            }
            else if (currentDirection.equals("down")) {

                if(drawMap(currentXposition,currentYposition+1,currentDirection)){
                    currentYposition++;
                    if(currentXposition == 9 && currentYposition == 7 && isKeyFound){
                        System.out.println("goodbye");
                        break;
                    }
                    sayTheWords(currentXposition,currentYposition);
                    if (!isKeyFound) {
                        isKeyFound = searchForKey(currentXposition, currentYposition);
                    }                }else{
                    System.out.println("Invalid Move In -Y direction");
                }
            }
            else if (currentDirection.equals("left")) {

                if(drawMap(currentXposition-1,currentYposition,currentDirection)){
                    currentXposition--;
                    if(currentXposition == 9 && currentYposition == 7 && isKeyFound){
                        System.out.println("Hooray! You can leave since you have the key!");
                        break;
                    }
                    sayTheWords(currentXposition,currentYposition);
                    if (!isKeyFound) {
                        isKeyFound = searchForKey(currentXposition, currentYposition);
                    }                }else{
                    System.out.println("Invalid Move In -X direction");
                }
            }
            else if (currentDirection.equals("right")) {

                if(drawMap(currentXposition+1,currentYposition,currentDirection)){
                    currentXposition++;

                    if(currentXposition == 9 && currentYposition == 7 && isKeyFound){
                        System.out.println("Hooray! You can leave since you have the key!");
                        break;
                    }
                    sayTheWords(currentXposition,currentYposition);
                    if (!isKeyFound) {
                        isKeyFound = searchForKey(currentXposition, currentYposition);
                    }
                }else{
                    System.out.println("Invalid Move In +X direction");
                }
            }


            if(currentXposition == 9 && currentYposition == 7 && isKeyFound){
                System.out.println("Hooray! You can leave since you have the key!");
                break;
            }

        }

        System.out.println("gameover!");




    }



}




