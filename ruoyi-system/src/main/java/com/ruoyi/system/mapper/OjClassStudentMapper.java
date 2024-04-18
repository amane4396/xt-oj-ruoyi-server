package com.ruoyi.system.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.OjClassStudent;

/**
 * 班级学生关联Mapper接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface OjClassStudentMapper extends BaseMapper<OjClassStudent> {
    /**
     * 查询班级学生关联
     *
     * @param ojClassId 班级学生关联主键
     * @return 班级学生关联
     */
    public OjClassStudent selectOjClassStudentByOjClassId(Long ojClassId);

    /**
     * 查询班级学生关联列表
     *
     * @param ojClassStudent 班级学生关联
     * @return 班级学生关联集合
     */
    public List<OjClassStudent> selectOjClassStudentList(OjClassStudent ojClassStudent);

    /**
     * 新增班级学生关联
     *
     * @param ojClassStudent 班级学生关联
     * @return 结果
     */
    public int insertOjClassStudent(OjClassStudent ojClassStudent);

    /**
     * 修改班级学生关联
     *
     * @param ojClassStudent 班级学生关联
     * @return 结果
     */
    public int updateOjClassStudent(OjClassStudent ojClassStudent);

    /**
     * 删除班级学生关联
     *
     * @param ojClassId 班级学生关联主键
     * @return 结果
     */
    public int deleteOjClassStudentByOjClassId(Long ojClassId);

    /**
     * 批量删除班级学生关联
     *
     * @param ojClassIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOjClassStudentByOjClassIds(Long[] ojClassIds);
}
