import java.util.LinkedList;
import java.util.List;

public class Vehicle {

  private int earliestFinishTime;
  private List<Ride> rides;

  public Vehicle() {
    earliestFinishTime = 0;
    rides = new LinkedList<>();
  }

  public void addRide(Ride ride) {
    rides.add(ride);
    Position startIntersection = ride.getStartIntersection();
    Position endIntersection = ride.getEndIntersection();
    int distance = Math.abs(endIntersection.getY() - startIntersection.getY())
        + Math.abs(endIntersection.getX() - startIntersection.getX());

  }

  public int getEarliestFinishTime() {
    return earliestFinishTime;
  }

  public List<Ride> getRides() {
    return rides;
  }

  public boolean isAvailable(int time) {
    for (Ride ride : rides) {
      Position startIntersection = ride.getStartIntersection();
      Position endIntersection = ride.getEndIntersection();

    }
  }
}
