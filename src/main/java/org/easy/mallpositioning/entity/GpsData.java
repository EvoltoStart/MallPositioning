package org.easy.mallpositioning.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author meng
 * @since 2024-09-21
 */
@TableName("gps_data")
@ApiModel(value = "GpsData对象", description = "")
public class GpsData implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "gps_id", type = IdType.AUTO)
    private Integer gpsId;

    private Integer userId;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private Double accuracy;

    private LocalDateTime timestamp;

    public Integer getGpsId() {
        return gpsId;
    }

    public void setGpsId(Integer gpsId) {
        this.gpsId = gpsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "GpsData{" +
            "gpsId = " + gpsId +
            ", userId = " + userId +
            ", latitude = " + latitude +
            ", longitude = " + longitude +
            ", accuracy = " + accuracy +
            ", timestamp = " + timestamp +
        "}";
    }
}
