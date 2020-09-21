package cn.edu.zjut.csma.label.service.impl;
import cn.edu.zjut.csma.label.entity.TaskInfo;
import cn.edu.zjut.csma.label.mapper.TaskInfoMapper;
import cn.edu.zjut.csma.label.service.TaskInfoService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TaskInfoServiceImpl extends ServiceImpl<TaskInfoMapper, TaskInfo> implements TaskInfoService {

    @Override
    public TaskInfo uploadTask() {
        TaskInfo taskInfo=new TaskInfo();
        System.out.println(taskInfo.getTaskId());
        //taskInfo.setGmtCreate(new Date());
        baseMapper.insert(taskInfo);
        return taskInfo;
    }
}
