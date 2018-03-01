import java.util.List;

public class Vehicle {

  private final int currTime;
  private final List<Ride> rides;
  private Position currPosition;

  public Vehicle(List<Ride> rides) {
    this.rides = rides;
    currPosition = new Position(0, 0);
    currTime = 0;
  }

  public Position getCurrPosition() {
    return currPosition;
  }


}
