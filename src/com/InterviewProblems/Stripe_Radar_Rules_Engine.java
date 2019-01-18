package com.InterviewProblems;
import java.util.HashMap;
import java.util.Map;


public class Stripe_Radar_Rules_Engine {

    public enum Attribute {
        AMOUNT("amount"), CARD_COUNTRY("card_country"), CURRENCY("currency"), IP_COUNTRY("ip_country");

        String code;

        Attribute(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public Attribute setCode(String code) {
            this.code = code;
            return this;
        }

        public static Attribute fromString(String string) {
            if (string != null) {
                for (Attribute b : Attribute.values()) {
                    if (string.equalsIgnoreCase(b.getCode())) {
                        return b;
                    }
                }
            }
            return null;
        }
    }

    public enum RuleValue {
        ALLOW("allow"), BLOCK("block");

        String code;

        RuleValue(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public RuleValue setCode(String code) {
            this.code = code;
            return this;
        }

        public static RuleValue fromString(String string) {
            if (string != null) {
                for (RuleValue b : RuleValue.values()) {
                    if (string.equalsIgnoreCase(b.getCode())) {
                        return b;
                    }
                }
            }
            return null;
        }
    }

    public enum Operator {
        EQ("=="), NE("!="), LT("<"), LTE("<="), GT(">"), GTE(">=");

        String code;

        Operator(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public Operator setCode(String code) {
            this.code = code;
            return this;
        }

        public static Operator fromString(String string) {
            if (string != null) {
                for (Operator b : Operator.values()) {
                    if (string.equalsIgnoreCase(b.getCode())) {
                        return b;
                    }
                }
            }
            return null;
        }
    }

    public static int rules_engine(String charge) {
        String[] chargeParameters = charge.split(",");
        String query = chargeParameters[0];
        Map<Attribute, String> queryAttributeToValueMap = new HashMap<>();
        query = query.substring(7, query.length() - 1);
        for (String queryParams : query.split("&")) {
            String key = queryParams.split("=")[0];
            String value = queryParams.split("=")[1];
            queryAttributeToValueMap.put(Attribute.fromString(key), value);
        }
        for (int i = 1; i < chargeParameters.length; i++) {
            String rule = chargeParameters[i];
            System.out.println(rule);
            String[] ruleParams = rule.split(":");
            RuleValue ruleValue = RuleValue.fromString(ruleParams[0]);
            for (int j = 1; j < ruleParams.length; j++) {
                String[] individualRules = ruleParams[j].split("AND");
                if (individualRules.length > 1) {
                    for (String individualRule : individualRules) {
                        individualRule.replaceAll("^\"|\"$", "").trim();
                        if (calculate(queryAttributeToValueMap, individualRule, ruleValue) == 0) {
                            return 0;
                        }
                    }
                    return 1;
                } else {
                    individualRules = ruleParams[j].split("OR");
                    if (individualRules.length > 1) {
                        for (String individualRule : individualRules) {
                            individualRule.replaceAll("^\"|\"$", "").trim();
                            if (calculate(queryAttributeToValueMap, individualRule, ruleValue) == 1) {
                                return 1;
                            }
                        }
                        return 0;
                    } else {
                        String individualRule = individualRules[0].replaceAll("^\"|\"$", "").trim();
                        return calculate(queryAttributeToValueMap, individualRule, ruleValue);
                    }
                }
            }
            return 1;
        }
        return 1;
    }

    public static int calculate(Map<Attribute, String> queryAttributeToValueMap, String individualRule, RuleValue ruleValue) {
        boolean flag = true;
        String[] individualRuleParams = individualRule.split(" ");
        String attribute = individualRuleParams[0];
        String operator = individualRuleParams[1];
        String value = individualRuleParams[2];

        switch (Attribute.fromString(attribute)) {
            case AMOUNT:
                switch (Operator.fromString(operator)) {
                    case EQ:
                        if (Integer.parseInt(queryAttributeToValueMap.get(Attribute.AMOUNT)) != Integer.parseInt(value)) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                    case NE:
                        if (Integer.parseInt(queryAttributeToValueMap.get(Attribute.AMOUNT)) == Integer.parseInt(value)) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                    case LT:
                        if (Integer.parseInt(queryAttributeToValueMap.get(Attribute.AMOUNT)) >= Integer.parseInt(value)) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                    case LTE:
                        if (Integer.parseInt(queryAttributeToValueMap.get(Attribute.AMOUNT)) > Integer.parseInt(value)) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                    case GT:
                        if (Integer.parseInt(queryAttributeToValueMap.get(Attribute.AMOUNT)) <= Integer.parseInt(value)) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                    case GTE:
                        if (Integer.parseInt(queryAttributeToValueMap.get(Attribute.AMOUNT)) < Integer.parseInt(value)) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                }

            case CARD_COUNTRY:
                switch (Operator.fromString(operator)) {
                    case EQ:
                        if (!queryAttributeToValueMap.get(Attribute.CARD_COUNTRY).equals(queryAttributeToValueMap.get(Attribute.IP_COUNTRY))) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                    case NE:
                        if (queryAttributeToValueMap.get(Attribute.CARD_COUNTRY).equals(queryAttributeToValueMap.get(Attribute.IP_COUNTRY))) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                }

            case IP_COUNTRY:
                switch (Operator.fromString(operator)) {
                    case EQ:
                        if (!queryAttributeToValueMap.get(Attribute.CARD_COUNTRY).equals(queryAttributeToValueMap.get(Attribute.IP_COUNTRY))) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                    case NE:
                        if (queryAttributeToValueMap.get(Attribute.CARD_COUNTRY).equals(queryAttributeToValueMap.get(Attribute.IP_COUNTRY))) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                }

            case CURRENCY:
                switch (Operator.fromString(operator)) {
                    case EQ:
                        if (!queryAttributeToValueMap.get(Attribute.CURRENCY).equals(value)) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                    case NE:
                        if (queryAttributeToValueMap.get(Attribute.CARD_COUNTRY).equals(queryAttributeToValueMap.get(Attribute.IP_COUNTRY))) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                }
        }
        if (ruleValue == RuleValue.ALLOW) {
            if (flag) {
                return 1;
            } else {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Stripe_Radar_Rules_Engine srre = new Stripe_Radar_Rules_Engine();
        System.out.println(srre.rules_engine(""));
    }

}
