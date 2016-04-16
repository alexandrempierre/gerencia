package br.ufrj.dcc.gerencia.domain.entities;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/14/16.
 */

@Component
public class SambaInfo extends LCIModel implements Cloneable {

  private Integer uidNumber;
  private Integer sambaNextRid;
  private String sambaSID;

  public Integer getUidNumber() {
    return uidNumber;
  }

  public void setUidNumber(Integer uidNumber) {
    this.uidNumber = uidNumber;
  }

  public void incrementUidNumber(){
    this.uidNumber++;
  }

  public Integer getSambaNextRid() {
    return sambaNextRid;
  }

  public void setSambaNextRid(Integer sambaNextRid) {
    this.sambaNextRid = sambaNextRid;
  }

  public void incrementSambaNextRid(){
    this.sambaNextRid++;
  }

  public String getSambaSID() {
    return sambaSID;
  }

  public void setSambaSID(String sambaSID) {
    this.sambaSID = sambaSID;
  }

  @Override
  public SambaInfo clone() throws CloneNotSupportedException {
    return (SambaInfo) super.clone();
  }
}
