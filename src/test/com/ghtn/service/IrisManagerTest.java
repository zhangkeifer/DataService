package com.ghtn.service;

import com.ghtn.BaseTestCase;
import org.junit.Test;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * Created by lihe on 14-6-3.
 */
public class IrisManagerTest extends BaseTestCase {

    private IrisManager irisManager;

    @Resource
    public void setIrisManager(IrisManager irisManager) {
        this.irisManager = irisManager;
    }

    @Test
    public void testGetData() throws ParseException {
       /* List<IrisVO> list = irisManager.getIrisDataMysqlDataSource5("01216");
        if (list != null && list.size() > 0) {
            IrisVO vo = list.get(0);
            System.out.println(vo.getDepartName());
        }*/
    }


}
