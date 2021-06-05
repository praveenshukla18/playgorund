package com.ps.covidportal.services.beans;

public class CaseStat {

    private Long active;
    private Long confirmed;
    private Long deceased;
    private Long recovered;

    public CaseStat() {
    }

    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }

    public Long getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Long confirmed) {
        this.confirmed = confirmed;
    }

    public Long getDeceased() {
        return deceased;
    }

    public void setDeceased(Long deceased) {
        this.deceased = deceased;
    }

    public Long getRecovered() {
        return recovered;
    }

    public void setRecovered(Long recovered) {
        this.recovered = recovered;
    }
}
