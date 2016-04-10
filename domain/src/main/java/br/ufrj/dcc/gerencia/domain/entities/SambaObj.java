package br.ufrj.dcc.gerencia.domain.entities;

/**
 * Created by fausto on 4/10/16.
 */
public class SambaObj {
  private String sambaSID;
  private String sambaAcctFlags;
  private String sambaKickoffTime;
  private String sambaLMPassword;
  private String sambaNTPassword;
  private String sambaPrimaryGroupSID;
  private String sambaPwdCanChange;
  private String sambaPwdLastSet;
  private String sambaPwdMustChange;

  public SambaObj(String sambaSID, String sambaAcctFlags, String sambaKickoffTime, String sambaLMPassword, String sambaNTPassword, String sambaPrimaryGroupSID, String sambaPwdCanChange, String sambaPwdLastSet, String sambaPwdMustChange) {
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

  public String getSambaAcctFlags() {
    return sambaAcctFlags;
  }

  public void setSambaAcctFlags(String sambaAcctFlags) {
    this.sambaAcctFlags = sambaAcctFlags;
  }

  public String getSambaKickoffTime() {
    return sambaKickoffTime;
  }

  public void setSambaKickoffTime(String sambaKickoffTime) {
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

  public String getSambaPwdCanChange() {
    return sambaPwdCanChange;
  }

  public void setSambaPwdCanChange(String sambaPwdCanChange) {
    this.sambaPwdCanChange = sambaPwdCanChange;
  }

  public String getSambaPwdLastSet() {
    return sambaPwdLastSet;
  }

  public void setSambaPwdLastSet(String sambaPwdLastSet) {
    this.sambaPwdLastSet = sambaPwdLastSet;
  }

  public String getSambaPwdMustChange() {
    return sambaPwdMustChange;
  }

  public void setSambaPwdMustChange(String sambaPwdMustChange) {
    this.sambaPwdMustChange = sambaPwdMustChange;
  }
}
