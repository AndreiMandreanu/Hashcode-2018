import java.util.LinkedList;
import java.util.List;

public class Vehicle {

  private int earliestFinishTime;
  private List<Ride> rides;
  private Position currPosition;

  public Vehicle() {
    earliestFinishTime = 0;
    rides = new LinkedList<>();
  }

  public void addRide(Ride ride) {
    Position currentPosition;
    if (rides.isEmpty()) {
      currentPosition = new  Position(0,0);
    } else {
      Ride lastRide = rides.get(rides.size() - 1);
      currentPosition = lastRide.getEndIntersection();
    }
      Position rideStartIntersection = ride.getStartIntersection();
      Position rideEndIntersection = ride.getEndIntersection();
      int distanceFromLastRide = Math.abs(rideStartIntersection.getY() -
          currentPosition.getY()) + Math.abs(rideStartIntersection.getX() -
          currentPosition.getX());
      int rideDistance =
          Math.abs(rideEndIntersection.getY() - rideStartIntersection.getY())
              + Math
              .abs(rideEndIntersection.getX() - rideStartIntersection.getX());
      earliestFinishTime = Math.max(earliestFinishTime + distanceFromLastRide,
          ride.getEarliestStart()) + rideDistance;
      rides.add(ride);
  }

  public int getEarliestFinishTime() {
    return earliestFinishTime;
  }

  public List<Ride> getRides() {
    return rides;
  }

  public Position getCurrPosition() {
    return rides.get(rides.size()-1).getEndIntersection();
  }

}

