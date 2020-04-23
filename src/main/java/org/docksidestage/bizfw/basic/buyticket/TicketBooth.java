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

/**
 * @author jflute
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    private static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    private static final int TWO_DAY_PRICE = 13200; // when 2020/04/22

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private int quantity = MAX_QUANTITY;
    private int quantity2 = MAX_QUANTITY;
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

    public int buyPassport(int handedMoney, int day){
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

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
