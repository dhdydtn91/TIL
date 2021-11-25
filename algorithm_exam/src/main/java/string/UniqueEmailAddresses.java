package string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static int numUniqueEmails(String[] emails) {
        Set<String> result = new HashSet<>();
        //  ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]

        for (int i = 0; i < emails.length; i++) {
            String part[] = emails[i].split("@");
            String doamin[] = part[0].split("\\+");
            String filteringDomain = doamin[0].replace(".", "");
            result.add(filteringDomain + "@" + part[1]);
        }

        return result.size();
    }

    public static void main(String[] args) {
        String emails[] =
                {"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"};

        int i = numUniqueEmails(emails);

        System.out.println("emails = " + i);
    }
}
