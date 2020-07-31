package 力扣刷题;

import java.util.HashSet;

public class Num929独特的电子邮件地址 {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder name = new StringBuilder();
            int index = email.indexOf('@');
            String domain = email.substring(index + 1);
            for (int i = 0; i < index; i++) {
                char c = email.charAt(i);
                if (c == '.') continue;
                if (c == '+') break;
                name.append(c);
            }
            set.add(name.append("@").append(domain).toString());
        }
        return set.size();
    }
}
