package org.j.mysql;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 给定一个表salary（例如下面的表），该表具有m = male和f = female值。交换所有f和m值
 * @date 2020-09-08 17:06
 **/
public class SwapSalary627 {
    public static void main(String[] args) {
        System.out.println("给定一个表salary（例如下面的表），该表具有m = male和f = female值。交换所有f和m值");
        System.out.println("Given a table salary, such as the one below, that has m=male and f=female values. Swap all f and m values (i.e., change all f values to m and vice versa) with a single update statement and no intermediate temp table.\n" +
                "\n" +
                "Note that you must write a single update statement, DO NOT write any select statement for this problem.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "| id | name | sex | salary |\n" +
                "|----|------|-----|--------|\n" +
                "| 1  | A    | m   | 2500   |\n" +
                "| 2  | B    | f   | 1500   |\n" +
                "| 3  | C    | m   | 5500   |\n" +
                "| 4  | D    | f   | 500    |\n" +
                "After running your update statement, the above salary table should have the following rows:\n" +
                "| id | name | sex | salary |\n" +
                "|----|------|-----|--------|\n" +
                "| 1  | A    | f   | 2500   |\n" +
                "| 2  | B    | m   | 1500   |\n" +
                "| 3  | C    | f   | 5500   |\n" +
                "| 4  | D    | m   | 500    |");
        System.out.println("result:");
        System.out.println("UPDATE salary SET sex=CASE WHEN sex='m' THEN 'f' else 'm' END");
        System.out.println("知识点：CASE");
    }
}
