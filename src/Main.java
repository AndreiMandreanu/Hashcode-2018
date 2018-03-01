import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static Simulation simulation;
    static int idCounter = 0;
    public static void main(String[] args) {
        if (args.length == 0){
            throw new IllegalArgumentException("Wrong number of args. Need an input file");
        }
        else {
            readIn(args[0]);
        }
    }

    private static void readIn(String loc){
        BufferedReader reader = null;
        int R, C, F, N, B, T;
        int a, b, x, y, s, f;
        try {
            File file = new File(loc);
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
                Ride ride = new Ride(start, finish, s, f, idCounter);
                idCounter++;
                rides.add(ride);
            }

            cars = IntStream.range(0, F).mapToObj(i -> new Vehicle()).collect(Collectors.toList());
            simulation = new Simulation(cars, rides, R, C, B, T);
            writeOut();
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


    private static void writeOut(){
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("output.out"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Vehicle> vehicles = simulation.getVehicles();
        for(Vehicle v : vehicles){
            StringBuilder rideNos = new StringBuilder();
            List<Ride> rideNumbers = v.getRides();
            for(Ride r: rideNumbers){
                rideNos.append(r.getId()).append(" ");
            }
            assert bufferedWriter != null;
            try {
                bufferedWriter.write(v.getRides().size() + " " + rideNos + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
