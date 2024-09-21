package org.easy.mallpositioning.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("wifi_signals")
@ApiModel(value = "WifiSignals对象", description = "")
public class WifiSignals implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "signal_id", type = IdType.AUTO)
    private Integer signalId;

    private Integer userId;

    private String ssid;

    private String bssid;

    private Integer signalStrength;

    private LocalDateTime timestamp;

    public Integer getSignalId() {
        return signalId;
    }

    public void setSignalId(Integer signalId) {
        this.signalId = signalId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getBssid() {
        return bssid;
    }

    public void setBssid(String bssid) {
        this.bssid = bssid;
    }

    public Integer getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(Integer signalStrength) {
        this.signalStrength = signalStrength;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "WifiSignals{" +
            "signalId = " + signalId +
            ", userId = " + userId +
            ", ssid = " + ssid +
            ", bssid = " + bssid +
            ", signalStrength = " + signalStrength +
            ", timestamp = " + timestamp +
        "}";
    }
}
