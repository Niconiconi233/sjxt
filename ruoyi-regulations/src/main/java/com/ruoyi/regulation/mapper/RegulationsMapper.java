package com.ruoyi.regulation.mapper;

import java.util.List;
import com.ruoyi.regulation.domain.Regulations;

/**
 * 制度管理Mapper接口
 * 
 * @author yw
 * @date 2025-05-28
 */
public interface RegulationsMapper 
{
    /**
     * 查询制度管理
     * 
     * @param id 制度管理主键
     * @return 制度管理
     */
    public Regulations selectRegulationsById(Long id);

    /**
     * 查询制度管理列表
     * 
     * @param regulations 制度管理
     * @return 制度管理集合
     */
    public List<Regulations> selectRegulationsList(Regulations regulations);

    /**
     * 新增制度管理
     * 
     * @param regulations 制度管理
     * @return 结果
     */
    public int insertRegulations(Regulations regulations);

    /**
     * 修改制度管理
     * 
     * @param regulations 制度管理
     * @return 结果
     */
    public int updateRegulations(Regulations regulations);

    /**
     * 删除制度管理
     * 
     * @param id 制度管理主键
     * @return 结果
     */
    public int deleteRegulationsById(Long id);

    /**
     * 批量删除制度管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRegulationsByIds(Long[] ids);
}
