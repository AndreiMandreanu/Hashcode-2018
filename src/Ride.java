public class Ride {

  private final Position startIntersection;
  private final Position endIntersection;
  private final int earliestStart;
  private final int latestFinish;

  public Ride(Position startIntersection, Position endIntersection,
      int earliestStart, int latestFinish) {
    this.startIntersection = startIntersection;
    this.endIntersection = endIntersection;
    this.earliestStart = earliestStart;
    this.latestFinish = latestFinish;
  }


  public int getEarliestStart() {
    return earliestStart;
  }

  public int getLatestFinish() {
    return latestFinish;
  }

  public Position getStartIntersection() {
    return startIntersection;
  }

  public Position getEndIntersection() {
    return endIntersection;
  }


}
