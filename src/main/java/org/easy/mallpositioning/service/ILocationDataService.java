package org.easy.mallpositioning.service;

import org.easy.mallpositioning.entity.LocationData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author meng
 * @since 2024-09-26
 */
public interface ILocationDataService extends IService<LocationData> {

    void saveLocationData(LocationData locationData);

    List<String> getAllDeviceId(Long id);
}
