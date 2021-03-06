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
package org.docksidestage.javatry.basic;

import org.docksidestage.bizfw.basic.buyticket.Ticket;
import org.docksidestage.bizfw.basic.buyticket.TicketBooth;
import org.docksidestage.bizfw.basic.objanimal.Animal;
import org.docksidestage.bizfw.basic.objanimal.BarkedSound;
import org.docksidestage.bizfw.basic.objanimal.Cat;
import org.docksidestage.bizfw.basic.objanimal.Dog;
import org.docksidestage.bizfw.basic.objanimal.Penguin;
import org.docksidestage.bizfw.basic.objanimal.Sleepable;
import org.docksidestage.bizfw.basic.objanimal.Zombie;
import org.docksidestage.bizfw.basic.objanimal.loud.AlarmClock;
import org.docksidestage.bizfw.basic.objanimal.loud.Loudable;
import org.docksidestage.bizfw.basic.objanimal.runner.FastRunner;
import org.docksidestage.javatry.basic.st6.dbms.St6MySql;
import org.docksidestage.javatry.basic.st6.dbms.St6PostgreSql;
import org.docksidestage.javatry.basic.st6.dbms.St6Sql;
import org.docksidestage.javatry.basic.st6.os.St6Mac;
import org.docksidestage.javatry.basic.st6.os.St6Windows;
import org.docksidestage.unit.PlainTestCase;

/**
 * The test of object-oriented. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author kazutoshi-mizutani-biz
 */
public class Step06ObjectOrientedTest extends PlainTestCase {

    // ===================================================================================
    //                                                                        About Object
    //                                                                        ============
    // -----------------------------------------------------
    //                                        Against Object
    //                                        --------------
    /**
     * Fix several mistakes in buying one-day passport and in-park process. <br>
     * (OneDayPassportを買って InPark する処理の中で、間違いがいくつかあるので修正しましょう)
     */
    public void test_objectOriented_aboutObject_againstObject() {
        //
        // [ticket booth info]
        //
        int oneDayPrice = 7400;
        int quantity = 10;
        Integer salesProceeds = null;

        //
        // [buy one-day passport]
        //
        int handedMoney = 10000;
        if (quantity <= 0) {
            throw new IllegalStateException("Sold out");
        }
        if (handedMoney < oneDayPrice) {
            throw new IllegalStateException("Short money: handedMoney=" + handedMoney);
        }
        --quantity;
        salesProceeds = oneDayPrice;

        //
        // [ticket info]
        //
        int displayPrice = oneDayPrice;
        boolean alreadyIn = false;

        // other processes here...
        // ...
        // ...

        //
        // [do in park now!!!]
        //
        if (alreadyIn) {
            throw new IllegalStateException("Already in park by this ticket: displayPrice=" + displayPrice);
        }
        alreadyIn = true;

        //
        // [final process]
        //
        saveBuyingHistory(quantity, salesProceeds, displayPrice, alreadyIn);
    }

    private void saveBuyingHistory(int quantity, Integer salesProceeds, int displayPrice, boolean alreadyIn) {
        if (alreadyIn) {
            // only logging here (normally e.g. DB insert)
            showTicketBooth(quantity, salesProceeds);
            showYourTicket(displayPrice, alreadyIn);
        }
    }

    private void showTicketBooth(int quantity, Integer salesProceeds) {
        log("Ticket Booth: quantity={}, salesProceeds={}", quantity, salesProceeds);
    }

    private void showYourTicket(int displayPrice, boolean alreadyIn) {
        log("Ticket: displayPrice={}, alreadyIn={}", displayPrice, alreadyIn);
    }

    // -----------------------------------------------------
    //                                          Using Object
    //                                          ------------
    /**
     * Read (analyze) this code and compare with the previous test method, and think "what is object?". <br>
     * (このコードを読んで(分析して)、一つ前のテストメソッドと比べて、「オブジェクトとは何か？」を考えてみましょう)
     */
    public void test_objectOriented_aboutObject_usingObject() {
        //
        // [ticket booth info]
        //
        TicketBooth booth = new TicketBooth();

        // *booth has these properties:
        //int oneDayPrice = 7400;
        //int quantity = 10;
        //Integer salesProceeds = null;

        //
        // [buy one-day passport]
        //
        // _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        // # you if step05 has been finished, you can use this code by jflute (2019/06/15)
        // _/_/_/_/_/_/_/_/_/_/
        //Ticket ticket = booth.buyOneDayPassport(10000);

        // *buyOneDayPassport() has this process:
        //if (quantity <= 0) {
        //    throw new TicketSoldOutException("Sold out");
        //}
        //if (handedMoney < oneDayPrice) {
        //    throw new TicketShortMoneyException("Short money: handedMoney=" + handedMoney);
        //}
        //--quantity;
        //salesProceeds = handedMoney;

        // *ticket has these properties:
        //int displayPrice = oneDayPrice;
        //boolean alreadyIn = false;

        // other processes here...
        // ...
        // ...

        //
        // [do in park now!!!]
        //
        //        ticket.doInPark();

        // *doInPark() has this process:
        //if (alreadyIn) {
        //    throw new IllegalStateException("Already in park by this ticket: displayPrice=" + displayPrice);
        //}
        //alreadyIn = true;

        //
        // [final process]
        //
        //        saveBuyingHistory(booth, ticket);
    }

    // TODO mizutani コメントアウトしちゃったからかな？ unused の警告が出ていますね by jflute (2020/05/20)
    private void saveBuyingHistory(TicketBooth booth, Ticket ticket) {
        if (ticket.isAlreadyIn()) {
            // only logging here (normally e.g. DB insert)
            doShowTicketBooth(booth);
            doShowYourTicket(ticket);
        }
    }

    private void doShowTicketBooth(TicketBooth booth) {
        log("Ticket Booth: quantity={}, salesProceeds={}", booth.getQuantity(), booth.getSalesProceeds());
    }

    private void doShowYourTicket(Ticket ticket) {
        log("Your Ticket: displayPrice={}, alreadyIn={}", ticket.getDisplayPrice(), ticket.isAlreadyIn());
    }

    // ===================================================================================
    //                                                              Polymorphism Beginning
    //                                                              ======================
    /**
     * What string is sea and land variable at the method end? <br>
     * (メソッド終了時の変数 sea, land の中身は？)
     */
    public void test_objectOriented_polymorphism_1st_concreteOnly() {
        Dog dog = new Dog();
        BarkedSound sound = dog.bark();
        String sea = sound.getBarkWord();
        log(sea); // your answer? => wan
        //        correct answer => wan
        int land = dog.getHitPoint();
        log(land); // your answer? => 10
        //        correct answer => 7
        //        NOTE: prepareAbdominalMuscle, breatheIn, doBark で 1 ずつ減る by kazutoshi-mizutani-biz
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_objectOriented_polymorphism_2nd_asAbstract() {
        Animal animal = new Dog();
        BarkedSound sound = animal.bark();
        String sea = sound.getBarkWord();
        log(sea); // your answer? => wan
        //        correct answer => wan
        int land = animal.getHitPoint();
        log(land); // your answer? => 7
        //        correct answer => 7
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_objectOriented_polymorphism_3rd_fromMethod() {
        Animal animal = createAnyAnimal();
        BarkedSound sound = animal.bark();
        String sea = sound.getBarkWord();
        log(sea); // your answer? => wan
        //        correct answer => wan
        int land = animal.getHitPoint();
        log(land); // your answer? => 7
        //        correct answer => 7
    }

    private Animal createAnyAnimal() {
        return new Dog();
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_objectOriented_polymorphism_4th_toMethod() {
        Dog dog = new Dog();
        doAnimalSeaLand_for_4th(dog);
    }

    private void doAnimalSeaLand_for_4th(Animal animal) {
        BarkedSound sound = animal.bark();
        String sea = sound.getBarkWord();
        log(sea); // your answer? => wan
        //        correct answer => wan
        int land = animal.getHitPoint();
        log(land); // your answer? => 7
        //        correct answer => 7
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_objectOriented_polymorphism_5rd_overrideWithSuper() {
        Animal animal = new Cat();
        BarkedSound sound = animal.bark();
        String sea = sound.getBarkWord();
        log(sea); // your answer? => nya-
        //        correct answer => nya-
        int land = animal.getHitPoint();
        log(land); // your answer? => 5
        //        correct answer => 5
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_objectOriented_polymorphism_6th_overriddenWithoutSuper() {
        Animal animal = new Zombie();
        BarkedSound sound = animal.bark();
        String sea = sound.getBarkWord();
        log(sea); // your answer? => uooo
        //        correct answer => uooo
        int land = animal.getHitPoint();
        log(land); // your answer? => -1
        //        correct answer => -1
    }

    // ===================================================================================
    //                                                              Polymorphism Interface
    //                                                              ======================
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_objectOriented_polymorphism_interface_dispatch() {
        Loudable loudable = new Zombie();
        String sea = loudable.soundLoudly();
        log(sea); // your answer? => uooo
        //        correct answer => uooo
        String land = ((Zombie) loudable).bark().getBarkWord();
        log(land); // your answer? => uooo
        //        correct answer => uooo
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_objectOriented_polymorphism_interface_hierarchy() {
        Loudable loudable = new AlarmClock();
        String sea = loudable.soundLoudly();
        log(sea); // your answer? => jiri jiri jiri---
        //        correct answer => jiri jiri jiri---
        boolean land = loudable instanceof Animal;
        log(land); // your answer? => false
        //        correct answer => false
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_objectOriented_polymorphism_interface_partImpl() {
        Animal seaAnimal = new Cat();
        Animal landAnimal = new Zombie();
        boolean sea = seaAnimal instanceof FastRunner;
        log(sea); // your answer? => true
        //        correct answer => true
        boolean land = landAnimal instanceof FastRunner;
        log(land); // your answer? => false
        //        correct answer => false
    }

    /**
     * Make Dog class implement FastRunner interface. (the implementation is same as Cat class) <br>
     * (DogもFastRunnerインターフェースをimplementsしてみましょう (実装はCatと同じで))
     */
    public void test_objectOriented_polymorphism_interface_runnerImpl() {
        // your confirmation code here
        Animal dog = new Dog();
        boolean sea = dog instanceof FastRunner;
        log(sea);
        //        correct answer => true
    }

    // ===================================================================================
    //                                                                 Polymorphism Making
    //                                                                 ===================
    /**
     * Make concrete class of Animal, which is not FastRunner, in "objanimal" package. (implementation is as you like) <br>
     * (FastRunnerではないAnimalクラスのコンクリートクラスをobjanimalパッケージに作成しましょう (実装はお好きなように))
     */
    public void test_objectOriented_polymorphism_makeConcrete() {
        // your confirmation code here
        Penguin penguin = new Penguin();
        BarkedSound sound = penguin.bark();
        String sea = sound.getBarkWord();
        log(sea);
        //        correct answer => penpen-
        int land = penguin.getHitPoint();
        log(land);
        //        correct answer => 7
        log((penguin instanceof FastRunner));
        //        correct answer => false
    }

    /**
     * Make interface implemented by part of Animal concrete class in new package under "objanimal" package. (implementation is as you like) <br>
     * (Animalクラスの一部のコンクリートクラスだけがimplementsするインターフェースをobjanimal配下の新しいパッケージに作成しましょう (実装はお好きなように))
     */
    public void test_objectOriented_polymorphism_makeInterface() {
        // your confirmation code here
        Penguin penguin = new Penguin();
        BarkedSound sound = penguin.bark();
        String sea = sound.getBarkWord();
        log(sea);
        //        correct answer => penpen-
        penguin.sleep();
        int land = penguin.getHitPoint();
        log(land);
        //        correct answer => 8
        log((penguin instanceof Sleepable));
        //        correct answer => true
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Extract St6MySql, St6PostgreSql (basic.st6.dbms)'s process to abstract class (as super class and sub-class) <br>
     * (St6MySql, St6PostgreSql (basic.st6.dbms) から抽象クラスを抽出してみましょう (スーパークラスとサブクラスの関係に))
     */
    public void test_objectOriented_writing_generalization_extractToAbstract() {
        // your confirmation code here
        // TODO mizutani buildPagingQuery() は、public にしないと、抽象クラスで扱うときにメソッドが呼べないです by jflute (2020/05/20) - DONE
        // TODO mizutani calculateOffset() は、外から呼ばれないと思うので、protected にしましょう by jflute (2020/05/20)
        // TODO mizutani 再利用自体はできていますね。ただ、テンプレートメソッドパターンではないですね by jflute (2020/05/20)
        // 11:30にsubaruさんがライブコーディングで説明してくれたやり方を思い出しましょう。
        St6MySql st6mySql = new St6MySql();
        St6PostgreSql st6postgreSql = new St6PostgreSql();
        // TODO mizutani 抽象クラスの名前も、subaruさんが説明していましたので、もう少し適切な名前にしましょう by jflute (2020/05/20)
        boolean sea = st6mySql instanceof St6Sql;
        boolean land = st6postgreSql instanceof St6Sql;
        log(sea, land);
        //        output => true, true
        //        NOTE: 抽出ってこういうことでしょうか...? よくわからない by kazutoshi-mizutani-biz
    }

    /**
     * Extract St6OperationSystem (basic.st6.os)'s process to concrete classes (as super class and sub-class) <br>
     * (St6OperationSystem (basic.st6.os) からコンクリートクラスを抽出してみましょう (スーパークラスとサブクラスの関係に))
     */
    public void test_objectOriented_writing_specialization_extractToConcrete() {
        // your confirmation code here
        // TODO mizutani St6OperationSystem で unused の警告が出ています (OS_TYPE_MACはもう使ってない？) by jflute (2020/05/20) - DONE
        St6Mac mac = new St6Mac("Fizz");
        St6Windows windows = new St6Windows("Buzz");
        String sea = mac.buildUserResourcePath("sea");
        String land = windows.buildUserResourcePath("land");
        log(sea);
        //        output => /Users/Fizz/sea
        log(land);
        //        output => \Users\Buzz\land
        //        NOTE: 同上
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Extract Animal's bark() process as BarkingProcess class to also avoid large abstract class. <br>
     * (抽象クラス肥大化を抑制するためにも、Animalのbark()のプロセス(処理)をBarkingProcessクラスとして切り出しましょう)
     */
    public void test_objectOriented_writing_withDelegation() {
        // your confirmation code here
        // TODO mizutani Zombieの挙動はキープできていますか？ by jflute (2020/05/20)
        Penguin penguin = new Penguin();
        BarkedSound sound = penguin.bark();
        String sea = sound.getBarkWord();
        log(sea);
        //        correct answer => penpen-
        penguin.sleep();
        int land = penguin.getHitPoint();
        log(land);
        //        correct answer => 8
        log((penguin instanceof Sleepable));
        //        correct answer => true
    }

    /**
     * Is Zombie correct as sub-class of Animal? Analyze it in thirty seconds. (thinking only) <br>
     * (ゾンビは動物クラスのサブクラスとして適切でしょうか？30秒だけ考えてみましょう (考えるだけでOK))
     */
    public void test_objectOriented_zoo() {
        // do nothing here
        // ZOMBIE IS NOT ANIMAL
        // ... Because they are too special to be animal. (ex. infinite HP)
    }
}
