package com.aouf.mallmanagement;

import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.tran.DataStream;
import org.frameworkset.tran.db.input.es.DB2ESImportBuilder;

public class ESImport {
    public static void main(String[] args) {
        DB2ESImportBuilder importBuilder = DB2ESImportBuilder.newInstance();
//        try {
//            // 删除原有的 Indice
//            ElasticSearchHelper.getRestClientUtil().dropIndice("spu");
//        }
//        catch (Exception e){}
        // JDBC 配置
        importBuilder.setDbName("atstudy_mall")
                .setDbDriver("com.mysql.cj.jdbc.Driver")
                .setDbUrl("jdbc:mysql://127.0.0.1:3306/atstudy_mall?useUnicode=true&characterEncoding=utf8&useCursorFetch=true")
                .setDbUser("root")
                .setDbPassword("")
                .setUsePool(false);//是否使用连接池

        // 将查询结果导入 ElasticSearch
        importBuilder.setSql("select * from `spu`");
        // ElasticSearch 配置
        importBuilder
                .setIndex("spu")
                .setIndexType("_doc")
                .setRefreshOption(null)
                .setUseJavaName(false)
                .setBatchSize(5000)
                .setJdbcFetchSize(10000);
        // 开始导入数据
        DataStream dataStream = importBuilder.builder();
        dataStream.execute();
    }
}
