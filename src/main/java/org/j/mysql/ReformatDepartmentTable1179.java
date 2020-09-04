package org.j.mysql;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 1179编写SQL查询以重新格式化表，以便每个月都有一个部门ID列和一个收入列。
 * @date 2020-09-04 15:45
 **/
public class ReformatDepartmentTable1179 {
    public static void main(String[] args) {
        System.out.println("编写SQL查询以重新格式化表，以便每个月都有一个部门ID列和一个收入列。");
        System.out.println("Department table:\n" +
                "+------+---------+-------+\n" +
                "| id   | revenue | month |\n" +
                "+------+---------+-------+\n" +
                "| 1    | 8000    | Jan   |\n" +
                "| 2    | 9000    | Jan   |\n" +
                "| 3    | 10000   | Feb   |\n" +
                "| 1    | 7000    | Feb   |\n" +
                "| 1    | 6000    | Mar   |\n" +
                "+------+---------+-------+\n" +
                "\n" +
                "Result table:\n" +
                "+------+-------------+-------------+-------------+-----+-------------+\n" +
                "| id   | Jan_Revenue | Feb_Revenue | Mar_Revenue | ... | Dec_Revenue |\n" +
                "+------+-------------+-------------+-------------+-----+-------------+\n" +
                "| 1    | 8000        | 7000        | 6000        | ... | null        |\n" +
                "| 2    | 9000        | null        | null        | ... | null        |\n" +
                "| 3    | null        | 10000       | null        | ... | null        |\n" +
                "+------+-------------+-------------+-------------+-----+-------------+\n" +
                "\n" +
                "Note that the result table has 13 columns (1 for the department id + 12 for the months).");
        System.out.println("result:");
        System.out.println("select id, sum(case when month = 'Jan' then revenue else NULL end) as Jan_Revenue ,\n" +
                "           sum(case when month = 'Feb' then revenue else NULL end) as Feb_Revenue ,\n" +
                "           sum(case when month = 'Mar' then revenue else NULL end) as Mar_Revenue ,\n" +
                "           sum(case when month = 'Apr' then revenue else NULL end) as Apr_Revenue ,\n" +
                "           sum(case when month = 'May' then revenue else NULL end) as May_Revenue ,\n" +
                "           sum(case when month = 'Jun' then revenue else NULL end) as Jun_Revenue ,\n" +
                "           sum(case when month = 'Jul' then revenue else NULL end) as Jul_Revenue ,\n" +
                "           sum(case when month = 'Aug' then revenue else NULL end) as Aug_Revenue ,\n" +
                "           sum(case when month = 'Sep' then revenue else NULL end) as Sep_Revenue ,\n" +
                "           sum(case when month = 'Oct' then revenue else NULL end) as Oct_Revenue ,\n" +
                "           sum(case when month = 'Nov' then revenue else NULL end) as Nov_Revenue ,\n" +
                "           sum(case when month = 'Dec' then revenue else NULL end) as Dec_Revenue \n" +
                "from Department \n" +
                "group by id");
        System.out.println("知识点：CASE WHEN condition THEN (val1) ELSE (val2) END;////可嵌套");
    }
}
