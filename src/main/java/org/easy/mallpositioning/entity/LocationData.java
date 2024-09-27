package org.easy.mallpositioning.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
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
 * @since 2024-09-26
 */
@Data
@TableName("location_data")
@ApiModel(value = "LocationData对象", description = "")
public class LocationData implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long deviceId;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private LocalDateTime timestamp;
    @TableField("userid")
    private Long userid;


}
