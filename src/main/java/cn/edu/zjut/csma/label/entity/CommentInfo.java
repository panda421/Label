package cn.edu.zjut.csma.label.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * comment实体
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="NewsInfo对象", description="新闻")
public class CommentInfo {
    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "评论Id")
    private String commentId;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "新闻id")
    private String newsId;

    @ApiModelProperty(value = "用户Id")
    private String userId;

    @ApiModelProperty(value = "任务Id")
    private String taskId;

    @ApiModelProperty(value = "父节点Id")
    private String parentcommentId;

    @ApiModelProperty(value = "是否完成")
    private String isfinished;


}
