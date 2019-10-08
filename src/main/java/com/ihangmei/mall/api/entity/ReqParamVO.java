package com.ihangmei.mall.api.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReqParamVO  implements Serializable {
    private static final long serialVersionUID = 5565730100388401219L;
    /*企业ID*/
    private String appkey;
    private String signature;
    private String params;
    private Long timestamp;
}
