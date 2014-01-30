package org.datanucleus.test;

import static org.junit.Assert.fail;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import mydomain.model.Detail;
import mydomain.model.Master;

import org.datanucleus.util.NucleusLogger;
import org.junit.Test;

public class SimpleTest
{
    @Test
    public void testSimple()
    {
        NucleusLogger.GENERAL.info(">> test START");
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("MyTest");

        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
            tx.begin();
            Master master = new Master(1, "Master");
            Detail detail = new Detail(1, "Detail");
            master.addDetail(detail);
            pm.makePersistent(master);

            Query query = pm.newQuery("select from mydomain.model.Master ORDER BY id");
            pm.getFetchPlan().addGroup("details");
            query.execute(1);
            
            tx.commit();
        }
        catch (Throwable thr)
        {
            NucleusLogger.GENERAL.error(">> Exception thrown persisting data", thr);
            fail("Failed to persist data : " + thr.getMessage());
        }
        finally 
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }

        pmf.close();
        NucleusLogger.GENERAL.info(">> test END");
    }
}
