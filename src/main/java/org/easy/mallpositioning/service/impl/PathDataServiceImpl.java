package org.easy.mallpositioning.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.easy.mallpositioning.entity.PathData;
import org.easy.mallpositioning.mapper.PathDataMapper;
import org.easy.mallpositioning.service.IPathDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author meng
 * @since 2024-09-26
 */
@Service
public class PathDataServiceImpl extends ServiceImpl<PathDataMapper, PathData> implements IPathDataService {

    @Override
    public PathData getPathData(Long userId) {
        LambdaQueryWrapper<PathData> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(PathData::getUserid,userId);
        PathData pathData = baseMapper.selectOne(wrapper);
        return pathData;
    }
}
