package com.bs.gas.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lst
 * @since 2020-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("REFUELING_INFORMATION")
public class Information extends Model<Information> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String mercuryName;

    /**
     * 加油类型
     */
    private String refuelingType;

    /**
     * 创建时间时间
     */
    private String creatorTime;

    /**
     * 加油数量（L）
     */
    private String num;

    /**
     * 加油站大妈id
     */
    private String creator;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
