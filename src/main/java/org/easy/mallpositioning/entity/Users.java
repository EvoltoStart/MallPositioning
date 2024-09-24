package org.easy.mallpositioning.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author meng
 * @since 2024-09-21
 */
@Data
@ApiModel(value = "Users对象", description = "")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    
    private Integer monitorId;

    private String name;

    private String phoneNumber;

    private String email;

    private String userType;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    @Override
    public String toString() {
        return "Users{" +
            "userId = " + userId +
            ", name = " + name +
            ", phoneNumber = " + phoneNumber +
            ", email = " + email +
            ", userType = " + userType +
            ", createdAt = " + createdAt +
            ", updatedAt = " + updatedAt +
        "}";
    }
}
