package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OjClassMapper;
import com.ruoyi.system.domain.OjClass;
import com.ruoyi.system.service.IOjClassService;

/**
 * 班级管理Service业务层处理
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@Service
public class OjClassServiceImpl extends ServiceImpl<OjClassMapper, OjClass> implements IOjClassService {
    @Autowired
    private OjClassMapper ojClassMapper;

    /**
     * 查询班级管理
     *
     * @param classId 班级管理主键
     * @return 班级管理
     */
    @Override
    public OjClass selectOjClassByClassId(Long classId) {
        return ojClassMapper.selectOjClassByClassId(classId);
    }

    /**
     * 查询班级管理列表
     *
     * @param ojClass 班级管理
     * @return 班级管理
     */
    @Override
    public List<OjClass> selectOjClassList(OjClass ojClass) {
        return ojClassMapper.selectOjClassList(ojClass);
    }

    /**
     * 新增班级管理
     *
     * @param ojClass 班级管理
     * @return 结果
     */
    @Override
    public int insertOjClass(OjClass ojClass) {
        ojClass.setCreateTime(DateUtils.getNowDate());
        return ojClassMapper.insertOjClass(ojClass);
    }

    /**
     * 修改班级管理
     *
     * @param ojClass 班级管理
     * @return 结果
     */
    @Override
    public int updateOjClass(OjClass ojClass) {
        ojClass.setUpdateTime(DateUtils.getNowDate());
        return ojClassMapper.updateOjClass(ojClass);
    }

    /**
     * 批量删除班级管理
     *
     * @param classIds 需要删除的班级管理主键
     * @return 结果
     */
    @Override
    public int deleteOjClassByClassIds(Long[] classIds) {
        return ojClassMapper.deleteOjClassByClassIds(classIds);
    }

    /**
     * 删除班级管理信息
     *
     * @param classId 班级管理主键
     * @return 结果
     */
    @Override
    public int deleteOjClassByClassId(Long classId) {
        return ojClassMapper.deleteOjClassByClassId(classId);
    }
}
