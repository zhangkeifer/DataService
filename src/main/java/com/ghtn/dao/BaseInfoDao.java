package com.ghtn.dao;

import com.ghtn.model.oracle.fxyk.CsBaseinfoset;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-4
 * Time: 下午3:46
 * To change this template use File | Settings | File Templates.
 */
public interface BaseInfoDao extends GenericDao<CsBaseinfoset, Integer> {

    List<CsBaseinfoset> listBaseInfo();

    List<CsBaseinfoset> listBaseInfoByFid(Integer fid);
}
