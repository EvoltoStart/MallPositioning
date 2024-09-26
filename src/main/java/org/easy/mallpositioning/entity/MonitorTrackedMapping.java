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
 * @since 2024-09-26
 */
@TableName("monitor_tracked_mapping")
@ApiModel(value = "MonitorTrackedMapping对象", description = "")
public class MonitorTrackedMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long monitorId;

    private Long trackedDeviceId;

    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(Long monitorId) {
        this.monitorId = monitorId;
    }

    public Long getTrackedDeviceId() {
        return trackedDeviceId;
    }

    public void setTrackedDeviceId(Long trackedDeviceId) {
        this.trackedDeviceId = trackedDeviceId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "MonitorTrackedMapping{" +
            "id = " + id +
            ", monitorId = " + monitorId +
            ", trackedDeviceId = " + trackedDeviceId +
            ", createdAt = " + createdAt +
        "}";
    }
}
