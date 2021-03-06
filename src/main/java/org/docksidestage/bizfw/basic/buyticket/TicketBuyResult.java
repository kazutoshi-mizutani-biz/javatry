package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author mizutani-kazutoshi-biz
 */
public class TicketBuyResult {
    private final Ticket ticket;
    private final int change;
    public TicketBuyResult(Ticket boughtTicket,int change){
        this.ticket = boughtTicket;
        this.change = change;
    }
    public Ticket getTicket(){
        return ticket;
    }
    public int getChange(){
        return change;
    }
}
