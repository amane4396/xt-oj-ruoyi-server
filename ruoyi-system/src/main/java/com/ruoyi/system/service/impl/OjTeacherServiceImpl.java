package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OjTeacherMapper;
import com.ruoyi.system.domain.OjTeacher;
import com.ruoyi.system.service.IOjTeacherService;

/**
 * teacherService业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-18
 */
@Service
public class OjTeacherServiceImpl implements IOjTeacherService 
{
    @Autowired
    private OjTeacherMapper ojTeacherMapper;

    /**
     * 查询teacher
     * 
     * @param teacherId teacher主键
     * @return teacher
     */
    @Override
    public OjTeacher selectOjTeacherByTeacherId(Long teacherId)
    {
        return ojTeacherMapper.selectOjTeacherByTeacherId(teacherId);
    }

    /**
     * 查询teacher列表
     * 
     * @param ojTeacher teacher
     * @return teacher
     */
    @Override
    public List<OjTeacher> selectOjTeacherList(OjTeacher ojTeacher)
    {
        return ojTeacherMapper.selectOjTeacherList(ojTeacher);
    }

    /**
     * 新增teacher
     * 
     * @param ojTeacher teacher
     * @return 结果
     */
    @Override
    public int insertOjTeacher(OjTeacher ojTeacher)
    {
        ojTeacher.setCreateTime(DateUtils.getNowDate());
        return ojTeacherMapper.insertOjTeacher(ojTeacher);
    }

    /**
     * 修改teacher
     * 
     * @param ojTeacher teacher
     * @return 结果
     */
    @Override
    public int updateOjTeacher(OjTeacher ojTeacher)
    {
        ojTeacher.setUpdateTime(DateUtils.getNowDate());
        return ojTeacherMapper.updateOjTeacher(ojTeacher);
    }

    /**
     * 批量删除teacher
     * 
     * @param teacherIds 需要删除的teacher主键
     * @return 结果
     */
    @Override
    public int deleteOjTeacherByTeacherIds(Long[] teacherIds)
    {
        return ojTeacherMapper.deleteOjTeacherByTeacherIds(teacherIds);
    }

    /**
     * 删除teacher信息
     * 
     * @param teacherId teacher主键
     * @return 结果
     */
    @Override
    public int deleteOjTeacherByTeacherId(Long teacherId)
    {
        return ojTeacherMapper.deleteOjTeacherByTeacherId(teacherId);
    }
}
