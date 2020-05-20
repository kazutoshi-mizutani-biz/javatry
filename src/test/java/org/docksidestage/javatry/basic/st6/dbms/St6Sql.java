package org.docksidestage.javatry.basic.st6.dbms;

/**
 * @author kazutoshi-mizutani-biz
 */
public abstract class St6Sql {

    abstract String buildPagingQuery(int pageSize, int pageNumber);

    public int calculateOffset(int pageSize, int pageNumber){
        return pageSize * (pageNumber - 1);
    }

}
