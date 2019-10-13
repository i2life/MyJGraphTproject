package bean;

public class Relation {
  private String relationType;
  private int relationYear;

  public Relation(String relationType, int relationYear)
  {
    this.relationType = relationType;
    this.relationYear = relationYear;
  }

  public String toString()
  {
    return relationType+":"+relationYear;
  }

  public String getRelationType() {
    return relationType;
  }

  public void setRelationType(String relationType) {
    this.relationType = relationType;
  }

  public int getRelationYear() {
    return relationYear;
  }

  public void setRelationYear(int relationYear) {
    this.relationYear = relationYear;
  }
}
