package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OjStudentMapper;
import com.ruoyi.system.domain.OjStudent;
import com.ruoyi.system.service.IOjStudentService;

/**
 * 学生管理Service业务层处理
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@Service
public class OjStudentServiceImpl extends ServiceImpl<OjStudentMapper, OjStudent> implements IOjStudentService {
    @Autowired
    private OjStudentMapper ojStudentMapper;

    /**
     * 查询学生管理
     *
     * @param studentId 学生管理主键
     * @return 学生管理
     */
    @Override
    public OjStudent selectOjStudentByStudentId(Long studentId) {
        return ojStudentMapper.selectOjStudentByStudentId(studentId);
    }

    /**
     * 查询学生管理列表
     *
     * @param ojStudent 学生管理
     * @return 学生管理
     */
    @Override
    public List<OjStudent> selectOjStudentList(OjStudent ojStudent) {
        return ojStudentMapper.selectOjStudentList(ojStudent);
    }

    /**
     * 新增学生管理
     *
     * @param ojStudent 学生管理
     * @return 结果
     */
    @Override
    public int insertOjStudent(OjStudent ojStudent) {
                ojStudent.setCreateTime(DateUtils.getNowDate());
            return ojStudentMapper.insertOjStudent(ojStudent);
    }

    /**
     * 修改学生管理
     *
     * @param ojStudent 学生管理
     * @return 结果
     */
    @Override
    public int updateOjStudent(OjStudent ojStudent) {
                ojStudent.setUpdateTime(DateUtils.getNowDate());
        return ojStudentMapper.updateOjStudent(ojStudent);
    }

    /**
     * 批量删除学生管理
     *
     * @param studentIds 需要删除的学生管理主键
     * @return 结果
     */
    @Override
    public int deleteOjStudentByStudentIds(Long[] studentIds) {
        return ojStudentMapper.deleteOjStudentByStudentIds(studentIds);
    }

    /**
     * 删除学生管理信息
     *
     * @param studentId 学生管理主键
     * @return 结果
     */
    @Override
    public int deleteOjStudentByStudentId(Long studentId) {
        return ojStudentMapper.deleteOjStudentByStudentId(studentId);
    }
}
