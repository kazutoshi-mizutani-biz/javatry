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
package org.docksidestage.javatry.framework;

import org.docksidestage.bizfw.di.nondi.NonDiDirectFirstAction;
import org.docksidestage.bizfw.di.nondi.NonDiDirectSecondAction;
import org.docksidestage.unit.PlainTestCase;

/**
 * The test of Dependency Injection (DI) as beginner level. <br>
 * Show answer by log() or write answer on comment for question of javadoc.
 * @author jflute
 * @author kazutoshi-mizutnai-biz
 */
public class Step41DependencyInjectionBeginnerTest extends PlainTestCase {

    // ===================================================================================
    //                                                                        Precondition
    //                                                                        ============
    /**
     * Search "Dependency Injection" by internet and learn it in thirty minutes. (study only) <br>
     * ("Dependency Injection" をインターネットで検索して、30分ほど学んでみましょう。(勉強のみ))
     */
    public void test_whatis_DependencyInjection() {
        // _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        // What is Dependency Injection?
        // - - - - - (your answer?)
        //
        // 依存性の注入
        // dependency injection is a technique in which an object receives other objects that it depends on.
        //
        // あるコンポーネントが利用している別のコンポーネントを前者の内部で生成するのではなく、生成したものを渡して実行させることで、
        // 実装の際の依存性をなくし、機能がカスタムされたコンポーネントを使用する際に前者を書き換えなくてもすませる方法？
        //
        // ・constructor injection
        // ・setter injection
        // ・interface injection
        //
        // _/_/_/_/_/_/_/_/_/_/
    }

    // ===================================================================================
    //                                                                 Non DI Code Reading
    //                                                                 ===================
    /**
     * What is the difference between NonDiDirectFirstAction and NonDiDirectSecondAction? <br>
     * (NonDiDirectFirstAction と NonDiDirectSecondAction の違いは？)
     */
    public void test_nondi_difference_between_first_and_second() {
        // your answer? =>
        //  dog processにおいて前者はdogを、後者はlazy dogを作成する。
        //  lazy dogは petMeして playWithしないとbarkしないし、しても代わりにfriendのcatがbarkする
        //  wakeupMeの場合、barkが3回されるので、3回目に猫が疲れてしまう
        //  supercar processにおいて
        //  secondはSupercarManufacturerのmakeSuperCarクラスを「...making supercar by {}」を表示してから実行するようにoverrideしている
        // and your confirmation code here freely
        NonDiDirectFirstAction first = new NonDiDirectFirstAction();
        NonDiDirectSecondAction second = new NonDiDirectSecondAction();
        System.out.println("@@@FIRST CALL FRIEND@@@");
        first.callFriend();
        System.out.println("@@@FIRST WAKE UP ME@@@");
        first.wakeupMe();
        System.out.println("@@@SECOND CALL FRIEND@@@");
        second.callFriend();
        System.out.println("@@@SECOND WAKE UP ME@@@");
        try{
            second.wakeupMe();
        } catch (IllegalStateException e){
            System.out.println("Exception message: " + e.getMessage());
        }
        System.out.println("@@@FIRST GO TO OFFICE@@@");
        first.goToOffice();
        System.out.println("@@@FIRST SEND GIFT@@@");
        first.sendGift();
        System.out.println("@@@SECOND GO TO OFFICE@@@");
        second.goToOffice();
        System.out.println("@@@SECOND SEND GIFT@@@");
        second.sendGift();
    }

    /**
     * What is the difference between NonDiDirectSecondAction and NonDiFactoryMethodAction? <br>
     * (NonDiDirectSecondAction と NonDiFactoryMethodAction の違いは？)
     */
    public void test_nondi_difference_between_second_and_FactoryMethod() {
        // your answer? => 
        // and your confirmation code here freely
    }

    /**
     * What is the difference between NonDiFactoryMethodAction and NonDiIndividualFactoryAction? <br>
     * (NonDiFactoryMethodAction と NonDiIndividualFactoryAction の違いは？)
     */
    public void test_nondi_difference_between_FactoryMethod_and_IndividualFactory() {
        // your answer? => 
        // and your confirmation code here freely
    }

    // ===================================================================================
    //                                                               Using DI Code Reading
    //                                                               =====================
    /**
     * What is the difference between UsingDiAccessorAction and UsingDiAnnotationAction? <br>
     * (UsingDiAccessorAction と UsingDiAnnotationAction の違いは？)
     */
    public void test_usingdi_difference_between_Accessor_and_Annotation() {
        // your answer? => 
        // and your confirmation code here freely
    }

    /**
     * What is the difference between UsingDiAnnotationAction and UsingDiDelegatingAction? <br>
     * (UsingDiAnnotationAction と UsingDiDelegatingAction の違いは？)
     */
    public void test_usingdi_difference_between_Annotation_and_Delegating() {
        // your answer? => 
        // and your confirmation code here freely
    }

    // ===================================================================================
    //                                                           Execute like WebFramework
    //                                                           =========================
    /**
     * Execute callFriend() of accessor action by UsingDiWebFrameworkProcess. <br>
     * (accessor の Action の callFriend() を UsingDiWebFrameworkProcess 経由で実行してみましょう)
     */
    public void test_usingdi_UsingDiWebFrameworkProcess_callfriend_accessor() {
        // execution code here
    }

    /**
     * Execute callFriend() of annotation and delegating actions by UsingDiWebFrameworkProcess.
     * (And you can increase hit-points of sleepy cat in this method) <br>
     * (annotation, delegating の Action の callFriend() を UsingDiWebFrameworkProcess 経由で実行してみましょう。
     * (眠い猫のヒットポイントをこのメソッド内で増やしてもOK))
     */
    public void test_usingdi_UsingDiWebFrameworkProcess_callfriend_annotation_delegating() {
        // execution code here
    }

    /**
     * What is concrete class of instance variable "animal" of UsingDiAnnotationAction? (when registering UsingDiModule) <br>
     * (UsingDiAnnotationAction のインスタンス変数 "animal" の実体クラスは？ (UsingDiModuleを登録した時))
     */
    public void test_usingdi_whatis_animal() {
        // your answer? => 
        // and your confirmation code here freely
    }

    // ===================================================================================
    //                                                                        DI Container
    //                                                                        ============
    /**
     * What is DI container? <br>
     * (DIコンテナとは？)
     */
    public void test_whatis_DIContainer() {
        // your answer? => 
        // and your confirmation code here freely
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * What is class or file of DI settings that defines MemberBhv class as DI component in the following Lasta Di application? <br>
     * (以下のLasta DiアプリケーションでMemberBhvクラスをDIコンポーネントとして定義しているDI設定クラスもしくはファイルは？) <br>
     * 
     * https://github.com/lastaflute/lastaflute-example-harbor
     */
    public void test_zone_search_component_on_LastaDi() {
        // your answer? => 
    }

    /**
     * What is class or file of DI settings that defines MemberBhv class as DI component in the following Spring application? <br>
     * (以下のSpringアプリケーションでMemberBhvクラスをDIコンポーネントとして定義しているDI設定クラスもしくはファイルは？) <br>
     * 
     * https://github.com/dbflute-example/dbflute-example-on-springboot
     */
    public void test_zone_search_component_on_Spring() {
        // your answer? => 
    }
}
