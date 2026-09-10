import java.util.Scanner;

public class RobotMovement {

    public static String moveRobot(int input1, int input2,
                                   String input3, String input4) {

        String[] position = input3.split("-");

        int x = Integer.parseInt(position[0]);
        int y = Integer.parseInt(position[1]);
        String direction = position[2];

        String[] commands = input4.split(" ");

        boolean error = false;

        for (String command : commands) {

            if (command.equals("R")) {

                if (direction.equals("N"))
                    direction = "E";
                else if (direction.equals("E"))
                    direction = "S";
                else if (direction.equals("S"))
                    direction = "W";
                else
                    direction = "N";

            } else if (command.equals("L")) {

                if (direction.equals("N"))
                    direction = "W";
                else if (direction.equals("W"))
                    direction = "S";
                else if (direction.equals("S"))
                    direction = "E";
                else
                    direction = "N";

            } else if (command.equals("M")) {

                int newX = x;
                int newY = y;

                if (direction.equals("N"))
                    newY++;
                else if (direction.equals("S"))
                    newY--;
                else if (direction.equals("E"))
                    newX++;
                else if (direction.equals("W"))
                    newX--;

                if (newX < 0 || newX > input1 ||
                    newY < 0 || newY > input2) {

                    error = true;
                    break;
                }

                x = newX;
                y = newY;
            }
        }

        String result = x + "-" + y + "-" + direction;

        if (error)
            result += "-ER";

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter grid size X: ");
        int x = sc.nextInt();

        System.out.print("Enter grid size Y: ");
        int y = sc.nextInt();

        System.out.print("Enter starting position: ");
        String position = sc.next();

        sc.nextLine();

        System.out.print("Enter instructions: ");
        String instructions = sc.nextLine();

        System.out.println("Final position: "
                + moveRobot(x, y, position, instructions));

        sc.close();
    }
}