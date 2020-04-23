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
package org.docksidestage.bizfw.basic.objanimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The object for penguin, so cute.
 * @author jflute
 * @author kazutoshi-mizutani-biz
 */
public class Penguin extends Animal implements Sleepable{

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Penguin() {
    }

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final Logger logger = LoggerFactory.getLogger(Penguin.class);

    // ===================================================================================
    //                                                                               Bark
    //                                                                              ======
    @Override
    protected String getBarkWord() {
        return "penpen-";
    }

    // ===================================================================================
    //                                                                              Sleepable
    //                                                                              ======

    @Override
    public void sleep() {
        upHitPoint();
        logger.debug("the penguin sleeps. so cute.");
    }

    // ===================================================================================
    //                                                                           Hit Point
    //                                                                           =========
    @Override
    protected void downHitPoint() {
        super.downHitPoint();
        logger.debug("* the penguin with sorrowful eyes");
    }

    public void fly(){
        logger.debug("Tips: penguins cannot fly.");
    }
}
