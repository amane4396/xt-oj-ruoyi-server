package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OjClassTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 班级教师关联Service接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface IOjClassTeacherService extends IService<OjClassTeacher> {
    /**
     * 查询班级教师关联
     *
     * @param ojClassId 班级教师关联主键
     * @return 班级教师关联
     */
    public OjClassTeacher selectOjClassTeacherByOjClassId(Long ojClassId);

    /**
     * 查询班级教师关联列表
     *
     * @param ojClassTeacher 班级教师关联
     * @return 班级教师关联集合
     */
    public List<OjClassTeacher> selectOjClassTeacherList(OjClassTeacher ojClassTeacher);

    /**
     * 新增班级教师关联
     *
     * @param ojClassTeacher 班级教师关联
     * @return 结果
     */
    public int insertOjClassTeacher(OjClassTeacher ojClassTeacher);

    /**
     * 修改班级教师关联
     *
     * @param ojClassTeacher 班级教师关联
     * @return 结果
     */
    public int updateOjClassTeacher(OjClassTeacher ojClassTeacher);

    /**
     * 批量删除班级教师关联
     *
     * @param ojClassIds 需要删除的班级教师关联主键集合
     * @return 结果
     */
    public int deleteOjClassTeacherByOjClassIds(Long[] ojClassIds);

    /**
     * 删除班级教师关联信息
     *
     * @param ojClassId 班级教师关联主键
     * @return 结果
     */
    public int deleteOjClassTeacherByOjClassId(Long ojClassId);
}
