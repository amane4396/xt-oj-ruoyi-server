package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OjClassStudentMapper;
import com.ruoyi.system.domain.OjClassStudent;
import com.ruoyi.system.service.IOjClassStudentService;

/**
 * 班级学生关联Service业务层处理
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@Service
public class OjClassStudentServiceImpl extends ServiceImpl<OjClassStudentMapper, OjClassStudent> implements IOjClassStudentService {
    @Autowired
    private OjClassStudentMapper ojClassStudentMapper;

    /**
     * 查询班级学生关联
     *
     * @param ojClassId 班级学生关联主键
     * @return 班级学生关联
     */
    @Override
    public OjClassStudent selectOjClassStudentByOjClassId(Long ojClassId) {
        return ojClassStudentMapper.selectOjClassStudentByOjClassId(ojClassId);
    }

    /**
     * 查询班级学生关联列表
     *
     * @param ojClassStudent 班级学生关联
     * @return 班级学生关联
     */
    @Override
    public List<OjClassStudent> selectOjClassStudentList(OjClassStudent ojClassStudent) {
        return ojClassStudentMapper.selectOjClassStudentList(ojClassStudent);
    }

    /**
     * 新增班级学生关联
     *
     * @param ojClassStudent 班级学生关联
     * @return 结果
     */
    @Override
    public int insertOjClassStudent(OjClassStudent ojClassStudent) {
            return ojClassStudentMapper.insertOjClassStudent(ojClassStudent);
    }

    /**
     * 修改班级学生关联
     *
     * @param ojClassStudent 班级学生关联
     * @return 结果
     */
    @Override
    public int updateOjClassStudent(OjClassStudent ojClassStudent) {
        return ojClassStudentMapper.updateOjClassStudent(ojClassStudent);
    }

    /**
     * 批量删除班级学生关联
     *
     * @param ojClassIds 需要删除的班级学生关联主键
     * @return 结果
     */
    @Override
    public int deleteOjClassStudentByOjClassIds(Long[] ojClassIds) {
        return ojClassStudentMapper.deleteOjClassStudentByOjClassIds(ojClassIds);
    }

    /**
     * 删除班级学生关联信息
     *
     * @param ojClassId 班级学生关联主键
     * @return 结果
     */
    @Override
    public int deleteOjClassStudentByOjClassId(Long ojClassId) {
        return ojClassStudentMapper.deleteOjClassStudentByOjClassId(ojClassId);
    }
}
