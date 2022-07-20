import java.util.Arrays;
import java.util.List;

public class MarsRover {

    public String run(String input) {
        String out = "";

        String[] lines = input.split("\n");

        int numberOfRovers = (lines.length - 1) / 2;

        for (int i = 0; i < numberOfRovers; i++) {
            int positionLineIndex = i * 2 + 1;
            int commandLineIndex = positionLineIndex + 1;

            int xWidth, yWidth;

            try {
                String[] split = lines[positionLineIndex].split(" ");

                xWidth = Integer.parseInt(split[0]);
                yWidth = Integer.parseInt(split[1]);
            } catch (RuntimeException e) {
                throw new IllegalArgumentException("Could not parse position from: " + lines[positionLineIndex]);
            }

            int[] position = new int[]{xWidth, yWidth};

            String direction;

            try {
                direction = lines[positionLineIndex].split(" ")[2];
                if (!Arrays.asList("N", "E", "S", "W").contains(direction)) {
                    throw new IllegalArgumentException();
                }
            } catch (RuntimeException e) {
                throw new IllegalArgumentException("Could not parse direction from: " + lines[positionLineIndex]);
            }

            String[] commandArray = lines[commandLineIndex].split("(?!^)");

            List<String> validCommands = Arrays.asList("L", "R", "M");
            for (String command : commandArray) {
                if (!validCommands.contains(command)) {
                    throw new IllegalArgumentException("Invalid command sequence: " + lines[commandLineIndex]);
                }
            }

            for (String command : commandArray) {
                if (command.equals("M")) {
                    int[] newPosition = position;

                    if (direction.equals("N")) {
                        newPosition[1] += +1;
                    } else if (direction.equals("S")) {
                        newPosition[1] += -1;
                    } else if (direction.equals("E")) {
                        newPosition[0] += +1;
                    } else if (direction.equals("W")) {
                        newPosition[0] += -1;
                    }

                    position = newPosition;
                } else if (command.equals("R")) {
                    List<String> all = Arrays.asList("N", "E", "S", "W");
                    direction = all.get((all.indexOf(direction) + 1) % all.size());
                } else if (command.equals("L")) {
                    List<String> all = Arrays.asList("N", "E", "S", "W");
                    direction = all.get((all.indexOf(direction) + 3) % all.size());
                }
            }

            out += position[0] + " " + position[1] + " " + direction + "\n";
        }

        return out;
    }

}
