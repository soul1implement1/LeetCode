package org.j.mysql;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 一个国家如果面积超过300万平方公里或人口超过2500万，就大。
 * 编写SQL解决方案以输出大国的名称，人口和地区。
 * @date 2020-09-07 10:59
 **/
public class BigCountries595 {
    public static void main(String[] args) {
        System.out.println("编写SQL解决方案以输出大国的名称，人口和地区。");
        System.out.println("There is a table World\n" +
                "\n" +
                "+-----------------+------------+------------+--------------+---------------+\n" +
                "| name            | continent  | area       | population   | gdp           |\n" +
                "+-----------------+------------+------------+--------------+---------------+\n" +
                "| Afghanistan     | Asia       | 652230     | 25500100     | 20343000      |\n" +
                "| Albania         | Europe     | 28748      | 2831741      | 12960000      |\n" +
                "| Algeria         | Africa     | 2381741    | 37100000     | 188681000     |\n" +
                "| Andorra         | Europe     | 468        | 78115        | 3712000       |\n" +
                "| Angola          | Africa     | 1246700    | 20609294     | 100990000     |\n" +
                "+-----------------+------------+------------+--------------+---------------+\n" +
                "A country is big if it has an area of bigger than 3 million square km or a population of more than 25 million.\n" +
                "\n" +
                "Write a SQL solution to output big countries' name, population and area.\n" +
                "\n" +
                "For example, according to the above table, we should output:\n" +
                "\n" +
                "+--------------+-------------+--------------+\n" +
                "| name         | population  | area         |\n" +
                "+--------------+-------------+--------------+\n" +
                "| Afghanistan  | 25500100    | 652230       |\n" +
                "| Algeria      | 37100000    | 2381741      |\n" +
                "+--------------+-------------+--------------+");
        System.out.println("result:");
        System.out.println("SELECT name,population,area FROM World WHERE population>=25000000 OR area>=3000000");
        System.out.println("知识点：select or   |使用OR（and）搜索时，条件顺序重要(最左前缀原则，索引失效，)");
    }
}
