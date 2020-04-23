package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author mizutani-kazutoshi-biz
 */
public class TicketBuyResult {
    private Ticket ticket;
    private int change;
    public TicketBuyResult(Ticket t,int c){
        this.ticket = t;
        this.change = c;
    }
    public Ticket getTicket(){
        return ticket;
    }
    public int getChange(){
        return change;
    }
}
