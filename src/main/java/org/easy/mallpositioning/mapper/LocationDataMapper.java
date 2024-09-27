package org.easy.mallpositioning.mapper;

import org.apache.ibatis.annotations.Param;
import org.easy.mallpositioning.entity.LocationData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author meng
 * @since 2024-09-26
 */
public interface LocationDataMapper extends BaseMapper<LocationData> {
    List<String> selectAllByDeviceIdList(@Param("id") Long id);
}
