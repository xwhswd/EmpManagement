package com.iweb.arui.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private long id;
    private String positionName;
    private String positionMsg;
}
