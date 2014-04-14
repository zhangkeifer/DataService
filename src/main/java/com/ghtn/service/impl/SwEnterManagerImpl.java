package com.ghtn.service.impl;

import com.ghtn.dao.PersonDao;
import com.ghtn.dao.PlaceDao;
import com.ghtn.dao.SwEnterDao;
import com.ghtn.model.oracle.*;
import com.ghtn.service.SwEnterManager;
import com.ghtn.util.DateUtil;
import com.ghtn.util.StringUtil;
import com.ghtn.vo.SwBasisVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;

/**
 * User: Administrator
 * Date: 2014/4/10
 * Time: 9:40
 */
@Service("swEnterManager")
public class SwEnterManagerImpl extends GenericManagerImpl implements SwEnterManager {

    private SwEnterDao swEnterDao;

    @Autowired
    public SwEnterManagerImpl(SwEnterDao swEnterDao) {
        super(swEnterDao);
        this.swEnterDao = swEnterDao;
    }

    private PersonDao personDao;

    @Resource
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    private PlaceDao placeDao;

    @Resource
    public void setPlaceDao(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    @Override
    public List<SwBasisVO> getSwBasisOracleDataSource3(String deptNumber, HttpSession session) {
        List<Object[]> list = swEnterDao.getSwBasis(deptNumber);
        if (list != null && list.size() > 0) {
            List<SwBasisVO> resultList = new ArrayList<>();
            Map<String, String> levelMap = new HashMap<>();
            Map<String, String> typeMap = new HashMap<>();
            Map<String, String> hazardMap = new HashMap<>();
            for (Object[] o : list) {
                SwBasisVO vo = new SwBasisVO();
                vo.setSwId(StringUtil.processNullStr(String.valueOf(o[0])));
                vo.setSwNumber(StringUtil.processNullStr(String.valueOf(o[1])));
                vo.setSwContent(StringUtil.processNullStr(String.valueOf(o[2])));
                vo.setLevelId(StringUtil.processNullStr(String.valueOf(o[3])));
                vo.setLevelName(StringUtil.processNullStr(String.valueOf(o[4])));
                vo.setTypeId(StringUtil.processNullStr(String.valueOf(o[5])));
                vo.setTypeName(StringUtil.processNullStr(String.valueOf(o[6])));
                vo.sethNumber(StringUtil.processNullStr(String.valueOf(o[7])));
                vo.sethContent(StringUtil.processNullStr(String.valueOf(o[8])));

                resultList.add(vo);

                levelMap.put(vo.getSwId(), vo.getLevelId());
                typeMap.put(vo.getSwId(), vo.getTypeId());
                hazardMap.put(vo.getSwId(), vo.gethNumber());

            }

            if (session != null) {
                session.setAttribute("levelMap", levelMap);
                session.setAttribute("typeMap", typeMap);
                session.setAttribute("hazardMap", hazardMap);
            }

            return resultList;
        }
        return null;
    }

    @Override
    public String getSwBasisLevelOracleDataSource3(String swid, HttpSession session) {
        if (session != null) {
            Map<String, String> levelMap = (Map<String, String>) session.getAttribute("levelMap");
            if (levelMap != null) {
                return levelMap.get(swid);
            }
        }

        return "";
    }

    @Override
    public String getSwBasisTypeOracleDataSource3(String swid, HttpSession session) {
        if (session != null) {
            Map<String, String> typeMap = (Map<String, String>) session.getAttribute("typeMap");
            if (typeMap != null) {
                return typeMap.get(swid);
            }
        }

        return "";
    }

    @Override
    public String getBasisHazardOracleDataSource3(String swid, HttpSession session) {
        if (session != null) {
            Map<String, String> hazardMap = (Map<String, String>) session.getAttribute("hazardMap");
            if (hazardMap != null) {
                return hazardMap.get(swid);
            }
        }

        return "";
    }

    @Override
    public List<Person> getPersonOracleDataSource3(String shortName, String mainDeptId) {
        return personDao.getPerson(shortName, mainDeptId);
    }

    @Override
    public String insertInfoOracleDataSource3(Integer swyj, Integer swxz, Integer swlx, Integer swzy, String wxy, String swms, String swry, String pcry, Integer pcdd, String mxdd, String pcsj, String pcbc, Integer jcfs, String mainDeptId) throws ParseException {
        // 插入NSWINPUT
        Nswinput nswinput = new Nswinput();

        nswinput.setSwid(swyj);
        nswinput.setRemarks(swms);
        nswinput.setSwpnumber(swry);
        nswinput.setPcpnumber(pcry);
        nswinput.setPlaceid(pcdd);

        if (StringUtil.isNullStr(mxdd)) {
            mxdd = "";
        }

        nswinput.setPlacedetail(mxdd);
        nswinput.setTypeid(swlx);
        nswinput.setLevelid(swxz);
        nswinput.setZyid(swzy);
        nswinput.sethNumber(wxy);
        nswinput.setPctime(new Timestamp(DateUtil.stringToDate(pcsj, "yyyy-MM-dd").getTime()));
        nswinput.setBanci(pcbc);
        nswinput.setJctype(BigInteger.valueOf(jcfs));
        nswinput.setIntime(new Timestamp(new Date().getTime()));
        nswinput.setInputpnumber(pcry);
        nswinput.setStatus("新增");
        nswinput.setMaindeptid(mainDeptId);
        nswinput.setLcmark(1);

        nswinput = (Nswinput) swEnterDao.save(nswinput);

        // 插入NSWINPUT_MORE
        NswinputMore nswinputMore = new NswinputMore();

        nswinputMore.setSwinputid(nswinput.getSwinputid());
        nswinputMore.setPersonid(pcry);
        nswinputMore.setJctype(BigInteger.valueOf(jcfs));
        nswinputMore.setRemarks(swms);

        swEnterDao.save(nswinputMore);

        // 插入NSWSTATUSCHANGE
        Nswstatuschange nswstatuschange = new Nswstatuschange();

        nswstatuschange.setSwinputid(nswinput.getSwinputid());
        nswstatuschange.setLcmark(1);
        nswstatuschange.setRecorddate(new Date());
        nswstatuschange.setNstatus("新增");
        nswstatuschange.setCremarks(personDao.getPersonName(pcry) + "于" + DateUtil.dateToString(new Date(), "yyyy/MM/dd HH:mm:ss") + "新增三违!");

        swEnterDao.save(nswstatuschange);

        // 插入NSWPERSISTENCE
        Nswpersistence nswpersistence = new Nswpersistence();

        nswpersistence.setSwinputid(nswinput.getSwinputid());
        nswpersistence.setSwpname(personDao.getPersonName(swry));
        nswpersistence.setPcpname(personDao.getPersonName(pcry));
        nswpersistence.setPlacename(placeDao.get(pcdd).getPlacename());
        nswpersistence.setInputpername(personDao.getPersonName(pcry));

        swEnterDao.save(nswpersistence);

        return "success";
    }

    @Override
    public List<SwBasisVO> filterSwBasisOracleDataSource3(String deptNumber, String arg) {
        List<Object[]> list = swEnterDao.filterSwBasis(deptNumber, arg);
        if (list != null && list.size() > 0) {
            List<SwBasisVO> resultList = new ArrayList<>();
            for (Object[] o : list) {
                SwBasisVO vo = new SwBasisVO();
                vo.setSwId(StringUtil.processNullStr(String.valueOf(o[0])));
                vo.setSwNumber(StringUtil.processNullStr(String.valueOf(o[1])));
                vo.setSwContent(StringUtil.processNullStr(String.valueOf(o[2])));
                vo.setLevelId(StringUtil.processNullStr(String.valueOf(o[3])));
                vo.setLevelName(StringUtil.processNullStr(String.valueOf(o[4])));
                vo.setTypeId(StringUtil.processNullStr(String.valueOf(o[5])));
                vo.setTypeName(StringUtil.processNullStr(String.valueOf(o[6])));
                vo.sethNumber(StringUtil.processNullStr(String.valueOf(o[7])));
                vo.sethContent(StringUtil.processNullStr(String.valueOf(o[8])));

                resultList.add(vo);

            }

            return resultList;
        }
        return null;
    }
}
