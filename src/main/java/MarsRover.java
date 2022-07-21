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

            Coordinate coordinate = getCoordinate(lines[positionLineIndex]);

            String direction = getDirection(lines[positionLineIndex]);
            Direction directionValue = Direction.valueOf(direction);
            Position roverPosition = new Position(coordinate, directionValue);

            String[] commandArray = getCommands(lines, commandLineIndex);

            out += executeCommands(roverPosition, commandArray);
        }

        return out;
    }

    private String executeCommands(Position initialPosition, String[] commandArray) {
        Position position = initialPosition;
        List<String> all = Arrays.asList("N", "E", "S", "W");
        for (String command : commandArray) {
            if (command.equals("M")) {
                Coordinate newCoordinate = position.getCoordinate().update(position.getDirection());
                position = new Position(newCoordinate, position.getDirection());
            } else if (command.equals("R")) {
                String newDirection = all.get((all.indexOf(position.getDirection().toString()) + 1) % all.size());
                position = new Position(position.getCoordinate(), Direction.valueOf(newDirection));
            } else if (command.equals("L")) {
                String newDirection = all.get((all.indexOf(position.getDirection().toString()) + 3) % all.size());
                position = new Position(position.getCoordinate(), Direction.valueOf(newDirection));
            }
        }
        return position.toString();
    }

    private String[] getCommands(String[] lines, int commandLineIndex) {
        String[] commandArray = lines[commandLineIndex].split("(?!^)");

        List<String> validCommands = Arrays.asList("L", "R", "M");
        for (String command : commandArray) {
            if (!validCommands.contains(command)) {
                throw new IllegalArgumentException("Invalid command sequence: " + lines[commandLineIndex]);
            }
        }
        return commandArray;
    }

    private String getDirection(String lines) {
        String direction;

        try {
            direction = lines.split(" ")[2];
            if (!Arrays.asList("N", "E", "S", "W").contains(direction)) {
                throw new IllegalArgumentException();
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Could not parse direction from: " + lines);
        }
        return direction;
    }

    private Coordinate getCoordinate(String lines) {
        int xWidth, yWidth;

        try {
            String[] split = lines.split(" ");

            xWidth = Integer.parseInt(split[0]);
            yWidth = Integer.parseInt(split[1]);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Could not parse position from: " + lines);
        }

        return new Coordinate(xWidth, yWidth);
    }

}
