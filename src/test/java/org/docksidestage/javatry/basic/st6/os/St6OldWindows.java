package org.docksidestage.javatry.basic.st6.os;

/**
 * @author kazutoshi-mizutani-biz
 */
public class St6OldWindows extends St6OperationSystem{
    public St6OldWindows(String loginId){
        super(loginId);
        setOsType("OldWindows");
    }
    @Override
    protected String getFileSeparator() {
        return "\\";
    }
    @Override
    protected String getUserDirectory() {
        return "/Documents and Settigs/" + loginId;
    }
}
