package cn.edu.zjut.csma.label.service;

import cn.edu.zjut.csma.label.entity.TaskInfo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface TaskInfoService extends IService<TaskInfo> {
    TaskInfo uploadTask();

}
