import java.util.List;

public class Simulation {

  private final List<Vehicle> cars;
  private final List<Ride> rides;
  private final int bonus;
  private final int numberOfSteps;
  private int currentStep;
  private final int width;
  private final int heigth;



  public Simulation(List<Vehicle> cars, List<Ride> rides, int width, int height, int bonus, int numberOfSteps){
    this.cars = cars;
    this.rides = rides;
    this.bonus = bonus;
    this.numberOfSteps = numberOfSteps;
    this.currentStep = 0;
    this.width = width;
    this.heigth = height;
  }


  private List<Vehicle> getAvailableVehicles(){
    for (Vehicle c : cars) {

    }}



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

}
