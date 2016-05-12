package br.ufrj.dcc.gerencia.domain.base;

/**
 * Created by fausto on 4/3/16.
 */

public abstract class LCIModel {

  private String id;
  private boolean saved;
  private Long createdAt;
  private Long updatedAt;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isSaved() {
    return saved;
  }

  public void setSaved(boolean saved) {
    this.saved = saved;
  }

  public Long getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Long updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "LCIModel{" +
      "id='" + id + '\'' +
      ", saved=" + saved +
      ", createdAt=" + createdAt +
      ", updatedAt=" + updatedAt +
      '}';
  }
}


