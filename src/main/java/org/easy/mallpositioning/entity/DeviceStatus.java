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
@TableName("device_status")
@ApiModel(value = "DeviceStatus对象", description = "")
public class DeviceStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "status_id", type = IdType.AUTO)
    private Integer statusId;

    private Integer deviceId;

    private String status;

    private LocalDateTime checkedAt;

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCheckedAt() {
        return checkedAt;
    }

    public void setCheckedAt(LocalDateTime checkedAt) {
        this.checkedAt = checkedAt;
    }

    @Override
    public String toString() {
        return "DeviceStatus{" +
            "statusId = " + statusId +
            ", deviceId = " + deviceId +
            ", status = " + status +
            ", checkedAt = " + checkedAt +
        "}";
    }
}
