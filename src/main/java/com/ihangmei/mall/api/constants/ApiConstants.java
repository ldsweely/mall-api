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
        /*同步分类接口*/
        public static  final String PROD_QUERY_CATE_LIST ="/api/cate/list";
        /*分页查询全量商品sku接口*/
        public static  final String PROD_QUERY_ALL_SKU_PAGE="/api/all/sku/page";
        /*根据sku批量查询商品详情*/
        public static final String PROD_QUERY_BATCH_LIST_SKU="/api/batch/query/sku";
        /*查询同类商品*/
        public static final String PROD_QUERY_SKU_SIMILAR="/api/sku/similar";

        /*订单模块*/
        //支付回调
        public static final String ORDER_PAY_CALL_BACK="/api/order/payCall";
        //支付回调-V2
        public static final String ORDER_PAY_CALL_BACK_V2="/api/order/v2/payCall";
        public static final String ORDER_RERUND_CALL_BACK="/api/backstage/afterservice/refund/callback";
        /*支付模块 - 创建订单接口*/
        public static final String PAY_CREATE_ORDER="/api/pay/createOrder";
        /*支付模块 - 退款接口*/
        public static final String PAY_REFUND_ORDER="/api/pay/refund";
        /*支付模块 - 查询订单支付结果 */
        public static final String PAY_RESULT_QUERY="/api/pay/query";


        /*redis 存储*/
        /*企业ID  key="api:enterprise:appkey"   value="ent_id:app_sec" */
        public static final String ORDER_PAY_LOCK_PREFIX = "api:enterprise:";

}
