import java.util.ArrayList;
import java.util.List;

public class Simulation {

  private final List<Vehicle> vehicles;
  private final List<Ride> rides;
  private final int bonus;
  private final int numberOfSteps;
  private int currentStep = 0;
  private final int width;
  private final int heigth;



  public Simulation(List<Vehicle> vehicles, List<Ride> rides,
      int width, int height, int bonus, int numberOfSteps){
    this.vehicles = vehicles;
    this.rides = rides;
    this.bonus = bonus;
    this.numberOfSteps = numberOfSteps;
    this.width = width;
    this.heigth = height;
  }

  public void assignRide() {
    Ride ride = rides.get(0);
    rides.remove(ride);
    List<Vehicle> availableVehicles = getAvailableVehicles(ride);

    getClosestVehicle(availableVehicles, position).getRides.add(ride);
  }

  public List<Vehicle> getAvailableVehicles(Ride ride) {
    List <Vehicle> availableVehicles = new ArrayList<>();
    int startTime = ride.getStartTime();
    int endTime = ride.getEndTime();
    Position startPos = ride.getStartPos();
    Position endPos = ride.getEndPos();
    for(Vehicle v : vehicles) {
      if(v.whenFree() <= endTime - distance(startPos, endPos) - v.getPosition(v.whenFree)) {
        availableVehicles.add(v);
      }
    }
    return availableVehicles;
  }




}
