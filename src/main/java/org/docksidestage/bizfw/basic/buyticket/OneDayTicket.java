package org.docksidestage.bizfw.basic.buyticket;

public class OneDayTicket implements Ticket {

    private final int displayPrice;
    private boolean alreadyIn;

    public OneDayTicket(int price){
        this.displayPrice = price;
    }

    public void doInPark() {
        if (alreadyIn) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        alreadyIn = true;
    }

    public int getDisplayPrice() {
        return displayPrice;
    }

    public int getRemainingDays(){
        if (alreadyIn){
            return 0;
        } else {
            return 1;
        }
    }

    public boolean isAlreadyIn() {
        return alreadyIn;
    }

}
