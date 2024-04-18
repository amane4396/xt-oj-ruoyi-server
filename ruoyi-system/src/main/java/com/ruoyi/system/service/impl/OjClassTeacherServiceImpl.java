package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OjClassTeacherMapper;
import com.ruoyi.system.domain.OjClassTeacher;
import com.ruoyi.system.service.IOjClassTeacherService;

/**
 * 班级教师关联Service业务层处理
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@Service
public class OjClassTeacherServiceImpl extends ServiceImpl<OjClassTeacherMapper, OjClassTeacher> implements IOjClassTeacherService {
    @Autowired
    private OjClassTeacherMapper ojClassTeacherMapper;

    /**
     * 查询班级教师关联
     *
     * @param ojClassId 班级教师关联主键
     * @return 班级教师关联
     */
    @Override
    public OjClassTeacher selectOjClassTeacherByOjClassId(Long ojClassId) {
        return ojClassTeacherMapper.selectOjClassTeacherByOjClassId(ojClassId);
    }

    /**
     * 查询班级教师关联列表
     *
     * @param ojClassTeacher 班级教师关联
     * @return 班级教师关联
     */
    @Override
    public List<OjClassTeacher> selectOjClassTeacherList(OjClassTeacher ojClassTeacher) {
        return ojClassTeacherMapper.selectOjClassTeacherList(ojClassTeacher);
    }

    /**
     * 新增班级教师关联
     *
     * @param ojClassTeacher 班级教师关联
     * @return 结果
     */
    @Override
    public int insertOjClassTeacher(OjClassTeacher ojClassTeacher) {
            return ojClassTeacherMapper.insertOjClassTeacher(ojClassTeacher);
    }

    /**
     * 修改班级教师关联
     *
     * @param ojClassTeacher 班级教师关联
     * @return 结果
     */
    @Override
    public int updateOjClassTeacher(OjClassTeacher ojClassTeacher) {
        return ojClassTeacherMapper.updateOjClassTeacher(ojClassTeacher);
    }

    /**
     * 批量删除班级教师关联
     *
     * @param ojClassIds 需要删除的班级教师关联主键
     * @return 结果
     */
    @Override
    public int deleteOjClassTeacherByOjClassIds(Long[] ojClassIds) {
        return ojClassTeacherMapper.deleteOjClassTeacherByOjClassIds(ojClassIds);
    }

    /**
     * 删除班级教师关联信息
     *
     * @param ojClassId 班级教师关联主键
     * @return 结果
     */
    @Override
    public int deleteOjClassTeacherByOjClassId(Long ojClassId) {
        return ojClassTeacherMapper.deleteOjClassTeacherByOjClassId(ojClassId);
    }
}
