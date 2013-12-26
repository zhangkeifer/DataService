package com.ghtn.model.oracle.fxyk;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * User: Administrator
 * Date: 13-12-26
 * Time: 上午10:58
 */
@Entity
@Table(name = "TP_PLAN", schema = "SEP3", catalog = "")
public class TpPlan {
    private BigDecimal id;
    private BigDecimal tpmonth;
    private Timestamp downminedate;
    private String planpersonid;
    private String banci;
    private String createuser;
    private String createdept;
    private Timestamp createtime;
    private String updateuser;
    private Timestamp updatetime;
    private String status;
    private String about;

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, length = 0, precision = -127)
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TPMONTH", nullable = true, insertable = true, updatable = true, length = 0, precision = -127)
    public BigDecimal getTpmonth() {
        return tpmonth;
    }

    public void setTpmonth(BigDecimal tpmonth) {
        this.tpmonth = tpmonth;
    }

    @Basic
    @Column(name = "DOWNMINEDATE", nullable = true, insertable = true, updatable = true, length = 7, precision = 0)
    public Timestamp getDownminedate() {
        return downminedate;
    }

    public void setDownminedate(Timestamp downminedate) {
        this.downminedate = downminedate;
    }

    @Basic
    @Column(name = "PLANPERSONID", nullable = true, insertable = true, updatable = true, length = 20, precision = 0)
    public String getPlanpersonid() {
        return planpersonid;
    }

    public void setPlanpersonid(String planpersonid) {
        this.planpersonid = planpersonid;
    }

    @Basic
    @Column(name = "BANCI", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public String getBanci() {
        return banci;
    }

    public void setBanci(String banci) {
        this.banci = banci;
    }

    @Basic
    @Column(name = "CREATEUSER", nullable = true, insertable = true, updatable = true, length = 20, precision = 0)
    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    @Basic
    @Column(name = "CREATEDEPT", nullable = true, insertable = true, updatable = true, length = 20, precision = 0)
    public String getCreatedept() {
        return createdept;
    }

    public void setCreatedept(String createdept) {
        this.createdept = createdept;
    }

    @Basic
    @Column(name = "CREATETIME", nullable = true, insertable = true, updatable = true, length = 7, precision = 0)
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "UPDATEUSER", nullable = true, insertable = true, updatable = true, length = 20, precision = 0)
    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }

    @Basic
    @Column(name = "UPDATETIME", nullable = true, insertable = true, updatable = true, length = 7, precision = 0)
    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "ABOUT", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpPlan tpPlan = (TpPlan) o;

        if (about != null ? !about.equals(tpPlan.about) : tpPlan.about != null) return false;
        if (banci != null ? !banci.equals(tpPlan.banci) : tpPlan.banci != null) return false;
        if (createdept != null ? !createdept.equals(tpPlan.createdept) : tpPlan.createdept != null) return false;
        if (createtime != null ? !createtime.equals(tpPlan.createtime) : tpPlan.createtime != null) return false;
        if (createuser != null ? !createuser.equals(tpPlan.createuser) : tpPlan.createuser != null) return false;
        if (downminedate != null ? !downminedate.equals(tpPlan.downminedate) : tpPlan.downminedate != null)
            return false;
        if (id != null ? !id.equals(tpPlan.id) : tpPlan.id != null) return false;
        if (planpersonid != null ? !planpersonid.equals(tpPlan.planpersonid) : tpPlan.planpersonid != null)
            return false;
        if (status != null ? !status.equals(tpPlan.status) : tpPlan.status != null) return false;
        if (tpmonth != null ? !tpmonth.equals(tpPlan.tpmonth) : tpPlan.tpmonth != null) return false;
        if (updatetime != null ? !updatetime.equals(tpPlan.updatetime) : tpPlan.updatetime != null) return false;
        if (updateuser != null ? !updateuser.equals(tpPlan.updateuser) : tpPlan.updateuser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tpmonth != null ? tpmonth.hashCode() : 0);
        result = 31 * result + (downminedate != null ? downminedate.hashCode() : 0);
        result = 31 * result + (planpersonid != null ? planpersonid.hashCode() : 0);
        result = 31 * result + (banci != null ? banci.hashCode() : 0);
        result = 31 * result + (createuser != null ? createuser.hashCode() : 0);
        result = 31 * result + (createdept != null ? createdept.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (updateuser != null ? updateuser.hashCode() : 0);
        result = 31 * result + (updatetime != null ? updatetime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (about != null ? about.hashCode() : 0);
        return result;
    }
}