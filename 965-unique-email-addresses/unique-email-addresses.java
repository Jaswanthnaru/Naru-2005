class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) uniqueEmails.add(getOrigin(email));
        return uniqueEmails.size();
    }

    private String getOrigin(String email) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@' || email.charAt(i) == '+') break;
            if (email.charAt(i) == '.') continue;
            stringBuilder.append(email.charAt(i));
        }
        stringBuilder.append(email.substring(email.indexOf('@'), email.length() - 1));
        return stringBuilder.toString();
    }
}