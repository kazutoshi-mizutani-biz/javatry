/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.buyticket;

// TODO mizutani javadocにauthorをお願いしますー by jflute (2020/04/23)
/**
 * @author jflute
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    private static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    private static final int TWO_DAY_PRICE = 13200;
    private static final int FOUR_DAY_PRICE = 22400;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // TODO mizutani 細かいですが、この場合は quantity1 にしちゃったほうが誤解がないかもですね by jflute (2020/04/23)
    // トータルの quantity みたいに一瞬見えてしまったりもしますし、2を使うべき場面で間違って quantity を使ってても気付きづらいです。
    private int quantity = MAX_QUANTITY;
    private int quantity2 = MAX_QUANTITY;
    private int quantity4 = MAX_QUANTITY;
    private Integer salesProceeds;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    public Ticket buyOneDayPassport(int handedMoney) {
        buyPassport(handedMoney, 1);
        // TODO mizutani 細かいですが、直接returnしちゃっていいですよ return new OneDay...() by jflute (2020/04/23)
        Ticket t = new OneDayTicket(ONE_DAY_PRICE);
        return t;
    }

    public TicketBuyResult buyTwoDayPassport(int handedMoney) {
        int change = 0;
        change = buyPassport(handedMoney, 2);
        Ticket t = new MultiDaysTicket(TWO_DAY_PRICE, 2);
        TicketBuyResult tbr = new TicketBuyResult(t,change);
        return tbr;
    }

    public TicketBuyResult buyFourDayPassport(int handedMoney) {
        int change = 0;
        change = buyPassport(handedMoney, 4);
        Ticket t = new MultiDaysTicket(FOUR_DAY_PRICE, 4);
        TicketBuyResult tbr = new TicketBuyResult(t,change);
        return tbr;
    }

    // TODO mizutani クラス内だけの再利用であれば、privateメソッドにしましょう (publicだと誰からでも呼べてしまう) by jflute (2020/04/23)
    // TODO mizutani 一方で、Slackのtipsスレッドで書いたように、doBuy...() にしてみましょう by jflute (2020/04/23)
    // IntelliJ の Rename の機能を使うと良いです。
    public int buyPassport(int handedMoney, int day){
        // TODO mizutani せっかくpublicメソッドのbuyの方で 2 days とか 4 days の情報を指定しているのに... by jflute (2020/04/23)
        // 再利用メソッドであるこのメソッド内でも 2 days とか 4 days を意識して分岐をしているのがもったいないですね。
        // もし、7 days が増えた時、「publicメソッドも追加するし、この中で分岐も増やすし」となると、修正漏れが怖いですね。
        // ただ、quantity周りはそんなに簡単ではないですね。。。
        int price = 0;
        int quan = 0;
        switch(day){
        case 1:
            price = ONE_DAY_PRICE;
            quan = quantity;
            break;
        case 2:
            price = TWO_DAY_PRICE;
            quan = quantity2;
            break;
        case 4:
            price = FOUR_DAY_PRICE;
            quan = quantity4;
            break;
        }
        if (quan <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
        if (handedMoney < price) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
        switch(day){
        case 1:
            --quantity;
            break;
        case 2:
            --quantity2;
            break;
        case 4:
            --quantity4;
        }
        if (salesProceeds != null) {
            salesProceeds = salesProceeds + price;
        } else {
            salesProceeds = price;
        }
        return handedMoney - price;

    }

    public static class TicketSoldOutException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public int getQuantity2(){
        return quantity2;
    }

    public int getQuantity4() {
        return quantity4;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
