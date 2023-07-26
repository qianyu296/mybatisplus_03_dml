package cn.hnkjzyxy.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@TableName("users")
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "password",select = false)
    private String password;
    @TableField(value = "email")
    private String email;
    @TableField(value = "birthday")
    private String birthday;
    @TableField(exist = false)
    private boolean online;
    // 逻辑删除字段
    @TableField(value = "deleted")
    private Integer deleted;
    // 乐观锁 : 当并发线程修改该字段时,需要一个用户先修改完,另一个用户才能够修改
    @Version
    private Integer version;
}
