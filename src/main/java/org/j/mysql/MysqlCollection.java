package org.j.mysql;

/**
 * 非常用语法集合
 */
public interface MysqlCollection {
    /**
     * 创建临时表
     */
    String TEMPORARY = "CREATE TEMPORARY TABLE tmp_table SELECT * FROM table_name";

    /**
     * CASE
     */
    String CaseWhenThenEnd = "CASE WHEN condition THEN (val1) ELSE (val2) END;////可嵌套";
}

