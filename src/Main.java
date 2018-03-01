import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {



    public static void main(String[] args) {
        if (args.length == 0){
            throw new IllegalArgumentException("Wrong number of args. Need an input file");
        }
        else {
            BufferedReader reader = null;
            int R, C, F, N, B, T;
            int a, b, x, y, s, f;
            try {
                File file = new File(args[0]);
                reader = new BufferedReader(new FileReader(file));
                String firstLine = reader.readLine();
                String[] split = firstLine.split(" ");
                R = Integer.parseInt(split[0]);
                C = Integer.parseInt(split[1]);
                F = Integer.parseInt(split[2]);
                N = Integer.parseInt(split[3]);
                B = Integer.parseInt(split[4]);
                T = Integer.parseInt(split[5]);

                List<Ride> rides = new ArrayList<>();
                List<Vehicle> cars;
                String line;
                for (int i = 0; i < N; i++){
                    line = reader.readLine();
                    String[] arg = line.split(" ");
                    a = Integer.parseInt(arg[0]);
                    b = Integer.parseInt(arg[1]);
                    x = Integer.parseInt(arg[2]);
                    y = Integer.parseInt(arg[3]);
                    s = Integer.parseInt(arg[4]);
                    f = Integer.parseInt(arg[5]);
                    Position start = new Position(a, b);
                    Position finish = new Position(x, y);
                    Ride ride = new Ride(start, finish, s, f);
                    rides.add(ride);
                }

                cars = IntStream.range(0, F).mapToObj(i -> new Vehicle()).collect(Collectors.toList());
                Simulation simulation = new Simulation(cars, rides, R, C, B, T);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert reader != null;
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
