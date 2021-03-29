package classes;

public class Subscription {
    private int idSubscription;
    private Date beginSubs;
    private Date endSubs;
    private boolean valid;
    private static int countSubs = 1;

    public Subscription(Date beginSubs, Date endSubs) {
        this.idSubscription = countSubs;
        this.beginSubs = beginSubs;
        this.endSubs = endSubs;
        this.valid = true;
        countSubs++;
    }

    public int getIdSubscription() {
        return idSubscription;
    }

    public Date getBeginSubs() {
        return beginSubs;
    }

    public void setBeginSubs(Date beginSubs) {
        this.beginSubs = beginSubs;
    }

    public Date getEndSubs() {
        return endSubs;
    }

    public void setEndSubs(Date endSubs) {
        this.endSubs = endSubs;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public static int getCountSubs() {
        return countSubs;
    }

    @Override
    public String toString() {
        if(valid == true)
         return "Subscription with ID " + idSubscription +
                " is valid and ends on " + endSubs;
        else {
            return "Subscription with ID " + idSubscription + " has expired. Please renew.";
        }

    }
}
