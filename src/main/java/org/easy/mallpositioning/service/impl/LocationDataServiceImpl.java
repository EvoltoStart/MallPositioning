package org.easy.mallpositioning.service.impl;

import org.easy.mallpositioning.entity.LocationData;
import org.easy.mallpositioning.mapper.LocationDataMapper;
import org.easy.mallpositioning.service.ILocationDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author meng
 * @since 2024-09-26
 */
@Service
public class LocationDataServiceImpl extends ServiceImpl<LocationDataMapper, LocationData> implements ILocationDataService {

    @Override
    public void saveLocationData(LocationData locationData){
        this.save(locationData);
    }

    @Override
    public List<String> getAllDeviceId(Long id) {

        return baseMapper.selectAllByDeviceIdList(id);
    }

}
