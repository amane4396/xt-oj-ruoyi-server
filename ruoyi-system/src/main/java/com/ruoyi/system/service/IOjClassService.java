package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OjClass;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 班级管理Service接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface IOjClassService extends IService<OjClass> {
    /**
     * 查询班级管理
     *
     * @param classId 班级管理主键
     * @return 班级管理
     */
    public OjClass selectOjClassByClassId(Long classId);

    /**
     * 查询班级管理列表
     *
     * @param ojClass 班级管理
     * @return 班级管理集合
     */
    public List<OjClass> selectOjClassList(OjClass ojClass);

    /**
     * 新增班级管理
     *
     * @param ojClass 班级管理
     * @return 结果
     */
    public int insertOjClass(OjClass ojClass);

    /**
     * 修改班级管理
     *
     * @param ojClass 班级管理
     * @return 结果
     */
    public int updateOjClass(OjClass ojClass);

    /**
     * 批量删除班级管理
     *
     * @param classIds 需要删除的班级管理主键集合
     * @return 结果
     */
    public int deleteOjClassByClassIds(Long[] classIds);

    /**
     * 删除班级管理信息
     *
     * @param classId 班级管理主键
     * @return 结果
     */
    public int deleteOjClassByClassId(Long classId);
}
