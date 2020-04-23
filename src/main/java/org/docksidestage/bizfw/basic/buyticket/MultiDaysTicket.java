package org.docksidestage.bizfw.basic.buyticket;

public class MultiDaysTicket implements Ticket{

    private final int displayPrice;
    private final int displayDays;
    private int remainingDays;
    private boolean alreadyIn;

    public MultiDaysTicket(int price,int days){
        this.displayPrice = price;
        this.displayDays = days;
        this.remainingDays = this.displayDays;
    }

    public void doInPark() {
        if (remainingDays <= 0) {
            throw new IllegalStateException("There is no remaining days on this ticket: displayedPrice=" + displayPrice);
        }
        alreadyIn = true;
        --remainingDays;
    }

    public int getDisplayPrice() {
        return displayPrice;
    }

    public int getDisplayDays(){
        return displayDays;
    }

    public int getRemainingDays(){
        return remainingDays;
    }

    public boolean isAlreadyIn() {
        return alreadyIn;
    }

}
