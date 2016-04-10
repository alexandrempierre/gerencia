package br.ufrj.dcc.gerencia.domain.entities;

/**
 * Created by fausto on 4/10/16.
 */
public class ShadowObj {
  private Integer shadowExpire;
  private Integer shadowFlag;
  private Integer shadowInactive;
  private Integer shadowLastChange;
  private Integer shadowMax;
  private Integer shadowMin;
  private Integer shadowWarning;

  public ShadowObj() {
  }

  public ShadowObj(Integer shadowExpire, Integer shadowFlag, Integer shadowInactive, Integer shadowLastChange, Integer shadowMax, Integer shadowMin, Integer shadowWarning) {
    this.shadowExpire = shadowExpire;
    this.shadowFlag = shadowFlag;
    this.shadowInactive = shadowInactive;
    this.shadowLastChange = shadowLastChange;
    this.shadowMax = shadowMax;
    this.shadowMin = shadowMin;
    this.shadowWarning = shadowWarning;
  }

  public Integer getShadowExpire() {
    return shadowExpire;
  }

  public void setShadowExpire(Integer shadowExpire) {
    this.shadowExpire = shadowExpire;
  }

  public Integer getShadowFlag() {
    return shadowFlag;
  }

  public void setShadowFlag(Integer shadowFlag) {
    this.shadowFlag = shadowFlag;
  }

  public Integer getShadowInactive() {
    return shadowInactive;
  }

  public void setShadowInactive(Integer shadowInactive) {
    this.shadowInactive = shadowInactive;
  }

  public Integer getShadowLastChange() {
    return shadowLastChange;
  }

  public void setShadowLastChange(Integer shadowLastChange) {
    this.shadowLastChange = shadowLastChange;
  }

  public Integer getShadowMax() {
    return shadowMax;
  }

  public void setShadowMax(Integer shadowMax) {
    this.shadowMax = shadowMax;
  }

  public Integer getShadowMin() {
    return shadowMin;
  }

  public void setShadowMin(Integer shadowMin) {
    this.shadowMin = shadowMin;
  }

  public Integer getShadowWarning() {
    return shadowWarning;
  }

  public void setShadowWarning(Integer shadowWarning) {
    this.shadowWarning = shadowWarning;
  }
}
