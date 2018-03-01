public class Simulation {

  private final List<Car> cars;
  private final List<Ride> rides;
  private final int bonus;
  private final int numberOfSteps;
  private int currentStep;
  private final int width;
  private final int heigth;



  public Simulation(List<Car> cars, List<Ride> rides, int width, int height, int bonus, int numberOfSteps){
    this.cars = cars;
    this.rides = rides;
    this.bonus = bonus;
    this.numberOfSteps = numberOfSteps;
    this.currentStep = 0;
    this.width = width;
    this.heigth = height;
  }

}
