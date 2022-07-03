package com.lte.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: laite
 * @Date: 2021/9/22 - 09 - 22 - 16:45
 * @Description: com.lte.pojo
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseStorage implements Serializable {
    private Integer id;
    private String productName;
    private String specification;
    private Double price;
    private Integer amount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date billDate;
    private String remark;
    private String pictureUrl;

}
