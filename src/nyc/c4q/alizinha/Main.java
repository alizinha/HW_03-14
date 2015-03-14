
package nyc.c4q.alizinha;

/**
 * Created by c4q-Allison on 3/13/15.
 */
public class Main {g

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
        System.out.println(drawMap(3, 1, "left"));


    }



}




