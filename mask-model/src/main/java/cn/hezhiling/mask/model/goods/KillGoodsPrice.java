package cn.hezhiling.mask.model.goods;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class KillGoodsPrice implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer specGoodsId;

    private Integer status;

    private BigDecimal price;

    private Integer killCount;

    private Integer freezedKillCount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date begainTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpecGoodsId() {
        return specGoodsId;
    }

    public void setSpecGoodsId(Integer specGoodsId) {
        this.specGoodsId = specGoodsId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getKillCount() {
        return killCount;
    }

    public void setKillCount(Integer killCount) {
        this.killCount = killCount;
    }

    public Integer getFreezedKillCount() {
        return freezedKillCount;
    }

    public void setFreezedKillCount(Integer freezedKillCount) {
        this.freezedKillCount = freezedKillCount;
    }

    public Date getBegainTime() {
        return begainTime;
    }

    public void setBegainTime(Date begainTime) {
        this.begainTime = begainTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}