package org.easy.mallpositioning.service;

import org.easy.mallpositioning.entity.PathData;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author meng
 * @since 2024-09-26
 */
public interface IPathDataService extends IService<PathData> {

    PathData getPathData(Long userId);
}
