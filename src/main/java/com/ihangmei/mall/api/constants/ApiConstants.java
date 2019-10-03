package com.ihangmei.mall.api.constants;
/**
 * @ClassName: ApiConstants
 * @Auther: liudushi
 * @Date: 2019/9/24
 * @Description: 请求地址常量
 * @Version : 1.0
 */
public class ApiConstants {
        /*产品模块 */
        /**
         * 同步分类接口
         * */
        public static  final String PROD_QUERY_CATE_LIST ="/api/cate/list";
        /**
         * 分页查询全量商品sku接口
         * */
        public static  final String PROD_QUERY_ALL_SKU_PAGE="/api/all/sku/page";
        /**
         * 根据sku批量查询商品详情
         * */
        public static final String PROD_QUERY_BATCH_LIST_SKU="/api/batch/query/sku";
        /**
         * 查询同类商品
         * */
        public static final String PROD_QUERY_SKU_SIMILAR="/api/sku/similar";

        /*地域模块*/
        /**
         * 查询一级地域（省份）接口
         */
        public static final String ADDR_PROVINCE_LIST="/openapi/address/provinceList";
        /**
         * 根据一级地域编码查询二级地域（地市）接口
         */
        public static final String ADDR_CITY_LIST="/openapi/address/cityList";
        /**
         * 根据二级地域编码查询三级地域（区县）接口
         */
        public static final String ADDR_COUNTY_LIST="/openapi/address/countyList";
        /**
         * 根据三级地域编码查询四级地域（乡镇）接口
         */
        public static final String ADDR_TOWN_LIST="/openapi/address/townList";
        /**
         * 校验地址接口
         */
        public static final String ADDR_CHECK="/openapi/address/checkAddress";

        /*订单模块*/
        /**
         * 查询商品库存接口
         */
        public static final String ORDER_STOCK="/openapi/order/stock";
        /**
         * 查询订单运费接口
         */
        public static final String ORDER_FREIGHT="/openapi/order/freight";
        /**
         * 统一下单接口
         */
        public static final String ORDER_SUBMIT="/openapi/order/submit";
        /**
         * 下单支付成功回调接口
         */
        public static final String ORDER_PAY="/openapi/order/pay";
        /**
         * 查询订单详情接口
         */
        public static final String ORDER_DETAIL="/openapi/order/detail";
        /**
         * 订单退款查询接口
         */
        public static final String ORDER_REFUND="/openapi/order/refund";
        /**
         * 订单物流查询接口
         */
        public static final String ORDER_TRACK="/openapi/order/track";


        /*售后模块*/
        /**
         * 查询商品支持的售后类型接口
         */
        public static final String AFTER_SALE_SERVICES="/openapi/aftersale/services";
        /**
         * 查询订单商品是否支持售后接口
         */
        public static final String AFTER_SALE_IS_CAN="/openapi/aftersale/isCan";
        /**
         * 申请售后接口
         */
        public static final String AFTER_SALE_APPLY="/openapi/aftersale/apply";
        /**
         * 查询售后列表接口
         */
        public static final String AFTER_SALE_LIST="/openapi/aftersale/list";
        /**
         * 查询售后详情接口
         */
        public static final String AFTER_SALE_DETAIL="/openapi/aftersale/detail";
        /**
         * 取消售后单接口
         */
        public static final String AFTER_SALE_CANCEL="/openapi/aftersale/cancel";
        /**
         * 售后物流跟踪接口
         */
        public static final String AFTER_SALE_TRACK="/openapi/aftersale/track";
        /**
         * 客户返件售后单填写发运接口
         */
        public static final String AFTER_SALE_SEND_SKU="/openapi/aftersale/sendsku";

        /*redis 存储*/
        /**
         *企业ID  key="api:enterprise:appkey"   value="ent_id:app_sec" */
        public static final String ORDER_PAY_LOCK_PREFIX = "api:enterprise:";

}
