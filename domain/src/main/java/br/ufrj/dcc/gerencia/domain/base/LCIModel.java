package br.ufrj.dcc.gerencia.domain.base;

import javax.naming.Name;

/**
 * Created by fausto on 4/3/16.
 */

public abstract class LCIModel {

  private String id;
  private boolean saved;
  private Integer createdAt;
  private Integer updatedAt;

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

  public Integer getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Integer updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Integer getCreatedAt() {

    return createdAt;
  }

  public void setCreatedAt(Integer createdAt) {
    this.createdAt = createdAt;
  }
}


