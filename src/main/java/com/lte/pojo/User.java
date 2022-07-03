package com.lte.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Auther: laite
 * @Date: 2021/9/18 - 09 - 18 - 13:17
 * @Description: com.lte.pojo
 * @version: 1.0
 */
@Data
@TableName("user")
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @NotEmpty(message = "用户名不能为空")
    @Size(min = 3,max = 15,message = "用户名长度应该在3和15之间")
    @TableField("username")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Size(min = 3,max = 15,message = "密码长度应该在3和15之间")
    @TableField("password")
    private String password;

    @TableField("realname")
    @NotEmpty(message = "真实姓名不能为空")
    @Size(min =2,max = 15,message = "真实姓名长度应该在3和15之间")
    private String realname;

}
