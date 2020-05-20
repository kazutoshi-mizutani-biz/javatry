package org.docksidestage.bizfw.basic.objanimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kazutoshi-mizutani-biz
 */
public class BarkingProcess {

    private static final Logger logger = LoggerFactory.getLogger(BarkingProcess.class);
    private Animal barkingAnimal;

    public BarkingProcess(Animal animal){
        this.barkingAnimal = animal;
    }

    public BarkedSound doBarkingProcess(){
        breatheIn();
        prepareAbdominalMuscle();
        String barkWord = barkingAnimal.getBarkWord();
        BarkedSound barkedSound = doBark(barkWord);
        return barkedSound;
    }

    private void breatheIn() {
        logger.debug("...Breathing in");
        barkingAnimal.downHitPoint();
    }

    private void prepareAbdominalMuscle() {
        logger.debug("...Using my abdominal muscle");
        barkingAnimal.downHitPoint();
    }

    protected BarkedSound doBark(String barkWord) {
        barkingAnimal.downHitPoint();
        return new BarkedSound(barkWord);
    }

    public Animal getBarkingAnimal(){
        return barkingAnimal;
    }

}
