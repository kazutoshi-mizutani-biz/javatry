package org.docksidestage.javatry.basic.st6.os;

/**
 * @author kazutoshi-mizutani-biz
 */
public class St6Windows extends St6OperationSystem{
    public St6Windows(String loginId){
        super(loginId);
        setOsType("Windows");
    }
    @Override
    protected String getFileSeparator() {
        return "\\";
    }
    @Override
    protected String getUserDirectory() {
        return "/Users/" + loginId;
    }
}
