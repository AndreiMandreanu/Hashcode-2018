import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Simulation{

  private final List<Vehicle> vehicles;
  private final List<Ride> rides;
  private final int bonus;
  private final int numberOfSteps;
  private int currentStep = 0;
  private final int width;
  private final int heigth;

  class RideComparator implements Comparator<Ride> {

    @Override
    public int compare(Ride o1, Ride o2) {
      return Integer.compare(o1.getEarliestStart(), o2.getEarliestStart());
    }
  }

  public Simulation(List<Vehicle> vehicles, List<Ride> rides,
      int width, int height, int bonus, int numberOfSteps){
    this.vehicles = vehicles;
    this.rides = rides;
    this.bonus = bonus;
    this.numberOfSteps = numberOfSteps;
    this.width = width;
    this.heigth = height;
    rides.sort(new RideComparator());
    assignRides();
  }

  public void assignRides() {
    while(!rides.isEmpty()) {
      assignRide();
    }
  }
  


    private int distance(Position s, Position f){
    return Math.abs(s.getX() - f.getX()) + Math.abs(s.getY() - f.getY());
    }

  private Vehicle getClosestVehicle(Position position, List<Vehicle> vehicles){
    int smallestDistance = Integer.MAX_VALUE;
    Vehicle closest = null;
    for (Vehicle c: vehicles){
      int newDistance = distance(c.getCurrPosition(), position);
      if (newDistance <= smallestDistance){
        smallestDistance = newDistance;
        closest = c;
      }
    }
    return closest;
  }

  public void assignRide() {
    Ride ride = rides.get(0);
    rides.remove(ride);
    List<Vehicle> availableVehicles = getAvailableVehicles(ride);
    getClosestVehicle(ride.getStartIntersection(), availableVehicles).addRide(ride);
  }

  private List<Vehicle> getAvailableVehicles(Ride ride) {
    List <Vehicle> availableVehicles = new ArrayList<>();
    int startTime = ride.getEarliestStart();
    int endTime = ride.getLatestFinish();
    Position startPos = ride.getStartIntersection();
    Position endPos = ride.getStartIntersection();
    for(Vehicle v : vehicles) {
      if(v.getEarliestFinishTime() <= endTime - distance(startPos, endPos) - distance(v.getCurrPosition(), startPos)) {
        availableVehicles.add(v);
      }
    }
    return availableVehicles;
  }

  public List<Vehicle> getVehicles() {
    return vehicles;
  }
}
