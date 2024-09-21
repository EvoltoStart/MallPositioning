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
@TableName("tracking_history")
@ApiModel(value = "TrackingHistory对象", description = "")
public class TrackingHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "track_id", type = IdType.AUTO)
    private Integer trackId;

    private Integer userId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String path;

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "TrackingHistory{" +
            "trackId = " + trackId +
            ", userId = " + userId +
            ", startTime = " + startTime +
            ", endTime = " + endTime +
            ", path = " + path +
        "}";
    }
}
