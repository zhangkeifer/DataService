package com.ghtn.service;

import com.ghtn.BaseTestCase;
import org.junit.Test;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * User: Administrator
 * Date: 14-2-17
 * Time: 上午11:14
 */
public class SummaryManagerTest extends BaseTestCase {

    private SummaryManager summaryManager;

    @Resource
    public void setSummaryManager(SummaryManager summaryManager) {
        this.summaryManager = summaryManager;
    }

    @Test
    public void testRjxx() throws SQLException {
        List list = summaryManager.getRjxxSummaryOracleDataSource3();
    }

}