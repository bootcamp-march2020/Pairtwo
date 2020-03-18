package com.bootcamp.test.part2;

import java.util.Map;

public class Ex2 {

    class CsvValidation {
        public void validateProduct(Map<String, String> product) throws Exception {
            String[] attr = {"color", "size", "type"};
            for (String s : attr) {
                if (("").equals(product.get(s))) {
                    throw new Exception("Import fail: the product attribute "+s+" is missing");
                }
            }
        }


    }
}
