import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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


                String line;
                while ((line = reader.readLine()) != null) {
                    String[] arg = line.split(" ");
                    a = Integer.parseInt(arg[0]);
                    b = Integer.parseInt(arg[1]);
                    x = Integer.parseInt(arg[2]);
                    y = Integer.parseInt(arg[3]);
                    s = Integer.parseInt(arg[4]);
                    f = Integer.parseInt(arg[5]);
                    
                }

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
