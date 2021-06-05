package com.ps.covidportal.services.resultbeans;

public class CovidTotalSummary {

    private long active;
    private long confirmed;
    private long deceased;
    private long recovered;

    public CovidTotalSummary() {
    }

    public long getActive() {
        return active;
    }

    public void setActive(long active) {
        this.active = active;
    }

    public long getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(long confirmed) {
        this.confirmed = confirmed;
    }

    public long getDeceased() {
        return deceased;
    }

    public void setDeceased(long deceased) {
        this.deceased = deceased;
    }

    public long getRecovered() {
        return recovered;
    }

    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }
}
