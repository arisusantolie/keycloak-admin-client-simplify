package org.keycloak.admin.client.simplify.reprensetation.realm;

public class RealmSecurityBruteForceSettingRepresentation {
    private Boolean bruteForceProtected; //Enabled or disabled brute force
    private Boolean permanentLockout; //Enable or disable Permanent Lockout
    private Integer failureFactor; //Max Login Failures
    private Integer waitIncrementSeconds; //Wait Increment (in seconds)
    private Long quickLoginCheckMilliSeconds; //Quick Login Check Milli Seconds (in milliseconds)
    private Integer minimumQuickLoginWaitSeconds; //Minimum Quick Login Wait (in seconds)
    private Integer maxFailureWaitSeconds; //Max Wait (in seconds)
    private Integer maxDeltaTimeSeconds; //Failure Reset Time (in seconds)

    public RealmSecurityBruteForceSettingRepresentation() {
    }

    public RealmSecurityBruteForceSettingRepresentation(Boolean bruteForceProtected, Boolean permanentLockout, Integer failureFactor, Integer waitIncrementSeconds, Long quickLoginCheckMilliSeconds, Integer minimumQuickLoginWaitSeconds, Integer maxFailureWaitSeconds, Integer maxDeltaTimeSeconds) {
        this.bruteForceProtected = bruteForceProtected;
        this.permanentLockout = permanentLockout;
        this.failureFactor = failureFactor;
        this.waitIncrementSeconds = waitIncrementSeconds;
        this.quickLoginCheckMilliSeconds = quickLoginCheckMilliSeconds;
        this.minimumQuickLoginWaitSeconds = minimumQuickLoginWaitSeconds;
        this.maxFailureWaitSeconds = maxFailureWaitSeconds;
        this.maxDeltaTimeSeconds = maxDeltaTimeSeconds;
    }

    public Boolean getBruteForceProtected() {
        return bruteForceProtected;
    }

    public void setBruteForceProtected(Boolean bruteForceProtected) {
        this.bruteForceProtected = bruteForceProtected;
    }

    public Boolean getPermanentLockout() {
        return permanentLockout;
    }

    public void setPermanentLockout(Boolean permanentLockout) {
        this.permanentLockout = permanentLockout;
    }

    public Integer getFailureFactor() {
        return failureFactor;
    }

    public void setFailureFactor(Integer failureFactor) {
        this.failureFactor = failureFactor;
    }

    public Integer getWaitIncrementSeconds() {
        return waitIncrementSeconds;
    }

    public void setWaitIncrementSeconds(Integer waitIncrementSeconds) {
        this.waitIncrementSeconds = waitIncrementSeconds;
    }

    public Long getQuickLoginCheckMilliSeconds() {
        return quickLoginCheckMilliSeconds;
    }

    public void setQuickLoginCheckMilliSeconds(Long quickLoginCheckMilliSeconds) {
        this.quickLoginCheckMilliSeconds = quickLoginCheckMilliSeconds;
    }

    public Integer getMinimumQuickLoginWaitSeconds() {
        return minimumQuickLoginWaitSeconds;
    }

    public void setMinimumQuickLoginWaitSeconds(Integer minimumQuickLoginWaitSeconds) {
        this.minimumQuickLoginWaitSeconds = minimumQuickLoginWaitSeconds;
    }

    public Integer getMaxFailureWaitSeconds() {
        return maxFailureWaitSeconds;
    }

    public void setMaxFailureWaitSeconds(Integer maxFailureWaitSeconds) {
        this.maxFailureWaitSeconds = maxFailureWaitSeconds;
    }

    public Integer getMaxDeltaTimeSeconds() {
        return maxDeltaTimeSeconds;
    }

    public void setMaxDeltaTimeSeconds(Integer maxDeltaTimeSeconds) {
        this.maxDeltaTimeSeconds = maxDeltaTimeSeconds;
    }
}
