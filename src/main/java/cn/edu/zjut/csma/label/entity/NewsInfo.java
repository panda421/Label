package cn.edu.zjut.csma.label.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * NewsInfo实体
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="NewsInfo对象", description="新闻")
public class NewsInfo implements Serializable {
    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "新闻Id")
    private String newsId;

    @ApiModelProperty(value = "新闻内容")
    private String content;

    @ApiModelProperty(value = "新闻类型")
    private String newsType;

    @ApiModelProperty(value = "任务Id")
    private String taskId;

    @ApiModelProperty(value = "新闻标题")
    private String newsTitle;

}
