package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author mizutani-kazutoshi-biz
 */
public class TicketBuyResult {
    // TODO mizutani finalが付けられるインスタンス変数には、できるだけ付けていきましょう by jflute (2020/04/23)
    // その方が、安全だし、読む方も判断がしやすいです。
    private Ticket ticket;
    private int change;
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
