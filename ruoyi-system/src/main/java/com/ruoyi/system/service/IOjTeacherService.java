package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OjTeacher;

/**
 * teacherService接口
 * 
 * @author ruoyi
 * @date 2024-04-18
 */
public interface IOjTeacherService 
{
    /**
     * 查询teacher
     * 
     * @param teacherId teacher主键
     * @return teacher
     */
    public OjTeacher selectOjTeacherByTeacherId(Long teacherId);

    /**
     * 查询teacher列表
     * 
     * @param ojTeacher teacher
     * @return teacher集合
     */
    public List<OjTeacher> selectOjTeacherList(OjTeacher ojTeacher);

    /**
     * 新增teacher
     * 
     * @param ojTeacher teacher
     * @return 结果
     */
    public int insertOjTeacher(OjTeacher ojTeacher);

    /**
     * 修改teacher
     * 
     * @param ojTeacher teacher
     * @return 结果
     */
    public int updateOjTeacher(OjTeacher ojTeacher);

    /**
     * 批量删除teacher
     * 
     * @param teacherIds 需要删除的teacher主键集合
     * @return 结果
     */
    public int deleteOjTeacherByTeacherIds(Long[] teacherIds);

    /**
     * 删除teacher信息
     * 
     * @param teacherId teacher主键
     * @return 结果
     */
    public int deleteOjTeacherByTeacherId(Long teacherId);
}
