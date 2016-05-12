package br.ufrj.dcc.gerencia.domain.entities;

/**
 * Created by fausto on 4/10/16.
 */
public class SambaObj {
  private String sambaSID;
  private String sambaAcctFlags;
  private Long sambaKickoffTime;
  private String sambaLMPassword;
  private String sambaNTPassword;
  private String sambaPrimaryGroupSID;
  private Long sambaPwdCanChange;
  private Long sambaPwdLastSet;
  private Long sambaPwdMustChange;
  private SambaInfo sambaInfo;

  public SambaObj(String sambaSID, String sambaAcctFlags, Long sambaKickoffTime, String sambaLMPassword, String sambaNTPassword, String sambaPrimaryGroupSID, Long sambaPwdCanChange, Long sambaPwdLastSet, Long sambaPwdMustChange) {
    this.sambaSID = sambaSID;
    this.sambaAcctFlags = sambaAcctFlags;
    this.sambaKickoffTime = sambaKickoffTime;
    this.sambaLMPassword = sambaLMPassword;
    this.sambaNTPassword = sambaNTPassword;
    this.sambaPrimaryGroupSID = sambaPrimaryGroupSID;
    this.sambaPwdCanChange = sambaPwdCanChange;
    this.sambaPwdLastSet = sambaPwdLastSet;
    this.sambaPwdMustChange = sambaPwdMustChange;
  }

  public SambaObj() {
  }

  public String getSambaSID() {
    return sambaSID;
  }

  public void setSambaSID(String sambaSID) {
    this.sambaSID = sambaSID;
  }

  public void setSambaSID(String sambaSIDBase, Integer sambaNextRid){
    this.setSambaSID(sambaSIDBase + "-" + sambaNextRid);
  }

  public String getSambaAcctFlags() {
    return sambaAcctFlags;
  }

  public void setSambaAcctFlags(String sambaAcctFlags) {
    this.sambaAcctFlags = sambaAcctFlags;
  }

  public Long getSambaKickoffTime() {
    return sambaKickoffTime;
  }

  public void setSambaKickoffTime(Long sambaKickoffTime) {
    this.sambaKickoffTime = sambaKickoffTime;
  }

  public String getSambaLMPassword() {
    return sambaLMPassword;
  }

  public void setSambaLMPassword(String sambaLMPassword) {
    this.sambaLMPassword = sambaLMPassword;
  }

  public String getSambaNTPassword() {
    return sambaNTPassword;
  }

  public void setSambaNTPassword(String sambaNTPassword) {
    this.sambaNTPassword = sambaNTPassword;
  }

  public String getSambaPrimaryGroupSID() {
    return sambaPrimaryGroupSID;
  }

  public void setSambaPrimaryGroupSID(String sambaPrimaryGroupSID) {
    this.sambaPrimaryGroupSID = sambaPrimaryGroupSID;
  }

  public Long getSambaPwdCanChange() {
    return sambaPwdCanChange;
  }

  public void setSambaPwdCanChange(Long sambaPwdCanChange) {
    this.sambaPwdCanChange = sambaPwdCanChange;
  }

  public Long getSambaPwdLastSet() {
    return sambaPwdLastSet;
  }

  public void setSambaPwdLastSet(Long sambaPwdLastSet) {
    this.sambaPwdLastSet = sambaPwdLastSet;
  }

  public Long getSambaPwdMustChange() {
    return sambaPwdMustChange;
  }

  public void setSambaPwdMustChange(Long sambaPwdMustChange) {
    this.sambaPwdMustChange = sambaPwdMustChange;
  }

  public SambaInfo getSambaInfo() {
    return sambaInfo;
  }

  public void setSambaInfo(SambaInfo sambaInfo) {
    this.sambaInfo = sambaInfo;
  }

  @Override
  public String toString() {
    return "SambaObj{" +
      "sambaSID='" + sambaSID + '\'' +
      ", sambaAcctFlags='" + sambaAcctFlags + '\'' +
      ", sambaKickoffTime=" + sambaKickoffTime +
      ", sambaLMPassword='" + sambaLMPassword + '\'' +
      ", sambaNTPassword='" + sambaNTPassword + '\'' +
      ", sambaPrimaryGroupSID='" + sambaPrimaryGroupSID + '\'' +
      ", sambaPwdCanChange=" + sambaPwdCanChange +
      ", sambaPwdLastSet=" + sambaPwdLastSet +
      ", sambaPwdMustChange='" + sambaPwdMustChange + '\'' +
      ", sambaInfo=" + sambaInfo +
      '}';
  }
}
