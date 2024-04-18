package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.OjTeacher;

/**
 * teacherMapper接口
 * 
 * @author ruoyi
 * @date 2024-04-18
 */
public interface OjTeacherMapper 
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
     * 删除teacher
     * 
     * @param teacherId teacher主键
     * @return 结果
     */
    public int deleteOjTeacherByTeacherId(Long teacherId);

    /**
     * 批量删除teacher
     * 
     * @param teacherIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOjTeacherByTeacherIds(Long[] teacherIds);
}
