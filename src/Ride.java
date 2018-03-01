public class Ride {

  private final Position startIntersection;
  private final Position endIntersection;
  private final int earliestStart;
  private final int latestFinish;
  private final int id;
  private int idCounter = 0;

  public Ride(Position startIntersection, Position endIntersection,
      int earliestStart, int latestFinish) {
    this.startIntersection = startIntersection;
    this.endIntersection = endIntersection;
    this.earliestStart = earliestStart;
    this.latestFinish = latestFinish;
    this.id = idCounter;
    idCounter++;
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


  public int getId() {
    return id;
  }
}
