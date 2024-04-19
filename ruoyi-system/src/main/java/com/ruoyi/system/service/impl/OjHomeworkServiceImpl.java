package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.vo.AddHomeworkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OjHomeworkMapper;
import com.ruoyi.system.domain.OjHomework;
import com.ruoyi.system.service.IOjHomeworkService;

import javax.annotation.Resource;

/**
 * 作业管理Service业务层处理
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@Service
public class OjHomeworkServiceImpl extends ServiceImpl<OjHomeworkMapper, OjHomework> implements IOjHomeworkService {
    @Resource
    private OjHomeworkMapper ojHomeworkMapper;


    /**
     * 查询作业管理
     *
     * @param homeworkId 作业管理主键
     * @return 作业管理
     */
    @Override
    public OjHomework selectOjHomeworkByHomeworkId(Long homeworkId) {
        return ojHomeworkMapper.selectOjHomeworkByHomeworkId(homeworkId);
    }

    /**
     * 查询作业管理列表
     *
     * @param ojHomework 作业管理
     * @return 作业管理
     */
    @Override
    public List<OjHomework> selectOjHomeworkList(OjHomework ojHomework) {
        return ojHomeworkMapper.selectOjHomeworkList(ojHomework);
    }

    /**
     * 新增作业管理
     *
     * @param ojHomework 作业管理
     * @return 结果
     */
    @Override
    public int insertOjHomework(OjHomework ojHomework) {
        ojHomework.setCreateTime(DateUtils.getNowDate());
        ojHomework.setStatus(0L);
        ojHomework.setCreateBy(SecurityUtils.getUsername());
        return ojHomeworkMapper.insertOjHomework(ojHomework);
    }

    /**
     * 修改作业管理
     *
     * @param ojHomework 作业管理
     * @return 结果
     */
    @Override
    public int updateOjHomework(OjHomework ojHomework) {
        ojHomework.setUpdateTime(DateUtils.getNowDate());
        return ojHomeworkMapper.updateOjHomework(ojHomework);
    }

    /**
     * 批量删除作业管理
     *
     * @param homeworkIds 需要删除的作业管理主键
     * @return 结果
     */
    @Override
    public int deleteOjHomeworkByHomeworkIds(Long[] homeworkIds) {
        return ojHomeworkMapper.deleteOjHomeworkByHomeworkIds(homeworkIds);
    }

    /**
     * 删除作业管理信息
     *
     * @param homeworkId 作业管理主键
     * @return 结果
     */
    @Override
    public int deleteOjHomeworkByHomeworkId(Long homeworkId) {
        return ojHomeworkMapper.deleteOjHomeworkByHomeworkId(homeworkId);
    }

}
